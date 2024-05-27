package com.mycompany.proyecto_final_fabricatrajes;

import java.util.ArrayList;

// Clase Traje que contiene una colección de componentes
public class Traje {
    // Lista de componentes que forman el traje
    private ArrayList<Componente> piezas;
    // Nombre del traje
    private String nombre;

    // Constructor de la clase Traje
    public Traje(String nombre) {
        // Inicialización de la lista de componentes
        this.piezas = new ArrayList<>();
        // Asignación del nombre del traje
        this.nombre = nombre;
    }

    // Método para añadir un componente a la lista de piezas
    public void addComponente(Componente componente) {
        this.piezas.add(componente);
    }

    // Método para obtener la lista de piezas del traje
    public ArrayList<Componente> getPiezas() {
        return piezas;
    }

    // Método para establecer la lista de piezas del traje
    public void setPiezas(ArrayList<Componente> piezas) {
        this.piezas = piezas;
    }

    // Método para obtener el nombre del traje
    public String getNombre() {
        return nombre;
    }

    // Método para establecer el nombre del traje
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método toString para representar el objeto Traje como una cadena de texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Agrega el nombre del traje al StringBuilder
        sb.append("Traje: ").append(nombre).append("\n");

        // Recorre y agrega cada componente del traje al StringBuilder
        for (Componente pieza : piezas) {
            sb.append(pieza).append("\n");
        }

        // Devuelve la representación en cadena del traje
        return sb.toString();
    }
}
