package com.works.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
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

    @Column(unique = true)
    var title: String,
    var description: String,
    var price: Double,
    @JsonIgnore var createdDate: LocalDateTime? = null,
    @JsonIgnore var updatedDate: LocalDateTime? = null,

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
