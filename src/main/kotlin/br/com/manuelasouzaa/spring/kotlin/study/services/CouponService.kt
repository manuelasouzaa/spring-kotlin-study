package br.com.manuelasouzaa.spring.kotlin.study.services

import br.com.manuelasouzaa.spring.kotlin.study.databases.entities.CouponEntity
import br.com.manuelasouzaa.spring.kotlin.study.databases.repositories.CouponRepository
import br.com.manuelasouzaa.spring.kotlin.study.dtos.CouponDto
import org.springframework.stereotype.Service

@Service
class CouponService(
    private val repository: CouponRepository
) {

    fun register(code: String, owner: String): CouponDto {
        val entity = CouponEntity(
            code = code.trim(),
            owner = owner.trim(),
            clicks = 0
        )
        val savedEntity = repository.save(entity)

        return CouponDto(
            id = savedEntity.id!!,
            code = savedEntity.code,
            owner = savedEntity.owner,
            clicks = savedEntity.clicks
        )
    }

}
