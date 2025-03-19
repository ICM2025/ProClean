package com.example.proclean

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proclean.databinding.ActivityBusquedaServiciosTrabajadorBinding
import com.example.proclean.databinding.ActivityMenuTrabajadorBinding

class busqueda_servicios_trabajador : AppCompatActivity() {


    private lateinit var binding: ActivityBusquedaServiciosTrabajadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBusquedaServiciosTrabajadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.aceptarButton.setOnClickListener{
            val i = Intent(baseContext,aceptar_servicio_trabajador::class.java)
            startActivity(i)

        }

        binding.rechazarButton.setOnClickListener{
            val i = Intent(baseContext,menu_trabajador::class.java)
            startActivity(i)
        }

    }
}