package com.kubele.fraud

import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class FraudCheckService(val repository: FraudCheckHistoryRepository) {

    fun isFraudulentCustomer(customerId: Int): Boolean {
        val result = false
        repository.save(
            FraudCheckHistory(
                customerId = customerId,
                isFraudster = result,
                createdAt = LocalDateTime.now()
            )
        )
        return result
    }
}
