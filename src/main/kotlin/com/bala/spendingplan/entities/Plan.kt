package com.bala.spendingplan.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import lombok.NoArgsConstructor
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@NoArgsConstructor
data class Plan (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val month: Int,

    val year: Int,

    val totalBudget: BigDecimal,

    @OneToMany(mappedBy = "plan", fetch = FetchType.EAGER)
    @JsonManagedReference
    val categories: List<Category> = mutableListOf(),

    var isActive: Boolean = false,

    @ManyToOne
    var author: UserPlan,

    var addedAt: LocalDateTime = LocalDateTime.now()

)