package com.rct.payroll.infra.delivery.hr

import com.rct.payroll.core.service.hr.DepartmentService
import com.rct.payroll.infra.persistence.entity.hr.Department
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
 * Department resource - API Rest
 * @property service DepartmentService
 * @constructor Create empty Department resource
 */
@RestController
@RequestMapping("/departments")
class DepartmentResource(
    private val service: DepartmentService,
) {
    /**
     * GET Http Method
     * Find all Department
     * @return ResponseEntity
     */
    @GetMapping
    fun findAll(): ResponseEntity<List<Department>> = service.findAll()

    /**
     * POST Http Method
     * Create Department
     * @param department
     * @return ResponseEntity
     */
    @PostMapping
    fun create(
        @RequestBody department: Department,
    ): ResponseEntity<Department> = service.create(department)

    /**
     * GET Http Method
     * Get Department by id
     * @param id UUID UUID
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    fun findById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Department> = service.findById(id)

    /**
     * PUT - Http Method
     * Update Department
     * @param id UUID
     * @param department
     * @return ResponseEntity
     */
    @PutMapping("/{id}")
    fun update(
        @PathVariable(value = "id") id: UUID,
        @RequestBody department: Department,
    ): ResponseEntity<Department> = service.updateById(id, department)

    /**
     * Delete Department by id
     * @param id UUID
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable(value = "id") id: UUID,
    ): ResponseEntity<Unit> = service.deleteById(id)
}
