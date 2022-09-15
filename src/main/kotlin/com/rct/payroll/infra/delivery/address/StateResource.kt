package com.rct.payroll.infra.delivery.address

import com.rct.payroll.core.service.adress.StateService
import com.rct.payroll.infra.persistence.entity.address.State
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
 * State resource - API Rest
 * @property service StateService
 * @constructor Create empty State resource
 */
@RestController
@RequestMapping("/states")
class StateResource(
    private val service: StateService,
) {
    /**
     * GET Http Method
     * Find all State
     * @return ResponseEntity
     */
    @GetMapping
    fun findAll(): ResponseEntity<List<State>> = service.findAll()

    /**
     * GET Http Method
     * Find all State
     * @return ResponseEntity
     */
    @GetMapping("/countries/{countryId}")
    fun findAllByCountryId(
        @PathVariable(value = "countryId") countryId: UUID,
    ): ResponseEntity<List<State>> = service.findAllByCountryId(countryId)

    /**
     * POST Http Method
     * Create State
     * @param state
     * @return ResponseEntity
     */
    @PostMapping
    fun create(
        @RequestBody state: State,
    ): ResponseEntity<State> = service.create(state)

    /**
     * GET Http Method
     * Get State by id
     * @param id UUID UUID
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    fun findById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<State> = service.findById(id)

    /**
     * PUT - Http Method
     * Update State
     * @param id UUID
     * @param state
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    fun update(
        @PathVariable(value = "id") id: UUID,
        @RequestBody state: State,
    ): ResponseEntity<State> = service.updateById(id, state)

    /**
     * Delete State by id
     * @param id UUID
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Unit> = service.deleteById(id)
}
