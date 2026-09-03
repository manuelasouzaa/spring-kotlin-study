package br.com.manuelasouzaa.spring.kotlin.study.databases.entities

import jakarta.persistence.*
import java.util.*
import kotlin.time.Clock
import kotlin.time.Instant

@Entity
@Table(
    name = "coupons",
    uniqueConstraints = [
        UniqueConstraint(name = "br_coupons_code", columnNames = ["code"]),
        UniqueConstraint(name = "br_coupons_owner", columnNames = ["owner"]),
    ]
)
class CouponEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @Column(nullable = false)
    var code: String,

    @Column(nullable = false)
    var owner: String,

    @Column(nullable = false)
    var clicks: Int,

    @Column(nullable = false)
    var createdAt: Instant = Clock.System.now()
)
