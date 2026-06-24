package com.example.elmercadito.entity

data class Pedido(
    val id: Int,
    val fecha: String,
    val productos: List<CarritoItem>,
    val total: Double
)