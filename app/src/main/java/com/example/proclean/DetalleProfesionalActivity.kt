package com.example.proclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleProfesionalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_profesional)

        // Obtener datos del profesional
        val nombre = intent.getStringExtra("NOMBRE") ?: "Nombre no disponible"
        val categoria = intent.getStringExtra("CATEGORIA") ?: "Categoría no disponible"
        val rating = intent.getStringExtra("RATING") ?: "0.0"
        val distancia = intent.getStringExtra("DISTANCIA") ?: "No disponible"
        val precio = intent.getStringExtra("PRECIO") ?: "No disponible"
        val destacado = intent.getBooleanExtra("DESTACADO", false)

        // Inicializar vistas
        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val tvCategoria = findViewById<TextView>(R.id.tvCategoria)
        val tvRating = findViewById<TextView>(R.id.tvRating)
        val tvDistancia = findViewById<TextView>(R.id.tvDistancia)
        val tvPrecio = findViewById<TextView>(R.id.tvPrecio)
        val tvDescripcion = findViewById<TextView>(R.id.tvDescripcion)
        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)
        val btnSolicitarServicio = findViewById<Button>(R.id.btnSolicitarServicio)

        // Establecer datos en las vistas
        tvNombre.text = nombre
        tvCategoria.text = categoria
        tvRating.text = rating
        tvDistancia.text = distancia
        tvPrecio.text = precio

        // Descripción de ejemplo basada en la categoría
        val descripcion = when (categoria) {
            "Plomería" -> "Profesional con más de 10 años de experiencia en servicios de plomería y electricidad. Especializado en instalaciones, reparaciones y mantenimiento para hogares y pequeños negocios."
            "Limpieza" -> "Servicio de limpieza profesional con equipo calificado. Especialistas en limpieza de hogares, oficinas y espacios comerciales. Productos ecológicos y de alta calidad."
            "Cerrajería" -> "Cerrajero profesional con experiencia en todo tipo de cerraduras y sistemas de seguridad. Servicio rápido y confiable para emergencias, instalaciones y reparaciones."
            "Mecánica" -> "Mecánico con amplia experiencia en diagnóstico y reparación de vehículos. Especialista en sistemas eléctricos, mecánicos y electrónicos de automóviles de todas las marcas."
            "Fletes" -> "Servicio de fletes y mudanzas con vehículos de diferentes tamaños. Transporte seguro de muebles, electrodomésticos y objetos frágiles. Personal capacitado y cuidadoso."
            else -> "Profesional con experiencia y calificaciones destacadas en su área de especialidad. Servicio de calidad, puntual y confiable."
        }
        tvDescripcion.text = descripcion

        btnVolver.setOnClickListener {
            finish() // Volver a la pantalla anterior
        }

        btnSolicitarServicio.setOnClickListener {
            val intent = Intent(this, SolicitarServicioActivity::class.java)
            // Pasar información a la pantalla de solicitud
            intent.putExtra("NOMBRE", nombre)
            intent.putExtra("CATEGORIA", categoria)
            intent.putExtra("PRECIO", precio)
            startActivity(intent)
        }
    }
}