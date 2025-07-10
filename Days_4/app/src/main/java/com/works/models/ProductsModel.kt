package com.works.models

data class ProductsModel (
    val meta: MetaProduct,
    val data: List<Product>
)

data class Product (
    val id: Long,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Long,
    val tags: List<String>,
    val brand: String,
    val sku: String,
    val minimumOrderQuantity: Long,
    val images: List<String>
)

data class MetaProduct (
    val status: Long,
    val message: String,
    val pagination: Pagination
)

data class Pagination (
    val page: Long,
    val perPage: Long,
    val totalItems: Long,
    val totalPages: Long
)
