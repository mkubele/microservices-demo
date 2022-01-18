package com.kubele.utils

object EmailValidator {
    private const val EMAIL_VALIDATION_REGEX =
        "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"

    fun isValid(email: String): Boolean {
        return email.matches(EMAIL_VALIDATION_REGEX.toRegex())
    }
}
