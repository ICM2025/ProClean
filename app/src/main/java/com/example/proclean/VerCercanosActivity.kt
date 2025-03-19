package com.example.proclean

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class VerCercanosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_cercanos)

        // Obtener referencia a las vistas
        val ivMapaCercanos = findViewById<ImageView>(R.id.ivMapaCercanos)
        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)

        ivMapaCercanos.setImageResource(R.drawable.ver_cercanos)

        btnVolver.setOnClickListener {
            finish() // Volver a la anterior
        }
    }
}