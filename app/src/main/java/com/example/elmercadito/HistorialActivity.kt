package com.example.elmercadito

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.elmercadito.adapters.PedidoAdapter

class HistorialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        findViewById<ImageView>(R.id.btnVolver).setOnClickListener { finish() }

        val pedidos = HistorialManager.obtenerPedidos()
        val recycler = findViewById<RecyclerView>(R.id.recyclerHistorial)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = PedidoAdapter(pedidos)
    }
}