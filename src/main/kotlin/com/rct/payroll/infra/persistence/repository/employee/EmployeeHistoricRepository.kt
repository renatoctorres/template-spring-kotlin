package com.rct.payroll.infra.persistence.repository.employee

import com.rct.payroll.infra.persistence.entity.employee.EmployeeHistoric
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface EmployeeHistoricRepository : CrudRepository<EmployeeHistoric, UUID> {
    fun findAllByEmployeeId(employeeId: UUID): List<EmployeeHistoric>
}
