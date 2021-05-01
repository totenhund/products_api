package com.example.products_api.models

import javax.persistence.*

@Entity
@Table(name = "food_additive")
class FoodAdditive (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    @Column(name = "title", nullable = false)
    var title: String = ""
)