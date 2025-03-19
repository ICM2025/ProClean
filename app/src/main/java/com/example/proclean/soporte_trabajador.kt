package com.example.proclean

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proclean.databinding.ActivitySoporteTrabajadorBinding
import com.example.proclean.databinding.ActivityVerServicioEspecificoBinding

class soporte_trabajador : AppCompatActivity() {
    private lateinit var binding: ActivitySoporteTrabajadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySoporteTrabajadorBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.volverMenuButton.setOnClickListener{
            val i = Intent(baseContext,menu_trabajador::class.java)
            startActivity(i)

        }

        binding.enviarSoporteButton.setOnClickListener{


        }
    }
}