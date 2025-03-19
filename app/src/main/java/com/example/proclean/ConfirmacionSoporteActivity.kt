package com.example.proclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ConfirmacionSoporteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion_soporte)

        findViewById<Button>(R.id.volverMenuButton).setOnClickListener {
            // Volver a MenuClienteActivity cerrando todas las actividades intermedias
            // Esto evita crear múltiples instancias de MenuClienteActivity en la pila.
            val intent = Intent(this, MenuClienteActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}