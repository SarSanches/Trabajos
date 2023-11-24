package com.example.taran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Eventos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eventos)

        val button11: View = findViewById(R.id.button11)
        button11.setOnClickListener {
            val intent = Intent(this, Restaurantes::class.java)
            startActivity(intent)
        }

        val button12: View = findViewById(R.id.button12)
        button12.setOnClickListener {
            val intent = Intent(this, Hoteleria::class.java)
            startActivity(intent)
        }
        val button7: View = findViewById(R.id.button7)
        button7.setOnClickListener {
            val intent = Intent(this, Eventos::class.java)
            startActivity(intent)
        }
        val button: View = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, Tiendas::class.java)
            startActivity(intent)
        }
    }
}