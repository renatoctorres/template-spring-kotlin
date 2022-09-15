package com.rct.payroll

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Payroll Application
 * @constructor Create Spring Kotlin Template - Payroll Application
 */
@SpringBootApplication
class PayrollApplication

/**
 * Spring Boot - Main function Application
 * @param args arguments
 */
fun main(args: Array<String>) {
    runApplication<PayrollApplication>(*args)
}
