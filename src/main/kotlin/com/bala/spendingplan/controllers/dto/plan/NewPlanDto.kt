package com.bala.spendingplan.controllers.dto.plan

import com.bala.spendingplan.entities.Category
import jakarta.persistence.OneToMany
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.math.BigDecimal

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
data class NewPlanDto(
    @field:Min(value=1, message="Value must be at least 1")
    @field:Max(value=12, message="Value must be at most 12")
    private val month: Int,

    private val year: Int,

    private val totalBudget: BigDecimal,

    @OneToMany
    private var categories: List<Category>? = mutableListOf(),

    private var authorId: Long
)