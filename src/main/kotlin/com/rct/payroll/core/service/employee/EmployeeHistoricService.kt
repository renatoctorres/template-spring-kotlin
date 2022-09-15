package com.rct.payroll.core.service.employee

import com.rct.payroll.common.extension.logger
import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.employee.EmployeeHistoric
import com.rct.payroll.infra.persistence.repository.employee.EmployeeHistoricRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Service
import java.util.UUID

/**
 * Employee service
 *
 * @property repository
 * @constructor Create empty Employee service
 */
@Service
class EmployeeHistoricService(
    private val repository: EmployeeHistoricRepository,
) {
    private val logger by logger()

    /**
     * Find all Employees
     *
     * @return ResponseEntity
     */
    fun findAll(): ResponseEntity<List<EmployeeHistoric>> = ok(repository.findAll().toList())

    /**
     * Create Employee
     *
     * @param employeeHistoric Employee
     * @return ResponseEntity
     */
    fun create(employeeHistoric: EmployeeHistoric): ResponseEntity<EmployeeHistoric> {
        try {
            val saved = repository.save(employeeHistoric)
            return ResponseEntity(saved, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            logger.error(e.message)
            return throw ResourceNotFoundException()
        }
    }

    /**
     * Get Employee by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun findById(id: UUID): ResponseEntity<EmployeeHistoric> =
        repository
            .findById(id)
            .map { employee ->
                ok(employee)
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Get Employee by Employee ID
     *
     * @param employeeId UUID
     * @return ResponseEntity
     */
    fun findAllByEmployeeId(employeeId: UUID): ResponseEntity<List<EmployeeHistoric>> {
        val employees = repository.findAllByEmployeeId(employeeId)
        return if (employees.isNotEmpty()) {
            ok(employees)
        } else {
            throw ResourceNotFoundException()
        }
    }

    /**
     * Update Employee by ID
     *
     * @param id UUID
     * @param newItem
     * @return ResponseEntity
     */
    fun updateById(
        id: UUID,
        newItem: EmployeeHistoric,
    ): ResponseEntity<EmployeeHistoric> =
        repository
            .findById(id)
            .map { currentEmployeeHistoric ->
                val updated: EmployeeHistoric =
                    currentEmployeeHistoric
                        .copy(
                            id = newItem.id,
                            department = newItem.department,
                            salary = newItem.salary,
                            current = newItem.current,
                            employee = newItem.employee,
                            startDate = newItem.startDate,
                            endDate = newItem.endDate,
                        )
                ok().body(repository.save(updated))
            }.orElseThrow { ResourceNotFoundException() }

// .orElseThrow { ResourceNotFoundException() }

    /**
     * Delete Employee by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun deleteById(id: UUID): ResponseEntity<Unit> {
        val employeeHistoric = repository.findById(id)
        return if (employeeHistoric.isPresent) {
            repository.deleteById(id)
            noContent().build()
        } else {
            throw ResourceNotFoundException()
        }
    }
}
