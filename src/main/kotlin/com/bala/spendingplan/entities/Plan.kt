package com.bala.spendingplan.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Plan (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val month: Int,
    val year: Int,
    val totalBudget: BigDecimal,
    val categories: List<Category>?,
    var isActive: Boolean = false,
    var author: UserPlan,
    var addedAt: LocalDateTime = LocalDateTime.now()

)