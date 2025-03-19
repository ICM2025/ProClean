package com.example.proclean

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proclean.databinding.ActivityRegistroTrabajadorParteDosBinding
import com.example.proclean.databinding.ActivityRegistroTrabajadorParteTresBinding

class registro_trabajador_parte_tres : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroTrabajadorParteTresBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityRegistroTrabajadorParteTresBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        llenarSpinners()

        binding.btnSiguiente.setOnClickListener{

            val i = Intent(baseContext, registro_trabajador_parte_cuatro::class.java)
            startActivity(i)



        }






    }


    private fun llenarSpinners() {
        val profesiones = listOf("Trabajadora Doméstica", "Plomero", "Carpintero")

        fun crearAdapter(datos: List<String>): ArrayAdapter<String> {
            return object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos) {
                override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                    val view = super.getView(position, convertView, parent)
                    (view as TextView).setTextColor(Color.WHITE)  // Cambia el color del texto a blanco
                    return view
                }

                override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                    val view = super.getDropDownView(position, convertView, parent)
                    (view as TextView).setTextColor(Color.WHITE)  // Cambia el color en la lista desplegable
                    return view
                }
            }
        }

        binding.spinnerProfesion.adapter = crearAdapter(profesiones)
    }

}