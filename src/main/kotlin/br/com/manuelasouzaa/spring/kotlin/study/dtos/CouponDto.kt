package br.com.manuelasouzaa.spring.kotlin.study.dtos

data class CouponDto(
    val id: String,
    val code: String,
    val owner: String,
    val clicks: Int,
)
