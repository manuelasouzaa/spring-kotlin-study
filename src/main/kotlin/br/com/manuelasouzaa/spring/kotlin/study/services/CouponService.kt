package br.com.manuelasouzaa.spring.kotlin.study.services

import br.com.manuelasouzaa.spring.kotlin.study.databases.entities.CouponEntity
import br.com.manuelasouzaa.spring.kotlin.study.databases.repositories.CouponRepository
import br.com.manuelasouzaa.spring.kotlin.study.dtos.CouponDto
import org.springframework.stereotype.Service

@Service
class CouponService(
    private val repository: CouponRepository
) {
    private val domain = "https://www.google.com"

    fun click(code: String): String {
        val entity = repository.findByCode(code)

        return entity?.let {
            entity.clicks +=1
            repository.save(entity)
            "$domain/search?q=${it.code}"
        } ?: domain
    }

    fun fetch(code: String): CouponDto? {
        val entity = repository.findByCode(code)

        return entity?.let {
            CouponDto(
                id = it.id!!,
                code = it.code,
                owner = it.owner,
                clicks = it.clicks
            )
        }
    }

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
