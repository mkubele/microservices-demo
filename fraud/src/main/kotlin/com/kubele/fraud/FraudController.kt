package com.kubele.fraud

import com.kubele.clients.fraud.FraudCheckResponse
import mu.KotlinLogging.logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/fraud-check")
class FraudController(private val service: FraudCheckService) {

    private val logger = logger {}

    @GetMapping(path = ["{customerId}"])
    fun isFraudster(@PathVariable customerId: Int): FraudCheckResponse {
        val isFraudulent = service.isFraudulentCustomer(customerId)
        logger.info { "fraud check for $customerId" }
        return FraudCheckResponse(isFraudulent)
    }
}
