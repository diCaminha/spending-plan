package com.bala.spendingplan.entities

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val percentageBudget: Int,
    var currentTotalExpense: BigDecimal? = BigDecimal.valueOf(0),
    @OneToMany(fetch = FetchType.LAZY)
    var expenses: MutableList<Expense>? = mutableListOf()
)