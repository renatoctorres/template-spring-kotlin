package com.rct.payroll.infra.persistence.repository.hr

import com.rct.payroll.infra.persistence.entity.hr.Sector
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

/**
 * Sector repository
 *
 * @constructor Create empty Sector repository
 */
@Repository
interface SectorRepository : CrudRepository<Sector, UUID> {
    fun findAllByDepartmentId(departmentId: UUID): List<Sector>
}
