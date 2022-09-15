package com.rct.payroll.core.service.adress

import com.rct.payroll.common.extension.logger
import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.address.State
import com.rct.payroll.infra.persistence.repository.address.StateRepository
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Service
import java.util.UUID

/**
 * State service
 *
 * @property repository
 * @constructor Create empty State service
 */
@Service
class StateService(
    private val repository: StateRepository,
) {
    private val logger by logger()

    /**
     * Find all States
     *
     * @return ResponseEntity
     */
    fun findAll(): ResponseEntity<List<State>> = ok(repository.findAll())

    /**
     * Create State
     *
     * @param state
     * @return ResponseEntity
     */
    fun create(state: State): ResponseEntity<State> {
        try {
            val saved = repository.save(state)
            return ResponseEntity(saved, CREATED)
        } catch (e: IllegalArgumentException) {
            logger.error(e.message)
            throw ResourceNotFoundException()
        }
    }

    /**
     * Get State by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun findById(id: UUID): ResponseEntity<State> =
        repository
            .findById(id)
            .map { state ->
                ok(state)
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Get State by Country ID
     *
     * @param countryId UUID
     * @return ResponseEntity
     */
    fun findAllByCountryId(countryId: UUID): ResponseEntity<List<State>> {
        val states = repository.findAllByCountryId(countryId)
        return if (states.isNotEmpty()) {
            ok(states)
        } else {
            throw ResourceNotFoundException()
        }
    }

    /**
     * Update State by ID
     *
     * @param id UUID
     * @param newItem
     * @return ResponseEntity
     */
    fun updateById(
        id: UUID,
        newItem: State,
    ): ResponseEntity<State> =
        repository
            .findById(id)
            .map { currentState ->
                val updated: State =
                    currentState
                        .copy(
                            id = newItem.id,
                            country = newItem.country,
                            name = newItem.name,
                            initial = newItem.initial,
                        )
                ok().body(repository.save(updated))
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Delete State by id
     *
     * @param id UUID
     * @return
     */
    fun deleteById(id: UUID): ResponseEntity<Unit> {
        val state = repository.findById(id)
        return if (state.isPresent) {
            repository.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            throw ResourceNotFoundException()
        }
    }
}
