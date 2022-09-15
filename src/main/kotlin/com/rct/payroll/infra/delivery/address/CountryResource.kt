package com.rct.payroll.infra.delivery.address

import com.rct.payroll.core.service.adress.CountryService
import com.rct.payroll.infra.persistence.entity.address.Country
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
 * Country resource - API Rest
 * @property service CountryService
 * @constructor Create empty Country resource
 */
@RestController
@RequestMapping("/countries")
class CountryResource(
    private val service: CountryService,
) {
    /**
     * GET Http Method
     * Find all Countries
     * @return ResponseEntity
     */
    @GetMapping
    fun findAll(): ResponseEntity<List<Country>> = service.findAll()

    /**
     * POST Http Method
     * Create Country
     * @param country
     * @return ResponseEntity
     */
    @PostMapping
    fun create(
        @RequestBody country: Country,
    ): ResponseEntity<Country> = service.create(country)

    /**
     * GET Http Method
     * Get Country by id
     * @param id UUID UUID
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    fun findById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Country> = service.findById(id)

    /**
     * PUT - Http Method
     * Update Country
     * @param id UUID
     * @param country
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    fun update(
        @PathVariable(value = "id") id: UUID,
        @RequestBody country: Country,
    ): ResponseEntity<Country> = service.updateById(id, country)

    /**
     * Delete Country by id
     * @param id UUID
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Unit> = service.deleteById(id)
}
