package com.rct.payroll.infra.persistence.entity.employee

import com.rct.payroll.infra.persistence.entity.bank.Bank
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import java.util.UUID

/**
 * Account employee - Jakarta Entity
 *
 * @property id UUID
 * @property employee Employee
 * @property bank Bank
 * @property number Number Int
 * @property digit Int
 * @property active Boolean
 * @constructor Create empty Account employee
 */
@Entity
data class EmployeeAccount(
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(columnDefinition = "UUID")
    val id: UUID,
    @OneToOne
    val employee: Employee,
    @ManyToOne
    val bank: Bank,
    val number: Int,
    val digit: Int,
    val active: Boolean,
)
