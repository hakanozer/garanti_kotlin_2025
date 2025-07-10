package com.works.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.time.LocalDateTime

@Entity
data class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var pid: Long? = null,

    var title: String,
    var description: String,
    var price: Double,
    var createdDate: LocalDateTime? = null,
    var updatedDate: LocalDateTime? = null,
) {

    @PrePersist
    fun prePersist() {
        createdDate = LocalDateTime.now()
        updatedDate = LocalDateTime.now()
    }

    @PreUpdate
    fun preUpdate() {
        updatedDate = LocalDateTime.now()
    }
}
