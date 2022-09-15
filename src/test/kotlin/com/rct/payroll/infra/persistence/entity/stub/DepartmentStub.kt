package com.rct.payroll.infra.persistence.entity.stub

import com.rct.payroll.infra.persistence.entity.hr.Department
import java.util.UUID

object DepartmentStub {
    fun any() =
        Department(
            description = "description",
            name = "name",
            id = UUID.randomUUID(),
        )
}
