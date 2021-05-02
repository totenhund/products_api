package com.example.products_api.models

import com.example.products_api.models.FoodAdditive
import com.example.products_api.models.FoodIngredient
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*


@Entity
@Table(name="product_composition")
class ProductComposition (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    @OneToMany(mappedBy = "productComp")
    @JsonManagedReference
    var foodAdditives: List<FoodAdditive> = emptyList(),

    @OneToMany(mappedBy = "productComp")
    @JsonManagedReference
    var foodIngredients: List<FoodIngredient> = emptyList(),

    @OneToOne(mappedBy = "productComposition")
    var product: Product?

)