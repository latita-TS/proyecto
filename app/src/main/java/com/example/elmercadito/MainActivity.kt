package com.example.elmercadito

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.elmercadito.adapters.ProductoAdapter
import com.example.elmercadito.entity.Producto

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<Any>()

        items.add("🥤 Bebidas")
        items.add(Producto(1,"Inca Kola 500ml", "Bebidas", "Gaseosa amarilla sabor dulce", 2.50, "https://frankoschicken.pe/wp-content/uploads/2026/03/ICA-KOLA-600ML-1200X1200-1.jpg"))
        items.add(Producto(2,"Coca Cola 500ml", "Bebidas", "Gaseosa clásica refrescante", 2.50, "https://www.papajohns.com.pe/media/catalog/product/1/4/14935.png?optimize=medium&bg-color=255,255,255&fit=bounds&height=700&width=700&canvas=700:700&format=jpeg"))
        items.add(Producto(3,"Agua San Luis 625ml", "Bebidas", "Agua mineral sin gas", 1.50, "https://production-tailoy-repo-magento-statics.s3.amazonaws.com/imagenes/872x872/productos/i/a/g/agua-san-luis-sin-gas-625ml-5024-default-1.jpg"))
        items.add(Producto(4,"Gatorade 500ml", "Bebidas", "Bebida rehidratante de frutas", 3.50, "https://plazavea.vteximg.com.br/arquivos/ids/318889-418-418/bebida-rehidratante-gatorade-tropical-fruit-botella-500ml.jpg"))

        items.add("🍫 Snacks")
        items.add(Producto(5,"Sublime", "Snacks", "Chocolate con mani peruano", 1.50, "https://oechsle.vteximg.com.br/arquivos/ids/14861563-1000-1000/image-005044d8e1da4645b29c394988f69683.jpg?v=638281538576770000"))
        items.add(Producto(6,"Doritos", "Snacks", "Chips de maiz sabor queso", 2.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT09S19IixyokQI7QM0N5s_aBUWQ3Oe-Xygg&s"))
        items.add(Producto(7,"Chisitos", "Snacks", "Palitos de maíz inflado", 1.00, "https://grandcentral.pe/wp-content/uploads/2025/09/GCG028-CHS1.jpg"))
        items.add(Producto(8,"Galletas Oreo", "Snacks", "Galletas de chocolate con crema", 2.00, "https://metroio.vtexassets.com/arquivos/ids/606033/958304-1-88266.jpg?v=638948446381770000"))

        items.add("🥛 Lácteos")
        items.add(Producto(9,"Leche Gloria 1L", "Lácteos", "Leche entera evaporada", 4.50, "https://dojiw2m9tvv09.cloudfront.net/54185/product/20221221167164184412453.jpg"))
        items.add(Producto(10,"Yogurt Gloria 1L", "Lácteos", "Yogurt de fresa azucarado", 2.50, "https://metroio.vtexassets.com/arquivos/ids/598538/Yogurt-Bebible-Gloria-Fresa-Pl-tano-Galonera-1-7kg-1-240906.jpg?v=638896665982000000"))
        items.add(Producto(11,"Mantequilla Laive", "Lácteos", "Mantequilla sin sal cremosa", 4.00, "https://metroio.vtexassets.com/arquivos/ids/607565/455388-01-34907.jpg?v=638938245858570000"))

        items.add("🧹 Limpieza")
        items.add(Producto(12,"Detergente Ariel 500g", "Limpieza", "Detergente en polvo multiusos", 8.00, "https://promart.vteximg.com.br/arquivos/ids/8492285-1000-1000/147711.jpg?v=638700540634530000"))
        items.add(Producto(13,"Lejia Clorox 1L", "Limpieza", "Desinfectante y blanqueador", 4.00, "https://promart.vteximg.com.br/arquivos/ids/8820026/30310.jpg?v=638822446292900000"))
        items.add(Producto(14,"Jabon Bolívar", "Limpieza", "Jabon de lavar ropa azul", 2.50, "https://corporacionliderperu.com/51237-large_default/bolivar-jabon-vida-x-190-gr-cuidado-total.jpg"))

        val recycler = findViewById<RecyclerView>(R.id.recyclerProductos)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = ProductoAdapter(items)
    }
}