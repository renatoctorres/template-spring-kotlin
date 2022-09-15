package com.rct.payroll.core.model.dto.business

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID
import java.util.UUID.randomUUID

/**
 * Discount DTO
 *
 * @property id UUID
 * @property value
 * @property createdAt LocalDateTime
 * @property status
 * @property updatedAt LocalDateTime
 * @property type
 * @constructor Create empty Discount
 */
data class Discount(
    override var id: UUID = randomUUID(),
    override var value: BigDecimal,
    override var createdAt: LocalDateTime,
    override var status: InclusionStatus = InclusionStatus.CREATED,
    override var updatedAt: LocalDateTime,
    val type: DiscountTypeEnum,
) : Inclusion(id, value, status, createdAt, updatedAt)

enum class DiscountTypeEnum {
    TRANSPORT,
    VOUCHER,
    MEAL_TICKET,
    DELAY,
    ABSENCE,
    INCOME_TAX,
}
