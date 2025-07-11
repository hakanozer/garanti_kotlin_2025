package com.works.repositories

import com.works.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface CustomerRepository : JpaRepository<Customer, Long> {
    fun findByUsernameEqualsIgnoreCase(username: String): Optional<Customer>
}