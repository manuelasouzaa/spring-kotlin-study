package br.com.manuelasouzaa.spring.kotlin.study.controllers

import br.com.manuelasouzaa.spring.kotlin.study.dtos.CouponDto
import br.com.manuelasouzaa.spring.kotlin.study.dtos.CouponRequest
import br.com.manuelasouzaa.spring.kotlin.study.services.CouponService
import org.springframework.web.bind.annotation.*

@RestController
class CouponController(
    private val service: CouponService
) {

    @GetMapping("/{code}")
    fun fetch(@PathVariable code: String): CouponDto? {
        return service.fetch(code)
    }

    @PostMapping("/register")
    fun post(@RequestBody coupon: CouponRequest): CouponDto {
        val dto = service.register(code = coupon.code, owner = coupon.owner)
        return dto
    }

}
