package com.rct.payroll.infra.persistence.entity.stub

import com.rct.payroll.infra.persistence.entity.employee.EmployeePayroll
import com.rct.payroll.infra.persistence.entity.employee.EmployeePayrollStatus.CREATED
import java.math.BigDecimal
import java.time.LocalDateTime.now
import java.util.UUID.randomUUID

object EmployeePayrollStub {
    fun any() =
        EmployeePayroll(
            id = randomUUID(),
            employee = EmployeeStub.any(),
            payrollStatus = CREATED,
            salary = BigDecimal.valueOf(10000),
            createdAt = now(),
            updatedAt = now(),
            totalBenefits = BigDecimal.valueOf(1000),
            totalDiscounts = BigDecimal.valueOf(800),
            amountValue = BigDecimal.valueOf(9200),
        )
}
