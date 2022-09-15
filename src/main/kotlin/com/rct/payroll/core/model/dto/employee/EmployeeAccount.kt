package com.rct.payroll.core.model.dto.employee

import com.rct.payroll.core.model.dto.bank.Bank
import java.util.UUID
import java.util.UUID.randomUUID

/**
 * Account employee DTO
 *
 * @property id UUID
 * @property employeeId UUID
 * @property bank
 * @property number Number
 * @property digit
 * @property active Boolean
 * @constructor Create empty Account employee
 */
data class EmployeeAccount(
    val id: UUID = randomUUID(),
    val employeeId: UUID,
    val bank: Bank,
    val number: Int,
    val digit: Int,
    val active: Boolean = true,
)
