package com.example.elmercadito.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.elmercadito.R
import com.example.elmercadito.entity.Producto

class ProductoAdapter(private val items: List<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TIPO_CATEGORIA = 0
        const val TIPO_PRODUCTO = 1
    }

    // ViewHolder para el encabezado de categoría
    class CategoriaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCategoria: TextView = itemView.findViewById(R.id.tvCategoria)
    }

    // ViewHolder para el producto
    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProducto: ImageView = itemView.findViewById(R.id.ivProducto)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreProducto)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcionProducto)
        val tvPrecio: TextView = itemView.findViewById(R.id.tvPrecioProducto)
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is String) TIPO_CATEGORIA else TIPO_PRODUCTO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TIPO_CATEGORIA) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_categoria, parent, false)
            CategoriaViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_producto, parent, false)
            ProductoViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CategoriaViewHolder) {
            holder.tvCategoria.text = items[position] as String
        } else if (holder is ProductoViewHolder) {
            val producto = items[position] as Producto
            holder.tvNombre.text = producto.nombre
            holder.tvDescripcion.text = producto.descripcion
            holder.tvPrecio.text = "S/ %.2f".format(producto.precio)
            Glide.with(holder.itemView.context)
                .load(producto.imagen)
                .into(holder.ivProducto)
        }
    }

    override fun getItemCount(): Int = items.size
}