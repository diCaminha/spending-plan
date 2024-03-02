package com.bala.spendingplan.repository

import com.bala.spendingplan.entities.Plan
import com.bala.spendingplan.entities.UserPlan
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PlanRepository: CrudRepository<Plan, Long> {
    fun findByAuthorUsername(username: String) : List<Plan>
    fun findByisActiveTrueAndAuthorAndIdNot(author: UserPlan, id: Long): Optional<Plan>
}