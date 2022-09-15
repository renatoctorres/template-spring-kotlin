package com.rct.payroll.infra.persistence.entity.stub

import com.rct.payroll.infra.persistence.entity.business.Discount
import com.rct.payroll.infra.persistence.entity.business.DiscountTypeEnum.VOUCHER
import com.rct.payroll.infra.persistence.entity.business.InclusionStatus.CREATED
import java.math.BigDecimal
import java.time.LocalDateTime.now
import java.util.UUID.randomUUID

object DiscountStub {
    fun any() =
        Discount(
            id = randomUUID(),
            createdAt = now(),
            updatedAt = now(),
            amountValue = BigDecimal.valueOf(1000),
            status = CREATED,
            payroll = EmployeePayrollStub.any(),
            type = VOUCHER,
        )
}
