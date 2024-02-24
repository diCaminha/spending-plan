package com.bala.spendingplan.mapper

import com.bala.spendingplan.controllers.dto.plan.PlanView
import com.bala.spendingplan.entities.Plan
import org.springframework.stereotype.Component

@Component
class PlanViewMapper: Mapper<Plan, PlanView> {
    override fun map(plan: Plan): PlanView {
        return PlanView(
            id = plan.id,
            month = plan.month,
            year = plan.year,
            totalBudget = plan.totalBudget,
            isActive = plan.isActive,
            authorId = plan.author.id,
            addedAt = plan.addedAt
        )
    }
}