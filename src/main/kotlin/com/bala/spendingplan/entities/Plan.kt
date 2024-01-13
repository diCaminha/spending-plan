package com.bala.spendingplan.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
class Plan (
    @Id @GeneratedValue var id: Long? = null,
    var month: Int,
    var year: Int,
    var isActive: Boolean = false,
    @ManyToOne var author: UserPlan,
    var addedAt: LocalDateTime = LocalDateTime.now()
)