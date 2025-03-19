package com.example.proclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale

class DetalleServicioProgresoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_servicio_progreso)

        // Obtener los datos del servicio pasados en el intent
        val id = intent.getStringExtra("ID") ?: ""
        val nombreCliente = intent.getStringExtra("NOMBRE_CLIENTE") ?: ""
        val tipoServicio = intent.getStringExtra("TIPO_SERVICIO") ?: ""
        val fecha = intent.getStringExtra("FECHA") ?: ""
        val duracion = intent.getIntExtra("DURACION", 0)
        val precio = intent.getIntExtra("PRECIO", 0)
        val direccion = intent.getStringExtra("DIRECCION") ?: ""
        val descripcion = intent.getStringExtra("DESCRIPCION") ?: ""

        // Inicializar vistas
        val tvNombreCliente = findViewById<TextView>(R.id.tvNombreCliente)
        val tvTipoServicio = findViewById<TextView>(R.id.tvTipoServicio)
        val tvFechaServicio = findViewById<TextView>(R.id.tvFechaServicio)
        val tvDuracionServicio = findViewById<TextView>(R.id.tvDuracionServicio)
        val tvPrecioServicio = findViewById<TextView>(R.id.tvPrecioServicio)
        val tvDireccionServicio = findViewById<TextView>(R.id.tvDireccionServicio)
        val tvDescripcionServicio = findViewById<TextView>(R.id.tvDescripcionServicio)

        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)
        val btnComenzarServicio = findViewById<Button>(R.id.btnComenzarServicio)
        val btnVerRuta = findViewById<Button>(R.id.btnVerRuta)
        val btnTerminarServicio = findViewById<Button>(R.id.btnTerminarServicio)

        // Establecer datos en las vistas
        tvNombreCliente.text = nombreCliente
        tvTipoServicio.text = tipoServicio
        tvFechaServicio.text = fecha
        tvDuracionServicio.text = "$duracion horas"

        val formato = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
        tvPrecioServicio.text = formato.format(precio)

        tvDireccionServicio.text = direccion
        tvDescripcionServicio.text = descripcion

        btnVolver.setOnClickListener {
            finish() // Volver a la pantalla anterior
        }

        btnComenzarServicio.setOnClickListener {
            val intent = Intent(this, NfcConfirmacionActivity::class.java)
            intent.putExtra("ID", id)
            intent.putExtra("NOMBRE_CLIENTE", nombreCliente)
            startActivity(intent)
        }

        btnVerRuta.setOnClickListener {
            val intent = Intent(this, VerRutaActivity::class.java)
            startActivity(intent)
        }

        btnTerminarServicio.setOnClickListener {
            val intent = Intent(this, CalificarAtencionActivity::class.java)
            intent.putExtra("ID", id)
            intent.putExtra("NOMBRE_CLIENTE", nombreCliente)
            intent.putExtra("TIPO_SERVICIO", tipoServicio)
            startActivity(intent)
        }
    }
}