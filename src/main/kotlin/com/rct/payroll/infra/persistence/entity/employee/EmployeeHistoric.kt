package com.rct.payroll.infra.persistence.entity.employee

import com.rct.payroll.infra.persistence.entity.hr.Department
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.UUID

/**
 * Employee historic - Jakarta Entity
 *
 * @property id UUID
 * @property employee Employee
 * @property department Department of Employee
 * @property current Boolean
 * @property salary BigDecimal
 * @property startDate LocalDateTime
 * @property endDate LocalDateTime
 * @property createdAt LocalDateTime
 * @property updatedAt LocalDateTime
 * @constructor Create empty Employee historic
 */
@Entity
data class EmployeeHistoric(
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(columnDefinition = "UUID")
    val id: UUID,
    @ManyToOne
    val employee: Employee,
    @ManyToOne
    val department: Department,
    val current: Boolean = true,
    val salary: BigDecimal,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime?,
    val createdAt: LocalDateTime = now(),
    val updatedAt: LocalDateTime,
)
