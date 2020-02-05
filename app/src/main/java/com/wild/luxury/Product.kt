package com.wild.luxury

data class Room(
    val name: String,
    val productList: List<Product>
)
data class Product (
    val name: String,
    val price: Int,
    val count: Int
)