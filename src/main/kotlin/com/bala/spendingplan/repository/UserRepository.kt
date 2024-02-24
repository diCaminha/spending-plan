package com.bala.spendingplan.repository

import com.bala.spendingplan.entities.UserPlan
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<UserPlan, Long> {}