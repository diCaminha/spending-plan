package com.bala.spendingplan.util

import com.bala.spendingplan.configurations.TokenService
import org.springframework.stereotype.Component

@Component
class HeaderRequestUtil(
    private val tokenService: TokenService
) {

    fun getTokenFromAuthorization(authorization: String): String? {
        val token = authorization.substringAfter("Bearer ")
        return tokenService.extractUsername(token)
    }
}