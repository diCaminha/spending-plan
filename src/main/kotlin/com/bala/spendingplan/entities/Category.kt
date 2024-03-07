package com.bala.spendingplan.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import lombok.NoArgsConstructor
import java.math.BigDecimal

@Entity
@NoArgsConstructor
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    val percentageBudget: Int,

    var currentTotalExpense: BigDecimal? = BigDecimal.valueOf(0),

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "category")
    var expenses: MutableList<Expense> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    //@JsonBackReference
    val plan: Plan
) {
    fun getOwnerUsername(): String {
        return plan.author.username
    }
}