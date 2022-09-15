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
import java.util.UUID.randomUUID

/**
 * Benefit - Jakarta Entity
 *
 * @property id UUID
 * @property amountValue BigDecimal
 * @property status InclusionStatus
 * @property updatedAt LocalDateTime
 * @property createdAt LocalDateTime
 * @property benefitType BenefitTypeEnum
 * @property payroll EmployeePayroll
 * @constructor Create empty Benefit
 */
@Entity
data class Benefit(
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(columnDefinition = "UUID")
    val id: UUID = randomUUID(),
    val amountValue: BigDecimal,
    @Enumerated(STRING)
    val status: InclusionStatus,
    @LastModifiedDate
    val updatedAt: LocalDateTime,
    @CreatedDate
    val createdAt: LocalDateTime = now(),
    @Enumerated(STRING)
    val benefitType: BenefitTypeEnum,
    @ManyToOne
    val payroll: EmployeePayroll,
)

/**
 * Benefit type enum
 * @constructor Create empty Benefit type enum
 */
enum class BenefitTypeEnum {
    TRANSPORT,
    VOUCHER,
    MEAL_TICKET,
    DELAY,
    ABSENCE,
    INCOME_TAX,
    OVERTIME,
}
