
dependencies {
    implementation(project(":amqp"))
    implementation(project(":clients"))
    implementation(project(":utils"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
    implementation("org.springframework.cloud:spring-cloud-sleuth-zipkin")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.6.2")
    implementation("org.springframework.boot:spring-boot-starter-amqp")
    runtimeOnly("org.postgresql:postgresql")

    implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:12.0.0")
    implementation("com.graphql-java:graphiql-spring-boot-starter:5.0.2")

    implementation("io.springfox:springfox-swagger-ui:2.9.2")
    implementation("io.springfox:springfox-swagger2:2.9.2")
}

springBoot {
    mainClass.set("com.kubele.customer.CustomerApplicationKt")
}
