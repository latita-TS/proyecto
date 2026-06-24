package com.example.elmercadito.entity

data class Usuario(
    val id: Int = 0,
    val dni: String,
    val nombres: String,
    val apellidoPaterno: String,
    val apellidoMaterno: String,
    val celular: String,
    val sexo: String,
    val correo: String,
    val password: String
)