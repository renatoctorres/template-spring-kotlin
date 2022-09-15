package com.rct.payroll.core.service.exception

class BadRequestException(
    override val message: String,
) : RuntimeException(message)
