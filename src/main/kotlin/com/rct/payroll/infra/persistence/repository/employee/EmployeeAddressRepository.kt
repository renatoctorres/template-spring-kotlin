package com.rct.payroll.infra.persistence.repository.employee

import com.rct.payroll.infra.persistence.entity.employee.EmployeeAddress
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

/**
 * Address employee repository - Interface
 * @constructor Create empty Address employee repository
 */
@Repository
interface EmployeeAddressRepository : CrudRepository<EmployeeAddress, UUID> {
    fun findAllByEmployeeId(employerId: UUID): List<EmployeeAddress>
}
