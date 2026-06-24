package com.example.elmercadito

import android.content.Intent
import android.os.Bundle
<<<<<<< HEAD
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.example.elmercadito.database.UsuarioDAO
import com.example.elmercadito.entity.Usuario

class RegistroActivity : AppCompatActivity() {

    private lateinit var tietDni: TextInputEditText
    private lateinit var tietApellidoPaterno: TextInputEditText
    private lateinit var tietApellidoMaterno: TextInputEditText
    private lateinit var tietNombres: TextInputEditText
    private lateinit var tietCelular: TextInputEditText
    private lateinit var rgSexo: RadioGroup
    private lateinit var tietCorreo: TextInputEditText
    private lateinit var tietPassword: TextInputEditText
    private lateinit var cbTerminos: CheckBox
    private lateinit var btnGuardar: MaterialButton
=======
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
>>>>>>> 6eb8369d0693609b50a623a290496b52ea58ba23
    private lateinit var tvVolver: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

<<<<<<< HEAD
        tietDni = findViewById(R.id.tietDni)
        tietApellidoPaterno = findViewById(R.id.tietApellidoPaterno)
        tietApellidoMaterno = findViewById(R.id.tietApellidoMaterno)
        tietNombres = findViewById(R.id.tietNombres)
        tietCelular = findViewById(R.id.tietCelular)
        rgSexo = findViewById(R.id.rgSexo)
        tietCorreo = findViewById(R.id.tietCorreo)
        tietPassword = findViewById(R.id.tietPassword)
        cbTerminos = findViewById(R.id.cbTerminos)
        btnGuardar = findViewById(R.id.btnGuardar)
        tvVolver = findViewById(R.id.tvVolver)

        btnGuardar.setOnClickListener {
            val dni = tietDni.text.toString().trim()
            val apPaterno = tietApellidoPaterno.text.toString().trim()
            val apMaterno = tietApellidoMaterno.text.toString().trim()
            val nombres = tietNombres.text.toString().trim()
            val celular = tietCelular.text.toString().trim()
            val correo = tietCorreo.text.toString().trim()
            val password = tietPassword.text.toString().trim()

            if (dni.isEmpty() || apPaterno.isEmpty() || apMaterno.isEmpty() ||
                nombres.isEmpty() || celular.isEmpty() || correo.isEmpty() ||
                password.isEmpty()) {
                mostrarAlerta("Completa todos los campos")
                return@setOnClickListener
            }

            if (dni.length != 8) {
                mostrarAlerta("El DNI debe tener 8 dígitos")
                return@setOnClickListener
            }

            if (celular.length != 9) {
                mostrarAlerta("El celular debe tener 9 dígitos")
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                mostrarAlerta("El correo no es válido")
                return@setOnClickListener
            }

            if (!cbTerminos.isChecked) {
                mostrarAlerta("Debes aceptar los términos y condiciones")
                return@setOnClickListener
            }

            val sexo = when (rgSexo.checkedRadioButtonId) {
                R.id.rbMasculino -> "Masculino"
                R.id.rbFemenino -> "Femenino"
                else -> "Prefiero no decirlo"
            }

            val usuario = Usuario(
                dni = dni,
                nombres = nombres,
                apellidoPaterno = apPaterno,
                apellidoMaterno = apMaterno,
                celular = celular,
                sexo = sexo,
                correo = correo,
                password = password
            )

            val dao = UsuarioDAO(this)
            val exito = dao.registrarUsuario(usuario)

            if (exito) {
                mostrarAlerta("Completado, Ya puedes iniciar sesión")
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                mostrarAlerta("Este correo ya está registrado")
=======
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
>>>>>>> 6eb8369d0693609b50a623a290496b52ea58ba23
            }
        }

        tvVolver.setOnClickListener {
            finish()
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