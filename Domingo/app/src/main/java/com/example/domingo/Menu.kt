package com.example.domingo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val button2: View = findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this, com.example.domingo.Alumnos::class.java)
            startActivity(intent)
        }
        val button3: View = findViewById(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this, com.example.domingo.Maestros::class.java)
            startActivity(intent)
        }
        val button4: View = findViewById(R.id.button4)
        button4.setOnClickListener {
            val intent = Intent(this, com.example.domingo.Materias::class.java)
            startActivity(intent)
        }
    }
}