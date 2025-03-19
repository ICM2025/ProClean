package com.example.proclean

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proclean.databinding.ActivityHistorialDeServiciosTrabajadorBinding

class historial_de_servicios_trabajador : AppCompatActivity() {

    private lateinit var binding:ActivityHistorialDeServiciosTrabajadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistorialDeServiciosTrabajadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        llenarListaHistorial()

        binding.listViewHistorial.setOnItemClickListener { _, _, position, _ ->

            val intent = Intent(baseContext, ver_servicio_especifico::class.java)

            startActivity(intent) // Iniciar la actividad
        }

    }


    private  fun llenarListaHistorial() {
        // Datos de ejemplo para el historial de servicios
        val historialServicios = listOf(
            "ID: 001 | Cliente: Juan Pérez | Precio: $50.000 | Fecha: 15/03/2024",
            "ID: 002 | Cliente: María Gómez | Precio: $80.000 | Fecha: 18/03/2024",
            "ID: 003 | Cliente: Carlos Ramírez | Precio: $60.000 | Fecha: 20/03/2024",
            "ID: 004 | Cliente: Ana Torres | Precio: $45.000 | Fecha: 22/03/2024",
            "ID: 005 | Cliente: Pedro Gómez | Precio: $75.000 | Fecha: 25/03/2024",
            "ID: 006 | Cliente: Laura Méndez | Precio: $90.000 | Fecha: 28/03/2024",
            "ID: 007 | Cliente: Andrés Herrera | Precio: $55.000 | Fecha: 30/03/2024",
            "ID: 008 | Cliente: Sofía Rojas | Precio: $70.000 | Fecha: 02/04/2024",
            "ID: 009 | Cliente: Fernando López | Precio: $85.000 | Fecha: 05/04/2024",
            "ID: 010 | Cliente: Carolina Díaz | Precio: $65.000 | Fecha: 07/04/2024",
            "ID: 011 | Cliente: Ricardo Gutiérrez | Precio: $78.000 | Fecha: 10/04/2024",
            "ID: 012 | Cliente: Natalia Vargas | Precio: $95.000 | Fecha: 12/04/2024",
            "ID: 013 | Cliente: Miguel Castillo | Precio: $60.000 | Fecha: 15/04/2024",
            "ID: 014 | Cliente: Valentina Pardo | Precio: $88.000 | Fecha: 18/04/2024",
            "ID: 015 | Cliente: Sebastián Ruiz | Precio: $72.000 | Fecha: 20/04/2024"
        )

        // Adaptador para el ListView
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, historialServicios)

        // Asignar el adaptador al ListView
        binding.listViewHistorial.adapter = adapter
    }
}