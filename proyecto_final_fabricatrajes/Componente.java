package com.mycompany.proyecto_final_fabricatrajes;

// Clase abstracta Componente que implementa la interfaz Comparable
public abstract class Componente implements Comparable<Componente> {
    // Variables de instancia protegidas
    protected int id;
    protected String nombre;
    protected String talla;
    protected String color;
    protected boolean esComunitario;
    protected double precio;

    // Constructor de la clase Componente
    public Componente(int id, String nombre, String talla, String color, boolean esComunitario, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.esComunitario = esComunitario;
        this.precio = precio;
    }

    // Métodos getter y setter
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTalla() {
        return talla;
    }

    public String getColor() {
        return color;
    }

    public boolean isEsComunitario() {
        return esComunitario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEsComunitario(boolean esComunitario) {
        this.esComunitario = esComunitario;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método toString para representar el objeto Componente como una cadena de texto
    @Override
    public String toString() {
        return "Componente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", talla='" + talla + '\'' +
                ", color='" + color + '\'' +
                ", esComunitario=" + esComunitario +
                ", precio=" + precio +
                '}';
    }

    // Método equals para comparar dos objetos Componente por su id
    @Override
public boolean equals(Object o) {
    // Verifica si el objeto actual y el objeto pasado como argumento son el mismo objeto
    if (this == o) return true;
    // Verifica si el objeto pasado como argumento es nulo o si no es de la misma clase
    if (o == null || getClass() != o.getClass()) return false;
    // Convierte el objeto pasado como argumento a un objeto de tipo Componente
    Componente that = (Componente) o;
    // Compara el id del objeto actual con el id del objeto pasado como argumento
    return id == that.id;
}

    // Método compareTo para comparar dos objetos Componente por su id 
//El método compareTo se utiliza para definir el orden natural de los objetos de la clase Componente. 
//Implementa la interfaz Comparable<Componente> y permite comparar dos objetos basándose en el id.
    @Override
    public int compareTo(Componente o) {
        return Integer.compare(this.id, o.id);
    }
}
