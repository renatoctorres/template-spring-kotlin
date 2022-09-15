package com.rct.payroll.core.model.dto.business

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

/**
 * Inclusion DTO
 *
 * @property id UUID
 * @property value
 * @property status
 * @property createdAt LocalDateTime
 * @property updatedAt LocalDateTime
 * @constructor Create empty Inclusion
 */
open class Inclusion(
    open var id: UUID,
    open var value: BigDecimal,
    open var status: InclusionStatus = InclusionStatus.CREATED,
    open var createdAt: LocalDateTime,
    open var updatedAt: LocalDateTime,
)

/**
 * Inclusion Status Enumerator
 *
 * @constructor Create empty Inclusion status
 */
enum class InclusionStatus {
    CREATED,
    GENERATED,
    PAYED,
}
