package com.rct.payroll.infra.persistence.repository.address

import com.rct.payroll.infra.persistence.entity.address.Country
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

/**
 * Country repository
 *
 * @constructor Create empty Country repository
 */
@Repository
interface CountryRepository : CrudRepository<Country, UUID>
