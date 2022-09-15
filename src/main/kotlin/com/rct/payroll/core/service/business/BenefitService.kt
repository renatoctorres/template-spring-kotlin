package com.rct.payroll.core.service.business

import com.rct.payroll.common.extension.logger
import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.business.Benefit
import com.rct.payroll.infra.persistence.repository.business.BenefitRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Service
import java.util.UUID

/**
 * Benefit service
 *
 * @property repository
 * @constructor Create empty Benefit service
 */
@Service
class BenefitService(
    private val repository: BenefitRepository,
) {
    private val logger by logger()

    /**
     * Find all Benefits
     *
     * @return ResponseEntity
     */
    fun findAll(): ResponseEntity<List<Benefit>> = ok(repository.findAll().toList())

    /**
     * Create Benefit
     *
     * @param city Benefit
     * @return ResponseEntity
     */
    fun create(city: Benefit): ResponseEntity<Benefit> {
        try {
            val saved = repository.save(city)
            return ResponseEntity(saved, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            logger.error(e.message)
            return throw ResourceNotFoundException()
        }
    }

    /**
     * Get Benefit by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun findById(id: UUID): ResponseEntity<Benefit> =
        repository
            .findById(id)
            .map { city ->
                ok(city)
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Get Benefit by Payroll ID
     *
     * @param payrollId UUID
     * @return ResponseEntity
     */
    fun findAllByPayrollId(payrollId: UUID): ResponseEntity<List<Benefit>> {
        val payrolls = repository.findAllByPayrollId(payrollId)
        return if (payrolls.isNotEmpty()) {
            ok(payrolls)
        } else {
            throw ResourceNotFoundException()
        }
    }

    /**
     * Update Benefit by ID
     *
     * @param id UUID
     * @param newItem
     * @return ResponseEntity
     */
    fun updateById(
        id: UUID,
        newItem: Benefit,
    ): ResponseEntity<Benefit> =
        repository
            .findById(id)
            .map { currentBenefit ->
                val updated: Benefit =
                    currentBenefit
                        .copy(
                            id = newItem.id,
                            benefitType = newItem.benefitType,
                            amountValue = newItem.amountValue,
                            status = newItem.status,
                            payroll = newItem.payroll,
                        )
                ok().body(repository.save(updated))
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Delete Benefit by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun deleteById(id: UUID): ResponseEntity<Unit> {
        val city = repository.findById(id)
        return if (city.isPresent) {
            repository.deleteById(id)
            noContent().build()
        } else {
            throw ResourceNotFoundException()
        }
    }
}
