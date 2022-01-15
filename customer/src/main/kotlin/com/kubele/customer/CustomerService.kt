package com.kubele.customer

import com.kubele.amqp.RabbitMQMessageProducer
import com.kubele.clients.fraud.FraudClient
import com.kubele.clients.notification.NotificationRequest
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val repository: CustomerRepository,
    private val fraudClient: FraudClient,
    private val rabbitMQMessageProducer: RabbitMQMessageProducer
) {
    companion object {
        private const val EMAIL_VALIDATION_REGEX =
            "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"
    }

    fun registerCustomer(request: CustomerRegistrationRequest) {
        val customer = Customer(
            firstName = request.firstName,
            lastName = request.lastName,
            email = request.email
        )
        customer.email.let { if (!isEmailValid(it)) throw InvalidEmailException(it) }
        repository.run {
            if (selectExistsByEmail(customer.email)) {
                throw ExistingEmailException(customer.email)
            }
            saveAndFlush(customer)
        }
        val fraudCheckResponse = fraudClient.isFraudster(customer.id)
        if (fraudCheckResponse.isFraudster) throw IllegalStateException("FRAUDSTER!!")

        val notificationRequest = NotificationRequest(
            customer.id,
            customer.email,
            message = "Hello from ${customer.firstName} ${customer.lastName}"
        )

        rabbitMQMessageProducer.publish(
            notificationRequest,
            "internal.exchange",
            "internal.notification.routing-key"
        )
    }

    private fun isEmailValid(email: String): Boolean {
        return email.matches(EMAIL_VALIDATION_REGEX.toRegex())
    }
}

class InvalidEmailException(private val email: String) : Exception() {
    override val message: String
        get() = "e-mail \"$email\" is not valid"
}

class ExistingEmailException(private val email: String) : Exception() {
    override val message: String
        get() = "e-mail \"$email\" already exists"
}
