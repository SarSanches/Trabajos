package com.example.taran

import AdminSQLiteOpenHelper
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class inciarsession : AppCompatActivity() {

    private lateinit var nombreEditText: EditText
    private lateinit var contrasenaEditText: EditText
    private lateinit var confirmarContrasenaEditText: EditText
    private lateinit var registrarButton: Button

    private lateinit var databaseManager: AdminSQLiteOpenHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inciarsession)

        // Inicializar vistas
        nombreEditText = findViewById(R.id.editTextText3)
        contrasenaEditText = findViewById(R.id.editTextTextPassword)
        confirmarContrasenaEditText = findViewById(R.id.editTextTextPassword2)
        registrarButton = findViewById(R.id.button6)

        // Inicializar la base de datos
        databaseManager = AdminSQLiteOpenHelper(this)

        // Configurar el evento de clic para el botón de registro
        registrarButton.setOnClickListener { registrarUsuario() }
    }

    private fun registrarUsuario() {
        val nombre = nombreEditText.text.toString()
        val contrasena = contrasenaEditText.text.toString()
        val confirmarContrasena = confirmarContrasenaEditText.text.toString()

        // Verificar que las contraseñas coincidan
        if (contrasena != confirmarContrasena) {
            // Manejar el caso en que las contraseñas no coinciden
            // Puedes mostrar un mensaje de error o realizar otra acción
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return
        }

        // Insertar el nuevo usuario en la base de datos
        val userId: Long = databaseManager.insertUser(nombre, contrasena)

        // Mostrar un mensaje de éxito
        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

        // Redirigir de nuevo a la pantalla Iniciar_Session
        val intent = Intent(this, Iniciar_Session::class.java)
        startActivity(intent)
        finish()  // Opcional: Cierra la actividad actual para evitar que el usuario retroceda
    }
}
