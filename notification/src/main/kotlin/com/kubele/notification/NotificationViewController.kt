package com.kubele.notification

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class NotificationViewController(private val notificationService: NotificationService) {

    @GetMapping("notifications")
    fun listNotifications(model: Model): String {
        model.addAttribute("notifications", notificationService.getAllNotifications())
        return "notifications"
    }
}