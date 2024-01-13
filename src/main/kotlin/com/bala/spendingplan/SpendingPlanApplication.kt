package com.bala.spendingplan

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
class SpendingPlanApplication

fun main(args: Array<String>) {
	runApplication<SpendingPlanApplication>(*args)
}
