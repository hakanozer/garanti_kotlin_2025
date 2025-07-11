package com.works.restcontrollers

import com.works.entities.Customer
import com.works.repositories.CustomerRepository
import com.works.services.CustomerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerRestController (val customerService: CustomerService) {

    @PostMapping("/register")
    fun registerCustomer(@RequestBody customer: Customer): Customer {
        return customerService.registerCustomer(customer)
    }

}