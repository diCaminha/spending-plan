package com.bala.spendingplan.services

import com.bala.spendingplan.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailServiceImpl(
    private val userRepository: UserRepository
    ): UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        if (username != null) {
            return userRepository.findByUsername(username)
        } else {
            throw Exception()
        }
    }
}