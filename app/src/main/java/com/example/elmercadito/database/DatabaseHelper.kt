package com.example.elmercadito.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "mercaditobamba.db"
        const val DATABASE_VERSION = 1
        const val TABLE_USUARIOS = "usuarios"
        const val COL_ID = "id"
        const val COL_DNI = "dni"
        const val COL_NOMBRE = "nombres"
        const val COL_AP_PATERNO = "apellido_paterno"
        const val COL_AP_MATERNO = "apellido_materno"
        const val COL_CELULAR = "celular"
        const val COL_SEXO = "sexo"
        const val COL_CORREO = "correo"
        const val COL_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createUsuarios = """
            CREATE TABLE $TABLE_USUARIOS (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_DNI TEXT NOT NULL,
                $COL_NOMBRE TEXT NOT NULL,
                $COL_AP_PATERNO TEXT NOT NULL,
                $COL_AP_MATERNO TEXT NOT NULL,
                $COL_CELULAR TEXT NOT NULL,
                $COL_SEXO TEXT NOT NULL,
                $COL_CORREO TEXT NOT NULL UNIQUE,
                $COL_PASSWORD TEXT NOT NULL
            )
        """.trimIndent()

        db.execSQL(createUsuarios)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USUARIOS")
        onCreate(db)
    }
}