package br.com.manuelasouzaa.spring.kotlin.study.dtos

import java.util.*

data class CouponDto(
    val id: UUID,
    val code: String,
    val owner: String,
    val clicks: Int,
)
