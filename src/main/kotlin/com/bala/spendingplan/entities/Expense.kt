package com.bala.spendingplan.entities

import jakarta.persistence.*
import lombok.NoArgsConstructor
import java.math.BigDecimal

@Entity
@NoArgsConstructor
data class Expense(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val value: BigDecimal,

    @ManyToOne
    val category: Category
)