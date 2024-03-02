package com.bala.spendingplan.dto.auth

import com.bala.spendingplan.entities.enums.UserRoles

data class RegisterDto(
    val username: String,
    val password: String,
    val role: UserRoles
)
