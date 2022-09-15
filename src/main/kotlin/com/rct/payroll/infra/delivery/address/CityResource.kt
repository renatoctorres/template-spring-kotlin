package com.rct.payroll.infra.delivery.address

import com.rct.payroll.core.service.adress.CityService
import com.rct.payroll.infra.persistence.entity.address.City
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
 * City resource - API Rest
 * @property service CityService
 * @constructor Create empty City resource
 */
@RestController
@RequestMapping("/cities")
class CityResource(
    private val service: CityService,
) {
    /**
     * GET Http Method
     * Find all City
     * @return ResponseEntity
     */
    @GetMapping
    fun findAll(): ResponseEntity<List<City>> = service.findAll()

    /**
     * GET Http Method
     * Find all City by State ID
     * @return ResponseEntity
     */
    @GetMapping("/states/{stateId}")
    fun findAllByStateId(
        @PathVariable(value = "stateId") stateId: UUID,
    ): ResponseEntity<List<City>> = service.findAllByStateId(stateId)

    /**
     * POST Http Method
     * Create City
     * @param city
     * @return ResponseEntity
     */
    @PostMapping
    fun create(
        @RequestBody city: City,
    ): ResponseEntity<City> = service.create(city)

    /**
     * GET Http Method
     * Get City by id
     * @param id UUID UUID
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    fun findById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<City> = service.findById(id)

    /**
     * PUT - Http Method
     * Update City
     * @param id UUID
     * @param city
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    fun update(
        @PathVariable(value = "id") id: UUID,
        @RequestBody city: City,
    ): ResponseEntity<City> = service.updateById(id, city)

    /**
     * Delete City by id
     * @param id UUID
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Unit> = service.deleteById(id)
}
