package com.rct.payroll.core.model.dto.bank

import java.util.UUID
import java.util.UUID.randomUUID

/**
 * Bank DTO
 *
 * @property id UUID
 * @property code String
 * @property name String
 * @constructor Create empty Bank
 */
data class Bank(
    val id: UUID = randomUUID(),
    val code: String,
    val name: String,
)
