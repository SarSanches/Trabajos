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
class Materias : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materias)

        val et7 = findViewById<EditText>(R.id.et7)
        val et8 = findViewById<EditText>(R.id.et8)
        val et9 = findViewById<EditText>(R.id.et9)

        val boton11 = findViewById<Button>(R.id.boton11)
        val boton12 = findViewById<Button>(R.id.boton12)
        val boton13 = findViewById<Button>(R.id.boton13)
        val boton14 = findViewById<Button>(R.id.boton14)
        val boton15 = findViewById<Button>(R.id.boton15)


        boton11.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre", et7.text.toString())
            registro.put("profesor", et8.text.toString())
            registro.put("aula", et9.text.toString())
            bd.insert("materias", null, registro)
            bd.close()
            et7.setText("")
            et8.setText("")
            et9.setText("")
            Toast.makeText(this, "Se cargaron los datos de la materia", Toast.LENGTH_SHORT).show()
        }

        boton12.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select profesor,nombre from materias where aula=${et9.text.toString()}", null)
            if (fila.moveToFirst()) {
                et7.setText(fila.getString(0))
                et8.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe una materia con dicha aula", Toast.LENGTH_SHORT).show()
            bd.close()
        }

        boton13.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select nombre,aula from materias where profesor='${et8.text.toString()}'", null)
            if (fila.moveToFirst()) {
                et7.setText(fila.getString(0))
                et9.setText(fila.getString(1))
            } else {
                Toast.makeText(this, "No existe una materia con dicho profesor", Toast.LENGTH_SHORT).show()

            }
            bd.close()
        }

        boton14.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("materias", "aula=${et9.text.toString()}", null)
            bd.close()
            et7.setText("")
            et8.setText("")
            et9.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró la materia con dicha aula", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe una materia con dicha aula", Toast.LENGTH_SHORT).show()
        }
        boton15.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("profesor", et8.text.toString())
            registro.put("aula", et9.text.toString())
            val cant = bd.update("materias", registro, "nombre=${et7.text.toString()}", null)
            bd.close()
            if (cant == 1)
                Toast.makeText(this, "Se modificaron los datos de la materia", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe una materia con el nombre ingresado", Toast.LENGTH_SHORT).show()
        }
        val button7: View = findViewById(R.id.button7)
        button7.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
    }
}