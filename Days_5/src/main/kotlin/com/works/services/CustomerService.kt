package com.works.services

import com.works.entities.Customer
import com.works.repositories.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val tinkEncDec: TinkEncDec
) {

    fun registerCustomer(customer: Customer) : Customer {
        val cipher = tinkEncDec.encrypt(customer.password)
        customer.password = cipher
        customerRepository.save(customer)
        return customer
    }
}