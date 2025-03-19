package com.example.proclean

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proclean.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRegistro.setOnClickListener{
            val i = Intent(baseContext,registro_general::class.java)
            startActivity(i)
        }

        binding.btnIniciarSesion.setOnClickListener{
            val i = Intent(baseContext,iniciar_sesion_general::class.java)
            startActivity(i)


        }


        }


    }


