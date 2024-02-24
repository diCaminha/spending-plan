package com.bala.spendingplan.entities

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Expense(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val value: BigDecimal,
    @ManyToOne
    val category: Category
)