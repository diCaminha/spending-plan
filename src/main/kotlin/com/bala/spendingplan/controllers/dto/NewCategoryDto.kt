package com.bala.spendingplan.controllers.dto

data class NewCategoryDto (
    val name: String,
    val percentageBudget: Int,
    val planId: Long
)