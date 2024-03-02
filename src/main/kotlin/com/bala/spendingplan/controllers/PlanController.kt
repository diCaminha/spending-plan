package com.bala.spendingplan.controllers

import com.bala.spendingplan.dto.category.CategoryDto
import com.bala.spendingplan.dto.category.NewCategoryDto
import com.bala.spendingplan.dto.plan.ActivePlanDto
import com.bala.spendingplan.services.PlanService
import com.bala.spendingplan.dto.plan.NewPlanDto
import com.bala.spendingplan.dto.plan.PlanView
import com.bala.spendingplan.entities.Plan
import com.bala.spendingplan.services.CategoryService
import com.bala.spendingplan.util.HeaderRequestUtil
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/plans")
class PlanController(
    private val planService: PlanService,
    private val categoryService: CategoryService,
    private val headerRequestUtil: HeaderRequestUtil
) {

    @GetMapping
    fun list(@RequestParam("username", required = false) username: String,
             @RequestHeader("Authorization") authorizationHeader: String) : ResponseEntity<List<PlanView>> {
        val usernameFromToken = headerRequestUtil.getTokenFromAuthorization(authorizationHeader)
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

    @PatchMapping("/{id}/activate")
    fun active(@PathVariable("id") id: Long,
               @RequestHeader("Authorization") authorizationHeader: String): ResponseEntity<PlanView> {
        val usernameFromToken = headerRequestUtil.getTokenFromAuthorization(authorizationHeader)
        val planActivated = planService.activatePlanById(id, usernameFromToken)
        return ResponseEntity.status(HttpStatus.OK).body(planActivated)
    }

    @PatchMapping("/{id}/deactivate")
    fun deactivate(@PathVariable("id") id: Long,
               @RequestHeader("Authorization") authorizationHeader: String): ResponseEntity<PlanView> {
        val usernameFromToken = headerRequestUtil.getTokenFromAuthorization(authorizationHeader)
        val planActivated = planService.deactivatePlanById(id, usernameFromToken)
        return ResponseEntity.status(HttpStatus.OK).body(planActivated)
    }

    @GetMapping("/active/users/{username}")
    fun getActivePlanFromUser(@PathVariable("username") username: String,
                              @RequestHeader("Authorization") authorizationHeader: String): ResponseEntity<ActivePlanDto> {
        val usernameFromToken = headerRequestUtil.getTokenFromAuthorization(authorizationHeader)
        val activePlanDto = planService.getActivePlanByUser(username)
        return ResponseEntity.status(HttpStatus.OK).body(activePlanDto)


    }
}