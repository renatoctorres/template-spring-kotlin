package com.rct.payroll.core.service.adress

import com.rct.payroll.common.extension.logger
import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.address.City
import com.rct.payroll.infra.persistence.repository.address.CityRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Service
import java.util.UUID

/**
 * City service
 *
 * @property repository
 * @constructor Create empty City service
 */
@Service
class CityService(
    private val repository: CityRepository,
) {
    private val logger by logger()

    /**
     * Find all Cities
     *
     * @return ResponseEntity
     */
    fun findAll(): ResponseEntity<List<City>> = ok(repository.findAll().toList())

    /**
     * Create City
     *
     * @param city City
     * @return ResponseEntity
     */
    fun create(city: City): ResponseEntity<City> {
        try {
            val saved = repository.save(city)
            return ResponseEntity(saved, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            logger.error(e.message)
            return throw ResourceNotFoundException()
        }
    }

    /**
     * Get City by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun findById(id: UUID): ResponseEntity<City> =
        repository
            .findById(id)
            .map { city ->
                ok(city)
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Get City by State ID
     *
     * @param stateId
     * @return ResponseEntity
     */
    fun findAllByStateId(stateId: UUID): ResponseEntity<List<City>> {
        val cities = repository.findAllByStateId(stateId)
        return if (cities.isNotEmpty()) {
            ok(cities)
        } else {
            throw ResourceNotFoundException()
        }
    }

    /**
     * Update City by ID
     *
     * @param id UUID
     * @param newItem
     * @return ResponseEntity
     */
    fun updateById(
        id: UUID,
        newItem: City,
    ): ResponseEntity<City> =
        repository
            .findById(id)
            .map { currentCity ->
                val updated: City =
                    currentCity
                        .copy(
                            id = newItem.id,
                            state = newItem.state,
                            name = newItem.name,
                        )
                ok().body(repository.save(updated))
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Delete City by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun deleteById(id: UUID): ResponseEntity<Unit> {
        val city = repository.findById(id)
        return if (city.isPresent) {
            repository.deleteById(id)
            noContent().build()
        } else {
            throw ResourceNotFoundException()
        }
    }
}
