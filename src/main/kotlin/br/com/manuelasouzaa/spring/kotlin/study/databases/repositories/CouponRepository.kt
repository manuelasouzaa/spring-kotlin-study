package br.com.manuelasouzaa.spring.kotlin.study.databases.repositories

import br.com.manuelasouzaa.spring.kotlin.study.databases.entities.CouponEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CouponRepository : JpaRepository<CouponEntity, UUID> {

    fun findByCode(code: String): CouponEntity?

}
