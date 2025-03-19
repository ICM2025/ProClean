package com.example.proclean

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proclean.databinding.ActivityMenuTrabajadorBinding

class menu_trabajador : AppCompatActivity() {

    private lateinit var binding: ActivityMenuTrabajadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuTrabajadorBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnOpcion1.setOnClickListener{
            val i = Intent(baseContext,busqueda_servicios_trabajador::class.java)
            startActivity(i)

        }

    }
}