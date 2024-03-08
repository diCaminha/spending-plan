package com.bala.spendingplan.dto.category

import java.io.Serializable
import java.math.BigDecimal

data class ActiveCategoryDto(
    val id: Long,
    val name: String,
    val percentageBudget: Int,
    val maximumValue: BigDecimal,
    val currentTotalExpense: BigDecimal
): Serializable
