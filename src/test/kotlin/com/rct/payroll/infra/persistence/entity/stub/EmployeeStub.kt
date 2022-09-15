package com.rct.payroll.infra.persistence.entity.stub

import com.rct.payroll.core.model.dto.hr.Color
import com.rct.payroll.core.model.dto.hr.Sex
import com.rct.payroll.infra.persistence.entity.employee.Employee
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

object EmployeeStub {
    fun any() =
        Employee(
            color = Color.BROWN,
            name = "name",
            department = DepartmentStub.any(),
            actualSalary = BigDecimal.valueOf(10000),
            birthdayDate = LocalDateTime.of(1980, 6, 6, 15, 1),
            hiringDate = LocalDateTime.of(2021, 1, 1, 15, 1),
            sex = Sex.MALE,
            departmentHistory = listOf(),
            payrollHistory = listOf(),
            id = UUID.randomUUID(),
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
        )
}
