package com.example.proclean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class ServiciosPreferidosActivity : AppCompatActivity() {
    private lateinit var btnSiguiente: Button
    private lateinit var btnOmitir: Button
    private lateinit var checkBoxes: List<CheckBox>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios_preferidos)

        initViews()
        setupCheckBoxes()
        setupListeners()
    }

    private fun initViews() {
        btnSiguiente = findViewById(R.id.btn_siguiente)
        btnOmitir = findViewById(R.id.btn_omitir)
        btnSiguiente.isEnabled = false
    }

    private fun setupCheckBoxes() {
        val chkPlomeria = findViewById<CheckBox>(R.id.chk_plomeria)
        val chkLimpieza = findViewById<CheckBox>(R.id.chk_limpieza)
        val chkCerrajeria = findViewById<CheckBox>(R.id.chk_cerrajeria)
        val chkMecanica = findViewById<CheckBox>(R.id.chk_mecanica)
        val chkFletes = findViewById<CheckBox>(R.id.chk_fletes)

        chkPlomeria.text = "Servicios de plomería y electricidad"
        chkLimpieza.text = "Servicios de limpieza a domicilio"
        chkCerrajeria.text = "Servicios de cerrajería"
        chkMecanica.text = "Servicios de mecánica y asistencia vehicular"
        chkFletes.text = "Fletes, mudanzas y transporte de muebles (opcional)"

        checkBoxes = listOf(chkPlomeria, chkLimpieza, chkCerrajeria, chkMecanica, chkFletes)
    }

    private fun setupListeners() {
        checkBoxes.forEach { checkBox ->
            checkBox.setOnCheckedChangeListener { _, _ ->
                updateButtonState()
            }
        }

        btnSiguiente.setOnClickListener {
            val serviciosSeleccionados = getSelectedServices()
            irAPrincipalCliente()

        }

        btnOmitir.setOnClickListener {
            // Si el usuario omite, simplemente navegamos a la pantalla principal
            irAPrincipalCliente()
        }
    }

    private fun updateButtonState() {
        btnSiguiente.isEnabled = checkBoxes.any { it.isChecked }
    }

    private fun getSelectedServices(): List<String> {
        return checkBoxes
            .filter { it.isChecked }
            .map { it.text.toString() }
    }

    private fun irAPrincipalCliente() {
        val intent = Intent(this, PrincipalClienteActivity::class.java)
        startActivity(intent)
        finish() // Esto cierra la actividad actual para que el usuario no pueda volver atrás con el botón de retroceso
    }
}