package com.rct.payroll.core.model.dto.hr

import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.UUID

/**
 * Employee DTO
 *
 * @property id UUID
 * @property name String
 * @property color
 * @property sex
 * @property birthdayDate
 * @property hiringDate
 * @property actualDepartment
 * @property actualSalary
 * @property departmentHistory
 * @property createdAt LocalDateTime
 * @property updatedAt LocalDateTime
 * @constructor Create empty Employee
 */
data class Employee(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val color: Color,
    val sex: Sex,
    val birthdayDate: LocalDateTime,
    val hiringDate: LocalDateTime,
    val actualDepartment: Department,
    val actualSalary: BigDecimal,
    val departmentHistory: List<EmployeeHistoric> = listOf(),
    val createdAt: LocalDateTime = now(),
    val updatedAt: LocalDateTime,
) {
    /**
     * Employee historic DTO
     *
     * @property id UUID
     * @property employeeId UUID
     * @property departmentId
     * @property current
     * @property salary
     * @property createdAt LocalDateTime
     * @property updatedAt LocalDateTime
     * @constructor Create empty Employee historic
     */
    data class EmployeeHistoric(
        val id: UUID,
        val employeeId: UUID,
        val departmentId: UUID,
        val current: Boolean = true,
        val salary: BigDecimal,
        val createdAt: LocalDateTime = now(),
        val updatedAt: LocalDateTime? = null,
    )
}
