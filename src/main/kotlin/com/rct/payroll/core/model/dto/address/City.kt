package com.rct.payroll.core.model.dto.address

import java.util.UUID
import java.util.UUID.randomUUID

/**
 * City DTO
 *
 * @property id UUID
 * @property state
 * @property name String
 * @constructor Create empty City
 */
data class City(
    val id: UUID = randomUUID(),
    val state: State,
    val name: String,
)
