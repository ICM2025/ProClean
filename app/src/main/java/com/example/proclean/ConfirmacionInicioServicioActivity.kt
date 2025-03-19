package com.example.proclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ConfirmacionInicioServicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion_servicio)

        val btnConfirmar = findViewById<Button>(R.id.btn_siguiente)

        btnConfirmar.setOnClickListener {
            val intent = Intent(this, PrincipalClienteActivity::class.java)
            // Usar flags para limpiar el historial de actividades anteriores
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}