package com.rct.payroll.infra.persistence.entity.hr

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.UUID

/**
 * Sector - Jakarta Entity
 *
 * @property id UUID
 * @property name String
 * @property description Description of Sector
 * @property department Department of Sector
 * @constructor Create empty Sector
 */
@Entity
data class Sector(
    @Id
    @GeneratedValue(strategy = AUTO)
    val id: UUID,
    val name: String,
    val description: String,
    @ManyToOne
    val department: Department,
)
