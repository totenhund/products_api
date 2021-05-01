package com.example.products_api.components

import com.example.products_api.helpers.ProductCompositionVO
import com.example.products_api.helpers.ProductVO
import com.example.products_api.models.Product
import com.example.products_api.models.ProductComposition
import org.springframework.stereotype.Component

@Component
class ProductAssembler {
    fun toProductVO(product: Product): ProductVO{
        return ProductVO(product.idQrCode, product.productName, parseProductComposition(product.productComposition))
    }

    private fun parseProductComposition(productComposition: ProductComposition): ProductCompositionVO{
        val foodAdditives = mutableListOf<String>()
        productComposition.foodAdditives.forEach {
            foodAdditives.add(it.title)
        }
        val foodIngredients = mutableListOf<String>()
        productComposition.foodIngredients.forEach {
            foodIngredients.add(it.title)
        }
        return ProductCompositionVO(foodAdditives, foodIngredients)
    }
}