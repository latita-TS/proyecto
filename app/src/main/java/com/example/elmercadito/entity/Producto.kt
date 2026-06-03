package com.example.elmercadito.entity

data class Producto(
    val id: Int,
    val nombre: String,
    val categoria: String,
    val descripcion: String,
    val precio: Double,
    val imagen: String
)