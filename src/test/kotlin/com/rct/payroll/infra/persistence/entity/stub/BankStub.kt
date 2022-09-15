package com.rct.payroll.infra.persistence.entity.stub

import com.rct.payroll.infra.persistence.entity.bank.Bank
import java.util.UUID

object BankStub {
    fun any() =
        Bank(
            id = UUID.randomUUID(),
            name = "name",
            code = "044",
        )
}
