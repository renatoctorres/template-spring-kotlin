package com.rct.payroll.infra.persistence.entity.stub

import com.rct.payroll.infra.persistence.entity.employee.EmployeeHistoric
import java.math.BigDecimal
import java.time.LocalDateTime.now
import java.util.UUID.randomUUID

object EmployeeHistoricStub {
    fun any() =
        EmployeeHistoric(
            id = randomUUID(),
            department = DepartmentStub.any(),
            employee = EmployeeStub.any(),
            startDate = now(),
            salary = BigDecimal.valueOf(10000),
            updatedAt = now(),
            current = true,
            createdAt = now(),
            endDate = now(),
        )
}
