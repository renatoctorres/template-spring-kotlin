package com.rct.payroll.core.service.business

import com.rct.payroll.common.extension.logger
import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.business.Discount
import com.rct.payroll.infra.persistence.repository.business.DiscountRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Service
import java.util.UUID

/**
 * Discount service
 *
 * @property repository
 * @constructor Create empty Discount service
 */
@Service
class DiscountService(
    private val repository: DiscountRepository,
) {
    private val logger by logger()

    /**
     * Find all Discounts
     *
     * @return ResponseEntity
     */
    fun findAll(): ResponseEntity<List<Discount>> = ok(repository.findAll().toList())

    /**
     * Create Discount
     *
     * @param city Discount
     * @return ResponseEntity
     */
    fun create(city: Discount): ResponseEntity<Discount> {
        try {
            val saved = repository.save(city)
            return ResponseEntity(saved, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            logger.error(e.message)
            return throw ResourceNotFoundException()
        }
    }

    /**
     * Get Discount by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun findById(id: UUID): ResponseEntity<Discount> =
        repository
            .findById(id)
            .map { city ->
                ok(city)
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Get Discount by Discount ID
     *
     * @param discountId
     * @return ResponseEntity
     */
    fun findAllByPayrollId(discountId: UUID): ResponseEntity<List<Discount>> {
        val discounts = repository.findAllByPayrollId(discountId)
        return if (discounts.isNotEmpty()) {
            ok(discounts)
        } else {
            throw ResourceNotFoundException()
        }
    }

    /**
     * Update Discount by ID
     *
     * @param id UUID
     * @param newItem
     * @return ResponseEntity
     */
    fun updateById(
        id: UUID,
        newItem: Discount,
    ): ResponseEntity<Discount> =
        repository
            .findById(id)
            .map { currentDiscount ->
                val updated: Discount =
                    currentDiscount
                        .copy(
                            id = newItem.id,
                            payroll = newItem.payroll,
                            amountValue = newItem.amountValue,
                            status = newItem.status,
                            type = newItem.type,
                        )
                ok().body(repository.save(updated))
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Delete Discount by id
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
