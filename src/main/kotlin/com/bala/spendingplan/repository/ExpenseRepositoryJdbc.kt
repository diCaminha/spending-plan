package com.bala.spendingplan.repository

import com.bala.spendingplan.dto.expense.ExpenseDto
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class ExpenseRepositoryJdbc (
    val jdbcTemplate: JdbcTemplate
) {
    fun findExpensesByCategoryId(categoryId: Long): List<ExpenseDto> {

        var rowMapper: RowMapper<ExpenseDto> = RowMapper<ExpenseDto> { resultSet: ResultSet, rowIndex: Int ->
            ExpenseDto(
                description = resultSet.getString("description"),
                costValue = resultSet.getBigDecimal("value"),
                date = resultSet.getTimestamp("date").toLocalDateTime(),
                categoryId = resultSet.getLong("category_id"))
        }

        val results = jdbcTemplate.query(
            "SELECT description, value, date, category_id FROM expense" +
                    " WHERE category_id = ?", arrayOf(categoryId), rowMapper
        )

        results.forEach { println(it) }

        return results
    }
}