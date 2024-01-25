package com.bala.spendingplan.entities

import java.math.BigDecimal

data class Category(
    val id: Long? = null,
    val name: String,
    val percentageBudget: Int,
    var currentTotalExpense: BigDecimal? = BigDecimal.valueOf(0),
    var expenses: MutableList<Expense> = mutableListOf<Expense>()
)