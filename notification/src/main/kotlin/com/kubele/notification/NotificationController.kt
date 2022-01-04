package com.kubele.notification

import com.kubele.clients.notification.NotificationRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/notification")
class NotificationController(private val service: NotificationService) {

    @PostMapping
    fun sendNotification(@RequestBody request: NotificationRequest) {
        service.send(request)
    }
}
