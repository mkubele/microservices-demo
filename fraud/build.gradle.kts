
dependencies {
    implementation(project(":clients"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
    implementation("org.springframework.cloud:spring-cloud-sleuth-zipkin")
    runtimeOnly("org.postgresql:postgresql")
}

springBoot {
    mainClass.set("com.kubele.fraud.FraudApplicationKt")
}
