package com.example.elmercadito

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        findViewById<ImageView>(R.id.btnVolver).setOnClickListener { finish() }

        val usuario = SesionManager.usuarioActual

        if (usuario != null) {
            findViewById<TextView>(R.id.tvNombrePerfil).text =
                "${usuario.nombres} ${usuario.apellidoPaterno}"
            findViewById<TextView>(R.id.tvCorreoPerfil).text = usuario.correo
            findViewById<TextView>(R.id.tvDni).text = usuario.dni
            findViewById<TextView>(R.id.tvCelular).text = usuario.celular
            findViewById<TextView>(R.id.tvSexo).text = usuario.sexo
        }

        findViewById<MaterialButton>(R.id.btnCerrarSesion).setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Cerrar sesión")
                .setMessage("¿Estás seguro que quieres cerrar sesión?")
                .setPositiveButton("Sí") { _, _ ->
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                .setNegativeButton("No", null)
                .show()
        }
    }
}