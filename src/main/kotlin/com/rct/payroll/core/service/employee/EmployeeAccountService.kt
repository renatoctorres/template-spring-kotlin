package com.rct.payroll.core.service.employee

import com.rct.payroll.common.extension.logger
import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.employee.EmployeeAccount
import com.rct.payroll.infra.persistence.repository.employee.EmployeeAccountRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Service
import java.util.UUID

/**
 * EmployeeAccount service
 *
 * @property repository
 * @constructor Create empty EmployeeAccount service
 */
@Service
class EmployeeAccountService(
    private val repository: EmployeeAccountRepository,
) {
    private val logger by logger()

    /**
     * Find all EmployeeAccounts
     *
     * @return ResponseEntity
     */
    fun findAll(): ResponseEntity<List<EmployeeAccount>> = ok(repository.findAll().toList())

    /**
     * Create EmployeeAccount
     *
     * @param city EmployeeAccount
     * @return ResponseEntity
     */
    fun create(city: EmployeeAccount): ResponseEntity<EmployeeAccount> {
        try {
            val saved = repository.save(city)
            return ResponseEntity(saved, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            logger.error(e.message)
            return throw ResourceNotFoundException()
        }
    }

    /**
     * Get EmployeeAccount by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun findById(id: UUID): ResponseEntity<EmployeeAccount> =
        repository
            .findById(id)
            .map { city ->
                ok(city)
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Get List of EmployeeAccount by Employee ID
     *
     * @param employeeId
     * @return ResponseEntity
     */
    fun findAllByEmployeeId(employeeId: UUID): ResponseEntity<List<EmployeeAccount>> {
        val employeeAccounts = repository.findAllByEmployeeId(employeeId)
        return if (employeeAccounts.isNotEmpty()) {
            ok(employeeAccounts)
        } else {
            throw ResourceNotFoundException()
        }
    }

    /**
     * Update EmployeeAccount by ID
     *
     * @param id UUID
     * @param newItem
     * @return ResponseEntity
     */
    fun updateById(
        id: UUID,
        newItem: EmployeeAccount,
    ): ResponseEntity<EmployeeAccount> =
        repository
            .findById(id)
            .map { currentEmployeeAccount ->
                val updated: EmployeeAccount =
                    currentEmployeeAccount
                        .copy(
                            id = newItem.id,
                            active = newItem.active,
                            number = newItem.number,
                            employee = newItem.employee,
                            bank = newItem.bank,
                            digit = newItem.digit,
                        )
                ok().body(repository.save(updated))
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Delete EmployeeAccount by id
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
