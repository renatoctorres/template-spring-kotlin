package com.rct.payroll.infra.persistence.entity.employee

/**
 * Payroll employee status Enumerator
 * @constructor Create empty Payroll employee status
 */
enum class EmployeePayrollStatus {
    CREATED,
    GENERATED,
    PAYED,
    CANCELED,
}
