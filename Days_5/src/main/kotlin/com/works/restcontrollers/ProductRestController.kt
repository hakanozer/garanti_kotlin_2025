package com.works.restcontrollers

import com.works.entities.Product
import com.works.entities.dtos.ProductSaveDto
import com.works.services.ProductService
import com.works.utils.Util
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductRestController(
    private val productService: ProductService
) {

    @PostMapping("save")
    fun saveProduct(@Valid @RequestBody productSaveDto: ProductSaveDto): ResponseEntity<Any> {
        try {
            val product = productService.save(productSaveDto)
            return Util.ok(product)
        }catch ( ex: Exception ) {
            var message = ex.message!!
            if (ex.message!!.contains("Unique index")) {
                message ="title: " + productSaveDto.title + "  all ready use"
            }
            return Util.fail(message, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}