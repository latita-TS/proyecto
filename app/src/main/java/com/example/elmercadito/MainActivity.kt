package com.example.elmercadito

import CategoriaAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.elmercadito.adapters.ProductoAdapter
import com.example.elmercadito.entity.Producto
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import android.widget.ImageView
import com.example.elmercadito.entity.Categoria
class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var btnMenu: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        btnMenu = findViewById(R.id.btnMenu)

        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)

        btnMenu.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_inicio -> {
                    drawerLayout.closeDrawer(navigationView)
                }
                R.id.nav_historial -> {
                    drawerLayout.closeDrawer(navigationView)
                    val intent = Intent(this, HistorialActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_perfil -> {
                    drawerLayout.closeDrawer(navigationView)
                    val intent = Intent(this, PerfilActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_carrito -> {
                    drawerLayout.closeDrawer(navigationView)
                    val intent = Intent(this, CarritoActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }

        val categorias = listOf(
            Categoria(1, "Comidas", R.drawable.comida),
            Categoria(2, "Bebidas", R.drawable.bebida),
            Categoria(3, "Cervezas", R.drawable.cerveza),
            Categoria(4, "Alcohol", R.drawable.alcohol),
            Categoria(5, "Antojos", R.drawable.snack),
            Categoria(6, "Promociones", R.drawable.promocion),
            Categoria(7, "Despensa", R.drawable.dispensa),
            Categoria(8, "Helados", R.drawable.helado)
        )

        val recycler = findViewById<RecyclerView>(R.id.recyclerProductos)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = CategoriaAdapter(categorias) { categoria ->
            val intent = Intent(this, ProductosCategoriaActivity::class.java)
            intent.putExtra("categoria", categoria.nombre)
            startActivity(intent)
        }
    }
}