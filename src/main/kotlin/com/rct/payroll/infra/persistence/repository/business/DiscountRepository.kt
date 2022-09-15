package com.rct.payroll.infra.persistence.repository.business

import com.rct.payroll.infra.persistence.entity.business.Discount
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

/**
 * Discount repository
 *
 * @constructor Create empty Discount repository
 */
@Repository
interface DiscountRepository : CrudRepository<Discount, UUID> {
    fun findAllByPayrollId(payrollId: UUID): List<Discount>
}
