package com.rct.payroll.core.model.dto.business

import com.rct.payroll.core.model.dto.hr.Employee
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.UUID
import java.util.UUID.randomUUID

/**
 * Payroll Employee DTO
 *
 * @property id UUID
 * @property employee
 * @property createdAt LocalDateTime
 * @property month
 * @property year
 * @property salary
 * @property discounts
 * @property benefits
 * @property overtime
 * @property totalDiscounts
 * @property totalBenefits
 * @property totalOvertime
 * @property amount
 * @constructor Create empty Payroll employee
 */
data class EmployeePayroll(
    val id: UUID = randomUUID(),
    val employee: Employee,
    val createdAt: LocalDateTime = now(),
    val month: Int,
    val year: Int,
    val salary: BigDecimal,
    val discounts: List<Discount> = listOf(),
    val benefits: List<Benefit> = listOf(),
    val overtime: List<Inclusion> = listOf(),
    val totalDiscounts: BigDecimal,
    val totalBenefits: BigDecimal,
    val totalOvertime: BigDecimal,
    val amount: BigDecimal,
)
