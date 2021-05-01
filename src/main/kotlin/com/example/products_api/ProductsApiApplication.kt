package com.example.products_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductsApiApplication

fun main(args: Array<String>) {
    runApplication<ProductsApiApplication>(*args)
}
