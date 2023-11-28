package com.example.opcion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val button: View = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, com.example.opcion.Menu::class.java)
            startActivity(intent)
        }
    }
}