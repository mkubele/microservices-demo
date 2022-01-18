package com.kubele.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmailValidatorTest {

    companion object {
        private const val VALID_EMAIL = "test@test.com"
        private val INVALID_EMAIL_LIST = listOf(".@test.", "@test.com", "test", "test@test.com.")
    }

    @Test
    fun `Valid e-mail is validated correctly`() {
        assertThat(EmailValidator.isValid(VALID_EMAIL)).isTrue
    }

    @Test
    fun `Invalid e-mail is validated correctly`() {
        INVALID_EMAIL_LIST.forEach { INVALID_EMAIL ->
            assertThat(EmailValidator.isValid(INVALID_EMAIL)).isFalse
        }
    }
}