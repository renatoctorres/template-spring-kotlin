package com.rct.payroll.infra.persistence.entity.address

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.AUTO
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.UUID

/**
 * City - Jakarta Entity
 *
 * @property id UUID
 * @property state
 * @property name String
 * @constructor Create empty City
 */
@Entity
data class City(
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(columnDefinition = "UUID")
    val id: UUID,
    @ManyToOne
    val state: State,
    val name: String,
)
