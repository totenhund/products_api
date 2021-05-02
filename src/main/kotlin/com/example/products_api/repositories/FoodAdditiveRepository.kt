package com.example.products_api.repositories

import com.example.products_api.models.FoodAdditive
import org.springframework.data.repository.CrudRepository

interface FoodAdditiveRepository: CrudRepository<FoodAdditive, Long> {
}