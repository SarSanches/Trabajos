package com.example.taran

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth

class inciarsession : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inciarsession)

        //Eventos personalisados para google analiticts para consola firebase
        val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integración de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        //Setup
        setup()
    }

    private fun setup() {
        title = "Autenticación"
        val setUpButton: Button = findViewById(R.id.setUpButton)


        setUpButton.setOnClickListener {
            val emailtext: EditText = findViewById(R.id.emailtext)
            val editTextTextPassword: EditText = findViewById(R.id.editTextTextPassword)
            if (emailtext.text.isNotEmpty() && editTextTextPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(
                        emailtext.text.toString(),
                        editTextTextPassword.text.toString()  // Corrige el error tipográfico aquí
                    ).addOnCompleteListener {

                        if (it.isSuccessful){
                            // Hacer algo si el registro es exitoso
                            showSuccessMessage()
                        } else {
                            showAlert()
                        }
                    }
            }
        }
    }


    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando el usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }
    private fun showSuccessMessage() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Registro exitoso")
        builder.setMessage("Se ha iniciado sesión correctamente")
        builder.setPositiveButton("Aceptar") { _, _ ->
            val intent = Intent(this, com.example.taran.Menu::class.java)
            startActivity(intent)
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}




