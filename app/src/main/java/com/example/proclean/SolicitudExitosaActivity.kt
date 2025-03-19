package com.example.proclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SolicitudExitosaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion_solicitud)

        // Inicializar vistas
        val volverMenuButton = findViewById<Button>(R.id.volverMenuButton)

        // Texto de la confirmación ya está configurado en el layout

        // Configurar botón para volver al inicio
        volverMenuButton.setOnClickListener {
            val intent = Intent(this, PrincipalClienteActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}