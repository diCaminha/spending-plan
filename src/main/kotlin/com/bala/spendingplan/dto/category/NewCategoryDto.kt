package com.bala.spendingplan.dto.category

data class NewCategoryDto (
    val name: String,
    val percentageBudget: Int,
    val planId: Long
)