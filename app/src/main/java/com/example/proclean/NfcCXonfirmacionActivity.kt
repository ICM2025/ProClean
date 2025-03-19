package com.example.proclean

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NfcConfirmacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nfc_confirmacion)

        // Obtener los datos pasados en el intent
        val id = intent.getStringExtra("ID") ?: ""
        val nombreCliente = intent.getStringExtra("NOMBRE_CLIENTE") ?: ""

        // Inicializar vistas
        val tvEstadoNfc = findViewById<TextView>(R.id.tvEstadoNfc)
        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)
        val btnConfirmarNfc = findViewById<Button>(R.id.btnConfirmarNfc)

        btnVolver.setOnClickListener {
            finish() // Volver a la pantalla anterior
        }

        // Simular la detección de NFC después de unos segundos
        Handler(Looper.getMainLooper()).postDelayed({
            tvEstadoNfc.text = "Buscando dispositivo NFC..."
            tvEstadoNfc.setTextColor(resources.getColor(android.R.color.holo_blue_light))
        }, 1500)

        btnConfirmarNfc.setOnClickListener {
            tvEstadoNfc.text = "¡Conexión NFC establecida!"
            tvEstadoNfc.setTextColor(resources.getColor(android.R.color.holo_green_light))

            Handler(Looper.getMainLooper()).postDelayed({
                // Navegamos a la pantalla de confirmación
                val intent = Intent(this, ConfirmacionInicioServicioActivity::class.java)
                intent.putExtra("ID", id)
                intent.putExtra("NOMBRE_CLIENTE", nombreCliente)
                startActivity(intent)
                finish()
            }, 1500)
        }
    }
}