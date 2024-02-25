package com.bala.spendingplan.controllers.dto.plan

import lombok.NoArgsConstructor
import java.math.BigDecimal
import java.time.LocalDateTime

@NoArgsConstructor
data class PlanView(
    val id: Long?,
    val month: Int,
    val year: Int,
    val totalBudget: BigDecimal,
    var isActive: Boolean,
    var authorId: Long?,
    var addedAt: LocalDateTime
)