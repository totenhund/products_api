package com.example.products_api.models

import javax.persistence.*

@Entity
@Table(name = "food_ingredient")
class FoodIngredient (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    @Column(name = "title")
    var title: String = "",

    @ManyToOne()
    @JoinColumn(name="product_composition_id")
    var productComp: ProductComposition?
)