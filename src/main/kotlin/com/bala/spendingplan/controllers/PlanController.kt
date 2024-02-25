package com.bala.spendingplan.controllers

import com.bala.spendingplan.services.PlanService
import com.bala.spendingplan.controllers.dto.plan.NewPlanDto
import com.bala.spendingplan.controllers.dto.plan.PlanView
import com.bala.spendingplan.entities.Plan
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/plans")
class PlanController(
    private val planService: PlanService
) {

    @GetMapping
    fun list() : List<PlanView> {
        return planService.listAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long) {
        planService.findById(id)
    }

    @PostMapping
    fun register(@RequestBody @Valid planDto: NewPlanDto): ResponseEntity<PlanView> {
        return ResponseEntity.status(HttpStatus.CREATED).body(planService.register(planDto))
    }
}