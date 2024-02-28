package com.bala.spendingplan.mapper

import com.bala.spendingplan.controllers.dto.CategoryDto
import com.bala.spendingplan.controllers.dto.NewCategoryDto
import com.bala.spendingplan.entities.Category
import com.bala.spendingplan.entities.Plan
import org.springframework.stereotype.Component

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
}