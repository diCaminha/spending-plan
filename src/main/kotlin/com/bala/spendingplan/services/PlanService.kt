package com.bala.spendingplan.services

import com.bala.spendingplan.dto.plan.ActivePlanDto
import com.bala.spendingplan.dto.plan.NewPlanDto
import com.bala.spendingplan.dto.plan.PlanView
import com.bala.spendingplan.entities.Plan
import com.bala.spendingplan.exceptions.DuplicateActivePlanException
import com.bala.spendingplan.exceptions.NotFoundException
import com.bala.spendingplan.exceptions.UnauthorizedAccessException
import com.bala.spendingplan.mapper.ActivePlanDtoMapper
import com.bala.spendingplan.mapper.PlanViewMapper
import com.bala.spendingplan.repository.PlanRepository
import org.springframework.stereotype.Service

@Service
class PlanService (
    private val userService: UserService,
    private val planViewMapper: PlanViewMapper,
    private val planRepository: PlanRepository,
    private val activePlanDtoMapper: ActivePlanDtoMapper
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
            author = userService.findById(planDto.authorId)
        )
        val planSaved = planRepository.save(planToRegister)

        return planViewMapper.map(planSaved)
    }

    fun listByUser(username: String): List<PlanView> {
        val plans = planRepository.findByAuthorUsername(username)
        return plans.map { planViewMapper.map(it) }
    }

    fun activatePlanById(id: Long, usernameFromToken: String?): PlanView {
        val plan = planRepository.findById(id).orElseThrow {NotFoundException("Plan not found")}
        val username = plan.author.username
        if (username != usernameFromToken) {
            throw UnauthorizedAccessException("the user requestor is not the user owner of the plan")
        }
        if (planRepository.findByisActiveTrueAndAuthorAndIdNot(plan.author, id).isPresent) {
            throw DuplicateActivePlanException("Already exist a plan activated.")
        }
        plan.isActive = true
        planRepository.save(plan)

        return planViewMapper.map(plan)
    }

    fun deactivatePlanById(id: Long, usernameFromToken: String?): PlanView {
        val plan = planRepository.findById(id).orElseThrow {NotFoundException("Plan not found")}
        val username = plan.author.username
        if (username != usernameFromToken) {
            throw UnauthorizedAccessException("the user requestor is not the user owner of the plan")
        }

        plan.isActive = false
        planRepository.save(plan)

        return planViewMapper.map(plan)
    }

    fun getActivePlanByUser(username: String): ActivePlanDto {
        val activePlan =
            planRepository
                .findByAuthorUsernameAndIsActiveTrue(username)
                .orElseThrow { NotFoundException("Not found any plan active") }

        if (activePlan.author.username != username) {
            throw UnauthorizedAccessException("the user requestor is not the user owner of the plan")
        }

        return activePlanDtoMapper.map(activePlan)

    }
}