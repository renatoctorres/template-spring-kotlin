import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.3"
    id("io.gitlab.arturbosch.detekt") version "1.23.5"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
    id("io.spring.dependency-management") version "1.1.4"
    jacoco
    java
    application
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    kotlin("plugin.jpa") version "1.9.22"
}

group = "com.rct.payroll"
version = "0.0.1-SNAPSHOT"
JavaVersion.VERSION_21.also { java.sourceCompatibility = it }

val detektVersion = "1.23.5"
val h2Version = "2.2.224"
val jacksonModuleKotlin = "2.17.0"
val junitJupiterVersion = "5.10.2"
val kotlinVersion = "1.9.22"
val ktLintGradleVersion = "11.3.1"
val logbackVersion = "1.4.14"
val lombokVersion = "1.18.30"
val mockkVersion = "1.13.10"
val sl4jVersion = "2.0.12"
val springBootVersion = "3.2.3"
val springCoreVersion = "6.1.3"
val springDocOpenApiVersion = "2.3.0"

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:$detektVersion")
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    developmentOnly("org.springframework.boot:spring-boot-devtools:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonModuleKotlin")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$springDocOpenApiVersion")
    implementation("org.slf4j:slf4j-api:$sl4jVersion")
    implementation("ch.qos.logback:logback-core:$logbackVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    runtimeOnly("com.h2database:h2:$h2Version")
    runtimeOnly("org.springframework.boot:spring-boot-devtools:$springBootVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testImplementation("org.junit.vintage:junit-vintage-engine:$junitJupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true) // observe findings in your browser with structure and code snippets
        xml.required.set(true) // checkstyle like format mainly for integrations like Jenkins
        txt.required.set(true) // similar to the console output, contains issue signature to edit baseline files
        sarif.required.set(true) // standardized SARIF format to support integrations with GitHub Code Scanning
        md.required.set(true) // simple Markdown format
    }
}

// tasks.withType<Test> {
//    useJUnitPlatform()
// }

tasks.test {
    useJUnitPlatform()
//    finalizedBy(tasks.jacocoTestReport)
}
tasks.jacocoTestReport {
//    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.required = false
        csv.required = false
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
    }
}

detekt {
    allRules = false
    toolVersion = detektVersion
    source.setFrom(files("src/main/kotlin"))
    config.setFrom(files("$rootDir/config/detekt/detekt.yml"))
    parallel = true
    buildUponDefaultConfig = true
    autoCorrect = true
}

ktlint {
    ignoreFailures = false
    verbose = true
    enableExperimentalRules = false
    coloredOutput = true
}

configurations.matching { it.name != "detekt" }
