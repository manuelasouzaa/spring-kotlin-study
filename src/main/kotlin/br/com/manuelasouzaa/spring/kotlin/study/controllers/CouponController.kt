package br.com.manuelasouzaa.spring.kotlin.study.controllers

import br.com.manuelasouzaa.spring.kotlin.study.dtos.CouponDto
import br.com.manuelasouzaa.spring.kotlin.study.dtos.CouponRequest
import br.com.manuelasouzaa.spring.kotlin.study.services.CouponService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CouponController(
    private val service: CouponService
) {

    @GetMapping("/click/{code}")
    fun click(@PathVariable code: String): ResponseEntity<Void> {
        val url = service.click(code)
        return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, url)
            .build()
    }

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
