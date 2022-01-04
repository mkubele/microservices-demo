package com.kubele.customer

import com.kubele.clients.fraud.FraudClient
import com.kubele.clients.notification.NotificationClient
import com.kubele.clients.notification.NotificationRequest
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val repository: CustomerRepository,
    private val fraudClient: FraudClient,
    private val notificationClient: NotificationClient
) {
    fun registerCustomer(request: CustomerRegistrationRequest) {
        val customer = Customer(
            firstName = request.firstName,
            lastName = request.lastName,
            email = request.email
        )
        repository.saveAndFlush(customer)
        val fraudCheckResponse = fraudClient.isFraudster(customer.id)
        if (fraudCheckResponse.isFraudster) throw IllegalStateException("FRAUDSTER!!")

        val notificationRequest = NotificationRequest(
            customer.id,
            customer.email,
            message = "Hello from ${customer.firstName} ${customer.lastName}"
        )

        notificationClient.sendNotification(notificationRequest)
    }
}
