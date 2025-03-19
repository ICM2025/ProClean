package com.example.proclean

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proclean.databinding.ActivityConfirmacionFinalTrabajadorServicioBinding
import com.example.proclean.databinding.ActivityIniciarSesionGeneralBinding

class iniciar_sesion_general : AppCompatActivity() {
    private lateinit var binding: ActivityIniciarSesionGeneralBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIniciarSesionGeneralBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}