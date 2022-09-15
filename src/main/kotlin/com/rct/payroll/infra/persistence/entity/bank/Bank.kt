package com.rct.payroll.infra.persistence.entity.bank

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import jakarta.validation.constraints.NotNull
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
    @NotNull
    val code: String,
    @NotNull
    val name: String,
)
