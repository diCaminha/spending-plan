package com.bala.spendingplan.repository

import com.bala.spendingplan.entities.Plan
import com.bala.spendingplan.entities.UserPlan
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PlanRepository: CrudRepository<Plan, Long> {
    fun findByAuthorUsername(username: String) : List<Plan>
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Plan p WHERE p.isActive = true AND p.author = :author AND p.id != :id")
    fun checkIfExistsPlanAlreadyActive(author: UserPlan, id: Long): Boolean
    fun findByAuthorUsernameAndIsActiveTrue(username: String): Optional<Plan>
}