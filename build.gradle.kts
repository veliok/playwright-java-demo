plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.junit.jupiter)
    testRuntimeOnly(libs.bundles.junit.runtime)
    implementation("com.microsoft.playwright:playwright:1.54.0")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "org.example.App"
}

tasks.test {
    useJUnitPlatform()
    enabled = true
}
