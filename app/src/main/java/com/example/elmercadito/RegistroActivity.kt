package com.example.elmercadito

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class RegistroActivity : AppCompatActivity() {

    private lateinit var tietNombre: TextInputEditText
    private lateinit var tietCorreo: TextInputEditText
    private lateinit var tietTelefono: TextInputEditText
    private lateinit var tietPassword: TextInputEditText
    private lateinit var btnRegistrar: MaterialButton
    private lateinit var tvVolver: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        tietNombre = findViewById(R.id.tietNombre)
        tietCorreo = findViewById(R.id.tietCorreo)
        tietTelefono = findViewById(R.id.tietTelefono)
        tietPassword = findViewById(R.id.tietPassword)
        btnRegistrar = findViewById(R.id.btnRegistrar)
        tvVolver = findViewById(R.id.tvVolver)

        btnRegistrar.setOnClickListener {
            val nombre = tietNombre.text.toString().trim()
            val correo = tietCorreo.text.toString().trim()
            val telefono = tietTelefono.text.toString().trim()
            val password = tietPassword.text.toString().trim()

            if (nombre.isEmpty() || correo.isEmpty() ||
                telefono.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos porfavor", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ya creaste tu cuenta", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        tvVolver.setOnClickListener {
            finish()
        }
    }
}