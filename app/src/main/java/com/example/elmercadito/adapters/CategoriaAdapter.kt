import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.elmercadito.R
import com.example.elmercadito.entity.Categoria

class CategoriaAdapter(
    private val lista: List<Categoria>,
    private val onItemClick: (Categoria) -> Unit
) : RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder>() {

    class CategoriaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivCategoria: ImageView = itemView.findViewById(R.id.ivCategoria)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreCategoria)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_categoria_principal, parent, false)
        return CategoriaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        val categoria = lista[position]
        holder.ivCategoria.setImageResource(categoria.imagen)
        holder.tvNombre.text = categoria.nombre
        holder.itemView.setOnClickListener {
            onItemClick(categoria)
        }
    }

    override fun getItemCount(): Int = lista.size
}