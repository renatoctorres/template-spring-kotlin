package com.rct.payroll.infra.delivery.employee

import com.rct.payroll.core.service.employee.EmployeeAccountService
import com.rct.payroll.infra.persistence.entity.employee.EmployeeAccount
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
 * EmployeeAccount resource - API Rest
 * @property service EmployeeAccountService
 * @constructor Create empty EmployeeAccount resource
 */
@RestController
@RequestMapping("/employees")
class EmployeeAccountResource(
    private val service: EmployeeAccountService,
) {
    /**
     * GET Http Method
     * Find all EmployeeAccount
     * @return ResponseEntity
     */
    @GetMapping("/accounts")
    fun findAll(): ResponseEntity<List<EmployeeAccount>> = service.findAll()

    /**
     * GET Http Method
     * Find all EmployeeAccount by Employer ID
     * @return ResponseEntity
     */
    @GetMapping("/{employeeId}/accounts")
    fun findAllByEmployeeAccountId(
        @PathVariable(value = "employeeId") employeeId: UUID,
    ): ResponseEntity<List<EmployeeAccount>> = service.findAllByEmployeeId(employeeId)

    /**
     * POST Http Method
     * Create EmployeeAccount
     * @param employeeAccount
     * @return ResponseEntity
     */
    @PostMapping("/accounts")
    fun create(
        @RequestBody employeeAccount: EmployeeAccount,
    ): ResponseEntity<EmployeeAccount> = service.create(employeeAccount)

    /**
     * GET Http Method
     * Get EmployeeAccount by id
     * @param id UUID UUID
     * @return ResponseEntity
     */
    @GetMapping("/accounts/{id}")
    fun findById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<EmployeeAccount> = service.findById(id)

    /**
     * PUT - Http Method
     * Update EmployeeAccount
     * @param id UUID
     * @param employeeAccount
     * @return ResponseEntity
     */
    @PutMapping("/accounts/{id}")
    fun update(
        @PathVariable(value = "id") id: UUID,
        @RequestBody employeeAccount: EmployeeAccount,
    ): ResponseEntity<EmployeeAccount> = service.updateById(id, employeeAccount)

    /**
     * Delete EmployeeAccount by id
     * @param id UUID
     * @return ResponseEntity
     */
    @DeleteMapping("/accounts/{id}")
    fun deleteById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Unit> = service.deleteById(id)
}
