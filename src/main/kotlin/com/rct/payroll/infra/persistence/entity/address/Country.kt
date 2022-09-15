package com.rct.payroll.infra.persistence.entity.address

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import java.util.UUID

/**
 * Country - Jakarta Entity
 *
 * @property id UUID
 * @property name String
 * @constructor Create empty Country
 */
@Entity
data class Country(
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(columnDefinition = "UUID")
    val id: UUID,
    val name: String,
)
