package com.rct.payroll.infra.delivery.bank

import com.rct.payroll.core.service.bank.BankService
import com.rct.payroll.infra.persistence.entity.bank.Bank
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
 * Bank resource - API Rest
 * @property service BankService
 * @constructor Create empty Bank resource
 */
@RestController
@RequestMapping("/banks")
class BankResource(
    private val service: BankService,
) {
    /**
     * GET Http Method
     * Find all Banks
     * @return ResponseEntity
     */
    @GetMapping
    fun findAll(): ResponseEntity<List<Bank>> = service.findAll()

    /**
     * POST Http Method
     * Create Bank
     * @param country
     * @return ResponseEntity
     */
    @PostMapping
    fun create(
        @RequestBody country: Bank,
    ): ResponseEntity<Bank> = service.create(country)

    /**
     * GET Http Method
     * Get Bank by id
     * @param id UUID UUID
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    fun findById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Bank> = service.findById(id)

    /**
     * PUT - Http Method
     * Update Bank
     * @param id UUID
     * @param country
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    fun update(
        @PathVariable(value = "id") id: UUID,
        @RequestBody country: Bank,
    ): ResponseEntity<Bank> = service.updateById(id, country)

    /**
     * Delete Bank by id
     * @param id UUID
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Unit> = service.deleteById(id)
}
