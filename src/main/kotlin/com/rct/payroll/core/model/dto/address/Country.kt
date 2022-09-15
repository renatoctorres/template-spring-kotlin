package com.rct.payroll.core.model.dto.address

import java.util.UUID
import java.util.UUID.randomUUID

data class Country(
    val id: UUID = randomUUID(),
    val name: String,
)
