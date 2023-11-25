package com.example.domingo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: View = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, com.example.domingo.Menu::class.java)
            startActivity(intent)
        }
    }
}