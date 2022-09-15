package com.rct.payroll.infra.persistence.repository.hr

import com.rct.payroll.infra.persistence.entity.employee.Employee
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

/**
 * Employee repository
 *
 * @constructor Create empty Employee repository
 */
@Repository
interface EmployeeRepository : CrudRepository<Employee, UUID> {
    fun findAllByDepartmentId(departmentId: UUID): List<Employee>
}
