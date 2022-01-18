package com.kubele.notification

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Notification(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int = 0,
    val toCustomerId: Int = 0,
    val toCustomerEmail: String = "",
    val sender: String = "",
    val message: String = "",
    val sentAt: LocalDateTime = LocalDateTime.MIN
)
