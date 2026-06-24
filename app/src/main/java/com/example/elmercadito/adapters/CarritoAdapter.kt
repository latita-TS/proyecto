package com.example.elmercadito.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.elmercadito.CarritoManager
import com.example.elmercadito.R
import com.example.elmercadito.entity.CarritoItem
import com.google.android.material.button.MaterialButton

class CarritoAdapter(
    private val lista: MutableList<CarritoItem>,
    private val onCantidadCambiada: () -> Unit
) : RecyclerView.Adapter<CarritoAdapter.CarritoViewHolder>() {

    class CarritoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProducto: ImageView = itemView.findViewById(R.id.ivProducto)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreProducto)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcionProducto)
        val tvPrecio: TextView = itemView.findViewById(R.id.tvPrecioProducto)
        val btnMas: MaterialButton = itemView.findViewById(R.id.btnMas)
        val btnMenos: MaterialButton = itemView.findViewById(R.id.btnMenos)
        val tvCantidad: TextView = itemView.findViewById(R.id.tvCantidad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return CarritoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarritoViewHolder, position: Int) {
        val item = lista[position]
        holder.tvNombre.text = item.producto.nombre
        holder.tvDescripcion.text = item.producto.descripcion
        holder.tvPrecio.text = "S/ %.2f".format(item.producto.precio)
        holder.tvCantidad.text = item.cantidad.toString()

        Glide.with(holder.itemView.context)
            .load(item.producto.imagen)
            .into(holder.ivProducto)

        holder.btnMas.setOnClickListener {
            CarritoManager.agregarProducto(item.producto)
            item.cantidad = CarritoManager.obtenerCantidad(item.producto)
            holder.tvCantidad.text = item.cantidad.toString()
            onCantidadCambiada()
        }

        holder.btnMenos.setOnClickListener {
            if (item.cantidad > 1) {
                CarritoManager.eliminarProducto(item.producto)
                item.cantidad = CarritoManager.obtenerCantidad(item.producto)
                holder.tvCantidad.text = item.cantidad.toString()
            } else {
                CarritoManager.eliminarProducto(item.producto)
                lista.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, lista.size)
            }
            onCantidadCambiada()
        }
    }

    override fun getItemCount(): Int = lista.size
}