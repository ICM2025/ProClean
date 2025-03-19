package com.example.proclean

import android.graphics.Color
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

class HistorialServiciosAdapter(
    private var servicios: List<HistorialServicio>,
    private val onItemClick: (HistorialServicio) -> Unit
) : RecyclerView.Adapter<HistorialServiciosAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombreProfesional: TextView = itemView.findViewById(R.id.tvNombreProfesional)
        val tvTipoServicio: TextView = itemView.findViewById(R.id.tvTipoServicio)
        val tvFechaServicio: TextView = itemView.findViewById(R.id.tvFechaServicio)
        val tvDuracionServicio: TextView = itemView.findViewById(R.id.tvDuracionServicio)
        val tvCostoServicio: TextView = itemView.findViewById(R.id.tvCostoServicio)
        val tvEstadoServicio: TextView = itemView.findViewById(R.id.tvEstadoServicio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_historial, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val servicio = servicios[position]

        holder.tvNombreProfesional.text = servicio.nombreProfesional
        holder.tvTipoServicio.text = servicio.tipoServicio
        holder.tvFechaServicio.text = servicio.fecha
        holder.tvDuracionServicio.text = "Duración: ${servicio.duracion} horas"

        val formato = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
        holder.tvCostoServicio.text = formato.format(servicio.costo)

        when (servicio.estado) {
            EstadoServicio.COMPLETADO -> {
                holder.tvEstadoServicio.text = "Completado"
                holder.tvEstadoServicio.setBackgroundColor(Color.parseColor("#4CAF50")) // Verde
            }
            EstadoServicio.CANCELADO -> {
                holder.tvEstadoServicio.text = "Cancelado"
                holder.tvEstadoServicio.setBackgroundColor(Color.parseColor("#F44336")) // Rojo
            }
            EstadoServicio.EN_PROCESO -> {
                holder.tvEstadoServicio.text = "En proceso"
                holder.tvEstadoServicio.setBackgroundColor(Color.parseColor("#2196F3")) // Azul
            }
        }

        // Configurar un único onClick listener
        holder.itemView.setOnClickListener {
            if (servicio.estado == EstadoServicio.EN_PROCESO) {
                // Navegación a detalles para servicios en proceso
                val intent = Intent(holder.itemView.context, DetalleServicioProgresoActivity::class.java)
                intent.putExtra("ID", servicio.id)
                intent.putExtra("NOMBRE_CLIENTE", servicio.nombreProfesional)
                intent.putExtra("TIPO_SERVICIO", servicio.tipoServicio)
                intent.putExtra("FECHA", servicio.fecha)
                intent.putExtra("DURACION", servicio.duracion)
                intent.putExtra("PRECIO", servicio.costo)
                intent.putExtra("DIRECCION", "Calle Principal #123, Bogotá")
                intent.putExtra("DESCRIPCION", "Reparación de tubería con fuga en el baño principal y revisión del sistema eléctrico de la cocina.")
                holder.itemView.context.startActivity(intent)
            } else {
                // Callback general para otros estados
                onItemClick(servicio)
            }
        }
    }

    override fun getItemCount(): Int = servicios.size

    fun actualizarDatos(nuevaLista: List<HistorialServicio>) {
        servicios = nuevaLista
        notifyDataSetChanged()
    }
}