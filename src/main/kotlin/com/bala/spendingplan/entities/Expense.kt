package com.bala.spendingplan.entities

import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.math.BigDecimal

@Entity
@Getter
@Setter
@NoArgsConstructor
data class Expense(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,

    private val value: BigDecimal,

    @ManyToOne
    private val category: Category
)