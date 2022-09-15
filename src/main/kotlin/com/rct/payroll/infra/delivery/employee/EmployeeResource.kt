package com.rct.payroll.infra.delivery.employee

import com.rct.payroll.core.service.employee.EmployeeService
import com.rct.payroll.infra.persistence.entity.employee.Employee
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

/**
 * Employee resource - API Rest
 * @property service EmployeeService
 * @constructor Create empty Employee resource
 */
@RestController
@RequestMapping("/employees")
class EmployeeResource(
    private val service: EmployeeService,
) {
    /**
     * GET Http Method
     * Find all Employee
     * @return ResponseEntity
     */
    @GetMapping
    fun findAll(): ResponseEntity<List<Employee>> = service.findAll()

    /**
     * GET Http Method
     * Find all Employee by Department ID
     * @return ResponseEntity
     */
    @GetMapping("/departments/{departmentId}")
    fun findAllByDepartmentId(
        @PathVariable(value = "departmentId") departmentId: UUID,
    ): ResponseEntity<List<Employee>> = service.findAllByDepartmentId(departmentId)

    /**
     * POST Http Method
     * Create Employee
     * @param employee
     * @return ResponseEntity
     */
    @PostMapping
    fun create(
        @RequestBody employee: Employee,
    ): ResponseEntity<Employee> = service.create(employee)

    /**
     * GET Http Method
     * Get Employee by id
     * @param id UUID UUID
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    fun findById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Employee> = service.findById(id)

    /**
     * PUT - Http Method
     * Update Employee
     * @param id UUID
     * @param employee
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    fun update(
        @PathVariable(value = "id") id: UUID,
        @RequestBody employee: Employee,
    ): ResponseEntity<Employee> = service.updateById(id, employee)

    /**
     * Delete Employee by id
     * @param id UUID
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Unit> = service.deleteById(id)
}
