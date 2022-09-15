package com.rct.payroll.infra.delivery.business

import com.rct.payroll.core.service.business.DiscountService
import com.rct.payroll.infra.persistence.entity.business.Discount
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
 * Discount resource - API Rest
 * @property service DiscountService
 * @constructor Create empty Discount resource
 */
@RestController
@RequestMapping("/discounts")
class DiscountResource(
    private val service: DiscountService,
) {
    /**
     * GET Http Method
     * Find all Discounts
     * @return ResponseEntity
     */
    @GetMapping
    fun findAll(): ResponseEntity<List<Discount>> = service.findAll()

    /**
     * GET Http Method
     * Find all Discounts by Payroll ID
     * @return ResponseEntity
     */
    @GetMapping("/payrolls/{payrollId}")
    fun findAllByPayrollId(
        @PathVariable(value = "payrollId") payrollId: UUID,
    ): ResponseEntity<List<Discount>> = service.findAllByPayrollId(payrollId)

    /**
     * POST Http Method
     * Create Discount
     * @param discount
     * @return ResponseEntity
     */
    @PostMapping
    fun create(
        @RequestBody discount: Discount,
    ): ResponseEntity<Discount> = service.create(discount)

    /**
     * GET Http Method
     * Get Discount by id
     * @param id UUID UUID
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    fun findById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Discount> = service.findById(id)

    /**
     * PUT - Http Method
     * Update Discount
     * @param id UUID
     * @param discount
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    fun update(
        @PathVariable(value = "id") id: UUID,
        @RequestBody discount: Discount,
    ): ResponseEntity<Discount> = service.updateById(id, discount)

    /**
     * Delete Discount by id
     * @param id UUID
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Unit> = service.deleteById(id)
}
