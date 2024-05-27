package com.mycompany.proyecto_final_fabricatrajes;

// Clase Chaqueta que extiende de la clase Componente
public class Chaqueta extends Componente {
    // Variable que indica el número de botones de la chaqueta
    private int numBotones;

    // Constructor de la clase Chaqueta
    public Chaqueta(int id, String nombre, String talla, String color, boolean esComunitario, double precio, int numBotones) {
        // Llamada al constructor de la clase padre (Componente)
        super(id, nombre, talla, color, esComunitario, precio);
        // Inicialización de la variable numBotones
        this.numBotones = numBotones;
        // Ajuste del precio basado en el número de botones
        this.precio += 2 * numBotones;
    }

    // Método para obtener el número de botones
    public int getNumBotones() {
        return numBotones;
    }

    // Método para establecer el número de botones
    public void setNumBotones(int numBotones) {
        this.numBotones = numBotones;
        // Ajuste del precio basado en el nuevo número de botones
        this.precio += 2 * numBotones;
    }

    // Método toString para representar el objeto Chaqueta como una cadena de texto
    @Override
    public String toString() {
        return "Chaqueta{" +
                super.toString() + // Llamada al método toString de la clase padre
                ", numBotones=" + numBotones +
                '}';
    }
}
