package com.rct.payroll.core.service.hr

import com.rct.payroll.common.extension.logger
import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.hr.Sector
import com.rct.payroll.infra.persistence.repository.hr.SectorRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Service
import java.util.UUID

/**
 * Sector service
 *
 * @property repository
 * @constructor Create empty Sector service
 */
@Service
class SectorService(
    private val repository: SectorRepository,
) {
    private val logger by logger()

    /**
     * Find all Sectors
     *
     * @return ResponseEntity
     */
    fun findAll(): ResponseEntity<List<Sector>> = ok(repository.findAll().toList())

    /**
     * Create Sector
     *
     * @param city Sector
     * @return ResponseEntity
     */
    fun create(city: Sector): ResponseEntity<Sector> {
        try {
            val saved = repository.save(city)
            return ResponseEntity(saved, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            logger.error(e.message)
            return throw ResourceNotFoundException()
        }
    }

    /**
     * Get Sector by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun findById(id: UUID): ResponseEntity<Sector> =
        repository
            .findById(id)
            .map { city ->
                ok(city)
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Get Sector by  Department id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun findAllByDepartmentId(departmentId: UUID): ResponseEntity<List<Sector>> =
        ok(repository.findAllByDepartmentId(departmentId).toList())

    /**
     * Update Sector by ID
     *
     * @param id UUID
     * @param newItem
     * @return ResponseEntity
     */
    fun updateById(
        id: UUID,
        newItem: Sector,
    ): ResponseEntity<Sector> =
        repository
            .findById(id)
            .map { currentSector ->
                val updated: Sector =
                    currentSector
                        .copy(
                            id = newItem.id,
                            name = newItem.name,
                            description = newItem.description,
                        )
                ok().body(repository.save(updated))
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Delete Sector by id
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
