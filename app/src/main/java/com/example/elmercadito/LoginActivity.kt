package com.example.elmercadito

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.example.elmercadito.database.UsuarioDAO
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity() {

    private lateinit var tietUsuario: TextInputEditText
    private lateinit var tietPassword: TextInputEditText
    private lateinit var btnIngresar: MaterialButton
    private lateinit var tvRegistrarse: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tietUsuario = findViewById(R.id.tietUsuario)
        tietPassword = findViewById(R.id.tietPassword)
        btnIngresar = findViewById(R.id.btnIngresar)
        tvRegistrarse = findViewById(R.id.tvRegistrarse)

        btnIngresar.setOnClickListener {
            val correo = tietUsuario.text.toString().trim()
            val password = tietPassword.text.toString().trim()

            if (correo.isEmpty() || password.isEmpty()) {
                mostrarAlerta("Completa todos los campos")
                return@setOnClickListener
            }

            val dao = UsuarioDAO(this)
            val usuario = dao.loginUsuario(correo, password)

            if (usuario != null) {
                SesionManager.usuarioActual = usuario
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                mostrarAlerta("Correo o contraseña incorrectos")
            }
        }

        tvRegistrarse.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }
    private fun mostrarAlerta(mensaje: String) {
        AlertDialog.Builder(this)
            .setTitle("Aviso")
            .setMessage(mensaje)
            .setPositiveButton("OK", null)
            .show()
    }
}