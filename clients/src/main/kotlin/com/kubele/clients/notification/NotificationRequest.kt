package com.kubele.clients.notification

data class NotificationRequest(
    val toCustomerId: Int,
    val toCustomerEmail: String,
    val message: String
)
