package com.example.proclean

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proclean.databinding.ActivityVerServicioEspecificoBinding

class ver_servicio_especifico : AppCompatActivity() {

    private lateinit var binding: ActivityVerServicioEspecificoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerServicioEspecificoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.volverHistorialButton.setOnClickListener{
            val i = Intent(baseContext,historial_de_servicios_trabajador::class.java)
            startActivity(i)

        }

    }
}