package com.works.services

import com.works.entities.Product
import com.works.entities.dtos.ProductSaveDto
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

}