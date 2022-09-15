package com.rct.payroll.infra.persistence.entity.stub

import com.rct.payroll.infra.persistence.entity.address.State
import java.util.UUID

object StateStub {
    fun any() =
        State(
            id = UUID.randomUUID(),
            name = "name",
            country = CountryStub.any(),
            initial = "XX",
        )
}
