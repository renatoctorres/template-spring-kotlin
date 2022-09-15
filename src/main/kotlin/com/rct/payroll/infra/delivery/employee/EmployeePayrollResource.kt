package com.rct.payroll.infra.delivery.employee

import com.rct.payroll.core.service.employee.EmployeePayrollService
import com.rct.payroll.infra.persistence.entity.employee.EmployeePayroll
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
 * EmployeePayroll resource - API Rest
 * @property service EmployeePayrollService
 * @constructor Create empty EmployeePayroll resource
 */
@RestController
@RequestMapping("/employees")
class EmployeePayrollResource(
    private val service: EmployeePayrollService,
) {
    /**
     * GET Http Method
     * Find all EmployeePayroll
     * @return ResponseEntity
     */
    @GetMapping("/payrolls")
    fun findAll(): ResponseEntity<List<EmployeePayroll>> = service.findAll()

    /**
     * GET Http Method
     * Find all EmployeePayroll by Employer ID
     * @return ResponseEntity
     */
    @GetMapping("/{employeeId}/payrolls")
    fun findAllByEmployeeId(
        @PathVariable(value = "employeeId") employeeId: UUID,
    ): ResponseEntity<List<EmployeePayroll>> = service.findAllByEmployeeId(employeeId)

    /**
     * POST Http Method
     * Create EmployeePayroll
     * @param employeePayroll
     * @return ResponseEntity
     */
    @PostMapping("/payrolls")
    fun create(
        @RequestBody employeePayroll: EmployeePayroll,
    ): ResponseEntity<EmployeePayroll> = service.create(employeePayroll)

    /**
     * GET Http Method
     * Get EmployeePayroll by id
     * @param id UUID UUID
     * @return ResponseEntity
     */
    @GetMapping("/payrolls/{id}")
    fun findById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<EmployeePayroll> = service.findById(id)

    /**
     * PUT - Http Method
     * Update EmployeePayroll
     * @param id UUID
     * @param employeePayroll
     * @return ResponseEntity
     */
    @PutMapping("/payrolls/{id}")
    fun update(
        @PathVariable(value = "id") id: UUID,
        @RequestBody employeePayroll: EmployeePayroll,
    ): ResponseEntity<EmployeePayroll> = service.updateById(id, employeePayroll)

    /**
     * Delete EmployeePayroll by id
     * @param id UUID
     * @return ResponseEntity
     */
    @DeleteMapping("/payrolls/{id}")
    fun deleteById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Unit> = service.deleteById(id)
}
