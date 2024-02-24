package com.bala.spendingplan.controllers.dto.plan

import com.bala.spendingplan.entities.Category
import jakarta.persistence.OneToMany
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import java.math.BigDecimal

data class NewPlanDto(
    @field:NotEmpty
    @field:Size(min = 1, max = 12)
    val month: Int,

    val year: Int,
    val totalBudget: BigDecimal,
    @OneToMany
    var categories: List<Category>? = mutableListOf(),
    var authorId: Long
)