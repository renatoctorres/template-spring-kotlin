package com.rct.payroll.infra.persistence.entity.stub

import com.rct.payroll.infra.persistence.entity.hr.Sector
import java.util.UUID.randomUUID

object SectorStub {
    fun any() =
        Sector(
            id = randomUUID(),
            description = "description",
            department = DepartmentStub.any(),
            name = "name",
        )
}
