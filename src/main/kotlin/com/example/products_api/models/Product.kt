package com.example.products_api.models

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "product")
//@EntityListeners(ProductListener::class)
class Product(
        @Column(unique = true)
        @Size(min = 2)
        var productName: String = "",
        @Id
        var idQrCode: String = "",
        @OneToOne(optional = false)
        @JoinColumn(name="productComp")
        var productComposition: ProductComposition? = null
)