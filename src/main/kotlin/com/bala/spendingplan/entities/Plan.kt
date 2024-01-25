package com.bala.spendingplan.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.math.BigDecimal
import java.time.LocalDateTime

data class Plan (
    val id: Long? = null,
    val month: Int,
    val year: Int,
    val totalBudget: BigDecimal,
    val categories: List<Category>,
    var isActive: Boolean = false,
    var author: UserPlan,
    var addedAt: LocalDateTime = LocalDateTime.now()

)