package com.rct.payroll.core.service.employee

import com.rct.payroll.common.extension.logger
import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.employee.EmployeePayroll
import com.rct.payroll.infra.persistence.repository.employee.EmployeePayrollRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Service
import java.util.UUID

/**
 * EmployeePayroll service
 *
 * @property repository
 * @constructor Create empty EmployeePayroll service
 */
@Service
class EmployeePayrollService(
    private val repository: EmployeePayrollRepository,
) {
    private val logger by logger()

    /**
     * Find all EmployeePayrolls
     *
     * @return ResponseEntity
     */
    fun findAll(): ResponseEntity<List<EmployeePayroll>> = ok(repository.findAll().toList())

    /**
     * Create EmployeePayroll
     *
     * @param city EmployeePayroll
     * @return ResponseEntity
     */
    fun create(city: EmployeePayroll): ResponseEntity<EmployeePayroll> {
        try {
            val saved = repository.save(city)
            return ResponseEntity(saved, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            logger.error(e.message)
            return throw ResourceNotFoundException()
        }
    }

    /**
     * Get EmployeePayroll by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun findById(id: UUID): ResponseEntity<EmployeePayroll> =
        repository
            .findById(id)
            .map { city ->
                ok(city)
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Get List of EmployeePayroll by Employee ID
     *
     * @param employeeId
     * @return ResponseEntity
     */
    fun findAllByEmployeeId(employeeId: UUID): ResponseEntity<List<EmployeePayroll>> {
        val employeePayrolls = repository.findAllByEmployeeId(employeeId)
        return if (employeePayrolls.isNotEmpty()) {
            ok(employeePayrolls)
        } else {
            throw ResourceNotFoundException()
        }
    }

    /**
     * Update EmployeePayroll by ID
     *
     * @param id UUID
     * @param newItem
     * @return ResponseEntity
     */
    fun updateById(
        id: UUID,
        newItem: EmployeePayroll,
    ): ResponseEntity<EmployeePayroll> =
        repository
            .findById(id)
            .map { currentEmployeePayroll ->
                val updated: EmployeePayroll =
                    currentEmployeePayroll
                        .copy(
                            id = newItem.id,
                            amountValue = newItem.amountValue,
                            employee = newItem.employee,
                            payrollStatus = newItem.payrollStatus,
                            totalBenefits = newItem.totalBenefits,
                            totalDiscounts = newItem.totalDiscounts,
                        )
                ok().body(repository.save(updated))
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Delete EmployeePayroll by id
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
