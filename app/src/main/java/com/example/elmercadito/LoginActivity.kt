package com.example.elmercadito

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
<<<<<<< HEAD
import com.example.elmercadito.database.UsuarioDAO
import androidx.appcompat.app.AlertDialog
=======
>>>>>>> 6eb8369d0693609b50a623a290496b52ea58ba23

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
<<<<<<< HEAD
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
=======
            val usuario = tietUsuario.text.toString().trim()
            val password = tietPassword.text.toString().trim()

            if (usuario.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos porfavor", Toast.LENGTH_SHORT).show()
            } else if (usuario == "grupo2" && password == "123456") {
>>>>>>> 6eb8369d0693609b50a623a290496b52ea58ba23
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
<<<<<<< HEAD
                mostrarAlerta("Correo o contraseña incorrectos")
=======
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
>>>>>>> 6eb8369d0693609b50a623a290496b52ea58ba23
            }
        }

        tvRegistrarse.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }
<<<<<<< HEAD
    private fun mostrarAlerta(mensaje: String) {
        AlertDialog.Builder(this)
            .setTitle("Aviso")
            .setMessage(mensaje)
            .setPositiveButton("OK", null)
            .show()
    }
=======
>>>>>>> 6eb8369d0693609b50a623a290496b52ea58ba23
}