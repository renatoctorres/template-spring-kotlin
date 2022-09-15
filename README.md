
# Payroll Process MS Application
# Clean Arch and Clean Code / Spring Boot - Kotlin

![Kotlin](http://ForTheBadge.com/images/badges/made-with-kotlin.svg)

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

- Java Version 21
- Kotlin
- Gradle Version 8.6

## 3. Configuration

Spring Boot offers configuration over environment variables:
https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config

The application.yaml and application-local.yaml, that is included in the image, contains values for local
development.

## 4. Run 

To run in Local Environment, adjust profile to <b>local</b> in <b>application.properties</b> file, after this just run SpringBoot Command:
```
./gradlew bootRun
```


## 5 - Gradle Plugins


### Detekt 

The application has integration with Gradle Detekt Plugin, Detekt helps to write cleaner 
Kotlin code.

```
./gradlew detekt
```


### KtLint

The application has integration with Gradle Ktlint Plugin, Ktlint helps to standardize code formatting and 
adhere to a set of style rules


#### KtLint - Check:

Verify all points to fix:

```
./gradlew ktlintCheck
```


#### KtLint - Fix:

To automatically fix formatting issues that can be resolved by ktlint, use:

```
./gradlew ktlintFormat
```

## Stacks

<p style= "text-align: left;">
    <img src="https://skillicons.dev/icons?i=kotlin,spring,hibernate,gradle,git" />
    <img src="https://detekt.dev/img/home/detekt-logo.svg" width="48" height="48" alt="Detekt Plugin"/>
</p>
