package com.bala.spendingplan.controllers.dto.plan

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.math.BigDecimal
import java.time.LocalDateTime

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
data class PlanView(

    private val id: Long?,
    private val month: Int,
    private val year: Int,
    private val totalBudget: BigDecimal,
    private var isActive: Boolean,
    private var authorId: Long?,
    private var addedAt: LocalDateTime
)