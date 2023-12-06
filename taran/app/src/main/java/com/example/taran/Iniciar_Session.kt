package com.example.taran
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.setupActionBarWithNavController
//import com.facebook.CallbackManager
//import com.facebook.FacebookActivity
//import com.facebook.FacebookCallback
//import com.facebook.FacebookException
//import com.facebook.login.LoginManager
//import com.facebook.login.LoginResult
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth

class Iniciar_Session : AppCompatActivity() {

    //private val callbackManager = CallbackManager.Factory.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_session)

        val texto: View = findViewById(R.id.tx)
        texto.setOnClickListener {
            val intent = Intent(this, inciarsession::class.java)
            startActivity(intent)
        }
//Eventos personalizados para google analiticts para consola firebase
        val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integración de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        //Setup
        setup()
    }

    private fun setup() {


        val ingresar : Button =findViewById(R.id.ingresar)
         ingresar.setOnClickListener {
             val emailEditText: EditText = findViewById(R.id.emailEditText)
             val passwordEditText: EditText = findViewById(R.id.passwordEditText)
             if (emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()) {
                 FirebaseAuth.getInstance()
                     .signInWithEmailAndPassword(
                         emailEditText.text.toString(),
                         passwordEditText.text.toString()
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
        //val button4 : Button = findViewById(R.id.button4)
        //button4.setOnClickListener{
            //LoginManager.getInstance().registerCallback(callbackManager,
                //object : FacebookCallback<LoginResult>{
        //override fun onSuccess(result: LoginResult?){

         }

        // override fun onCancel() {

        // }

        //override fun onError(error: FacebookException?) {
        //showAlert()
        // }
    // })
        // }
        // }




    private fun showAlert() {
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

