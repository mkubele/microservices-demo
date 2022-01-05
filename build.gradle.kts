import com.google.cloud.tools.jib.gradle.JibExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.4" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    kotlin("jvm") version "1.6.10" apply false
    kotlin("plugin.spring") version "1.6.10" apply false
    id("org.jlleitschuh.gradle.ktlint") version "10.2.1" apply false
    id("com.google.cloud.tools.jib") version "3.1.4" apply false
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "com.google.cloud.tools.jib")

    group = "com.kubele"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    val implementation by configurations
    val testImplementation by configurations
    val springCloudVersion = "2020.0.5"

    dependencies {
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("io.github.microutils:kotlin-logging-jvm:2.1.21")
        implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    configure<JibExtension> {
        from {
            image = "eclipse-temurin:11"
        }
        to {
            image = "mkubele/${project.name}:$version"
            tags = setOf("latest")
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    task("ktlint").dependsOn(
            "ktlintCheck"
    )

    configure<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension> {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
        }
    }
}
