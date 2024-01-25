package com.bala.spendingplan.controllers

import com.bala.spendingplan.PlanService
import com.bala.spendingplan.entities.Plan
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("plans")
class PlanController(
    private val planService: PlanService
) {

    @GetMapping
    fun list() : List<Plan> {
        return planService.listAll()
    }
}