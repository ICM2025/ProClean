package com.example.proclean;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

public class RegistroCliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_cliente)

        findViewById<Button>(R.id.btn_siguiente).setOnClickListener {
            val intent = Intent(this, ClienteDatosContacto::class.java)
            startActivity(intent)
        }
    }
}
