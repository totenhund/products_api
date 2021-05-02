package com.example.products_api.models

import javax.persistence.*

@Entity
class FoodAdditive (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    @Column(name = "title")
    var title: String = "default",

    @ManyToOne
    @JoinColumn(name="productCompositionId", referencedColumnName = "id")
    var productComp: ProductComposition? = null
)