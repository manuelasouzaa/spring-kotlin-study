package br.com.manuelasouzaa.spring.kotlin.study.controllers

import br.com.manuelasouzaa.spring.kotlin.study.dtos.CouponDto
import br.com.manuelasouzaa.spring.kotlin.study.dtos.CouponRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CouponController {

    @PostMapping("/register")
    fun post(@RequestBody coupon: CouponRequest): CouponDto {
        return CouponDto(
            id = "123",
            code = coupon.code,
            owner = coupon.owner,
            clicks = 123
        )
    }

}
