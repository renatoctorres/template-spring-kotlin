
# Kotlin & Spring Boot Template - Payroll Process MS Application
# Clean Arch and Clean Code / Spring Boot - Kotlin

![Kotlin](http://ForTheBadge.com/images/badges/made-with-kotlin.svg)
![Docker](https://forthebadge.com/images/badges/docker-container.svg)
![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)
![MIT](https://forthebadge.com/images/badges/license-mit.svg)

<p style= "text-align: left;">
    <a href="https://github.com/renatoctorres/github-readme-stats/actions">
        <img alt="Tests Passing" src="https://github.com/renatoctorres/template-spring-kotlin/workflows/Test/badge.svg" />
    </a>
</p>

The objective of this application is to offer a robust and easy to maintain solution for managing an organization's payrolls. The API allows you to create, query, update and remove payroll 
records for employees, as well as automatically calculate salaries, taxes and other deductions.

## 1. Features

- <b> Clean Architecture: </b> The architecture model used was Clean Architecture, the layers were divided in order to make the application agnostic in relation to the technology used
- <b> Clean Code: </b> Development with an emphasis on the importance of creating code that is easy to understand, maintain and modify
- <b> Rest API: </b> Payroll CRUD MS in APIRest using SpringBoot and Kotlin
- <b> Quality: </b> Detekt plugin that provides static code analysis
- <b> Test: </b> Test Scenarios in JUnit and Mockito
- <b> API Documentation: </b> microservices documented in the Swagger tool use the OpenAPI 3


## 2. Requirements

- Java Version 24
- Kotlin

## 3. Configuration

Spring Boot offers configuration over environment variables:
https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config

The application.yaml and application-local.yaml, that is included in the image, contains values for local
development.

## 4. Run 

To run in Local Environment, adjust profile to <b>local</b> in <b>application.properties</b> file, after this just run SpringBoot Command:

```bash
  /gradlew bootRun
```

The application exposes an APIs on port 8080 with these URLs:
http://localhost:8080

Swagger documentation is available on this endpoint:
http://localhost:8080/swagger-ui/index.html

Open API Specification is available on this endpoint:
http://localhost:8080/v3/api-docs


## 5 - Gradle Plugins


### Detekt 

The application has integration with Gradle Detekt Plugin, Detekt helps to write cleaner 
Kotlin code.

```bash
  ./gradlew detekt
```

### KtLint

The application has integration with Gradle Ktlint Plugin, Ktlint helps to standardize code formatting and 
adhere to a set of style rules


#### KtLint - Check:

Verify all points to fix:

```bash
  ./gradlew ktlintCheck
```

#### KtLint - Fix:

To automatically fix formatting issues that can be resolved by ktlint, use:

```bash
  ./gradlew ktlintFormat
```

## Stacks
<p style= "text-align: left;">
    <img src="https://skillicons.dev/icons?i=kotlin" alt="Kotlin" /> 
    <img src="https://skillicons.dev/icons?i=spring" alt="Spring Boot" />
    <img src="https://icon.icepanel.io/Technology/svg/Jupyter.svg" width="48" height="48" alt="Jupyter" />
    <img src="https://junit.org/junit5/assets/img/junit5-logo.png" height="48" alt="JUnit 5" />
    <img src="https://skillicons.dev/icons?i=hibernate" alt="Hibernate" /> 
    <img src="https://icon.icepanel.io/Technology/svg/OpenAPI.svg" width="48" height="48" alt="OpenAPI" />
    <img src="https://icon.icepanel.io/Technology/svg/Swagger.svg" width="48" height="48" alt="Swagger" />
    <img src="https://icon.icepanel.io/Technology/svg/YAML.svg" width="48" height="48" alt="YAML" />
    <img src="https://skillicons.dev/icons?i=gradle" alt="Gradle" /> 
    <img src="https://skillicons.dev/icons?i=github" alt="Github" />   
    <img src="https://skillicons.dev/icons?i=githubactions" alt="Github Actions" />
    <img src="https://skillicons.dev/icons?i=docker" alt="Docker" /> 
    <img src="https://dbdb.io/media/logos/h2-logo.svg" width="48" height="48" alt="H2 Database" /> 
</p>
