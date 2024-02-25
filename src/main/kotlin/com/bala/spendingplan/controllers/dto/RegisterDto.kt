package com.bala.spendingplan.controllers.dto

import com.bala.spendingplan.entities.enums.UserRoles

data class RegisterDto(
    val username: String,
    val password: String,
    val role: UserRoles
)
