plugins {
    kotlin("jvm") version "1.4.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.h2database:h2:1.4.200")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.3")
    implementation("com.zaxxer:HikariCP:3.4.5")
    implementation("commons-logging:commons-logging:1.2")
    implementation("io.javalin:javalin:3.12.0")
    implementation("org.flywaydb:flyway-core:7.4.0")
    implementation("org.postgresql:postgresql:42.2.20")
    implementation("org.slf4j:slf4j-simple:1.7.28")
    testImplementation("org.assertj:assertj-core:3.19.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}
