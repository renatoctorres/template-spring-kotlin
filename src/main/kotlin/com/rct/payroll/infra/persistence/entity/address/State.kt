package com.rct.payroll.infra.persistence.entity.address

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.UUID

/**
 * State - Jakarta Entity
 *
 * @property id UUID
 * @property country Country
 * @property name String
 * @property initial String
 * @constructor Create empty State
 */
@Entity
data class State(
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(columnDefinition = "UUID")
    val id: UUID,
    @ManyToOne
    val country: Country,
    val name: String,
    val initial: String,
)
