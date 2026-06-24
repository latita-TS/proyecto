package com.example.elmercadito

import com.example.elmercadito.entity.CarritoItem
import com.example.elmercadito.entity.Producto

object CarritoManager {

    private val items = mutableListOf<CarritoItem>()

    fun agregarProducto(producto: Producto) {
        val item = items.find { it.producto.id == producto.id }
        if (item != null) {
            item.cantidad++
        } else {
            items.add(CarritoItem(producto, 1))
        }
    }

    fun eliminarProducto(producto: Producto) {
        val item = items.find { it.producto.id == producto.id }
        if (item != null) {
            if (item.cantidad > 1) {
                item.cantidad--
            } else {
                items.remove(item)
            }
        }
    }

    fun obtenerItems(): List<CarritoItem> = items

    fun obtenerTotal(): Double = items.sumOf { it.producto.precio * it.cantidad }

    fun obtenerCantidad(producto: Producto): Int {
        return items.find { it.producto.id == producto.id }?.cantidad ?: 0
    }

    fun limpiarCarrito() = items.clear()
}