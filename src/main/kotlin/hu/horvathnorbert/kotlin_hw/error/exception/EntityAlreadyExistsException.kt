package hu.horvathnorbert.kotlin_hw.error.exception

import java.lang.RuntimeException

class EntityAlreadyExistsException(message: String): RuntimeException(message) {
}