package com.mycompany.proyecto_final_fabricatrajes;

// Clase Blusa que extiende de la clase Componente
public class Blusa extends Componente {
    // Variable que indica si la blusa es de manga larga
    private boolean mangaLarga;

    // Constructor de la clase Blusa
    public Blusa(int id, String nombre, String talla, String color, boolean esComunitario, double precio, boolean mangaLarga) {
        // Llamada al constructor de la clase padre (Componente)
        super(id, nombre, talla, color, esComunitario, precio);
        // Inicialización de la variable mangaLarga
        this.mangaLarga = mangaLarga;
    }

    // Método para obtener el valor de mangaLarga
    public boolean isMangaLarga() {
        return mangaLarga;
    }

    // Método para establecer el valor de mangaLarga
    public void setMangaLarga(boolean mangaLarga) {
        this.mangaLarga = mangaLarga;
    }

    // Método toString para representar el objeto Blusa como una cadena de texto
    @Override
    public String toString() {
        return "Blusa{" +
                super.toString() + // Llamada al método toString de la clase padre
                ", mangaLarga=" + (mangaLarga ? "Sí" : "No") + // Inclusión del estado de mangaLarga en la cadena de texto
                '}';
    }
}
