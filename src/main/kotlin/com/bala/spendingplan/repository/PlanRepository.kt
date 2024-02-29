package com.bala.spendingplan.repository

import com.bala.spendingplan.entities.Plan
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlanRepository: CrudRepository<Plan, Long> {
    fun findByAuthorUsername(username: String) : List<Plan>
}