package com.mycompany.proyecto_final_fabricatrajes;

// Clase TrajeYaExisteException que extiende de Exception
public class TrajeYaExisteException extends Exception {
    // Constructor que recibe un mensaje de error
    public TrajeYaExisteException(String message) {
        // Llama al constructor de la clase padre (Exception) con el mensaje
        super(message);
    }
}
