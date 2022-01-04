package com.kubele.notification

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = ["com.kubele.notification", "com.kubele.amqp"]
)
class NotificationApplication {

//    @Bean
//    fun commandLineRunner(
//            producer: RabbitMQMessageProducer,
//            notificationConfig: NotificationConfig
//    ): CommandLineRunner {
//        return CommandLineRunner {
//            producer.publish(
//                    "foo",
//                    notificationConfig.internalExchange,
//                    notificationConfig.internalNotificationRoutingKey)
//        }
//    }
}

fun main(args: Array<String>) {
    runApplication<NotificationApplication>(*args)
}
