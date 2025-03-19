package com.example.proclean

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proclean.databinding.ActivityEnvioConfirmacionServicioBinding

class envio_confirmacion_servicio : AppCompatActivity() {

    private lateinit var binding :ActivityEnvioConfirmacionServicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityEnvioConfirmacionServicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSiguiente.setOnClickListener{

            val i = Intent(baseContext,menu_trabajador::class.java)
            startActivity(i)
        }

    }
}