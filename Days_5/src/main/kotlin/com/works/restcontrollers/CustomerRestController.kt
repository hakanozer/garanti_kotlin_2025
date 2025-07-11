package com.works.restcontrollers

import com.works.entities.Customer
import com.works.repositories.CustomerRepository
import com.works.services.CustomerService
import com.works.utils.Util
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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

    @PostMapping("/login")
    fun login(@RequestBody customer: Customer): ResponseEntity<Any> {
        val loginStatus = customerService.loginCustomer(customer)
        if (loginStatus != null) {
            return Util.ok(loginStatus)
        }
        return Util.fail("Username or password invalid", HttpStatus.NOT_FOUND)
    }



}