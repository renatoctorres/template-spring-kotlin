
plugins {
    id("org.springframework.boot") version "3.5.6"
    id("dev.detekt") version "2.0.0-alpha.0"
    id("org.jlleitschuh.gradle.ktlint") version "13.1.0"
    id("io.spring.dependency-management") version "1.1.7"
    jacoco
    java
    application
    kotlin("jvm") version "2.2.20"
    kotlin("plugin.spring") version "2.2.20"
    kotlin("plugin.jpa") version "2.2.20"

}
group = "com.rct.payroll"
version = "0.0.1-SNAPSHOT"


val detektVersion = "1.23.5"
val h2Version = "2.4.240"
val jacksonModuleKotlin = "2.20.0-rc1"
val junitJupiterVersion = "5.14.0"
val kotlinVersion = "1.9.22"
val logbackVersion = "1.5.19"
val mockkVersion = "1.14.6"
val sl4jVersion = "2.0.17"
val springBootVersion = "3.5.6"
val springCoreVersion = "7.0.0-RC1"
val springDocOpenApiVersion = "3.0.0-M1"

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
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
    testImplementation(platform("org.junit:junit-bom:5.14.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}


kotlin {
    compilerOptions {
        freeCompilerArgs.set(mutableListOf<String>("-Xjsr305=strict"))
    }
    jvmToolchain(24)
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}
tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
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
