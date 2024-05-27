package com.mycompany.proyecto_final_fabricatrajes;

// Clase MangaException que extiende de Exception
public class MangaException extends Exception {
    // Constructor que recibe un mensaje de error
    public MangaException(String message) {
        // Llama al constructor de la clase padre (Exception) con el mensaje
        super(message);
    }
}
