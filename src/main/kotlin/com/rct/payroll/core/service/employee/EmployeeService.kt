package com.rct.payroll.core.service.employee

import com.rct.payroll.common.extension.logger
import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.employee.Employee
import com.rct.payroll.infra.persistence.repository.hr.EmployeeRepository
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
class EmployeeService(
    private val repository: EmployeeRepository,
) {
    private val logger by logger()

    /**
     * Find all Employees
     *
     * @return ResponseEntity
     */
    fun findAll(): ResponseEntity<List<Employee>> = ok(repository.findAll().toList())

    /**
     * Create Employee
     *
     * @param city Employee
     * @return ResponseEntity
     */
    fun create(city: Employee): ResponseEntity<Employee> {
        try {
            val saved = repository.save(city)
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
    fun findById(id: UUID): ResponseEntity<Employee> =
        repository
            .findById(id)
            .map { employee ->
                ok(employee)
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Get List of Employee by Employee ID
     *
     * @param departmentId
     * @return ResponseEntity
     */
    fun findAllByDepartmentId(departmentId: UUID): ResponseEntity<List<Employee>> {
        val employees = repository.findAllByDepartmentId(departmentId)
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
        newItem: Employee,
    ): ResponseEntity<Employee> =
        repository
            .findById(id)
            .map { currentEmployee ->
                val updated: Employee =
                    currentEmployee
                        .copy(
                            id = newItem.id,
                            sex = newItem.sex,
                            department = newItem.department,
                            actualSalary = newItem.actualSalary,
                            birthdayDate = newItem.birthdayDate,
                            hiringDate = newItem.hiringDate,
                            color = newItem.color,
                            name = newItem.name,
                        )
                ok().body(repository.save(updated))
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Delete Employee by id
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
