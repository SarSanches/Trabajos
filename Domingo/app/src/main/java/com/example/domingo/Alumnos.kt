package com.example.domingo


import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Alumnos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumnos)


        val et1=findViewById<EditText>(R.id.GAP)
        val et2=findViewById<EditText>(R.id.TU)
        val et3=findViewById<EditText>(R.id.TU2)
        val boton1=findViewById<Button>(R.id.button8)
        val boton2=findViewById<Button>(R.id.button5)
        val boton3=findViewById<Button>(R.id.button10)
        val boton4=findViewById<Button>(R.id.button9)
        val boton5=findViewById<Button>(R.id.button6)
        boton1.setOnClickListener {
            val admin = TRABAJO(this,"administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("NumeroControl", et1.getText().toString())
            registro.put("Nombre", et2.getText().toString())
            registro.put("Grado", et3.getText().toString())
            bd.insert("Alumnos", null, registro)
            bd.close()
            et1.setText("")
            et2.setText("")
            et3.setText("")
            Toast.makeText(this, "Se cargaron los datos del Alumno", Toast.LENGTH_SHORT).show()
        }

        boton2.setOnClickListener {
            Log.d("Boton2", "Botón 2 clicado")
            val admin = TRABAJO(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            try {
                val fila = bd.rawQuery("select Nombre, Grado from Alumnos where NumeroControl=${et1.text.toString()}", null)
                if (fila.moveToFirst()) {
                    et2.setText(fila.getString(0))
                    et3.setText(fila.getString(1))
                } else {
                    Toast.makeText(this, "No existe un Alumno con dicho Numero de Control", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("ConsultaError", "Error al consultar datos: ${e.message}")
            } finally {
                bd.close()
            }
        }

        boton3.setOnClickListener {
            val admin = TRABAJO(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select NumeroControl,Grado from Alumnos where Nombre='${et2.text.toString()}'", null)
            if (fila.moveToFirst()) {
                et1.setText(fila.getString(0))
                et3.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un artículo con dicha descripción", Toast.LENGTH_SHORT).show()
            bd.close()
        }

        boton4.setOnClickListener {
            val admin = TRABAJO(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("Alumnos", "NumeroControl=${et1.text.toString()}", null)
            bd.close()
            et1.setText("")
            et2.setText("")
            et3.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró el alumno con dicho Numero de Control", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un Alumno con dicho Numero de Control", Toast.LENGTH_SHORT).show()
        }

        boton5.setOnClickListener {
            val admin = TRABAJO(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("Nombre", et2.text.toString())
            registro.put("Grado", et3.text.toString())
            val cant = bd.update("Alumnos", registro, "NumeroControl=${et1.text.toString()}", null)
            bd.close()
            if (cant == 1)
                Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "no existe un Alumno con el Numero de Control ingresado", Toast.LENGTH_SHORT).show()
        }
    }
}