package com.example.products_api.repositories

import com.example.products_api.models.FoodIngredient
import org.springframework.data.repository.CrudRepository

interface FoodIngredientRepository: CrudRepository<FoodIngredient, Long> {
}