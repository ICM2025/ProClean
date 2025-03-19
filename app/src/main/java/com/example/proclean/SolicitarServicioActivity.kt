package com.example.proclean

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Calendar
import java.util.Locale

class SolicitarServicioActivity : AppCompatActivity() {

    private lateinit var etHoras: EditText
    private lateinit var etFecha: EditText
    private lateinit var etDescripcion: EditText
    private lateinit var tvTotal: TextView
    private var precioHora: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitar_servicio)

        // Obtener datos del profesional
        val nombre = intent.getStringExtra("NOMBRE") ?: "Nombre no disponible"
        val categoria = intent.getStringExtra("CATEGORIA") ?: "Categoría no disponible"
        val precioTexto = intent.getStringExtra("PRECIO") ?: "$0 por hora"

        // Extraer el valor numérico del precio
        val precioRegex = "\\$(\\d+\\.?\\d*)".toRegex()
        val precioMatch = precioRegex.find(precioTexto)
        precioHora = precioMatch?.groupValues?.get(1)?.replace(".", "")?.toInt() ?: 0

        // Inicializar vistas
        val tvNombreResumen = findViewById<TextView>(R.id.tvNombreResumen)
        val tvCategoriaResumen = findViewById<TextView>(R.id.tvCategoriaResumen)
        val tvPrecioResumen = findViewById<TextView>(R.id.tvPrecioResumen)
        etHoras = findViewById(R.id.etHoras)
        etFecha = findViewById(R.id.etFecha)
        etDescripcion = findViewById(R.id.etDescripcion)
        tvTotal = findViewById(R.id.tvTotal)
        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)
        val btnEnviarSolicitud = findViewById<Button>(R.id.btnEnviarSolicitud)

        // Establecer datos en las vistas
        tvNombreResumen.text = nombre
        tvCategoriaResumen.text = categoria
        tvPrecioResumen.text = precioTexto
        tvTotal.text = "$0"

        // Configurar selector de fecha
        etFecha.setOnClickListener {
            mostrarSelectorFecha()
        }

        // Calcular total cuando cambie la cantidad de horas
        etHoras.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                calcularTotal()
            }
        })

        // Configurar botones
        btnVolver.setOnClickListener {
            finish() // Volver a la pantalla anterior
        }

        btnEnviarSolicitud.setOnClickListener {
            if (validarFormulario()) {
                val intent = Intent(this, SolicitudExitosaActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun mostrarSelectorFecha() {
        val calendario = Calendar.getInstance()
        val año = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        // Toma la información enviada por el usuario
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, monthOfYear, dayOfMonth ->
                // El mes va de 0 a 11, por lo que sumamos 1
                val fechaSeleccionada = "${dayOfMonth}/${monthOfYear + 1}/${year}"
                etFecha.setText(fechaSeleccionada)
            },
            año, mes, dia
        )

        // Establecer fecha mínima como hoy
        datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000
        // El metodo show es el que hace que se vea el calendario en la UI
        datePickerDialog.show()
    }

    private fun calcularTotal() {
        val horas = etHoras.text.toString().toIntOrNull() ?: 0
        val total = horas * precioHora
        // Convierte el formato de la modena a colombiana
        val formato = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
        tvTotal.text = formato.format(total)
    }

    private fun validarFormulario(): Boolean {
        when {
            etHoras.text.toString().isEmpty() -> {
                Toast.makeText(this, "Por favor, ingrese la cantidad de horas", Toast.LENGTH_SHORT).show()
                return false
            }
            etHoras.text.toString().toIntOrNull() ?: 0 <= 0 -> {
                Toast.makeText(this, "La cantidad de horas debe ser mayor a 0", Toast.LENGTH_SHORT).show()
                return false
            }
            etFecha.text.toString().isEmpty() -> {
                Toast.makeText(this, "Por favor, seleccione una fecha", Toast.LENGTH_SHORT).show()
                return false
            }
            etDescripcion.text.toString().isEmpty() -> {
                Toast.makeText(this, "Por favor, describa el problema", Toast.LENGTH_SHORT).show()
                return false
            }
            else -> return true
        }
    }
}