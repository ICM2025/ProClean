package com.example.proclean

import android.R
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proclean.databinding.ActivityRegistroTrabajadorBinding
import com.example.proclean.databinding.ActivityRegistroTrabajadorParteDosBinding
import models.ListaTrabajador




class registro_trabajador_parte_dos : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroTrabajadorParteDosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroTrabajadorParteDosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        llenarSpinners()

        binding.btnSiguiente.setOnClickListener {
            cargar_datos_dos()

            val i = Intent(baseContext,registro_trabajador_parte_tres::class.java)
            startActivity(i)
        }
    }


    private fun llenarSpinners() {
        val tipoDocumento = listOf("Cédula de Ciudadanía", "Cédula de Extranjería")
        val dias = (1..31).map { it.toString() }
        val meses = (1..12).map { it.toString() }
        val anios = (1900..2007).map { it.toString() }

        fun crearAdapter(datos: List<String>): ArrayAdapter<CharSequence> {
            return ArrayAdapter(this, android.R.layout.simple_spinner_item, datos.map {
                SpannableString(it).apply { setSpan(ForegroundColorSpan(Color.WHITE), 0, it.length, 0) }
            })
        }

        binding.spinnerTipoDocumento.adapter = crearAdapter(tipoDocumento)
        binding.spinnerDia.adapter = crearAdapter(dias)
        binding.spinnerMes.adapter = crearAdapter(meses)
        binding.spinnerAnio.adapter = crearAdapter(anios)
    }










    private fun cargar_datos_dos() {
        // Obtener la instancia del singleton y la lista de trabajadores
        val listaTrabajadores = ListaTrabajador.getInstance()

        // Verificar si hay trabajadores en la lista
        if (listaTrabajadores.trabajadores.isNotEmpty()) {
            // Obtener el último trabajador agregado
            val trabajador = listaTrabajadores.trabajadores.last()

            // Obtener los valores seleccionados de los Spinners
            val tipoDocumento = binding.spinnerTipoDocumento.selectedItem.toString()
            val dia = binding.spinnerDia.selectedItem.toString()
            val mes = binding.spinnerMes.selectedItem.toString()
            val anio = binding.spinnerAnio.selectedItem.toString()

            // Asignar los valores al objeto Trabajador
            trabajador.tipo_documento = tipoDocumento
            trabajador.n_documento = "$dia/$mes/$anio"



        } else {

        }
    }
}