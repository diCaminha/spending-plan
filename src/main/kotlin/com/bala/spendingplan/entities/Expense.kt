package com.bala.spendingplan.entities

import java.math.BigDecimal

data class Expense(
    val id: Long? = null,
    val value: BigDecimal,
    val category: Category
)