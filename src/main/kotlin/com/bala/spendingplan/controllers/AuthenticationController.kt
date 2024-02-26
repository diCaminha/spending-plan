package com.bala.spendingplan.controllers

import com.bala.spendingplan.controllers.dto.LoginDTO
import com.bala.spendingplan.controllers.dto.RegisterDto
import com.bala.spendingplan.entities.UserPlan
import com.bala.spendingplan.services.AuthService
import com.bala.spendingplan.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthenticationController(
    private val authService: AuthService,
    private val authenticationManager: AuthenticationManager,
    private val userService: UserService
) {

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDTO): ResponseEntity<Any> {
        val usernamePassword = UsernamePasswordAuthenticationToken(loginDto.username, loginDto.password)
        val authenticated = authenticationManager.authenticate(usernamePassword)
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