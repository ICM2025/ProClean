package com.example.proclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ClienteDatosContacto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente_datos_contacto)

        findViewById<Button>(R.id.btn_siguiente).setOnClickListener {
            val intent = Intent(this, RegistroExitosoCliente::class.java)
            startActivity(intent)
        }
    }
}