package com.kubele.customer

import mu.KotlinLogging.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customers")
class CustomerController(val customerService: CustomerService) {

    private val logger = logger {}

    @PostMapping
    fun registerCustomer(@RequestBody customerRegistrationRequest: CustomerRegistrationRequest): String {
        logger.info { "received new registration $customerRegistrationRequest" }
        customerService.registerCustomer(customerRegistrationRequest)
        return "OK"
    }

    @ExceptionHandler(ExistingEmailException::class, InvalidEmailException::class)
    fun handleEmailException(e: Exception) = ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
}
