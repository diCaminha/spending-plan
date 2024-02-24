package com.bala.spendingplan.services

import com.bala.spendingplan.controllers.dto.plan.NewPlanDto
import com.bala.spendingplan.controllers.dto.plan.PlanView
import com.bala.spendingplan.entities.Plan
import com.bala.spendingplan.mapper.PlanViewMapper
import com.bala.spendingplan.repository.PlanRepository
import org.springframework.stereotype.Service

@Service
class PlanService (
    private val userService: UserService,
    private val planViewMapper: PlanViewMapper,
    private val planRepository: PlanRepository
    ) {

    fun listAll(): List<PlanView> {
        val plans = planRepository.findAll()
        return plans.map { it -> planViewMapper.map(it) }
    }

    fun findById(id: Long): Plan {
        return planRepository.findById(id).get()
    }

    fun register(planDto: NewPlanDto): PlanView {
        val planToRegister = Plan(
            month = planDto.month,
            year = planDto.year,
            totalBudget = planDto.totalBudget,
            categories = planDto.categories,
            author = userService.findById(planDto.authorId)
        )

        val planSaved = planRepository.save(planToRegister)

        return planViewMapper.map(planSaved)
    }
}