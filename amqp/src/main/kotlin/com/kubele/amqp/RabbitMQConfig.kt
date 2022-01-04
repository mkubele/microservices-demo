package com.kubele.amqp

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig(private val connectionFactory: ConnectionFactory) {

    @Bean
    fun amqpTemplate(): AmqpTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = jacksonConvertor()
        return rabbitTemplate
    }

    @Bean
    fun simpleRabbitListenerContainerFactory(): SimpleRabbitListenerContainerFactory {
        val factory = SimpleRabbitListenerContainerFactory()
        factory.run {
            setConnectionFactory(connectionFactory)
            setMessageConverter(jacksonConvertor())
        }
        return factory
    }

    @Bean
    fun jacksonConvertor(): MessageConverter {
        val mapper = jacksonObjectMapper()

        return Jackson2JsonMessageConverter(mapper)
    }
}
