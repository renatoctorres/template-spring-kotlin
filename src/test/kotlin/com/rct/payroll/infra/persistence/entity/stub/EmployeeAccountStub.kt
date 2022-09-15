package com.rct.payroll.infra.persistence.entity.stub

import com.rct.payroll.infra.persistence.entity.employee.EmployeeAccount
import java.util.UUID

object EmployeeAccountStub {
    fun any() =
        EmployeeAccount(
            id = UUID.randomUUID(),
            employee = EmployeeStub.any(),
            bank = BankStub.any(),
            active = true,
            number = 888,
            digit = 2,
        )
}
