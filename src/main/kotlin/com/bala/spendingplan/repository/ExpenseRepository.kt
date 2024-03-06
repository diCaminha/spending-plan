package com.bala.spendingplan.repository

import com.bala.spendingplan.entities.Expense
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ExpenseRepository: CrudRepository<Expense,Long> {
    fun findByCategoryId(categoryId: Long): List<Expense>
}