package com.rct.payroll.infra.persistence.repository.employee

import com.rct.payroll.infra.persistence.entity.employee.EmployeePayroll
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

/**
 * Payroll employee repository
 *
 * @constructor Create empty Payroll employee repository
 */
@Repository
interface EmployeePayrollRepository : CrudRepository<EmployeePayroll, UUID> {
    fun findAllByEmployeeId(employeeId: UUID): List<EmployeePayroll>
}
