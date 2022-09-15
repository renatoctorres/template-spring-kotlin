package com.rct.payroll.infra.persistence.entity.stub

import com.rct.payroll.infra.persistence.entity.business.Benefit
import com.rct.payroll.infra.persistence.entity.business.BenefitTypeEnum.VOUCHER
import com.rct.payroll.infra.persistence.entity.business.InclusionStatus.CREATED
import java.math.BigDecimal
import java.time.LocalDateTime.now
import java.util.UUID.randomUUID

object BenefitStub {
    fun any() =
        Benefit(
            id = randomUUID(),
            benefitType = VOUCHER,
            createdAt = now(),
            amountValue = BigDecimal.valueOf(1000),
            status = CREATED,
            updatedAt = now(),
            payroll = EmployeePayrollStub.any(),
        )
}
