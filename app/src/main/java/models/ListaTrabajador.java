package models;

import java.util.List;

import java.util.ArrayList;

public class ListaTrabajador {
    private static ListaTrabajador instancia;
    private List<Trabajador> trabajadores;

    // Constructor privado para evitar instanciación externa
    private ListaTrabajador() {
        trabajadores = new ArrayList<>();
    }

    // Método estático para obtener la única instancia (Singleton)
    public static ListaTrabajador getInstance() {
        if (instancia == null) {
            instancia = new ListaTrabajador();
        }
        return instancia;
    }

    // Método para agregar un trabajador a la lista
    public void agregarTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    // Método para obtener la lista de trabajadores
    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    // Método para buscar un trabajador por nombre (opcional)
    public Trabajador buscarPorNombre(String nombre) {
        for (Trabajador t : trabajadores) {
            if (t.getPrimer_nombre().equalsIgnoreCase(nombre)) {
                return t;
            }
        }
        return null;
    }

    // Método para limpiar la lista (opcional)
    public void limpiarLista() {
        trabajadores.clear();
    }
}
