package com.kubele.customer

import mu.KotlinLogging.logger
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customers")
class CustomerController(val customerService: CustomerService) {

    private val logger = logger {}

    @PostMapping
    fun registerCustomer(@RequestBody customerRegistrationRequest: CustomerRegistrationRequest) {
        logger.info { "new registration $customerRegistrationRequest" }
        customerService.registerCustomer(customerRegistrationRequest)
    }
}
