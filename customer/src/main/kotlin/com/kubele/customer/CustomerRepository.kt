package com.kubele.customer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CustomerRepository : JpaRepository<Customer, Int> {
    @Query(
        "SELECT CASE WHEN COUNT(c) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Customer c " +
            "WHERE c.email = ?1"
    )
    fun selectExistsByEmail(email: String): Boolean
}
