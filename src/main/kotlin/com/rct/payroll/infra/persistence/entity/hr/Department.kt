package com.rct.payroll.infra.persistence.entity.hr

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import java.util.UUID

/**
 * Department - Jakarta Entity
 *
 * @property id UUID
 * @property name String
 * @property description Description of Department
 * @constructor Create empty Department
 */
@Entity
data class Department(
    @Id
    @GeneratedValue(strategy = AUTO)
    val id: UUID,
    val name: String,
    val description: String,
)
