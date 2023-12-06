package com.example.taran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Restaurantes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurantes)

        val button13: View = findViewById(R.id.button13)
        button13.setOnClickListener {
            val intent = Intent(this, Restaurantes::class.java)
            startActivity(intent)
        }
        val button15: View = findViewById(R.id.button15)
        button15.setOnClickListener {
            val intent = Intent(this, Hoteleria::class.java)
            startActivity(intent)
        }
        val button14: View = findViewById(R.id.button14)
        button14.setOnClickListener {
            val intent = Intent(this, Eventos::class.java)
            startActivity(intent)
        }
        val button9: View = findViewById(R.id.button9)
        button9.setOnClickListener {
            val intent = Intent(this, Tiendas::class.java)
            startActivity(intent)
        }
    }
}