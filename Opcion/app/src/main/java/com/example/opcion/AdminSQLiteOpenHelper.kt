package com.example.opcion
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase.CursorFactory

class AdminSQLiteOpenHelper(context: Context, name: String, factory: CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table alumnos(numero_control int primary key, nombre text, grado int)")
        db.execSQL("create table maestros(rfc int primary key, nombre text, Materia text)")
        db.execSQL("create table materias(aula int primary key, profesor text, nombre text)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Puedes implementar la lógica de actualización de la base de datos si es necesario
    }
}
