package hu.horvathnorbert.kotlin_hw.error

import hu.horvathnorbert.kotlin_hw.error.exception.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GeneralErrorHandler {

    @ExceptionHandler(EntityNotFoundException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleEntityNotFoundException(entityNotFoundException: EntityNotFoundException): ErrorResponse {
        return ErrorResponse("Error", entityNotFoundException.message ?: "Entity not found!")
    }
}