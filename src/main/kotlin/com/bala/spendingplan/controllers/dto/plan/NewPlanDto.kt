package com.bala.spendingplan.controllers.dto.plan

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import lombok.NoArgsConstructor
import java.math.BigDecimal

@NoArgsConstructor
data class
NewPlanDto(
    @field:Min(value=1, message="Value must be at least 1")
    @field:Max(value=12, message="Value must be at most 12")
    val month: Int,

    val year: Int,

    val totalBudget: BigDecimal,

    var authorId: Long
)