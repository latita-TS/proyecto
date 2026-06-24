package com.example.elmercadito.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
<<<<<<< HEAD
import com.example.elmercadito.CarritoManager
import com.example.elmercadito.R
import com.example.elmercadito.entity.Producto
import com.google.android.material.button.MaterialButton

class ProductoAdapter(private val lista: List<Producto>) :
    RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

=======
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
>>>>>>> 6eb8369d0693609b50a623a290496b52ea58ba23
    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProducto: ImageView = itemView.findViewById(R.id.ivProducto)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreProducto)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcionProducto)
        val tvPrecio: TextView = itemView.findViewById(R.id.tvPrecioProducto)
<<<<<<< HEAD
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
=======
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
>>>>>>> 6eb8369d0693609b50a623a290496b52ea58ba23
}