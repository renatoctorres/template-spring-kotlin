package com.rct.payroll.infra.persistence.repository.bank

import com.rct.payroll.infra.persistence.entity.bank.Bank
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

/**
 * Bank repository
 *
 * @constructor Create empty Bank repository
 */
@Repository
interface BankRepository : CrudRepository<Bank, UUID>
