package com.rct.payroll.infra.delivery.employee

import com.rct.payroll.core.service.employee.EmployeeHistoricService
import com.rct.payroll.infra.persistence.entity.employee.EmployeeHistoric
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
 * EmployeeHistoric resource - API Rest
 * @property service EmployeeHistoricService
 * @constructor Create empty EmployeeHistoric resource
 */
@RestController
@RequestMapping("/employees")
class EmployeeHistoricResource(
    private val service: EmployeeHistoricService,
) {
    /**
     * GET Http Method
     * Find all EmployeeHistoric
     * @return ResponseEntity
     */
    @GetMapping("/historic")
    fun findAll(): ResponseEntity<List<EmployeeHistoric>> = service.findAll()

    /**
     * GET Http Method
     * Find all EmployeeHistoric by Employer ID
     * @return ResponseEntity
     */
    @GetMapping("/{employeeId}/historic")
    fun findAllByEmployeeId(
        @PathVariable(value = "employeeId") employeeId: UUID,
    ): ResponseEntity<List<EmployeeHistoric>> = service.findAllByEmployeeId(employeeId)

    /**
     * POST Http Method
     * Create EmployeeHistoric
     * @param employeeHistoric
     * @return ResponseEntity
     */
    @PostMapping("/historic")
    fun create(
        @RequestBody employeeHistoric: EmployeeHistoric,
    ): ResponseEntity<EmployeeHistoric> = service.create(employeeHistoric)

    /**
     * GET Http Method
     * Get EmployeeHistoric by id
     * @param id UUID UUID
     * @return ResponseEntity
     */
    @GetMapping("/historic/{id}")
    fun findById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<EmployeeHistoric> = service.findById(id)

    /**
     * PUT - Http Method
     * Update EmployeeHistoric
     * @param id UUID
     * @param employeeHistoric
     * @return ResponseEntity
     */
    @PutMapping("/historic/{id}")
    fun update(
        @PathVariable(value = "id") id: UUID,
        @RequestBody employeeHistoric: EmployeeHistoric,
    ): ResponseEntity<EmployeeHistoric> = service.updateById(id, employeeHistoric)

    /**
     * Delete EmployeeHistoric by id
     * @param id UUID
     * @return ResponseEntity
     */
    @DeleteMapping("/historic/{id}")
    fun deleteById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Unit> = service.deleteById(id)
}
