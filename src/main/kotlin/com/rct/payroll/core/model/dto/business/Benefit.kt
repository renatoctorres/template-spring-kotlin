package com.rct.payroll.core.model.dto.business

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID
import java.util.UUID.randomUUID

/**
 * Benefit DTO
 *
 * @property id UUID
 * @property value
 * @property createdAt LocalDateTime
 * @property updatedAt LocalDateTime
 * @property type
 * @constructor Create empty Benefit
 */
data class Benefit(
    override var id: UUID = randomUUID(),
    override var value: BigDecimal,
    override var status: InclusionStatus = InclusionStatus.CREATED,
    override var createdAt: LocalDateTime,
    override var updatedAt: LocalDateTime,
    val type: BenefitTypeEnum?,
) : Inclusion(id, value, status, createdAt, updatedAt)

/**
 * Benefit type enum
 *
 * @constructor Create empty Benefit type enum
 */
enum class BenefitTypeEnum {
    TRANSPORT,
    VOUCHER,
    MEAL_TICKET,
    DELAY,
    ABSENCE,
    INCOME_TAX,
}
