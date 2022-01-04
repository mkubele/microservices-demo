package com.kubele.clients.notification

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient("notification")
interface NotificationClient {

    @PostMapping("api/v1/notification")
    fun sendNotification(request: NotificationRequest)
}
