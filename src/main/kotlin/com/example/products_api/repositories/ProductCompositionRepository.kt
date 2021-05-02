package com.example.products_api.repositories

import com.example.products_api.models.Product
import com.example.products_api.models.ProductComposition
import org.springframework.data.repository.CrudRepository

interface ProductCompositionRepository: CrudRepository<ProductComposition, Long> {
}