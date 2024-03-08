package com.bala.spendingplan.services

import com.bala.spendingplan.dto.category.CategoryDto
import com.bala.spendingplan.dto.category.NewCategoryDto
import com.bala.spendingplan.mapper.CategoryMapper
import com.bala.spendingplan.repository.CategoryRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.stereotype.Service

@Service
class CategoryService (
    private val planService: PlanService,
    private val categoryMapper: CategoryMapper,
    private val categoryRepository: CategoryRepository
) {
    @CacheEvict(cacheNames = ["activeplan"], allEntries = true)
    fun create(newCategoryDto: NewCategoryDto): CategoryDto {
        val plan = planService.findById(newCategoryDto.planId)
        val categoryToSave = categoryMapper.map(newCategoryDto, plan)
        categoryRepository.save(categoryToSave)
        return categoryMapper.mapToDto(categoryToSave)
    }
 }