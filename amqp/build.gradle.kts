import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-amqp")
}

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}
