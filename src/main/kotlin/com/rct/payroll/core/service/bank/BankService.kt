package com.rct.payroll.core.service.bank

import com.rct.payroll.common.extension.logger
import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.bank.Bank
import com.rct.payroll.infra.persistence.repository.bank.BankRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Service
import java.util.UUID

/**
 * Bank service
 *
 * @property repository
 * @constructor Create empty Bank service
 */
@Service
class BankService(
    private val repository: BankRepository,
) {
    private val logger by logger()

    /**
     * Find all Banks
     *
     * @return ResponseEntity
     */
    fun findAll(): ResponseEntity<List<Bank>> = ok(repository.findAll().toList())

    /**
     * Create Bank
     *
     * @param city Bank
     * @return ResponseEntity
     */
    fun create(city: Bank): ResponseEntity<Bank> {
        try {
            val saved = repository.save(city)
            return ResponseEntity(saved, HttpStatus.CREATED)
        } catch (e: IllegalArgumentException) {
            logger.error(e.message)
            return throw ResourceNotFoundException()
        }
    }

    /**
     * Get Bank by id
     *
     * @param id UUID
     * @return ResponseEntity
     */
    fun findById(id: UUID): ResponseEntity<Bank> =
        repository
            .findById(id)
            .map { city ->
                ok(city)
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Update Bank by ID
     *
     * @param id UUID
     * @param newItem
     * @return ResponseEntity
     */
    fun updateById(
        id: UUID,
        newItem: Bank,
    ): ResponseEntity<Bank> =
        repository
            .findById(id)
            .map { currentBank ->
                val updated: Bank =
                    currentBank
                        .copy(
                            id = newItem.id,
                            code = newItem.code,
                            name = newItem.name,
                        )
                ok().body(repository.save(updated))
            }.orElseThrow { ResourceNotFoundException() }

    /**
     * Delete Bank by id
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
