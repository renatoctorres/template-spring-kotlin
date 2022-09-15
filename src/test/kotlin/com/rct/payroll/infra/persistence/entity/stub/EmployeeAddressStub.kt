package com.rct.payroll.infra.persistence.entity.stub

import com.rct.payroll.core.model.dto.employee.StreetType.AVENUE
import com.rct.payroll.infra.persistence.entity.employee.EmployeeAddress
import java.time.LocalDateTime.now
import java.util.UUID.randomUUID

object EmployeeAddressStub {
    fun any() =
        EmployeeAddress(
            id = randomUUID(),
            employeeId = randomUUID(),
            city = CityStub.any(),
            street = "street",
            active = true,
            number = 1,
            streetType = AVENUE,
            zipCode = "00000",
            updatedAt = now(),
        )
}
