package com.example.products_api.helpers

import com.example.products_api.models.ProductComposition

data class ProductVO(
        val idQrCode: String,
        val productName: String,
        val productComposition: ProductCompositionVO
)

data class ProductCompositionVO(
        val foodAdditives: List<String>,
        val foodIngredients: List<String>
)