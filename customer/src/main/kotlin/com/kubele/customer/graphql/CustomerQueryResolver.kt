package com.kubele.customer.graphql

import com.kubele.customer.Customer
import com.kubele.customer.CustomerService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class CustomerQueryResolver(private val customerService: CustomerService) : GraphQLQueryResolver {

    fun customers(): List<Customer> {
        return customerService.getAllCustomers()
    }
}
