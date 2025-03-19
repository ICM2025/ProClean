package com.example.proclean

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.content.Intent
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PrincipalClienteActivity : AppCompatActivity() {

    // Modelo de datos para profesionales
    data class Profesional(
        val nombre: String,
        val destacado: Boolean,
        val categoria: String
    )

    private lateinit var rvProfesionales: RecyclerView
    private lateinit var btnVerCercanos: Button
    private lateinit var btnMenu: ImageButton
    private lateinit var categorias: List<LinearLayout>
    private var categoriaSeleccionada: String = "Plomería" // Categoría por defecto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_cliente)

        // Inicializar vistas
        rvProfesionales = findViewById(R.id.rvProfesionales)
        btnVerCercanos = findViewById(R.id.btnVerCercanos)
        btnMenu = findViewById(R.id.btnMenu)


        btnMenu.setOnClickListener {
            val intent = Intent(this, MenuClienteActivity::class.java)
            startActivity(intent)
        }

        // Obtener categorías
        categorias = listOf(
            findViewById(R.id.categoryPlomeria),
            findViewById(R.id.categoryLimpieza),
            findViewById(R.id.categoryCerrajeria),
            findViewById(R.id.categoryMecanica),
            findViewById(R.id.categoryFletes)
        )

        // Configurar categorías
        val categoriasNombres = listOf("Plomería", "Limpieza", "Cerrajería", "Mecánica", "Fletes")
        categorias.forEachIndexed { index, categoria ->
            categoria.setOnClickListener {
                categoriaSeleccionada = categoriasNombres[index]
                btnVerCercanos.visibility = if (categoriaSeleccionada == "Limpieza") View.GONE else View.VISIBLE

                // Filtrar profesionales según categoría
                val profesionalesFiltrados = obtenerProfesionales().filter {
                    it.categoria == categoriaSeleccionada
                }
                (rvProfesionales.adapter as SimpleProfesionalAdapter).actualizarDatos(profesionalesFiltrados)
            }
        }

        // Configurar RecyclerView, en esto se mostrara los items de profesional
        rvProfesionales.layoutManager = LinearLayoutManager(this)
        rvProfesionales.adapter = SimpleProfesionalAdapter(
            obtenerProfesionales().filter { it.categoria == "Plomería" }
        )


        // Solo muestra los profesionales con profesion de plomeria
        // Mostrar el botón "Ver cercanos" por defecto
        btnVerCercanos.visibility = View.VISIBLE

        // Marcar Plomería como seleccionada por defecto
        categorias[0].isSelected = true

        // Configurar acción del botón Ver cercanos
        btnVerCercanos.setOnClickListener {
            val intent = Intent(this, VerCercanosActivity::class.java)
            startActivity(intent)
        }
    }

    // Adaptador integrado en la actividad pero usando un modelo de datos
    inner class SimpleProfesionalAdapter(
        private var profesionales: List<Profesional>
    ) : RecyclerView.Adapter<SimpleProfesionalAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                // Infla la vista de ViewHolder con el modelo de item, infla significa rellena
                .inflate(R.layout.item_profesional, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val profesional = profesionales[position]

            holder.tvNombre.text = profesional.nombre
            holder.tvRating.text = (4.0 + (Math.random() * 1.0)).toString().substring(0, 3)
            holder.tvDistancia.text = "${(1 + (Math.random() * 5.0)).toString().substring(0, 3)} kilómetros de distancia"
            holder.tvPrecio.text = "$${30000 + (Math.random() * 30000).toInt()} por hora"

            holder.tagFavorite.visibility = if (profesional.destacado) View.VISIBLE else View.GONE

            // Añadir listener para redirigir al detalle del profesional
            holder.itemView.setOnClickListener {
                val intent = Intent(this@PrincipalClienteActivity, DetalleProfesionalActivity::class.java)
                // Pasar información del profesional
                intent.putExtra("NOMBRE", profesional.nombre)
                intent.putExtra("CATEGORIA", profesional.categoria)
                intent.putExtra("DESTACADO", profesional.destacado)
                intent.putExtra("RATING", holder.tvRating.text.toString())
                intent.putExtra("DISTANCIA", holder.tvDistancia.text.toString())
                intent.putExtra("PRECIO", holder.tvPrecio.text.toString())
                startActivity(intent)
            }
        }

        override fun getItemCount(): Int = profesionales.size

        fun actualizarDatos(nuevaLista: List<Profesional>) {
            profesionales = nuevaLista
            // Hace que el RecyclerView se redibuje
            notifyDataSetChanged()
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
            val tvRating: TextView = itemView.findViewById(R.id.tvRating)
            val tvDistancia: TextView = itemView.findViewById(R.id.tvDistancia)
            val tvPrecio: TextView = itemView.findViewById(R.id.tvPrecio)
            val tagFavorite: LinearLayout = itemView.findViewById(R.id.tagFavorite)
        }
    }

    // Datos de ejemplo usando la clase de datos Profesional
    private fun obtenerProfesionales(): List<Profesional> {
        return listOf(
            Profesional("Carlos Ramírez", true, "Plomería"),
            Profesional("Ana Gutiérrez", false, "Limpieza"),
            Profesional("Jorge Mendoza", true, "Cerrajería"),
            Profesional("María López", false, "Limpieza"),
            Profesional("Roberto Sánchez", true, "Mecánica"),
            Profesional("Laura Hernández", false, "Limpieza"),
            Profesional("Javier Torres", true, "Fletes"),
            Profesional("Patricia Núñez", false, "Plomería")
        )
    }
}