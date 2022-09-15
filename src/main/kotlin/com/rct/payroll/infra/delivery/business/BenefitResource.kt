package com.rct.payroll.infra.delivery.business

import com.rct.payroll.core.service.business.BenefitService
import com.rct.payroll.infra.persistence.entity.business.Benefit
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
 * Benefit resource - API Rest
 * @property service BenefitService
 * @constructor Create empty Benefit resource
 */
@RestController
@RequestMapping("/benefits")
class BenefitResource(
    private val service: BenefitService,
) {
    /**
     * GET Http Method
     * Find all Benefits
     * @return ResponseEntity
     */
    @GetMapping
    fun findAll(): ResponseEntity<List<Benefit>> = service.findAll()

    /**
     * GET Http Method
     * Find all Benefits by EmployerPayroll ID
     * @return ResponseEntity
     */
    @GetMapping("/payrolls/{payrollId}")
    fun findAllByPayrollId(
        @PathVariable(value = "payrollId") payrollId: UUID,
    ): ResponseEntity<List<Benefit>> = service.findAllByPayrollId(payrollId)

    /**
     * POST Http Method
     * Create Benefit
     * @param benefit
     * @return ResponseEntity
     */
    @PostMapping
    fun create(
        @RequestBody benefit: Benefit,
    ): ResponseEntity<Benefit> = service.create(benefit)

    /**
     * GET Http Method
     * Get Benefit by id
     * @param id UUID UUID
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    fun findById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Benefit> = service.findById(id)

    /**
     * PUT - Http Method
     * Update Benefit
     * @param id UUID
     * @param benefit
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    fun update(
        @PathVariable(value = "id") id: UUID,
        @RequestBody benefit: Benefit,
    ): ResponseEntity<Benefit> = service.updateById(id, benefit)

    /**
     * Delete Benefit by id
     * @param id UUID
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Unit> = service.deleteById(id)
}
