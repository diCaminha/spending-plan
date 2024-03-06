package com.bala.spendingplan.controllers

import com.bala.spendingplan.services.CategoryService
import com.bala.spendingplan.util.HeaderRequestUtil
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryService: CategoryService,
    private val headerRequestUtil: HeaderRequestUtil
) {
    @GetMapping("/{id}/summary")
    fun getCurrentSummary(@PathVariable("id") id: Long,
                         @RequestHeader("Authorization") authorizationHeader: String) {
        val usernameFromToken = headerRequestUtil.getTokenFromAuthorization(authorizationHeader)

    }
}