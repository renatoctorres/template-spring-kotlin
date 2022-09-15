package com.rct.payroll.infra.persistence.entity.business

import com.rct.payroll.infra.persistence.entity.employee.EmployeePayroll
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType.STRING
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.UUID

/**
 * Discount - Jakarta Entity
 *
 * @property id UUID
 * @property amountValue Amount of Discount
 * @property status Discount Status
 * @property updatedAt LocalDateTime
 * @property createdAt LocalDateTime
 * @property payroll Payroll Reference
 * @property type Type of Discount
 * @constructor Create empty Discount
 */
@Entity
data class Discount(
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(columnDefinition = "UUID")
    val id: UUID,
    val amountValue: BigDecimal,
    @Enumerated(STRING)
    val status: InclusionStatus,
    @LastModifiedDate
    val updatedAt: LocalDateTime,
    @CreatedDate
    val createdAt: LocalDateTime = now(),
    @ManyToOne
    val payroll: EmployeePayroll,
    @Enumerated(STRING)
    val type: DiscountTypeEnum,
)

/**
 * Discount type enum
 *
 * @constructor Create empty Discount type enum
 */
enum class DiscountTypeEnum {
    ABSENCE,
    DELAY,
    INCOME_TAX,
    MEAL_TICKET,
    TRANSPORT,
    VOUCHER,
}
