package com.rct.payroll.infra.delivery.hr

import com.rct.payroll.core.service.hr.SectorService
import com.rct.payroll.infra.persistence.entity.hr.Sector
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
 * Sector resource - API Rest
 * @property service SectorService
 * @constructor Create empty Sector resource
 */
@RestController
@RequestMapping("/sectors")
class SectorResource(
    private val service: SectorService,
) {
    /**
     * GET Http Method
     * Find all Sector
     * @return ResponseEntity
     */
    @GetMapping
    fun findAll(): ResponseEntity<List<Sector>> = service.findAll()

    /**
     * POST Http Method
     * Create Sector
     * @param sector
     * @return ResponseEntity
     */
    @PostMapping
    fun create(
        @RequestBody sector: Sector,
    ): ResponseEntity<Sector> = service.create(sector)

    /**
     * GET Http Method
     * Get Sector by id
     * @param id UUID UUID
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    fun findById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Sector> = service.findById(id)

    /**
     * GET Http Method
     * Get Sector by Department id
     * @param departmentId UUID UUID
     * @return ResponseEntity
     */
    @GetMapping("/departments/{departmentId}")
    fun findAllByDepartmentId(
        @PathVariable(value = "departmentId") departmentId: UUID,
    ): ResponseEntity<List<Sector>> = service.findAllByDepartmentId(departmentId)

    /**
     * PUT - Http Method
     * Update Sector
     * @param id UUID
     * @param sector
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    fun update(
        @PathVariable(value = "id") id: UUID,
        @RequestBody sector: Sector,
    ): ResponseEntity<Sector> = service.updateById(id, sector)

    /**
     * Delete Sector by id
     * @param id UUID
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Unit> = service.deleteById(id)
}
