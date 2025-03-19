package com.example.proclean

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistorialServiciosActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyView: TextView
    private lateinit var adapter: HistorialServiciosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente_servicios_historial)

        // Inicializar vistas
        recyclerView = findViewById(R.id.recyclerViewHistorial)
        emptyView = findViewById(R.id.emptyView)
        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)

        // Configurar RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = HistorialServiciosAdapter(obtenerHistorialServicios()) {}
        recyclerView.adapter = adapter

        // Mostrar vista vacía si no hay servicios
        if (adapter.itemCount == 0) {
            recyclerView.visibility = View.GONE
            emptyView.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            emptyView.visibility = View.GONE
        }

        btnVolver.setOnClickListener {
            finish() // Volver a la pantalla anterior
        }
    }

    // Obtener datos de ejemplo
    private fun obtenerHistorialServicios(): List<HistorialServicio> {
        return listOf(
            HistorialServicio(
                id = "1",
                nombreProfesional = "Carlos Ramírez",
                tipoServicio = "Plomería",
                fecha = "15/03/2025",
                duracion = 2,
                costo = 90000,
                estado = EstadoServicio.COMPLETADO
            ),
            HistorialServicio(
                id = "2",
                nombreProfesional = "María López",
                tipoServicio = "Limpieza",
                fecha = "10/03/2025",
                duracion = 4,
                costo = 160000,
                estado = EstadoServicio.EN_PROCESO
            ),
            HistorialServicio(
                id = "3",
                nombreProfesional = "Jorge Mendoza",
                tipoServicio = "Cerrajería",
                fecha = "05/03/2025",
                duracion = 1,
                costo = 50000,
                estado = EstadoServicio.CANCELADO
            ),
            HistorialServicio(
                id = "4",
                nombreProfesional = "Roberto Sánchez",
                tipoServicio = "Mecánica",
                fecha = "26/02/2025",
                duracion = 3,
                costo = 165000,
                estado = EstadoServicio.COMPLETADO
            ),
            HistorialServicio(
                id = "5",
                nombreProfesional = "Javier Torres",
                tipoServicio = "Fletes",
                fecha = "20/02/2025",
                duracion = 5,
                costo = 240000,
                estado = EstadoServicio.COMPLETADO
            )
        )
    }
}