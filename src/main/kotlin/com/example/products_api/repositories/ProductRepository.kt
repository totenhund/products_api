package com.example.products_api.repositories

import com.example.products_api.models.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<Product, Long> {
    fun findProductByIdQrCode(qrCode: String): Product?
}