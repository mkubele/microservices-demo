package com.kubele.amqp

import mu.KotlinLogging.logger
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.stereotype.Component

@Component
class RabbitMQMessageProducer(private val amqpTemplate: AmqpTemplate) {

    private val logger = logger {}

    fun publish(payload: Any, exchange: String, routingKey: String) {
        logger.info("Publishing to $exchange using routingKey $routingKey. Payload: $payload")
        amqpTemplate.convertAndSend(exchange, routingKey, payload)
        logger.info("Published to $exchange using routingKey $routingKey. Payload: $payload")
    }
}
