package com.bala.spendingplan.repository

import com.bala.spendingplan.entities.Category
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository: CrudRepository<Category,Long> {}