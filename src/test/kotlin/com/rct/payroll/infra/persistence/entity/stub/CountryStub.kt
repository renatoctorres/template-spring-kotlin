package com.rct.payroll.infra.persistence.entity.stub

import com.rct.payroll.infra.persistence.entity.address.Country
import java.util.UUID

object CountryStub {
    fun any() =
        Country(
            id = UUID.randomUUID(),
            name = "name",
        )
}
