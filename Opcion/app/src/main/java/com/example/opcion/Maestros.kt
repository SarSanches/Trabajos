package com.example.opcion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
class Maestros : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maestros)

        val et4 = findViewById<EditText>(R.id.et4)
        val et5 = findViewById<EditText>(R.id.et5)
        val et6 = findViewById<EditText>(R.id.et6)

        val boton6 = findViewById<Button>(R.id.boton6)
        val boton7 = findViewById<Button>(R.id.boton7)
        val boton8 = findViewById<Button>(R.id.boton8)
        val boton9 = findViewById<Button>(R.id.boton9)
        val boton10 = findViewById<Button>(R.id.boton10)

        boton6.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("rfc", et4.text.toString())
            registro.put("nombre", et5.text.toString())
            registro.put("Materia", et6.text.toString())
            bd.insert("maestros", null, registro)
            bd.close()
            et4.setText("")
            et5.setText("")
            et6.setText("")
            Toast.makeText(this, "Se cargaron los datos del maestro", Toast.LENGTH_SHORT).show()
        }

        boton7.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select nombre,Materia from maestros where rfc=${et4.text.toString()}", null)
            if (fila.moveToFirst()) {
                et5.setText(fila.getString(0))
                et6.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un maestro con dicho rfc", Toast.LENGTH_SHORT).show()
            bd.close()
        }

        boton8.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select rfc,Materia from maestros where nombre='${et5.text.toString()}'", null)
            if (fila.moveToFirst()) {
                et4.setText(fila.getString(0))
                et6.setText(fila.getString(1))
            } else {
                Toast.makeText(this, "No existe un maestro con dicho nombre", Toast.LENGTH_SHORT).show()

            }
            bd.close()
        }

        boton9.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("maestros", "rfc=${et4.text.toString()}", null)
            bd.close()
            et4.setText("")
            et5.setText("")
            et6.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró el maestro con dicho rfc", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un maestro con dicho rfc", Toast.LENGTH_SHORT).show()
        }
        boton10.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre", et5.text.toString())
            registro.put("Materia", et6.text.toString())
            val cant = bd.update("maestros", registro, "rfc=${et4.text.toString()}", null)
            bd.close()
            if (cant == 1)
                Toast.makeText(this, "Se modificaron los datos del maestro", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un maestro con el rfc ingresado", Toast.LENGTH_SHORT).show()
        }
        val button6: View = findViewById(R.id.button6)
        button6.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
    }
}