package com.example.products_api.services

import com.example.products_api.exceptions.QrCodeUnavailableException
import com.example.products_api.models.Product
import com.example.products_api.repositories.ProductRepository
import org.springframework.stereotype.Service
import kotlin.jvm.Throws

@Service
class ProductServiceImpl(val repository: ProductRepository) : ProductService {
    @Throws(QrCodeUnavailableException::class)
    override fun addProduct(productDetails: Product): Product {
        if(!qrCodeExists(productDetails.idQrCode)){
            val product = Product(
                    productDetails.productName,
                    productDetails.idQrCode,
                    productComposition = productDetails.productComposition
            )
            repository.save(product)
            return product
        }
        throw QrCodeUnavailableException("QR code ${productDetails.idQrCode} is already presented in the database")
    }

    private fun qrCodeExists(qrCode: String): Boolean{
        return repository.findProductByIdQrCode(qrCode) != null
    }

}