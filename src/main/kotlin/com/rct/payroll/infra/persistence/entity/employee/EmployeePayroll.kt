package com.rct.payroll.infra.persistence.entity.employee

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType.STRING
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.UUID

/**
 * Payroll employee - Jakarta Entity
 *
 * @property id UUID
 * @property employee Employee Entity
 * @property createdAt LocalDateTime
 * @property salary Employee Payroll Salary
 * @property totalDiscounts Salary Total Discounts
 * @property totalBenefits Total Benefits
 * @property amountValue Amount
 * @property payrollStatus Status of Payroll
 * @constructor Create empty Payroll employee
 */
@Entity
data class EmployeePayroll(
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(columnDefinition = "UUID")
    val id: UUID,
    @ManyToOne
    val employee: Employee,
    @CreatedDate
    val createdAt: LocalDateTime = now(),
    @LastModifiedDate
    val updatedAt: LocalDateTime,
    val salary: BigDecimal,
    val totalDiscounts: BigDecimal,
    val totalBenefits: BigDecimal,
    val amountValue: BigDecimal,
    @Enumerated(STRING)
    val payrollStatus: EmployeePayrollStatus = EmployeePayrollStatus.CREATED,
)
