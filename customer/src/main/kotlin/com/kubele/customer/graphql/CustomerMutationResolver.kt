package com.kubele.customer.graphql

import com.kubele.customer.Customer
import com.kubele.customer.CustomerRegistrationRequest
import com.kubele.customer.CustomerService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class CustomerMutationResolver(private val customerService: CustomerService) : GraphQLMutationResolver {

    fun registerCustomer(firstName: String, lastName: String, email: String): Customer {
        val customerRegistrationRequest = CustomerRegistrationRequest(firstName, lastName, email)
        return customerService.registerCustomer(customerRegistrationRequest)
    }

    // TODO: add error handling
}
