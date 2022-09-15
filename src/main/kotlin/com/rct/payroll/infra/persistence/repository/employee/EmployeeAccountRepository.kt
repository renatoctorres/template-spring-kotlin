package com.rct.payroll.infra.persistence.repository.employee

import com.rct.payroll.infra.persistence.entity.employee.EmployeeAccount
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

/**
 * Account Employee Repository - Interface
 * @constructor Create empty Account employee repository
 */
@Repository
interface EmployeeAccountRepository : CrudRepository<EmployeeAccount, UUID> {
    fun findAllByEmployeeId(employeeId: UUID): List<EmployeeAccount>
}
