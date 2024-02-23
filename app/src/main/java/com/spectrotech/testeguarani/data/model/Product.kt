package com.spectrotech.testeguarani.data.model

data class Product(
    val id: Long,
    val status: String,
    val descricao: String,
    val estoque: Long,
    val maxPrice: Float,
    val minPrice: Float
)
