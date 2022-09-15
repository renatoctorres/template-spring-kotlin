package com.rct.payroll.infra.persistence.entity.bank

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import java.util.UUID

/**
 * Bank - Jakarta Entity
 *
 * @property id UUID
 * @property code String
 * @property name String
 * @constructor Create empty Bank
 */
@Entity
data class Bank(
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(columnDefinition = "UUID")
    val id: UUID,
    val code: String,
    val name: String,
)
