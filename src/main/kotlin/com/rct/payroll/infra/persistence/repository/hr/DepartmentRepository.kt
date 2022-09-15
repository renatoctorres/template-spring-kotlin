package com.rct.payroll.infra.persistence.repository.hr

import com.rct.payroll.infra.persistence.entity.hr.Department
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

/**
 * Department repository Interface
 * @constructor Create empty Department repository
 */
@Repository
interface DepartmentRepository : CrudRepository<Department, UUID>
