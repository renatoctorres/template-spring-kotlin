package com.rct.payroll.infra.persistence.entity.stub

import com.rct.payroll.infra.persistence.entity.address.City
import java.util.UUID

object CityStub {
    fun any() =
        City(
            id = UUID.randomUUID(),
            name = "city",
            state = StateStub.any(),
        )
}
