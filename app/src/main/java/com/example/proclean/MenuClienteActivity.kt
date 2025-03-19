package com.example.proclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuClienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_cliente)


        findViewById<Button>(R.id.btnHistorial).setOnClickListener {
            val intent = Intent(this, HistorialServiciosActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnSoporte).setOnClickListener {
            val intent = Intent(this, SoporteActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnCerrarSesion).setOnClickListener {
            //Esto asegura que el usuario no pueda volver atrás después de cerrar sesión.
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}