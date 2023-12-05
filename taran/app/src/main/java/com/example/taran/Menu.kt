package com.example.taran

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Menu : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)



        val im: View = findViewById(R.id.im)
        im.setOnClickListener {
            val intent = Intent(this, Restaurantes::class.java)
            startActivity(intent)
        }

        val im2: View = findViewById(R.id.im2)
        im2.setOnClickListener {
            val intent = Intent(this, com.example.taran.Hoteleria::class.java)
            startActivity(intent)
        }

        val im4: View = findViewById(R.id.im4)
        im4.setOnClickListener {
            val intent = Intent(this, com.example.taran.Iniciar_Session::class.java)
            startActivity(intent)
        }

        val im5: View = findViewById(R.id.im5)
        im5.setOnClickListener {
            val intent = Intent(this, com.example.taran.Tiendas::class.java)
            startActivity(intent)
        }

        val im6: View = findViewById(R.id.im6)
        im6.setOnClickListener {
            val intent = Intent(this, com.example.taran.Eventos::class.java)
            startActivity(intent)
        }
    }
}

