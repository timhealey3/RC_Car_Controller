plugins {
    kotlin("jvm") version "1.8.0"
    id("org.jetbrains.compose") version "1.5.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.compose.ui:ui:1.5.0")
    implementation("org.jetbrains.compose.material:material:1.5.0")
    implementation("org.jetbrains.compose.ui:ui-tooling-preview:1.5.0")
    implementation("org.jetbrains.compose.foundation:foundation:1.5.0")
    implementation("org.java-websocket:Java-WebSocket:1.5.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.slf4j:slf4j-api:1.6.1")
    implementation("org.slf4j:slf4j-simple:1.6.1")
    implementation("com.google.code.gson:gson:2.8.9")
    implementation(compose.desktop.currentOs)
    testImplementation(kotlin("test"))
    testImplementation("org.mockito:mockito-core:3.+")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}