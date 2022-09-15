package com.rct.payroll.infra.persistence.repository.business

import com.rct.payroll.infra.persistence.entity.business.Benefit
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

/**
 * Benefit repository
 *
 * @constructor Create empty Benefit repository
 */
@Repository
interface BenefitRepository : CrudRepository<Benefit, UUID> {
    fun findAllByPayrollId(payrollId: UUID): List<Benefit>
}
