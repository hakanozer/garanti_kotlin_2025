package com.works.services

import com.works.entities.Customer
import com.works.repositories.CustomerRepository
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val tinkEncDec: TinkEncDec,
    val request: HttpServletRequest
) {

    fun registerCustomer(customer: Customer) : Customer {
        val cipher = tinkEncDec.encrypt(customer.password)
        customer.password = cipher
        customerRepository.save(customer)
        return customer
    }

    fun loginCustomer(customer: Customer): Customer? {
        val customerOptional = customerRepository.findByUsernameEqualsIgnoreCase(customer.username)
        if (customerOptional.isPresent) {
            val cus = customerOptional.get()
            val plainPassword = tinkEncDec.decrypt(cus.password)
            if (plainPassword == customer.password) {
                request.session.setAttribute("customer", customer)
                return cus
            }
        }
        return null
    }
}