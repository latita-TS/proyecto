package com.example.elmercadito

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

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
            val usuario = tietUsuario.text.toString().trim()
            val password = tietPassword.text.toString().trim()

            if (usuario.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos porfavor", Toast.LENGTH_SHORT).show()
            } else if (usuario == "grupo2" && password == "123456") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        tvRegistrarse.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }
}