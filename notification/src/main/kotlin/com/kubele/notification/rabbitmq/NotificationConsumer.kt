package com.kubele.notification.rabbitmq

import com.kubele.clients.notification.NotificationRequest
import com.kubele.notification.NotificationService
import mu.KotlinLogging
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class NotificationConsumer(private val notificationService: NotificationService) {

    private val logger = KotlinLogging.logger {}

    @RabbitListener(queues = ["\${rabbitmq.queues.notification}"])
    fun consumer(request: NotificationRequest) {
        logger.info { "consumed $request from queue" }
        notificationService.send(request)
    }
}
