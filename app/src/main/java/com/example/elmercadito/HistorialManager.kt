package com.example.elmercadito

import com.example.elmercadito.entity.Pedido
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object HistorialManager {

    private val pedidos = mutableListOf<Pedido>()

    fun agregarPedido(pedido: Pedido) {
        pedidos.add(pedido)
    }

    fun obtenerPedidos(): List<Pedido> = pedidos

    fun obtenerFechaActual(): String {
        val formato = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        return formato.format(Date())
    }
}