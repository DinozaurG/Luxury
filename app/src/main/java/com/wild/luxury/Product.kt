package com.wild.luxury

import java.io.Serializable

data class Room(
    val name: String,
    val productList: List<Product>
)
data class Product (
    val name: String,
    val price: Int,
    var count: Int,
    val description: String
) : Serializable