package com.mycompany.proyecto_final_fabricatrajes;

// Interface IFabricaDeTrajes que define los métodos que deben implementar las clases que la utilicen
public interface IFabricaDeTrajes {
    // Método para añadir un componente al almacén
    void añadirComponenteAAlmacen();

    // Método para listar todos los componentes en el almacén
    void listarComponentes();

    // Método para añadir un traje al almacén
    void añadirTrajeAAlmacen();

    // Método para listar todos los trajes en el almacén
    void listarTrajes();

    // Método para activar o desactivar las rebajas
    void activarDesactivarRebajas();

    // Método para crear un envío
    void crearEnvio();
}
