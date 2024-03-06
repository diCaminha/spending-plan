package com.bala.spendingplan.services

import com.bala.spendingplan.dto.category.CategoryDto
import com.bala.spendingplan.dto.category.NewCategoryDto
import com.bala.spendingplan.dto.expense.NewExpenseDto
import com.bala.spendingplan.entities.Category
import com.bala.spendingplan.entities.Expense
import com.bala.spendingplan.exceptions.NotFoundException
import com.bala.spendingplan.exceptions.UnauthorizedAccessException
import com.bala.spendingplan.mapper.CategoryMapper
import com.bala.spendingplan.repository.CategoryRepository
import com.bala.spendingplan.repository.ExpenseRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CategoryService (
    private val planService: PlanService,
    private val categoryMapper: CategoryMapper,
    private val categoryRepository: CategoryRepository

) {
    fun create(newCategoryDto: NewCategoryDto): CategoryDto {
        val plan = planService.findById(newCategoryDto.planId)
        val categoryToSave = categoryMapper.map(newCategoryDto, plan)
        categoryRepository.save(categoryToSave)
        return categoryMapper.mapToDto(categoryToSave)
    }
}