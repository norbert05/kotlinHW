package hu.horvathnorbert.kotlin_hw.error.exception

import java.lang.RuntimeException

class PasswordIncorrectException(message: String): RuntimeException(message)