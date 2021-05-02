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

    @OneToOne(mappedBy = "productComposition")
    var product: Product? = null
){
    @OneToMany(
            mappedBy = "productComp",
            targetEntity = FoodAdditive::class
    )
    lateinit var foodAdditives: MutableList<FoodAdditive>

    @OneToMany(
            mappedBy = "productComp",
            targetEntity = FoodIngredient::class
    )
    lateinit var foodIngredients: MutableList<FoodIngredient>

}