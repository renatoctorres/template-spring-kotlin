package com.rct.payroll.core.service.business

import com.rct.payroll.core.service.exception.ResourceNotFoundException
import com.rct.payroll.infra.persistence.entity.business.Benefit
import com.rct.payroll.infra.persistence.entity.stub.BenefitStub
import com.rct.payroll.infra.persistence.repository.business.BenefitRepository
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

internal class BenefitServiceTest {
    private val repository: BenefitRepository = mockk(relaxed = true)
    private val service = BenefitService(repository = repository)

    @Nested
    inner class WhenCreatingBenefit {
        @Test
        fun `it should use repository to persist benefit`() {
            val benefit: Benefit = mockk()
            val expected: Benefit = mockk()
            every { repository.save(benefit) } returns expected
            val actual = service.create(benefit)
            assertEquals(expected, actual.body)
            assertEquals(CREATED, actual.statusCode)
            verify(exactly = 1) { repository.save(any()) }
        }
    }

    @Nested
    inner class WhenFindingById {
        private val id: UUID = mockk()

        @Test
        fun `it should find Benefit when it exists`() {
            val expected: Benefit = mockk(relaxed = true)
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
        fun `it should find Benefit when it exists`() {
            val benefit: Benefit = mockk(relaxed = true)
            val expected = listOf(benefit)
            every { repository.findAll() } returns expected
            val actual = service.findAll()
            assertEquals(expected, actual.body)
            assertEquals(OK, actual.statusCode)
            verify(exactly = 1) { repository.findAll() }
        }
    }

    @Nested
    inner class WhenUpdatingBenefit {
        private val id = UUID.randomUUID()

        @Test
        fun `it should use repository to update benefit`() {
            val expected = BenefitStub.any()
            every { repository.findById(any()) } returns Optional.of(expected)
            every { repository.save(expected) } returns expected
            val actual = service.updateById(id, expected)
            assertEquals(expected, actual.body)
            assertEquals(OK, actual.statusCode)
            verify(exactly = 1) { repository.save(any()) }
        }

        @Test
        fun `it should throws ResourceNotFound when it does not exists`() {
            val expected = BenefitStub.any()
            every { repository.findById(expected.id) } returns empty()
            assertThrows<ResourceNotFoundException> { service.findById(expected.id) }
        }
    }

    @Nested
    inner class WhenDeletingBenefit {
        private val unit: Unit = mockk()

        @Test
        fun `it should use repository to delete benefit`() {
            val expected = BenefitStub.any()
            every { repository.findById(any()) } returns Optional.of(expected)
            every { repository.deleteById(expected.id) } returns unit
            val actual = service.deleteById(expected.id)
            assertEquals(NO_CONTENT, actual.statusCode)
            verify(exactly = 1) { repository.deleteById(any()) }
        }

        @Test
        fun `it should throws ResourceNotFound when it does not exists`() {
            val expected = BenefitStub.any()
            every { repository.findById(expected.id) } returns empty()
            assertThrows<ResourceNotFoundException> { service.deleteById(expected.id) }
        }
    }
}
