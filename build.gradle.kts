plugins {
    kotlin("jvm") version "2.2.10"
}

group = "kr.dboo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5-jvm:6.0.7")
    implementation("io.kotest:kotest-property-jvm:6.0.7")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}