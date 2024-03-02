package com.bala.spendingplan.mapper

import com.bala.spendingplan.dto.plan.ActivePlanDto
import com.bala.spendingplan.entities.Plan
import org.springframework.stereotype.Component

@Component
class ActivePlanDtoMapper (
    val categoryMapper: CategoryMapper
): Mapper<Plan, ActivePlanDto> {

    override fun map(plan: Plan): ActivePlanDto {
        return ActivePlanDto(
            id = plan.id!!,
            name = plan.month.toString() + "/" + plan.year.toString(),
            totalBudget = plan.totalBudget,
            categories = plan.categories.map { categoryMapper.mapToActiveCategory(it,plan.totalBudget) }
        )
    }
}