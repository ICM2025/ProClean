package com.example.proclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegistroExitosoCliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_exitoso_cliente)

        findViewById<Button>(R.id.btn_siguiente).setOnClickListener {
            val intent = Intent(this, ServiciosPreferidosActivity::class.java)
            startActivity(intent)
        }
    }
}