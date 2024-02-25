package com.bala.spendingplan.entities

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.math.BigDecimal

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,

    private val name: String,

    private val percentageBudget: Int,

    private var currentTotalExpense: BigDecimal? = BigDecimal.valueOf(0),

    @OneToMany(fetch = FetchType.LAZY)
    private var expenses: MutableList<Expense>? = mutableListOf(),

    @ManyToOne
    private val plan: Plan
)