package com.spectrotech.testeguarani.data.model

import androidx.room.Entity

@Entity(tableName = "GUA_PRODUTOS")
data class Product(
    val id: Long,
    val status: String,
    val descricao: String,
    val estoque: Long,
    val maxPrice: Float,
    val minPrice: Float
)
