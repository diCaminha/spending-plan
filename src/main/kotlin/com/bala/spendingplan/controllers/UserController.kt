package com.bala.spendingplan.controllers

import com.bala.spendingplan.entities.UserPlan
import com.bala.spendingplan.services.UserService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    fun save(@RequestBody user: UserPlan): UserPlan {
        return userService.save(user)
    }

    fun showAll(): MutableIterable<UserPlan> {
        return userService.getAll()
    }
}