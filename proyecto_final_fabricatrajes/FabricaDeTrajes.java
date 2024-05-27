
package com.mycompany.proyecto_final_fabricatrajes;

import java.util.*;

public class FabricaDeTrajes implements IFabricaDeTrajes {
    private ArrayList<Componente> componentesEnAlmacen;
    private TreeSet<Traje> trajesEnAlmacen;
    private boolean sonRebajas = false;

    public FabricaDeTrajes() {
        this.componentesEnAlmacen = new ArrayList<>();
        this.trajesEnAlmacen = new TreeSet<>(Comparator.comparing(Traje::getNombre));
    }

  @Override
    public void añadirComponenteAAlmacen() {
        Scanner scanner = new Scanner(System.in);
          // Solicitar datos del componente
        try {
            System.out.println("Seleccione el tipo de componente:");
            System.out.println("1. Falda");
            System.out.println("2. Chaqueta");
            System.out.println("3. Pantalón");
            System.out.println("4. Blusa");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Ingrese el ID del componente: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            // Validar si el id ya existe
            for (Componente c : componentesEnAlmacen) {
                if (c.getId() == id) {
                    throw new IdException("El ID del componente ya existe.");
                }
            }

            System.out.print("Ingrese el nombre del componente: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la talla del componente: ");
            String talla = scanner.nextLine();

            System.out.print("Ingrese el color del componente: ");
            String color = scanner.nextLine();

            System.out.print("Es comunitario (true/false): ");
            boolean esComunitario = scanner.nextBoolean();

            System.out.print("Ingrese el precio base del componente: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            // Validar porcentaje de componentes extracomunitarios
            int extracomunitarios = 0;
            for (Componente c : componentesEnAlmacen) {
                if (!c.isEsComunitario()) {
                    extracomunitarios++;
                }
            }
            if (!esComunitario && extracomunitarios >= componentesEnAlmacen.size() / 2) {
                throw new MuchoExtracomunitarioException("No se puede añadir más de 50% de componentes extracomunitarios.");
            }

            Componente nuevoComponente = null;
            switch (tipo) {
                case 1: // falda
                    System.out.print("Tiene cremallera (true/false): ");
                    // Verificar existencia de blusa de manga corta o larga del mismo color
                    boolean conCremalleraFalda = scanner.nextBoolean();
                    nuevoComponente = new Falda(id, nombre, talla, color, esComunitario, precio, conCremalleraFalda);
                    break;
                case 2: // Chaqueta
                    System.out.print("Número de botones: ");
                    int numBotones = scanner.nextInt();
                    nuevoComponente = new Chaqueta(id, nombre, talla, color, esComunitario, precio, numBotones);
                    break;
                case 3:  // Chaqueta
                    System.out.print("Tiene cremallera (true/false): ");
                    boolean conCremalleraPantalon = scanner.nextBoolean();
                    nuevoComponente = new Pantalon(id, nombre, talla, color, esComunitario, precio, conCremalleraPantalon);
                    break;
                case 4: // // blusa
                System.out.print("¿Es manga larga? (true/false): ");
                boolean mangaLarga = scanner.nextBoolean();
                
                // Verificar existencia de blusa del mismo color
                boolean existeBlusaMismoColor = componentesEnAlmacen.stream()
                        .anyMatch(c -> c instanceof Blusa && c.getColor().equals(color));
                
                if (existeBlusaMismoColor) {
                    // Verificar si hay una blusa del mismo color con la manga contraria
                    boolean existeMangaContraria = componentesEnAlmacen.stream()
                            .anyMatch(c -> c instanceof Blusa && c.getColor().equals(color) && ((Blusa) c).isMangaLarga() != mangaLarga);
                    
                    if (!existeMangaContraria) {
                        throw new MangaException("Debe existir una blusa del mismo color con la manga contraria.");
                    }
                }

                nuevoComponente = new Blusa(id, nombre, talla, color, esComunitario, precio, mangaLarga);
                break;
            }
       

            // Agregar el componente al almacén
            componentesEnAlmacen.add(nuevoComponente);
            System.out.println("Componente añadido correctamente.");

        } catch (IdException | MuchoExtracomunitarioException | MangaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    @Override
    public void listarComponentes() {
        System.out.println("Componentes en almacén:");
        for (Componente c : componentesEnAlmacen) {
            System.out.println(c);
        }
    }

   @Override
public void añadirTrajeAAlmacen() {
    Scanner scanner = new Scanner(System.in);

    try {
        // Listar las blusas disponibles y solicitar la elección del usuario
        System.out.println("Blusas disponibles:");
        for (Componente c : componentesEnAlmacen) {
            if (c instanceof Blusa) {
                System.out.println(c.getId() + ": " + c);
            }
        }
        System.out.print("Seleccione una blusa por ID: ");
        int blusaId = scanner.nextInt();
        Componente blusa = componentesEnAlmacen.stream()
                .filter(c -> c.getId() == blusaId && c instanceof Blusa)
                .findFirst()
                .orElseThrow(() -> new Exception("Blusa no encontrada"));

        // Listar las chaquetas disponibles y solicitar la elección del usuario
        System.out.println("Chaquetas disponibles:");
        for (Componente c : componentesEnAlmacen) {
            if (c instanceof Chaqueta) {
                System.out.println(c.getId() + ": " + c);
            }
        }
        //instanceof es un operador en Java que se utiliza para comprobar si un objeto es una instancia de una clase o subclase.
        // entonces el uso es si es una expresión booleana y devuelve true si el objeto pertenece a la clase especificada, de lo contrario devuelve false.
        System.out.print("Seleccione una chaqueta por ID: ");
        int chaquetaId = scanner.nextInt();
        Componente chaqueta = componentesEnAlmacen.stream()
                //filter es un método de la interfaz Stream  que se utiliza para filtrar elementos de un flujo
                // es decir que  define la condición de filtrado de chaqueta y devuelve un nuevo flujo que contiene solo los elementos que cumplen esa condición.
                .filter(c -> c.getId() == chaquetaId && c instanceof Chaqueta)
                //findFirst es un método de la interfaz Stream  que se utiliza para encontrar el primer elemento en un flujo que cumple una condición específica.
                //entonces devuelve un Optional que contiene el primer elemento encontrado o está vacío si no se encuentra.
                .findFirst()
                //orElseThrow es un método de la clase Optional, Se utiliza para 
                //manejar situaciones donde no se encuentra un valor y se desea lanzar una excepción en lugar de manejar un valor nulo.
                .orElseThrow(() -> new Exception("Chaqueta no encontrada"));

        // Listar las faldas y pantalones disponibles y solicitar la elección del usuario
        System.out.println("Faldas y pantalones disponibles:");
        for (Componente c : componentesEnAlmacen) {
            if (c instanceof Falda || c instanceof Pantalon) {
                System.out.println(c.getId() + ": " + c);
            }
        }
        System.out.print("Seleccione una falda o un pantalón por ID: ");
        int parteInferiorId = scanner.nextInt();
        Componente parteInferior = componentesEnAlmacen.stream()
                .filter(c -> c.getId() == parteInferiorId && (c instanceof Falda || c instanceof Pantalon))
                .findFirst()
                .orElseThrow(() -> new Exception("Falda o pantalón no encontrado"));

        // Verificar que todos los componentes sean del mismo color o colores amigos
        if (!blusa.getColor().equals(chaqueta.getColor()) || !blusa.getColor().equals(parteInferior.getColor())) {
            throw new ColoresException("Los componentes no son del mismo color o colores amigos.");
        }

        // Verificar que todos los componentes sean de la misma talla (excepto la falda)
        if (!blusa.getTalla().equals(chaqueta.getTalla()) || !blusa.getTalla().equals(parteInferior.getTalla())) {
            throw new TallaException("Los componentes no son de la misma talla.");
        }

        // Solicitar el nombre del traje y verificar que no exista
        scanner.nextLine();  // Limpiar el buffer
        System.out.print("Ingrese el nombre del traje: ");
        String nombreTraje = scanner.nextLine();
        for (Traje t : trajesEnAlmacen) {
            if (t.getNombre().equals(nombreTraje)) {
                throw new TrajeYaExisteException("El nombre del traje ya existe en el almacén.");
            }
        }

        // Crear el traje y añadirlo al almacén
        Traje traje = new Traje(nombreTraje);
        trajesEnAlmacen.add(traje);
        traje.addComponente(blusa);
        traje.addComponente(chaqueta);
        traje.addComponente(parteInferior);

        // Eliminar los componentes utilizados del almacén
        componentesEnAlmacen.remove(blusa);
        componentesEnAlmacen.remove(chaqueta);
        componentesEnAlmacen.remove(parteInferior);

        System.out.println("Traje añadido al almacén con éxito.");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}


        // forma para listar los trajes

   // Método para listar los trajes disponibles en el almacén
    @Override
    public void listarTrajes() {
        if (trajesEnAlmacen.isEmpty()) { // comprobamos que esta vacio
            System.out.println("No hay trajes en el almacén."); // Mensaje si no hay trajes
        } else {
            for (Traje traje : trajesEnAlmacen) {
                System.out.println(traje); // Imprimir cada traje
            }
        }
    }

        // Método para activar o desactivar las rebajas
    @Override
    public void activarDesactivarRebajas() {
        sonRebajas = !sonRebajas; // Cambiar el estado de las rebajas
        String estado = sonRebajas ? "activadas" : "desactivadas"; // Determinar el estado actual
        System.out.println("Las rebajas han sido " + estado); // Informar del cambio de estado
    }

 @Override
public void crearEnvio() {
    Scanner scanner = new Scanner(System.in);
    List<Traje> envio = new ArrayList<>();

    try {
        while (true) {
            // Listar los trajes disponibles y solicitar la elección del usuario
            System.out.println("Trajes disponibles:");
            for (Traje t : trajesEnAlmacen) {
                System.out.println(t.getNombre());
            }
            System.out.print("Seleccione un traje por nombre (o escriba 'fin' para terminar): ");
            String nombreTraje = scanner.nextLine();

            if (nombreTraje.equalsIgnoreCase("fin")) {
                break;
            }

            Traje traje = trajesEnAlmacen.stream()
                    .filter(t -> t.getNombre().equals(nombreTraje))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Traje no encontrado"));

            // Añadir el traje al envío y eliminarlo del almacén
            envio.add(traje);
            trajesEnAlmacen.remove(traje);
        }

        // Mostrar los trajes añadidos al envío
        System.out.println("Envío creado con los siguientes trajes:");
        for (Traje t : envio) {
            System.out.println(t);
        }

        // Lógica adicional para procesar el envío (por ejemplo, guardar en base de datos, generar factura, etc.)

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

    // Método que presenta un menú interactivo al usuario
    public void escribirMenu() {
        Scanner scanner = new Scanner(System.in); // Scanner para leer datos del usuario
        int opcion; // Variable para almacenar la opción seleccionada

        // Bucle do-while para mostrar el menú hasta que el usuario elija salir
        do {
            // Mostrar opciones del menú
            System.out.println("\nMENU FABRICA TRAJES");
            System.out.println("1.- Añadir Componente a almacén");
            System.out.println("2.- Listar Componentes del almacén");
            System.out.println("3.- Crear traje y añadir a almacén");
            System.out.println("4.- Listar trajes del almacén");
            System.out.println("7.- Activar/Desactivar las rebajas");
            System.out.println("8.- Crear envío");
            System.out.println("9.- Crear componentes de prueba");
            System.out.println("0.- Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt(); // Leer la opción seleccionada
            scanner.nextLine();  // Limpiar el buffer

            // Ejecutar acción basada en la opción seleccionada
            switch (opcion) {
                case 1:
                    añadirComponenteAAlmacen(); // Añadir un componente al almacén
                    break;
                case 2:
                    listarComponentes(); // Listar los componentes del almacén
                    break;
                case 3:
                    añadirTrajeAAlmacen(); // Crear un traje y añadirlo al almacén
                    break;
                case 4:
                    listarTrajes(); // Listar los trajes del almacén
                    break;
                case 7:
                    activarDesactivarRebajas(); // Activar o desactivar las rebajas
                    break;
                case 8:
                    crearEnvio(); // Crear un envío
                    break;
                case 9:
                    crearComponentesDePrueba(); // Crear componentes de prueba
                    break;
                case 0:
                    System.out.println("Saliendo del programa."); // Salir del programa
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo."); // Opción no válida
                    break;
            }
        } while (opcion != 0); // Repetir hasta que el usuario elija salir
    }

    // Método para crear componentes de prueba y añadirlos al almacén
    public void crearComponentesDePrueba() {
        try {
            // Añadir varios componentes de prueba al almacén
            componentesEnAlmacen.add(new Falda(1, "Falda1", "M", "negro", true, 10.0, true));
            componentesEnAlmacen.add(new Falda(2, "Falda2", "S", "amarillo", true, 20.0, true));
            componentesEnAlmacen.add(new Chaqueta(3, "Chaqueta1", "M", "negro", true, 20.0, 8));
            componentesEnAlmacen.add(new Chaqueta(4, "Chaqueta2", "S", "amarillo", true, 30.0, 5));
            componentesEnAlmacen.add(new Pantalon(5, "Pantalon1", "M", "negro", true, 15.0, false));
            componentesEnAlmacen.add(new Pantalon(6, "Pantalon2", "S", "amarillo", true, 25.0, true));
            componentesEnAlmacen.add(new Blusa(7, "Blusa1", "M", "negro", true, 12.0, true));
            componentesEnAlmacen.add(new Blusa(8, "Blusa2", "S", "amarillo", true, 24.0, false));
            
            System.out.println("Componentes de prueba creados correctamente."); // Mensaje de éxito
        } catch (Exception e) {
            // Manejar cualquier excepción
            System.out.println("Error al crear componentes de prueba: " + e.getMessage());
        }
    }

    // Método main para iniciar la aplicación
    public static void main(String[] args) {
        FabricaDeTrajes fabrica = new FabricaDeTrajes(); // Crear una instancia de FabricaDeTrajes
        fabrica.escribirMenu(); // Llamar al método para mostrar el menú
    }
}