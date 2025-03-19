package com.example.proclean

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proclean.databinding.ActivityRegistroGeneralBinding

class registro_general : AppCompatActivity() {

    private lateinit var binding : ActivityRegistroGeneralBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroGeneralBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCliente.setOnClickListener{



        }

        binding.btnTrabajador.setOnClickListener{
            val i = Intent(baseContext,registro_trabajador::class.java)
            startActivity(i)



        }


    }
}