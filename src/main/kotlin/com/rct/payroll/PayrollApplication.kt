package com.rct.payroll

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PayrollApplication

fun main(args: Array<String>) {
    runApplication<PayrollApplication>(*args)
}
