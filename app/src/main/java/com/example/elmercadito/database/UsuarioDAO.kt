package com.example.elmercadito.database

import android.content.ContentValues
import android.content.Context
import com.example.elmercadito.entity.Usuario

class UsuarioDAO(context: Context) {

    private val dbHelper = DatabaseHelper(context)

    fun registrarUsuario(usuario: Usuario): Boolean {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COL_DNI, usuario.dni)
            put(DatabaseHelper.COL_NOMBRE, usuario.nombres)
            put(DatabaseHelper.COL_AP_PATERNO, usuario.apellidoPaterno)
            put(DatabaseHelper.COL_AP_MATERNO, usuario.apellidoMaterno)
            put(DatabaseHelper.COL_CELULAR, usuario.celular)
            put(DatabaseHelper.COL_SEXO, usuario.sexo)
            put(DatabaseHelper.COL_CORREO, usuario.correo)
            put(DatabaseHelper.COL_PASSWORD, usuario.password)
        }
        val resultado = db.insert(DatabaseHelper.TABLE_USUARIOS, null, values)
        db.close()
        return resultado != -1L
    }

    fun loginUsuario(correo: String, password: String): Usuario? {
        val db = dbHelper.readableDatabase
        val cursor = db.query(
            DatabaseHelper.TABLE_USUARIOS,
            null,
            "${DatabaseHelper.COL_CORREO} = ? AND ${DatabaseHelper.COL_PASSWORD} = ?",
            arrayOf(correo, password),
            null, null, null
        )

        var usuario: Usuario? = null
        if (cursor.moveToFirst()) {
            usuario = Usuario(
                id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ID)),
                dni = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_DNI)),
                nombres = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_NOMBRE)),
                apellidoPaterno = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_AP_PATERNO)),
                apellidoMaterno = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_AP_MATERNO)),
                celular = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_CELULAR)),
                sexo = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_SEXO)),
                correo = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_CORREO)),
                password = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_PASSWORD))
            )
        }
        cursor.close()
        db.close()
        return usuario
    }
}