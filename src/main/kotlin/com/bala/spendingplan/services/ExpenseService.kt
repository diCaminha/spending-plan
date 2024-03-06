package com.bala.spendingplan.services

import com.bala.spendingplan.dto.expense.ExpenseDto
import com.bala.spendingplan.dto.expense.NewExpenseDto
import com.bala.spendingplan.entities.Expense
import com.bala.spendingplan.exceptions.NotFoundException
import com.bala.spendingplan.exceptions.UnauthorizedAccessException
import com.bala.spendingplan.repository.CategoryRepository
import com.bala.spendingplan.repository.ExpenseRepository
import com.bala.spendingplan.repository.ExpenseRepositoryJdbc
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ExpenseService (
    private val expenseRepositoryJdbc: ExpenseRepositoryJdbc,
    private val categoryRepository: CategoryRepository,
    private val expenseRepository: ExpenseRepository
) {
    fun retrieveAllExpensesFromCategoryId(categoryId: Long, username: String): List<ExpenseDto> {
        val category = categoryRepository
            .findById(categoryId)
            .orElseThrow { NotFoundException("Not found category") }

        val authorUsername = category.plan.author.username

        if (username != authorUsername)
            throw throw UnauthorizedAccessException("the user requestor is not the user owner of the category")

        return expenseRepositoryJdbc.findExpensesByCategoryId(categoryId)

    }

    @Transactional
    fun addExpense(newExpenseDto: NewExpenseDto, username: String) {
        val category = categoryRepository
            .findById(newExpenseDto.categoryId)
            .orElseThrow { NotFoundException("Not found category for the expense") }

        val authorUsername = category.plan.author.username

        if (username != authorUsername)
            throw throw UnauthorizedAccessException("the user requestor is not the user owner of the category's expense")

        val expense = Expense(
            value = newExpenseDto.costValue,
            category = category,
            date = newExpenseDto.date,
            description = newExpenseDto.description
        )

        category.expenses.add(expense)
        category.currentTotalExpense = category.currentTotalExpense!!.add(expense.value)

        expenseRepository.save(expense)
    }

}