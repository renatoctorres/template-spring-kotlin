package com.rct.payroll.infra.persistence.repository.address

import com.rct.payroll.infra.persistence.entity.address.City
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

/**
 * City repository
 *
 * @constructor Create empty City repository
 */
@Repository
interface CityRepository : CrudRepository<City, UUID> {
    fun findAllByStateId(stateId: UUID): List<City>
}
