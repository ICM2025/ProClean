package com.example.proclean

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proclean.databinding.ActivityAceptarServicioTrabajadorBinding

class aceptar_servicio_trabajador : AppCompatActivity() {

    private lateinit var binding: ActivityAceptarServicioTrabajadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAceptarServicioTrabajadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.enviarButton.setOnClickListener{

            val i = Intent(baseContext,envio_confirmacion_servicio::class.java)
            startActivity(i)
        }

    }
}