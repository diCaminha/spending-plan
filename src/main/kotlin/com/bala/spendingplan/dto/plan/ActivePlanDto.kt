package com.bala.spendingplan.dto.plan

import com.bala.spendingplan.dto.category.ActiveCategoryDto
import java.io.Serializable
import java.math.BigDecimal

data class ActivePlanDto(
    val id: Long,
    val name: String,
    val totalBudget: BigDecimal,
    val categories: List<ActiveCategoryDto>,
): Serializable
