package com.bala.spendingplan.entities

import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Getter
@Setter
@NoArgsConstructor
data class Plan (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,

    private val month: Int,

    private val year: Int,

    private val totalBudget: BigDecimal,

    @OneToMany
    private val categories: List<Category>?,

    private var isActive: Boolean = false,

    @ManyToOne
    private var author: UserPlan,

    private var addedAt: LocalDateTime = LocalDateTime.now()

)