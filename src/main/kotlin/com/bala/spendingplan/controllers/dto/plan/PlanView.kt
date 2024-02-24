package com.bala.spendingplan.controllers.dto.plan

import java.math.BigDecimal
import java.time.LocalDateTime

data class PlanView(
    private val id: Long?,
    private val month: Int,
    private val year: Int,
    private val totalBudget: BigDecimal,
    private var isActive: Boolean,
    private var authorId: Long?,
    private var addedAt: LocalDateTime
)