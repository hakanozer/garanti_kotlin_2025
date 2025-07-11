package com.works.configs

import com.works.entities.Product
import com.works.utils.Util
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver

@RestControllerAdvice
class GlobalException {

    @ExceptionHandler( MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun methodArgumentNotValidException ( ex: MethodArgumentNotValidException ) : List<Map<String, Any?>> {
        return parseError(ex.getFieldErrors())
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun methodArgumentTypeMismatchException(ex: MethodArgumentTypeMismatchException) : ResponseEntity<Any> {
        return Util.fail(ex.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun constraintViolationException(ex: ConstraintViolationException) : ResponseEntity<Any> {
        return Util.fail(ex.message!!, HttpStatus.BAD_REQUEST)
    }


    private fun parseError(fieldErrors: MutableList<FieldError>): List<Map<String, Any?>> {
        val list = mutableListOf<Map<String, Any?>>()
        for (fieldError in fieldErrors) {
            val field = fieldError.field
            val rejectedValue = fieldError.rejectedValue
            val defaultMessage = fieldError.defaultMessage
            val map = mutableMapOf<String, Any?>()
            map.put("field", field)
            map.put("rejectedValue", rejectedValue)
            map.put("defaultMessage", defaultMessage)
            list.add(map)
        }
        return list
    }


}