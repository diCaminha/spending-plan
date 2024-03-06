package com.bala.spendingplan.entities

import jakarta.persistence.*
import lombok.NoArgsConstructor
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@NoArgsConstructor
data class Expense(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val value: BigDecimal,

    @ManyToOne(fetch = FetchType.LAZY)
    val category: Category,

    val date: LocalDateTime,

    val description: String
)