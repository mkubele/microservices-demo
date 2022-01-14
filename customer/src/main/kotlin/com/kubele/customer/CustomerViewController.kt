package com.kubele.customer

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CustomerViewController(private val customerService: CustomerService) {

    @GetMapping("customers")
    fun listCustomers(model: Model): String {
        model.addAttribute("customers", customerService.getAllCustomers())
        return "customers"
    }
}