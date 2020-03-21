package hu.horvathnorbert.kotlin_hw.error.exception

import java.lang.RuntimeException

class EntityNotFoundException(message: String): RuntimeException(message)