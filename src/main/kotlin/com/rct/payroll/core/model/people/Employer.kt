package com.rct.payroll.core.model.people

import java.time.LocalDateTime
import java.util.UUID

data class Employer(



    val id: UUID,
    val name: String,
    val color: Color,
    val sex: Sex,
    val birthdayDate: LocalDateTime,
    val hiringDate: LocalDateTime,
    val departmentId: String
)