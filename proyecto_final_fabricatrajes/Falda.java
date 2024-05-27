package com.mycompany.proyecto_final_fabricatrajes;

// Clase Falda que extiende de la clase Componente
public class Falda extends Componente {
    // Variable que indica si la falda tiene cremallera
    private boolean conCremallera;

    // Constructor de la clase Falda
    public Falda(int id, String nombre, String talla, String color, boolean esComunitario, double precio, boolean conCremallera) {
        // Llamada al constructor de la clase padre (Componente)
        super(id, nombre, talla, color, esComunitario, precio);
        // Inicialización de la variable conCremallera
        this.conCremallera = conCremallera;
        // Ajuste del precio si la falda tiene cremallera
        if (conCremallera) {
            this.precio += 1;
        }
    }

    // Método para obtener si la falda tiene cremallera
    public boolean isConCremallera() {
        return conCremallera;
    }

    // Método para establecer si la falda tiene cremallera
    public void setConCremallera(boolean conCremallera) {
        this.conCremallera = conCremallera;
    }

    // Método toString para representar el objeto Falda como una cadena de texto
    @Override
    public String toString() {
        return "Falda{" +
                super.toString() + // Llamada al método toString de la clase padre
                ", conCremallera=" + (conCremallera ? "Sí" : "No") +
                '}';
    }
}
