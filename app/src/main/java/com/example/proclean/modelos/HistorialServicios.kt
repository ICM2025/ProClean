package com.example.proclean

data class HistorialServicio(
    val id: String,
    val nombreProfesional: String,
    val tipoServicio: String,
    val fecha: String,
    val duracion: Int,
    val costo: Int,
    val estado: EstadoServicio
)

enum class EstadoServicio {
    COMPLETADO, CANCELADO, EN_PROCESO
}