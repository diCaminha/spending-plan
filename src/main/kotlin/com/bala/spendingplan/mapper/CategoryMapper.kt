package com.bala.spendingplan.mapper

import com.bala.spendingplan.dto.category.ActiveCategoryDto
import com.bala.spendingplan.dto.category.CategoryDto
import com.bala.spendingplan.dto.category.NewCategoryDto
import com.bala.spendingplan.entities.Category
import com.bala.spendingplan.entities.Plan
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class CategoryMapper {
    fun map(newCategoryDto: NewCategoryDto, plan: Plan ): Category {
        return Category(
            name = newCategoryDto.name,
            percentageBudget = newCategoryDto.percentageBudget,
            plan = plan
        )
    }

    fun mapToDto(category: Category) = CategoryDto(
        id = category.id!!,
        name = category.name,
        percentageBudget = category.percentageBudget
    )

    fun mapToActiveCategory(category: Category, totalBudgetPlan: BigDecimal): ActiveCategoryDto {
        val maxValue =
            totalBudgetPlan * (category.percentageBudget/100.0).toBigDecimal()
        return ActiveCategoryDto(
            id = category.id!!,
            name = category.name,
            percentageBudget = category.percentageBudget,
            maximumValue = maxValue,
            currentTotalExpense = category.currentTotalExpense!!)
    }
}