package com.bala.spendingplan.controllers

import com.bala.spendingplan.dto.expense.ExpenseDto
import com.bala.spendingplan.dto.expense.NewExpenseDto
import com.bala.spendingplan.services.ExpenseService
import com.bala.spendingplan.util.HeaderRequestUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/expenses")
class ExpenseController (
    private val expenseService: ExpenseService,
    private val headerRequestUtil: HeaderRequestUtil
) {

    @PostMapping
    fun create(@RequestBody expenseDto: NewExpenseDto,
               @RequestHeader("Authorization") authorizationHeader: String): ResponseEntity<String> {
        val usernameFromToken = headerRequestUtil.getTokenFromAuthorization(authorizationHeader)
        expenseService.addExpense(expenseDto,usernameFromToken!!)
        return ResponseEntity.status(HttpStatus.OK).body("Expense created with success.")
    }

    @GetMapping
    fun findAllFromCategory(@RequestParam("categoryId") categoryId: Long,
                            @RequestHeader("Authorization") authorizationHeader: String): List<ExpenseDto> {
        val usernameFromToken = headerRequestUtil.getTokenFromAuthorization(authorizationHeader)
        val expenses = expenseService.retrieveAllExpensesFromCategoryId(categoryId,usernameFromToken!!)
        return expenses
    }
}