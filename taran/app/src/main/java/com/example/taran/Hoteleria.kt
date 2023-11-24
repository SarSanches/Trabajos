package com.example.taran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Hoteleria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hoteleria)

        val button17: View = findViewById(R.id.button17)
        button17.setOnClickListener {
            val intent = Intent(this, Restaurantes::class.java)
            startActivity(intent)
        }
        val button19: View = findViewById(R.id.button19)
        button19.setOnClickListener {
            val intent = Intent(this, Hoteleria::class.java)
            startActivity(intent)
        }
        val button20: View = findViewById(R.id.button20)
        button20.setOnClickListener {
            val intent = Intent(this, Eventos::class.java)
            startActivity(intent)
        }
        val button18: View = findViewById(R.id.button18)
        button18.setOnClickListener {
            val intent = Intent(this, Tiendas::class.java)
            startActivity(intent)
        }
    }
}