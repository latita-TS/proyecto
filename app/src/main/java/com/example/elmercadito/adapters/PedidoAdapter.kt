package com.example.elmercadito.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.elmercadito.R
import com.example.elmercadito.entity.Pedido

class PedidoAdapter(private val lista: List<Pedido>) :
    RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder>() {

    class PedidoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNumero: TextView = itemView.findViewById(R.id.tvNumeroPedido)
        val tvTotal: TextView = itemView.findViewById(R.id.tvTotalPedido)
        val tvFecha: TextView = itemView.findViewById(R.id.tvFechaPedido)
        val tvProductos: TextView = itemView.findViewById(R.id.tvProductosPedido)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pedido, parent, false)
        return PedidoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PedidoViewHolder, position: Int) {
        val pedido = lista[position]
        holder.tvNumero.text = "Pedido #%03d".format(pedido.id)
        holder.tvTotal.text = "S/ %.2f".format(pedido.total)
        holder.tvFecha.text = pedido.fecha

        val productosTexto = pedido.productos.joinToString("\n") {
            "• ${it.producto.nombre} x${it.cantidad}"
        }
        holder.tvProductos.text = productosTexto
    }

    override fun getItemCount(): Int = lista.size
}