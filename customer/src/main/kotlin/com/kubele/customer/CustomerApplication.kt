package com.kubele.customer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.PropertySource

@SpringBootApplication(scanBasePackages = ["com.kubele.customer", "com.kubele.amqp"])
@EnableEurekaClient
@EnableFeignClients(basePackages = ["com.kubele.clients"])
@PropertySource(value = ["classpath:clients-\${spring.profiles.active}.properties"])
class CustomerApplication

fun main(args: Array<String>) {
    runApplication<CustomerApplication>(*args)
}
