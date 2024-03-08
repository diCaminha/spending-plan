package com.bala.spendingplan.services

import com.bala.spendingplan.entities.UserPlan
import com.bala.spendingplan.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun save(user: UserPlan): UserPlan {
        return userRepository.save(user)
    }

    fun findById(id: Long): UserPlan {
        return userRepository.findById(id).orElseThrow {RuntimeException()}
    }

    fun getAll(): MutableIterable<UserPlan> {
        return userRepository.findAll()
    }
}
