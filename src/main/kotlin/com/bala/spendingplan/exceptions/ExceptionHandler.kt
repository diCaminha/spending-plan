package com.bala.spendingplan.exceptions

import com.bala.spendingplan.dto.error.ErrorView
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(
        exception: NotFoundException,
        request: HttpServletRequest
    ) : ErrorView {
        return ErrorView(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message,
            path = request.servletPath
        )
    }

    @ExceptionHandler(UnauthorizedAccessException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleUnauthorizedAccess(
        exception: UnauthorizedAccessException,
        request: HttpServletRequest
    ) : ErrorView {
        return ErrorView(
            status = HttpStatus.UNAUTHORIZED.value(),
            error = HttpStatus.UNAUTHORIZED.name,
            message = exception.message,
            path = request.servletPath
        )
    }

    @ExceptionHandler(DuplicateActivePlanException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handleDuplicateActivePlan(
        exception: DuplicateActivePlanException,
        request: HttpServletRequest
    ) : ErrorView {
        return ErrorView(
            status = HttpStatus.CONFLICT.value(),
            error = HttpStatus.CONFLICT.name,
            message = exception.message,
            path = request.servletPath
        )
    }
}