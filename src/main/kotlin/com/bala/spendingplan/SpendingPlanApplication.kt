package com.bala.spendingplan

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class SpendingPlanApplication

fun main(args: Array<String>) {
	runApplication<SpendingPlanApplication>(*args)
}
