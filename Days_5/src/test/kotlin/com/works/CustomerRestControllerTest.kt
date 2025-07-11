package com.works

import org.mockito.Mockito.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.works.entities.Customer
import com.works.repositories.CustomerRepository
import com.works.restcontrollers.CustomerRestController
import com.works.services.CustomerService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.mock.http.server.reactive.MockServerHttpRequest.post
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ExtendWith(SpringExtension::class)
@WebMvcTest(controllers = [CustomerRestController::class])
class CustomerRestControllerTest {

    @MockitoBean
    lateinit var customerService: CustomerService

    @Autowired
    lateinit var webMvc: MockMvc

    @Autowired
    lateinit var mapper: ObjectMapper

    @Test
    fun loginTest() {
        val url = "/customers/login"
        val customer = Customer(cid = null, username = "zehra@mail.com", password = "12345")

        customerService.loginCustomer(customer)
        val mvcResult = webMvc.perform(
            MockMvcRequestBuilders.post(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(customer))
        )
        .andExpect(MockMvcResultMatchers.status().isOk)
        .andDo(MockMvcResultHandlers.print())
        .andReturn()

        val content = mapper.readValue(mvcResult.response.contentAsString, Customer::class.java)
        Assertions.assertNotNull(content)
    }



}