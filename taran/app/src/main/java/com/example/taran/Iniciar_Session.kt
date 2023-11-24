package com.example.taran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.taran.R

class Iniciar_Session : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_session)


        val tx: View = findViewById(R.id.tx)
        tx.setOnClickListener {
            val intent = Intent(this, inciarsession::class.java)
            startActivity(intent)
        }
        val button2: View = findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this, com.example.taran.Menu::class.java)
            startActivity(intent)
        }
    }
}