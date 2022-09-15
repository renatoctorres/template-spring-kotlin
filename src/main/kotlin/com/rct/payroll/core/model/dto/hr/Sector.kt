package com.rct.payroll.core.model.dto.hr

import java.util.UUID
import java.util.UUID.randomUUID

/**
 * Sector DTO
 *
 * @property id UUID
 * @property name String
 * @property description
 * @property department
 * @constructor Create empty Sector
 */
data class Sector(
    val id: UUID = randomUUID(),
    val name: String,
    val description: String,
    val department: Department,
)
