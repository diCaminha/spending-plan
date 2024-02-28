package com.bala.spendingplan.services

import com.bala.spendingplan.controllers.dto.CategoryDto
import com.bala.spendingplan.controllers.dto.NewCategoryDto
import com.bala.spendingplan.mapper.CategoryMapper
import com.bala.spendingplan.repository.CategoryRepository
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