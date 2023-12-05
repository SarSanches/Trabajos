package com.example.taran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button3: View = findViewById(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this, com.example.taran.Menu::class.java)
            startActivity(intent)
        }
    }
}
