package com.works.services

import com.works.entities.Product
import com.works.entities.dtos.ProductSaveDto
import com.works.entities.dtos.ProductUpdateDto
import com.works.repositories.ProductRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val modelMapper: ModelMapper
) {

    fun save(productSaveDto: ProductSaveDto): Product {
        val product: Product = modelMapper.map(productSaveDto, Product::class.java)
        productRepository.save(product)
        return product
    }

    fun findAll(): List<Product> {
        return productRepository.findAll()
    }

    fun update(productUpdateDto: ProductUpdateDto): Product {
        val optionalProduct = productRepository.findById(productUpdateDto.pid!!)
        if (optionalProduct.isPresent) {
            val pro = optionalProduct.get()
            val product: Product = modelMapper.map(productUpdateDto, Product::class.java)
            product.createdDate = pro.createdDate
            productRepository.saveAndFlush<Product>(product)
            return product
        }
        throw IllegalArgumentException("Product not found")
    }

    fun delete(productId: Long) : Product?{
        val optionalProduct = productRepository.findById(productId)
        if (optionalProduct.isPresent) {
            val pro = optionalProduct.get()
            productRepository.deleteById(productId)
            return pro
        }
        return null
    }

    fun search(q: String): List<Product> {
        return productRepository.findByTitleContainsIgnoreCase(q)
    }

}