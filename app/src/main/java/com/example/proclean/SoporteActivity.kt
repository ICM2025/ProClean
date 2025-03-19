package com.example.proclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SoporteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soporte)

        val inquietudEditText = findViewById<EditText>(R.id.inquietudEditText)
        val enviarSoporteButton = findViewById<Button>(R.id.enviarSoporteButton)
        val volverMenuButton = findViewById<Button>(R.id.volverMenuButton)

        enviarSoporteButton.setOnClickListener {
            val inquietud = inquietudEditText.text.toString().trim()

            if (inquietud.isEmpty()) {
                Toast.makeText(this, "Por favor, escriba su inquietud", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ConfirmacionSoporteActivity::class.java)
                startActivity(intent)
            }
        }

        volverMenuButton.setOnClickListener {
            finish() // Vuelve a la actividad anterior (MenuClienteActivity)
        }
    }
}