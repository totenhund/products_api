package com.example.products_api.services

import com.example.products_api.models.Product

interface ProductService {
    fun addProduct(productDetails: Product): Product
}