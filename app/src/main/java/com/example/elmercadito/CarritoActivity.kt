package com.example.elmercadito

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.elmercadito.adapters.CarritoAdapter
import com.example.elmercadito.entity.Pedido
import com.google.android.material.button.MaterialButton

class CarritoActivity : AppCompatActivity() {

    private lateinit var tvTotal: TextView
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        tvTotal = findViewById(R.id.tvTotal)
        recycler = findViewById(R.id.recyclerCarrito)

        findViewById<ImageView>(R.id.btnVolver).setOnClickListener { finish() }

        cargarCarrito()

        findViewById<MaterialButton>(R.id.btnConfirmar).setOnClickListener {
            val items = CarritoManager.obtenerItems()
            if (items.isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Carrito vacío:c")
                    .setMessage("Agrega productos antes de confirmar")
                    .setPositiveButton("OK", null)
                    .show()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Pedido confirmado")
                    .setMessage("Tu pedido por S/ %.2f ha sido registrado"
                        .format(CarritoManager.obtenerTotal()))
                    .setPositiveButton("OK") { _, _ ->
                        // Guardar en historial
                        val pedido = Pedido(
                            id = HistorialManager.obtenerPedidos().size + 1,
                            fecha = HistorialManager.obtenerFechaActual(),
                            productos = CarritoManager.obtenerItems().toList(),
                            total = CarritoManager.obtenerTotal()
                        )
                        HistorialManager.agregarPedido(pedido)
                        CarritoManager.limpiarCarrito()
                        finish()
                    }
                    .show()
            }
        }
    }

    private fun cargarCarrito() {
        val items = CarritoManager.obtenerItems().toMutableList()
        tvTotal.text = "Total: S/ %.2f".format(CarritoManager.obtenerTotal())

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = CarritoAdapter(items) {
            tvTotal.text = "Total: S/ %.2f".format(CarritoManager.obtenerTotal())
        }
    }
}