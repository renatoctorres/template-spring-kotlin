package com.rct.payroll.core.service.hr

import com.rct.payroll.common.extension.logger
import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.hr.Department
import com.rct.payroll.infra.persistence.repository.hr.DepartmentRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Service
import java.util.UUID

/**
 * Department service
 *
 * @property repository
 * @constructor Create empty Department service
 */
@Service
class DepartmentService(
    private val repository: DepartmentRepository,
) {
    private val logger by logger()

    /**
     * Find all Departments
     *
     * @return ResponseEntity
     */
    fun findAll(): ResponseEntity<List<Department>> = ok(repository.findAll().toList())

    /**
     * Create Department
     *
     * @param city Department
     * @return ResponseEntity
     */
    fun create(city: Department): ResponseEntity<Department> {
        try {
            val saved = repository.save(city)
            return ResponseEntity(saved, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            logger.error(e.message)
            return throw ResourceNotFoundException()
        }
    }

    /**
     * Get Department by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun findById(id: UUID): ResponseEntity<Department> =
        repository
            .findById(id)
            .map { city ->
                ok(city)
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Update Department by ID
     *
     * @param id UUID
     * @param newItem
     * @return ResponseEntity
     */
    fun updateById(
        id: UUID,
        newItem: Department,
    ): ResponseEntity<Department> =
        repository
            .findById(id)
            .map { currentDepartment ->
                val updated: Department =
                    currentDepartment
                        .copy(
                            id = newItem.id,
                            name = newItem.name,
                            description = newItem.description,
                        )
                ok().body(repository.save(updated))
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Delete Department by id
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
