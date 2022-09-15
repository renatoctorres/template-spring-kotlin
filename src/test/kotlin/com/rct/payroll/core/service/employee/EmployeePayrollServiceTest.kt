package com.rct.payroll.core.service.employee

import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.employee.EmployeePayroll
import com.rct.payroll.infra.persistence.entity.stub.EmployeePayrollStub
import com.rct.payroll.infra.persistence.repository.employee.EmployeePayrollRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.http.HttpStatus.OK
import java.util.Optional
import java.util.Optional.empty
import java.util.UUID

internal class EmployeePayrollServiceTest {
    private val repository: EmployeePayrollRepository = mockk(relaxed = true)
    private val service = EmployeePayrollService(repository = repository)

    @Nested
    inner class WhenCreatingEmployeePayroll {
        @Test
        fun `it should use repository to persist employeePayroll`() {
            val employeePayroll: EmployeePayroll = mockk()
            val expected: EmployeePayroll = mockk()
            every { repository.save(employeePayroll) } returns expected
            val actual = service.create(employeePayroll)
            assertEquals(expected, actual.body)
            assertEquals(CREATED, actual.statusCode)
            verify(exactly = 1) { repository.save(any()) }
        }
    }

    @Nested
    inner class WhenFindingById {
        private val id: UUID = mockk()

        @Test
        fun `it should find EmployeePayroll when it exists`() {
            val expected: EmployeePayroll = mockk(relaxed = true)
            every { repository.findById(id) } returns Optional.of(expected)
            val actual = service.findById(id)
            assertEquals(expected, actual.body)
            assertEquals(OK, actual.statusCode)
            verify(exactly = 1) { repository.findById(any()) }
        }

        @Test
        fun `it should throws ResourceNotFound when it does not exists`() {
            every { repository.findById(id) } returns empty()
            assertThrows<ResourceNotFoundException> { service.findById(id) }
            verify(exactly = 1) { repository.findById(any()) }
        }
    }

    @Nested
    inner class WhenFindingAll {
        @Test
        fun `it should find EmployeePayroll when it exists`() {
            val employeePayroll: EmployeePayroll = mockk(relaxed = true)
            val expected = listOf(employeePayroll)
            every { repository.findAll() } returns expected
            val actual = service.findAll()
            assertEquals(expected, actual.body)
            assertEquals(OK, actual.statusCode)
            verify(exactly = 1) { repository.findAll() }
        }
    }

    @Nested
    inner class WhenUpdatingEmployeePayroll {
        private val id = UUID.randomUUID()

        @Test
        fun `it should use repository to update employeePayroll`() {
            val expected = EmployeePayrollStub.any()
            every { repository.findById(any()) } returns Optional.of(expected)
            every { repository.save(expected) } returns expected
            val actual = service.updateById(id, expected)
            assertEquals(expected, actual.body)
            assertEquals(OK, actual.statusCode)
            verify(exactly = 1) { repository.save(any()) }
        }

        @Test
        fun `it should throws ResourceNotFound when it does not exists`() {
            val expected = EmployeePayrollStub.any()
            every { repository.findById(expected.id) } returns empty()
            assertThrows<ResourceNotFoundException> { service.findById(expected.id) }
        }
    }

    @Nested
    inner class WhenDeletingEmployeePayroll {
        private val unit: Unit = mockk()

        @Test
        fun `it should use repository to delete employeePayroll`() {
            val expected = EmployeePayrollStub.any()
            every { repository.findById(any()) } returns Optional.of(expected)
            every { repository.deleteById(expected.id) } returns unit
            val actual = service.deleteById(expected.id)
            assertEquals(NO_CONTENT, actual.statusCode)
            verify(exactly = 1) { repository.deleteById(any()) }
        }

        @Test
        fun `it should throws ResourceNotFound when it does not exists`() {
            val expected = EmployeePayrollStub.any()
            every { repository.findById(expected.id) } returns empty()
            assertThrows<ResourceNotFoundException> { service.deleteById(expected.id) }
        }
    }
}
