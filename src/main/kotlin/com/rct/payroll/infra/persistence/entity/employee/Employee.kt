package com.rct.payroll.infra.persistence.entity.employee

import com.rct.payroll.core.model.dto.hr.Color
import com.rct.payroll.core.model.dto.hr.Sex
import com.rct.payroll.infra.persistence.entity.hr.Department
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType.STRING
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.UUID

/**
 * Employee - Jakarta Entity
 *
 * @property id UUID
 * @property name String
 * @property color Skin Color
 * @property sex Declarative Sex
 * @property birthdayDate Birthday Date
 * @property hiringDate Hiring Date
 * @property department Actual Department
 * @property actualSalary Actual Salary
 * @property departmentHistory Historic Department
 * @property payrollHistory Historic Payroll
 * @property createdAt LocalDateTime
 * @property updatedAt LocalDateTime
 * @constructor Create empty Employee
 */
@Entity
data class Employee(
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(columnDefinition = "UUID")
    val id: UUID = UUID.randomUUID(),
    val name: String,
    @Enumerated(STRING)
    val color: Color,
    @Enumerated(STRING)
    val sex: Sex,
    val birthdayDate: LocalDateTime,
    val hiringDate: LocalDateTime,
    @ManyToOne
    val department: Department,
    val actualSalary: BigDecimal,
    @OneToMany
    val departmentHistory: List<EmployeeHistoric> = listOf(),
    @OneToMany
    val payrollHistory: List<EmployeePayroll> = listOf(),
    val createdAt: LocalDateTime = now(),
    val updatedAt: LocalDateTime?,
)
