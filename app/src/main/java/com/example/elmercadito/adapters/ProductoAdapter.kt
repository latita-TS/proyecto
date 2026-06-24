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
import com.example.elmercadito.entity.Producto
import com.google.android.material.button.MaterialButton

class ProductoAdapter(private val lista: List<Producto>) :
    RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProducto: ImageView = itemView.findViewById(R.id.ivProducto)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreProducto)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcionProducto)
        val tvPrecio: TextView = itemView.findViewById(R.id.tvPrecioProducto)
        val btnMas: MaterialButton = itemView.findViewById(R.id.btnMas)
        val btnMenos: MaterialButton = itemView.findViewById(R.id.btnMenos)
        val tvCantidad: TextView = itemView.findViewById(R.id.tvCantidad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = lista[position]
        holder.tvNombre.text = producto.nombre
        holder.tvDescripcion.text = producto.descripcion
        holder.tvPrecio.text = "S/ %.2f".format(producto.precio)
        holder.tvCantidad.text = CarritoManager.obtenerCantidad(producto).toString()

        Glide.with(holder.itemView.context)
            .load(producto.imagen)
            .into(holder.ivProducto)

        holder.btnMas.setOnClickListener {
            CarritoManager.agregarProducto(producto)
            holder.tvCantidad.text = CarritoManager.obtenerCantidad(producto).toString()
        }

        holder.btnMenos.setOnClickListener {
            CarritoManager.eliminarProducto(producto)
            holder.tvCantidad.text = CarritoManager.obtenerCantidad(producto).toString()
        }
    }

    override fun getItemCount(): Int = lista.size
}