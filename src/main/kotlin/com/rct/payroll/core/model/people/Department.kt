package com.rct.payroll.core.model.people

import java.util.UUID

data class Department(
    val id: UUID,
    val name: String,
    val description: String
)
