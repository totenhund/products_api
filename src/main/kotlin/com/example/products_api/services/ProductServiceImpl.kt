package com.example.products_api.services

import com.example.products_api.exceptions.QrCodeUnavailableException
import com.example.products_api.models.Product
import com.example.products_api.repositories.FoodAdditiveRepository
import com.example.products_api.repositories.FoodIngredientRepository
import com.example.products_api.repositories.ProductCompositionRepository
import com.example.products_api.repositories.ProductRepository
import org.springframework.stereotype.Service
import kotlin.jvm.Throws

@Service
class ProductServiceImpl(val repository: ProductRepository, val productCompositionRepository: ProductCompositionRepository, val foodAdditiveRepository: FoodAdditiveRepository, val foodIngredientRepository: FoodIngredientRepository) : ProductService {
    @Throws(QrCodeUnavailableException::class)
    override fun addProduct(productDetails: Product): Product {
        if(!qrCodeExists(productDetails.idQrCode)){
            val product = Product(productDetails.productName, productDetails.idQrCode, productComposition = productDetails.productComposition)

            productDetails.productComposition?.let { productCompositionRepository.save(it) }
            productDetails.productComposition?.foodAdditives?.forEach {
                it.productComp = productDetails.productComposition!!
                foodAdditiveRepository.save(it)
            }
            productDetails.productComposition?.foodIngredients?.forEach {
                it.productComp = productDetails.productComposition!!
                foodIngredientRepository.save(it)
            }
            repository.save(product)
            return product
        }
        throw QrCodeUnavailableException("QR code ${productDetails.idQrCode} is already presented in the database")
    }

    private fun qrCodeExists(qrCode: String): Boolean{
        return repository.findProductByIdQrCode(qrCode) != null
    }

}