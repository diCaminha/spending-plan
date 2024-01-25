package com.bala.spendingplan

import com.bala.spendingplan.entities.Category
import com.bala.spendingplan.entities.Expense
import com.bala.spendingplan.entities.Plan
import com.bala.spendingplan.entities.UserPlan
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class PlanService {

    fun listAll(): List<Plan> {

        val category = Category(
            id = 1,
            name = "Compras",
            percentageBudget = 10
        )


        val plan = Plan(
            id = 1,
            month = 1,
            year = 2024,
            totalBudget = BigDecimal.valueOf(1000.0),
            author = UserPlan(
                id = 1,
                login = "denis",
                firstname = "Denis",
                lastname = "Caminha"
            ),
            categories = listOf(category)
        )

        return listOf(plan)
    }
}