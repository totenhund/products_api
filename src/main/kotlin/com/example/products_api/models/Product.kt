package com.example.products_api.models

import javax.persistence.*
import javax.validation.constraints.Size

@Entity()
@Table(name = "product")
//@EntityListeners(ProductListener::class)
class Product(
        @Column(unique = true)
        @Size(min = 2)
        var productName: String = "",
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        @OneToOne(optional = false, cascade = [(CascadeType.ALL)])
        @JoinColumn(name="product_composition_id")
        var productComposition: ProductComposition
)