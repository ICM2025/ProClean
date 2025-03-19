package com.example.proclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalificarAtencionActivity : AppCompatActivity() {

    private var calificacion = 0
    private lateinit var estrellas: List<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calificar_atencion)

        // Obtener los datos pasados en el intent
        val id = intent.getStringExtra("ID") ?: ""
        val nombreCliente = intent.getStringExtra("NOMBRE_CLIENTE") ?: ""
        val tipoServicio = intent.getStringExtra("TIPO_SERVICIO") ?: ""

        // Inicializar vistas
        val tvNombreCliente = findViewById<TextView>(R.id.tvNombreCliente)
        val tvTipoServicio = findViewById<TextView>(R.id.tvTipoServicio)
        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)
        val btnTerminar = findViewById<Button>(R.id.btnTerminar)

        // Inicializar estrellas
        estrellas = listOf(
            findViewById(R.id.star1),
            findViewById(R.id.star2),
            findViewById(R.id.star3),
            findViewById(R.id.star4),
            findViewById(R.id.star5)
        )

        // Establecer datos en las vistas
        tvNombreCliente.text = nombreCliente
        tvTipoServicio.text = tipoServicio

        // Configurar estrellas
        estrellas.forEachIndexed { index, estrella ->
            estrella.setOnClickListener {
                calificacion = index + 1
                actualizarEstrellas()
            }
        }

        // Configurar botones
        btnVolver.setOnClickListener {
            finish() // Volver a la pantalla anterior
        }

        btnTerminar.setOnClickListener {
            if (calificacion == 0) {
                Toast.makeText(this, "Por favor, califica el servicio", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Ir a pantalla principal
            val intent = Intent(this, PrincipalClienteActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }

    private fun actualizarEstrellas() {
        estrellas.forEachIndexed { index, estrella ->
            if (index < calificacion) {
                estrella.setImageResource(android.R.drawable.btn_star_big_on)
            } else {
                estrella.setImageResource(android.R.drawable.btn_star_big_off)
            }
        }
    }
}