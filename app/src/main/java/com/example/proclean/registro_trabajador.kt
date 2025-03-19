package com.example.proclean

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proclean.databinding.ActivityRegistroTrabajadorBinding
import models.ListaTrabajador
import models.Trabajador

class registro_trabajador : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroTrabajadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistroTrabajadorBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)

        setContentView(binding.root)


        binding.btnSiguiente.setOnClickListener{
        datos_trabajador_uno()

            val i = Intent(baseContext,registro_trabajador_parte_dos::class.java)
            startActivity(i)


        }

    }


    private fun datos_trabajador_uno(){
        val primerNombre = binding.primerNombre.text.toString().trim()
        val segundoNombre = binding.segundoNombre.text.toString().trim()
        val primerApellido = binding.editTextPrimerApellido.text.toString().trim()
        val segundoApellido = binding.editTextSegundoApellido.text.toString().trim()


        val trabajador = Trabajador().apply {
            primer_nombre = primerNombre
            segundo_nombre = segundoNombre
            primer_apellido = primerApellido
            segundo_apellido = segundoApellido
        }


        val listaTrabajador = ListaTrabajador.getInstance()
        listaTrabajador.agregarTrabajador(trabajador)

    }
}