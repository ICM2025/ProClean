package com.example.proclean

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class VerRutaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_ruta)

        // Obtener referencia a las vistas
        val ivMapaRuta = findViewById<ImageView>(R.id.ivMapaRuta)
        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)

        ivMapaRuta.setImageResource(R.drawable.ver_ruta)

        btnVolver.setOnClickListener {
            finish() // Volver a la anterior
        }
    }
}