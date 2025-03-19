package com.example.proclean

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proclean.databinding.ActivityRegistroTrabajadorParteCuatroBinding

class registro_trabajador_parte_cuatro : AppCompatActivity() {


    private lateinit var binding: ActivityRegistroTrabajadorParteCuatroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroTrabajadorParteCuatroBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSiguiente.setOnClickListener{
            val i = Intent(baseContext,menu_trabajador::class.java)
            startActivity(i)
        }

    }
}