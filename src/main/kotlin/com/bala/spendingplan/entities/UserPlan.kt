package com.bala.spendingplan.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
data class UserPlan (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,

    private var login: String,

    private val password: String,

    private var firstname: String,

    private var lastname: String,

    private var role: String

) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        TODO("Not yet implemented")
    }

    override fun getPassword(): String {
        TODO("Not yet implemented")
    }

    override fun getUsername(): String {
        TODO("Not yet implemented")
    }

    override fun isAccountNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAccountNonLocked(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isCredentialsNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
    }

}