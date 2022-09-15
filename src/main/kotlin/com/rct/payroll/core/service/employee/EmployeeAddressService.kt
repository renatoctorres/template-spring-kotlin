package com.rct.payroll.core.service.employee

import com.rct.payroll.common.extension.logger
import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.employee.EmployeeAddress
import com.rct.payroll.infra.persistence.repository.employee.EmployeeAddressRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Service
import java.util.UUID

/**
 * EmployeeAddress service
 *
 * @property repository
 * @constructor Create empty EmployeeAddress service
 */
@Service
class EmployeeAddressService(
    private val repository: EmployeeAddressRepository,
) {
    private val logger by logger()

    /**
     * Find all EmployeeAddresss
     *
     * @return ResponseEntity
     */
    fun findAll(): ResponseEntity<List<EmployeeAddress>> = ok(repository.findAll().toList())

    /**
     * Create EmployeeAddress
     *
     * @param city EmployeeAddress
     * @return ResponseEntity
     */
    fun create(city: EmployeeAddress): ResponseEntity<EmployeeAddress> {
        try {
            val saved = repository.save(city)
            return ResponseEntity(saved, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            logger.error(e.message)
            return throw ResourceNotFoundException()
        }
    }

    /**
     * Get EmployeeAddress by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun findById(id: UUID): ResponseEntity<EmployeeAddress> =
        repository
            .findById(id)
            .map { city ->
                ok(city)
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Get List of EmployeeAddress by Employee ID
     *
     * @param employeeId
     * @return ResponseEntity
     */
    fun findAllByEmployeeId(employeeId: UUID): ResponseEntity<List<EmployeeAddress>> {
        val employeeAddresses = repository.findAllByEmployeeId(employeeId)
        return if (employeeAddresses.isNotEmpty()) {
            ok(employeeAddresses)
        } else {
            throw ResourceNotFoundException()
        }
    }

    /**
     * Update EmployeeAddress by ID
     *
     * @param id UUID
     * @param newItem
     * @return ResponseEntity
     */
    fun updateById(
        id: UUID,
        newItem: EmployeeAddress,
    ): ResponseEntity<EmployeeAddress> =
        repository
            .findById(id)
            .map { currentEmployeeAddress ->
                val updated: EmployeeAddress =
                    currentEmployeeAddress
                        .copy(
                            id = newItem.id,
                            employeeId = newItem.employeeId,
                            city = newItem.city,
                            active = newItem.active,
                            streetType = newItem.streetType,
                            zipCode = newItem.zipCode,
                            number = newItem.number,
                            street = newItem.street,
                        )
                ok().body(repository.save(updated))
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Delete EmployeeAddress by id
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
