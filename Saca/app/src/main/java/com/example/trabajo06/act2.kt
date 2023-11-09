package com.example.trabajo06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView


class act2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act2)

        val et1=findViewById<EditText>(R.id.et1)
        val et2=findViewById<EditText>(R.id.et2)
        val r1=findViewById<RadioButton>(R.id.r1)
        val r2=findViewById<RadioButton>(R.id.r2)
        val tv=findViewById<TextView>(R.id.tv)
        val button3=findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            if (r1.isChecked)
                tv.text = "Resultado: ${et1.text.toString().toInt() + et2.text.toString().toInt()}"
            if (r2.isChecked)
                tv.text = "Resultado: ${et1.text.toString().toInt() - et2.text.toString().toInt()}"
        }
    }
}