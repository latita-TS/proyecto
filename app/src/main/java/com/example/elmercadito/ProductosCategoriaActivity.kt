package com.example.elmercadito

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.elmercadito.adapters.ProductoAdapter
import com.example.elmercadito.entity.Producto

class ProductosCategoriaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos_categoria)

        val categoria = intent.getStringExtra("categoria") ?: ""

        val tvTitulo = findViewById<TextView>(R.id.tvTituloCategoria)
        val btnVolver = findViewById<ImageView>(R.id.btnVolver)
        val recycler = findViewById<RecyclerView>(R.id.recyclerProductosCategoria)

        tvTitulo.text = categoria

        btnVolver.setOnClickListener { finish() }

        val todosLosProductos = obtenerProductos()
        val productosFiltrados = todosLosProductos.filter {
            it.categoria == categoria
        }

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = ProductoAdapter(productosFiltrados.map { it })
    }

    private fun obtenerProductos(): List<Producto> {
        return listOf(

            Producto(1, "Inca Kola 500ml", "Bebidas", "Gaseosa amarilla sabor dulce", 2.50, "https://frankoschicken.pe/wp-content/uploads/2026/03/ICA-KOLA-600ML-1200X1200-1.jpg"),
            Producto(2, "Inca Kola Zero 500ml", "Bebidas", "Gaseosa amarilla sin azúcar", 2.50, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5_klyQURIsoeSaOif0BZ5zz-Zemxx6l-Y6y2TlLbuv-HaMDVseLisygo&s=10"),
            Producto(3, "Coca Cola 500ml", "Bebidas", "Gaseosa negra sabor dulce", 2.50, "https://www.bembos.com.pe/media/catalog/product/2/1/2146469602_1.png?optimize=medium&bg-color=255,255,255&fit=bounds&height=700&width=700&canvas=700:700&format=jpeg"),
            Producto(4, "Coca Cola Zero 500ml", "Bebidas", "Gaseosa negra sin azúcar", 2.50, "https://media.falabella.com/tottusPE/43602768_1/w=1500,h=1500,fit=cover"),
            Producto(5, "Pepsi 450ml", "Bebidas", "Gaseosa negra sabor suave", 2.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7CTMDXmUlYJ-Gx3a6GTuJro0VeJ45-dgb_4-J57fYCz_qPiksjCtt-RM&s=10"),
            Producto(6, "Seven Up 355ml", "Bebidas", "Gaseosa de limón refrescante", 2.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-DiaRYSlO_HzJzYogUYY2ee7UVWmyWwm6Q3odYUXnqA&s=10"),
            Producto(7, "Te Lipton Limon 500ml", "Bebidas", "Té helado sabor limón", 3.00, "https://metroio.vtexassets.com/arquivos/ids/569401/BEBIDA-TE-LIPTON-BOT-500ML-LIM-N-1-288683.jpg?v=638736940971200000"),
            Producto(8, "Agua San Luis 625ml", "Bebidas", "Agua mineral sin gas", 2.50, "https://wongfood.vtexassets.com/arquivos/ids/724514-800-auto?v=638621051103830000&width=800&height=auto&aspect=true"),
            Producto(9, "Concordia Piña 355ml", "Bebidas", "Gaseosa sabor piña tropical", 2.00, "https://plazavea.vteximg.com.br/arquivos/ids/33481444-450-450/20033047.jpg?v=639041738854970000"),
            Producto(10, "Guarana 300ml", "Bebidas", "Bebida energizante sabor frutal", 2.00, "https://oechsle.vteximg.com.br/arquivos/ids/1352264-1000-1000/image-15df53afe6ae44f897c5cfa9dde9a749.jpg?v=637494732141030000"),

            Producto(11, "Cristal 650ml", "Cervezas", "Cerveza rubia peruana", 7.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCopiJ47KRAkLbStdLeDiSf4ObeBXEvLDQr0DcBqJSdNRkoNCufYvwL4UQ&s=10"),
            Producto(12, "Pilsen 650ml", "Cervezas", "Cerveza clásica peruana", 7.50, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9NcW-Xe79IvHe6XRiYhWn1QGdEnpqzB3DPqUUU-cbVj1MyJbtrfai6wQ&s=10"),
            Producto(13, "Cusqueña 650ml", "Cervezas", "Cerveza premium peruana", 8.50, "https://sumon.com.pe/wp-content/uploads/2024/10/cerveza-cusquena-trigo-botella-310ml.webp"),
            Producto(14, "Tres Cruces 470ml", "Cervezas", "Cerveza rubia ligera y fresca", 7.50, "https://aceleralastatic.nyc3.cdn.digitaloceanspaces.com/files/uploads/1499/1672330938-77-tres-cruces-cerveza-473ml-jpg.jpg"),
            Producto(15, "Heineken 470ml", "Cervezas", "Cerveza holandesa sabor suave", 8.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcfPk3DyM92SLiJK1bM_VfVG1uhl3XIF7SL0sbL2lKWw&s=10"),
            Producto(16, "Coronita 300ml", "Cervezas", "Cerveza mexicana ligera y fría", 6.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFIKslO04QCKZp7VkLH_qIYiKdN2zbB6ng6MJWv-IirP7aJD2zed7mDZ7y&s=10"),
            Producto(17, "Stella Artois 330ml", "Cervezas", "Cerveza belga de carácter fuerte", 9.00, "https://tatami.com.pe/192-large_default/stella-artois.jpg"),

            Producto(18, "Smirnoff 350ml", "Alcohol", "Vodka triple destilado sabor neutro", 8.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKb_DTFYgaV4fv05GsRITjkofgJedy8RkZO3YM11-MCVGKVeoZq6cWf-7H&s=10"),
            Producto(19, "Chilcano Limon 355ml", "Alcohol", "Bebida de pisco con limón lista", 8.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_gsFe6KxVf2g_j7-ov8XkUAoenu1raDRFI1v4oYXtHffngqG1LVdkGp8&s=10"),
            Producto(20, "Mikes Limon 355ml", "Alcohol", "Bebida alcohólica sabor limón", 9.50, "https://metroio.vtexassets.com/arquivos/ids/540926-800-auto?v=638597937757000000&width=800&height=auto&aspect=true"),
            Producto(21, "Mikes Maracuya 355ml", "Alcohol", "Bebida alcohólica sabor maracuyá", 9.50, "https://wongfood.vtexassets.com/arquivos/ids/560571-800-auto?v=637928129456800000&width=800&height=auto&aspect=true"),
            Producto(22, "Four loko 600ml", "Alcohol", "Bebida alcohólica energizante", 12.00, "https://wongfood.vtexassets.com/arquivos/ids/617593-800-auto?v=638126198488870000&width=800&height=auto&aspect=true"),
            Producto(23, "Piscano Limon 300ml", "Alcohol", "Bebida de pisco sabor limón", 7.00, "https://www.happydrinkdelivery.com/wp-content/uploads/2022/04/PISCANO-PERSONAL-LIMON-275ML-POKL001.jpg"),

            Producto(24, "Sublime 38g", "Antojos", "Chocolate con maní peruano", 1.50, "https://oechsle.vteximg.com.br/arquivos/ids/14861563-1000-1000/image-005044d8e1da4645b29c394988f69683.jpg"),
            Producto(25, "Doritos 40g", "Antojos", "Chips de maíz sabor queso", 2.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT09S19IixyokQI7QM0N5s_aBUWQ3Oe-Xygg&s"),
            Producto(26, "Chizitos 30g", "Antojos", "Palitos de maíz inflado", 1.00, "https://grandcentral.pe/wp-content/uploads/2025/09/GCG028-CHS1.jpg"),
            Producto(27, "Galletas Oreo 36g", "Antojos", "Galletas de chocolate con crema", 2.00, "https://metroio.vtexassets.com/arquivos/ids/606033/958304-1-88266.jpg"),
            Producto(28, "Morochas 60g", "Antojos", "Galletas bañadas en chocolate", 2.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmDPpIKL9AE834xrarzBl0YYlUXm1AwQSbmE_6_da3Xw&s=10"),
            Producto(29, "Princesa 38g", "Antojos", "Chocolate con leche y barquillo", 1.50, "https://wongfood.vtexassets.com/arquivos/ids/454530-800-auto?v=637616967702600000&width=800&height=auto&aspect=true"),
            Producto(30, "Kit Kat 40g", "Antojos", "Wafer cubierto de chocolate", 3.00, "https://plazavea.vteximg.com.br/arquivos/ids/2188047-450-450/20058944.jpg?v=637635920120100000"),
            Producto(31, "Triangulo 30g", "Antojos", "Barra de chocolate delgada", 2.00, "https://tiendanestle.pe/cdn/shop/files/12606836.jpg?v=1729082747"),
            Producto(32, "Inka Chips 135g", "Antojos", "Papas fritas sabor peruano", 3.00, "https://wongfood.vtexassets.com/arquivos/ids/651593-800-auto?v=638279878395770000&width=800&height=auto&aspect=true"),
            Producto(33, "Papas Pringles 110g", "Antojos", "Papas fritas en tubo saladas", 6.00, "https://wongfood.vtexassets.com/arquivos/ids/768962-800-auto?v=638826682123300000&width=800&height=auto&aspect=true"),

            Producto(34, "Leche Gloria 1L", "Despensa", "Leche entera evaporada", 4.50, "https://dojiw2m9tvv09.cloudfront.net/54185/product/20221221167164184412453.jpg"),
            Producto(35, "Arroz Costeño 1kg", "Despensa", "Arroz extra calidad", 4.00, "https://plazavea.vteximg.com.br/arquivos/ids/27552446-450-450/433778.jpg?v=638313120991600000"),
            Producto(36, "Aceite Primor 1L", "Despensa", "Aceite vegetal de girasol", 9.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKeXHrMp5ipmV72GynqA6mORedWmOxewwfQdpZ7mZ6hg&s=10"),
            Producto(37, "Mayonesa a la cena 190g", "Despensa", "Mayonesa cremosa sabor suave", 4.50, "https://media.falabella.com/tottusPE/43554995_1/w=1004,h=1500,fit=pad"),
            Producto(38, "Trozos de atun 150g", "Despensa", "Atún en agua lista para servir", 7.00, "https://media.falabella.com/tottusPE/42951131_1/w=1500,h=1500,fit=cover"),
            Producto(39, "Huevos Pardo 1Kg", "Despensa", "Huevos frescos de gallina", 6.00, "https://plazavea.vteximg.com.br/arquivos/ids/29456273-450-450/20111045.jpg?v=638618112198870000"),
            Producto(40, "Pan Blanco Bimbo 420g", "Despensa", "Pan blanco suave y esponjoso", 8.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAhs5Kto9zMupycw9i78-0d6WaVk69c7PMyDIF-IXnfw&s=10"),
            Producto(41, "Fideos Don Vittorio 500g", "Despensa", "Fideos de trigo sabor casero", 5.50, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBa9AFIaeU_hFJ9R1kE7YXVFYaH9MyuDK9Kz_51a1aKA&s=10"),

            Producto(42, "Donofrio Paleta", "Helados", "Paleta de chocolate", 2.50, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSV5ojNwTzu_YcSkVpEwkBTs2OWEbwsnPRl5vGP_KLZKQ&s=10"),
            Producto(43, "Helado Tentación", "Helados", "Helado de lúcuma", 3.50, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKrZgFOqerjYch-JHPxDonMdNQAb2KGlzv4QYwHUFC4w&s=10"),
            Producto(44, "Donofrio Peziduri", "Helados", "Helado de vainilla con cobertura", 11.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2lb9oOiqYrGTAMTyBPD5rD7rf7GrQ6nUI-tYYuvNuww&s=10"),
            Producto(45, "Bombones", "Helados", "Helado bañado en chocolate", 3.50, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSn8CfnCfR7Ueq6mmSpQKGl4tv9UieyL46KrR9frO_1eg&s=10"),
            Producto(46, "Frio Rico", "Helados", "Barquillo lleno de mani con helado de vainilla", 4.50, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCbCkIwusnbk6Kv4bnDdWweYpkxgK9ZZXtOf9kgQGyKt1tcI-s4Pjk1QU&s=10"),
            Producto(47, "Sublime Lucuma", "Helados", "Helado de lúcuma con chocolate", 2.50, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSx7rztp-KeqlJfhhD1YQk9Nh6V42wMWpTKxmwo7IEr1g&s=10"),
            Producto(48, "Alaska Camu Camu", "Helados", "Helado de camu camu ácido frutal", 2.50, "https://media.falabella.com/tottusPE/43471831_1/w=1004,h=1500,fit=pad"),
            Producto(49, "Sandwich vainilla", "Helados", "Helado de vainilla entre galletas", 2.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSj2Nn99-wZ2DanUnpGElPKavGgeeiSEnE9EkWAx-OSNA&s"),

            Producto(50, "Hamburguesa", "Comidas", "Hamburguesa de carne jugosa", 6.50, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT08WHJvZuEkMrTmEDZ61xAIF4q5MVdkiWaop8wPGRRIg&s=10"),
            Producto(51, "Pizza Americana", "Comidas", "Pizza con jamón y queso", 9.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_q-53C6SgqyFp4rIeWXxbGIkE5qK-0SWQ8ko5DpWJEw&s=10"),
            Producto(52, "Pizza Hawaiana", "Comidas", "Pizza con jamón y piña tropical", 11.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbqvfqV-WD_XCriEmtTZefyiLMf7ZbpY3S06QHJQuBUg&s=10"),
            Producto(53, "Pizza Peperoni", "Comidas", "Pizza con pepperoni y queso", 10.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTN9l28yWZMsuQerbKgHi8RZyeLR0DfRh3xhUQEsaSj3w&s=10"),
            Producto(54, "Enrollado de pollo", "Comidas", "Enrollado relleno de pollo", 6.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqOog6V9aAfc4sJOSCalqr9RV_1e4l-O6RtK0MekUmITTpOUy_KJOqdFU&s=10"),
            Producto(55, "Empanada de Carne", "Comidas", "Empanada horneada rellena de carne", 5.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZetSvV38BHziPJP8hszMwTCG_X9tIJsBC23VFXBKL6g&s=10"),
            Producto(56, "Empanada de Pollo", "Comidas", "Empanada horneada rellena de pollo", 5.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQSiR0CSGf-ubcwBeR3eQLJDASplvQfsXIBqz2LEHI6nw&s=10"),

            Producto(57, "Pack Inca Kola x6", "Promociones", "6 botellas de Inca Kola 500ml", 12.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRruG4RgAZyehs_EHHFfY0RbDMGTWn6yTjjJLGA85ZkLA&s=10"),
            Producto(58, "Pack Agua x6", "Promociones", "6 botellas de agua San Luis", 12.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyIxPNoUFfTPEqugPHajF-579kdB9qzq2vjipQ3ivTBw&s=10"),
            Producto(59, "Hamburguesa + Coca Cola 500ml", "Promociones", "Combo hamburguesa con gaseosa", 8.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQOTHUvu2hgCuKOiOylcKm8C-FRZP1StgMV2Tgx3rdXUQ&s=10"),
            Producto(60, "Empanada de pollo x3", "Promociones", "3 empanadas de pollo al horno", 11.00, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTH8sVDEFVX0q6Hy7dTFIDIWEb9M2A3gAQjbsFaT1j6MQ&s=10")
        )
    }
}
