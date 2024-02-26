package com.bala.spendingplan.services

import com.bala.spendingplan.configurations.JwtProperties
import com.bala.spendingplan.configurations.TokenService
import com.bala.spendingplan.controllers.dto.AuthenticationResponseDto
import com.bala.spendingplan.controllers.dto.LoginDto
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthenticationService(
    private val authManager: AuthenticationManager,
    private val userDetailsService: UserDetailServiceImpl,
    private val tokenService: TokenService,
    private val jwtProperties: JwtProperties,
) {
    fun authentication(authenticationRequest: LoginDto): AuthenticationResponseDto {
        authManager.authenticate(
            UsernamePasswordAuthenticationToken(
                authenticationRequest.username,
                authenticationRequest.password
            )
        )
        val user = userDetailsService.loadUserByUsername(authenticationRequest.username)
        val accessToken = createAccessToken(user)
        return AuthenticationResponseDto(
            token = accessToken,
        )
    }
    private fun createAccessToken(user: UserDetails) = tokenService.generate(
        userDetails = user,
        expirationDate = getAccessTokenExpiration()
    )
    private fun getAccessTokenExpiration(): Date =
        Date(System.currentTimeMillis() + jwtProperties.accessTokenExpiration)
}