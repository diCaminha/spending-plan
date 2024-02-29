package com.bala.spendingplan.controllers

import com.bala.spendingplan.configurations.TokenService
import com.bala.spendingplan.controllers.dto.CategoryDto
import com.bala.spendingplan.controllers.dto.NewCategoryDto
import com.bala.spendingplan.services.PlanService
import com.bala.spendingplan.controllers.dto.plan.NewPlanDto
import com.bala.spendingplan.controllers.dto.plan.PlanView
import com.bala.spendingplan.services.CategoryService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException.Unauthorized

@RestController
@RequestMapping("/plans")
class PlanController(
    private val planService: PlanService,
    private val categoryService: CategoryService,
    private val tokenService: TokenService
) {

    @GetMapping
    fun list(@RequestParam("username", required = false) username: String,
             @RequestHeader("Authorization") authorizationHeader: String) : ResponseEntity<List<PlanView>> {
        val token = authorizationHeader.substringAfter("Bearer ")
        val usernameFromToken = tokenService.extractUsername(token)
        if (usernameFromToken != username) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null)
        }
        return ResponseEntity.status(HttpStatus.OK).body(planService.listByUser(username))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long) {
        planService.findById(id)
    }

    @PostMapping
    fun register(@RequestBody @Valid planDto: NewPlanDto): ResponseEntity<PlanView> {
        return ResponseEntity.status(HttpStatus.CREATED).body(planService.register(planDto))
    }

    @PostMapping("/{planId}/categories")
    fun createCategory(@RequestBody newCategoryDto: NewCategoryDto): ResponseEntity<CategoryDto> {
        val categoryCreated = categoryService.create(newCategoryDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryCreated)
    }
}