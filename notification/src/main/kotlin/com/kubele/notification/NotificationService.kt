package com.kubele.notification

import com.kubele.clients.notification.NotificationRequest
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class NotificationService(private val repository: NotificationRepository) {

    fun send(request: NotificationRequest) {
        val notification = Notification(
            toCustomerId = request.toCustomerId,
            toCustomerEmail = request.toCustomerEmail,
            sender = "Server",
            message = request.message,
            sentAt = LocalDateTime.now()
        )
        repository.save(notification)
    }
}
