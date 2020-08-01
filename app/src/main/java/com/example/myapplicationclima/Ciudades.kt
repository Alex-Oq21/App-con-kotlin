package com.example.myapplicationclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)
        val button_medellin = findViewById<Button>(R.id.button_medellin)
        val button_cali = findViewById<Button>(R.id.button_cali)
        button_medellin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
        button_cali.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}