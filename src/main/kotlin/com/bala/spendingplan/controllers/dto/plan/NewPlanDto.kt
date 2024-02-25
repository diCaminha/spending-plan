package com.bala.spendingplan.controllers.dto.plan

import com.bala.spendingplan.entities.Category
import jakarta.persistence.OneToMany
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import java.math.BigDecimal

data class NewPlanDto(
    @field:Min(value=1, message="Value must be at least 1")
    @field:Max(value=12, message="Value must be at most 12")
    val month: Int,

    val year: Int,
    val totalBudget: BigDecimal,
    @OneToMany
    var categories: List<Category>? = mutableListOf(),
    var authorId: Long
)