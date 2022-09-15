package com.rct.payroll.core.service.adress

import com.rct.payroll.common.extension.logger
import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.address.Country
import com.rct.payroll.infra.persistence.repository.address.CountryRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Service
import java.util.UUID

/**
 * Country service
 *
 * @property repository
 * @constructor Create empty Country service
 */
@Service
class CountryService(
    private val repository: CountryRepository,
) {
    private val logger by logger()

    /**
     * Find all Countries
     *
     * @return ResponseEntity
     */
    fun findAll(): ResponseEntity<List<Country>> = ok(repository.findAll().toList())

    /**
     * Create Country
     *
     * @param country
     * @return ResponseEntity
     */
    fun create(country: Country): ResponseEntity<Country> {
        try {
            val saved = repository.save(country)
            return ResponseEntity(saved, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            logger.error(e.message)
            throw ResourceNotFoundException()
        }
    }

    /**
     * Get Country by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun findById(id: UUID): ResponseEntity<Country> =
        repository
            .findById(id)
            .map { country ->
                ok(country)
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Update Country by ID
     *
     * @param id UUID
     * @param newItem
     * @return ResponseEntity
     */
    fun updateById(
        id: UUID,
        newItem: Country,
    ): ResponseEntity<Country> =
        repository
            .findById(id)
            .map { currentCountry ->
                val updated: Country =
                    currentCountry
                        .copy(
                            id = newItem.id,
                            name = newItem.name,
                        )
                ok().body(repository.save(updated))
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Delete Country by id
     *
     * @param id UUID
     * @return
     */
    fun deleteById(id: UUID): ResponseEntity<Unit> {
        val country = repository.findById(id)
        return if (country.isPresent) {
            repository.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            throw ResourceNotFoundException()
        }
    }
}
