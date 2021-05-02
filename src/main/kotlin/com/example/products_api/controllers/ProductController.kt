package com.example.products_api.controllers

import com.example.products_api.components.ProductAssembler
import com.example.products_api.helpers.ProductVO
import com.example.products_api.models.Product
import com.example.products_api.repositories.ProductRepository
import com.example.products_api.services.ProductServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(val productService: ProductServiceImpl, val productAssembler: ProductAssembler, val productRepository: ProductRepository) {
    @GetMapping
    @RequestMapping("/{qrCode}")
    fun getProduct(@PathVariable("qrCode") qrCode: String): ResponseEntity<ProductVO> {
        val product = productRepository.findProductByIdQrCode(qrCode)
        return ResponseEntity.ok(product?.let { productAssembler.toProductVO(it) })
    }

    @PostMapping
    @RequestMapping("/add_product")
    fun addProduct(@Validated @RequestBody productDetails: Product): ResponseEntity<ProductVO> {
        val product = productService.addProduct(productDetails)
        print(product.idQrCode)
        return ResponseEntity.ok(productAssembler.toProductVO(product))
    }

}