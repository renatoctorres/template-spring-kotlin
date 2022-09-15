package com.rct.payroll.infra.persistence.entity.employee

import com.rct.payroll.core.model.dto.employee.StreetType
import com.rct.payroll.infra.persistence.entity.address.City
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType.STRING
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.UUID

/**
 * Address employee - Jakarta Entity
 *
 * @property id UUID
 * @property streetType StreetType Enumerator
 * @property street String
 * @property number Number
 * @property city City
 * @property zipCode String
 * @property employeeId UUID
 * @property active Boolean
 * @property createdAt LocalDateTime
 * @property updatedAt LocalDateTime
 * @constructor Create empty Address employee
 */
@Entity
data class EmployeeAddress(
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(columnDefinition = "UUID")
    val id: UUID,
    @Enumerated(STRING)
    val streetType: StreetType,
    val street: String,
    val number: Number,
    @OneToOne
    val city: City,
    val zipCode: String,
    val employeeId: UUID,
    val active: Boolean,
    val createdAt: LocalDateTime = now(),
    var updatedAt: LocalDateTime,
)
