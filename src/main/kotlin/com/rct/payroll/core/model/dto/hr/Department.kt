package com.rct.payroll.core.model.dto.hr

import java.util.UUID
import java.util.UUID.randomUUID

/**
 * Department DTO
 *
 * @property id UUID
 * @property name String
 * @property description
 * @constructor Create empty Department
 */
data class Department(
    val id: UUID = randomUUID(),
    val name: String,
    val description: String,
)
