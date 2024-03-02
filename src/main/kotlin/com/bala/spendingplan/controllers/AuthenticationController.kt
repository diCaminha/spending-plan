package com.bala.spendingplan.controllers

import com.bala.spendingplan.dto.auth.AuthenticationResponseDto
import com.bala.spendingplan.dto.auth.LoginDto
import com.bala.spendingplan.dto.auth.RegisterDto
import com.bala.spendingplan.entities.UserPlan
import com.bala.spendingplan.services.AuthenticationService
import com.bala.spendingplan.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthenticationController(
    private val authenticationService: AuthenticationService,
    private val userService: UserService
) {

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto): ResponseEntity<AuthenticationResponseDto> {
        val authenticated = authenticationService.authentication(loginDto)
        return ResponseEntity.ok(authenticated)
    }

    @PostMapping("/register")
    fun register(@RequestBody registerDto: RegisterDto): ResponseEntity<UserPlan> {

        val encryptPassword = BCryptPasswordEncoder().encode(registerDto.password)
        val userToRegister = UserPlan(
            username = registerDto.username,
            password = encryptPassword,
            role = registerDto.role
        )
        val userSaved = userService.save(userToRegister)
        return ResponseEntity.ok(userSaved)
    }
}