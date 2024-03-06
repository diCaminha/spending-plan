package com.bala.spendingplan.dto.expense

import java.math.BigDecimal
import java.time.LocalDateTime

data class ExpenseDto(
    val description: String,
    val categoryId: Long,
    val costValue: BigDecimal,
    val date: LocalDateTime,

)
