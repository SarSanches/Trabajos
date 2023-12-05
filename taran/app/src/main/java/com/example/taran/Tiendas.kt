package com.example.taran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Tiendas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiendas)

        val button22: View = findViewById(R.id.button22)
        button22.setOnClickListener {
            val intent = Intent(this, Restaurantes::class.java)
            startActivity(intent)
        }
        val button23: View = findViewById(R.id.button23)
        button23.setOnClickListener {
            val intent = Intent(this, Hoteleria::class.java)
            startActivity(intent)
        }
        val button21: View = findViewById(R.id.button21)
        button21.setOnClickListener {
            val intent = Intent(this, Eventos::class.java)
            startActivity(intent)
        }
        val button16: View = findViewById(R.id.button16)
        button16.setOnClickListener {
            val intent = Intent(this, Tiendas::class.java)
            startActivity(intent)
        }
    }
}