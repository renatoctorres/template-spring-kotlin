package com.rct.payroll.infra.delivery.employee

import com.rct.payroll.core.service.employee.EmployeeAddressService
import com.rct.payroll.infra.persistence.entity.employee.EmployeeAddress
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
 * EmployeeAddress resource - API Rest
 * @property service EmployeeAddressService
 * @constructor Create empty EmployeeAddress resource
 */
@RestController
@RequestMapping("/employees")
class EmployeeAddressResource(
    private val service: EmployeeAddressService,
) {
    /**
     * GET Http Method
     * Find all EmployeeAddress
     * @return ResponseEntity
     */
    @GetMapping("/addresses")
    fun findAll(): ResponseEntity<List<EmployeeAddress>> = service.findAll()

    /**
     * GET Http Method
     * Find all EmployeeAddress by Employer ID
     * @return ResponseEntity
     */
    @GetMapping("/{employeeId}/addresses")
    fun findAllByEmployeeId(
        @PathVariable(value = "employeeId") employeeId: UUID,
    ): ResponseEntity<List<EmployeeAddress>> = service.findAllByEmployeeId(employeeId)

    /**
     * POST Http Method
     * Create EmployeeAddress
     * @param employeeAddress
     * @return ResponseEntity
     */
    @PostMapping("/addresses")
    fun create(
        @RequestBody employeeAddress: EmployeeAddress,
    ): ResponseEntity<EmployeeAddress> = service.create(employeeAddress)

    /**
     * GET Http Method
     * Get EmployeeAddress by id
     * @param id UUID UUID
     * @return ResponseEntity
     */
    @GetMapping("/addresses/{id}")
    fun findById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<EmployeeAddress> = service.findById(id)

    /**
     * PUT - Http Method
     * Update EmployeeAddress
     * @param id UUID
     * @param employeeAddress
     * @return ResponseEntity
     */
    @PutMapping("/addresses/{id}")
    fun update(
        @PathVariable(value = "id") id: UUID,
        @RequestBody employeeAddress: EmployeeAddress,
    ): ResponseEntity<EmployeeAddress> = service.updateById(id, employeeAddress)

    /**
     * Delete EmployeeAddress by id
     * @param id UUID
     * @return ResponseEntity
     */
    @DeleteMapping("/addresses/{id}")
    fun deleteById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Unit> = service.deleteById(id)
}
