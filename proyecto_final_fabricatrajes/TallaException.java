package com.mycompany.proyecto_final_fabricatrajes;

// Clase TallaException que extiende de Exception
public class TallaException extends Exception {
    // Constructor que recibe un mensaje de error
    public TallaException(String message) {
        // Llama al constructor de la clase padre (Exception) con el mensaje
        super(message);
    }
}
