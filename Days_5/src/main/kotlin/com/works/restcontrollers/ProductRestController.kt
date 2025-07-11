package com.works.restcontrollers

import com.works.entities.Product
import com.works.entities.dtos.ProductSaveDto
import com.works.entities.dtos.ProductUpdateDto
import com.works.services.ProductService
import com.works.utils.Util
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.Length
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
@Validated
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

    @GetMapping("list")
    fun listProduct(): List<Product> {
        return productService.findAll()
    }

    @PutMapping("update")
    fun updateProduct(@Valid @RequestBody productUpdateDto: ProductUpdateDto): ResponseEntity<Any> {
        try {
            val product = productService.update(productUpdateDto)
            return Util.ok(product)
        }catch ( ex: Exception ) {
            var message = ex.message!!
            if (ex.message!!.contains("Unique index")) {
                message ="title: " + productUpdateDto.title + "  all ready use"
            }
            return Util.fail(message, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("delete")
    fun deleteProduct(@Min(1) @RequestParam pid: Long): ResponseEntity<Any> {
        val deleteEnd = productService.delete(pid)
        if(deleteEnd != null) {
            return Util.ok(deleteEnd)
        }
        return Util.fail("Product not found", HttpStatus.NOT_FOUND)
    }

    @GetMapping("search")
    fun searchProduct( @NotNull @NotEmpty @Size(min = 2, max = 100) @RequestParam q: String ): ResponseEntity<Any> {
        val list = productService.search(q)
        return Util.ok(list)
    }


}