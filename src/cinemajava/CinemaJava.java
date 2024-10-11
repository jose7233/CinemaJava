package cinemajava;
import Peliculas.*;
import Asientos.Matriz;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaJava {

    public static void main(String[] args) {
        Pelicula pelicula = new Pelicula("la bella y la bestia", 120, 15, "Aroldo", 5000);

        //datos de la pelicula
        System.out.println();
        System.out.println("Bienvenidos a cinema Java ");
        System.out.println();
        System.out.println("nombre de la pelicula: " + pelicula.getTitulo());
        System.out.println("la edad minima es: " + pelicula.getEdadMinima());
        System.out.println("la duracion es: " + pelicula.getDuracion());
        System.out.println("el director es: " + pelicula.getDirector());
        System.out.println("el costo de la pelicula es: " + pelicula.getCosto());
        System.out.println();


        Scanner sc = new Scanner(System.in);
        Matriz matriz = new Matriz();
        List<String> asientosComprados = new ArrayList<>();

        //datos de la persona


        boolean inc = true;
        mainloop:

        while (inc) {

            for (int i = 0; i < matriz.getNombres().length; i++) {
                for (int j = 0; j < matriz.getNombres()[i].length; j++) {
                    System.out.println(" ");
                    System.out.println("ingresa los siguientes datos para comprar la boleta");
                    System.out.println(" ");

                    System.out.println("ingrese su nombre:");
                    String nombre = sc.next();

                    System.out.println(" ");

                    System.out.println("ingrese su edad:");
                    int edad = sc.nextInt();


                    if (edad < pelicula.getEdadMinima()) {
                        System.out.println("no puedes ingresar");
                        inc = false;
                        break;
                    }
                    System.out.println("cantidad de dinero");
                    int cantidad = sc.nextInt();
                    if (cantidad < pelicula.getCosto()) {

                        System.out.println("no puedes ingresar");
                        inc = false;
                        break;
                    }

                    //menu
                    int opcion;

                    System.out.println("\nComprar boletas");
                    System.out.println("1. Sí");
                    System.out.println("2. Salir");
                    System.out.print("Selecciona una opción: ");
                    opcion = sc.nextInt();
                    boolean pdf = true;
                    while (pdf) {
                        switch (opcion) {
                            case 1:

                                System.out.println();
                                System.out.println("¿Quieres asignar este asiento? " + matriz.getNombres()[i][j] + " ");
                                System.out.println("1. Si" + "\n" + "2. No");
                                int asiento = sc.nextInt();

                                if (asiento == 1) {
                                    asientosComprados.add(matriz.getNombres()[i][j]);
                                    System.out.println("Asiento comprado correctamente");
                                    //esto suma una columna y si la columna J llega al borde de la matriz, va a sumar una fila y la columna vuelve a cer cero
                                    j++;
                                    if(j >= matriz.getNombres().length) {
                                        i++;
                                        j=0;
                                    }
                                    // y si tanto columna como fila, llegan al borde, ambas vuelven a ser cero, haciendo que el recorrido se reinicie
                                    if(i >= matriz.getNombres().length) {
                                        i = 0;
                                        j=0;
                                    }
                                } else if (asiento == 2) {

                                    System.out.println("nombre de la pelicula: " + pelicula.getTitulo());
                                    System.out.println("la edad minima es: " + pelicula.getEdadMinima());
                                    System.out.println("la duracion es: " + pelicula.getDuracion());
                                    System.out.println("el director es: " + pelicula.getDirector());
                                    System.out.println();
                                    System.out.println("nombre: " + nombre);
                                    System.out.println("edad: " + edad);
                                    System.out.println("dinero: " + cantidad);
                                    System.out.println();
                                    System.out.println("Compraste los siguientes asientos: " + asientosComprados + "\n");
                                    System.out.println("gracias por tu compra, vuelve pronto.");
                                    pdf = false;

                                }


                                break;

                            case 2:
                                System.out.println("Saliendo del programa.");
                                break mainloop;
                            default:
                                System.out.println("Opción no válida. Inténtalo de nuevo.");
                        }
                    }
                }
            }
        }
    }
}

//....