package com.rct.payroll.core.model.dto.address

import java.util.UUID
import java.util.UUID.randomUUID

data class State(
    val id: UUID = randomUUID(),
    val name: String,
    val country: Country,
)
