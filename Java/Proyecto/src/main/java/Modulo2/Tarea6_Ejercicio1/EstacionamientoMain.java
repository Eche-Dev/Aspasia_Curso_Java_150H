package Modulo2.Tarea6_Ejercicio1;

import java.util.Scanner;

/**
 * Main del control de estacionamiento.
 *
 * Aquí solo se pide datos por teclado y se llaman los métodos públicos
 * de Estacionamiento. La clase Estacionamiento guarda y calcula; este
 * main no toca sus datos privados.
 *
 * @author mañana
 */
public class EstacionamientoMain {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Creamos el objeto: a partir de aquí trabajamos con él
        Estacionamiento parking = new Estacionamiento();

        System.out.print("Número de vehículos: ");
        int numero = leerEnteroPositivo(teclado);

        // Bucle para pedir las horas de cada vehículo
        for (int i = 0; i < numero; i++) {
            System.out.print("Horas del vehículo " + (i + 1) + ": ");
            int h = leerEnteroPositivo(teclado);
            parking.agregarVehiculo(h);
        }

        // Llamadas a los métodos públicos de la clase
        parking.mostrarInforme();

        System.out.println("------------------------------");
        System.out.printf("Recaudación total: %.2f €%n", parking.getRecaudacion());
        System.out.println("Vehículos con descuento: " + parking.getConDescuento());
        System.out.println("Vehículos registrados: " + parking.getCantidad());

        teclado.close();
    }

    /**
     * Lee un entero positivo preguntando otra vez si no lo es.
     * El try/catch evita que el programa se caiga si el usuario escribe texto.
     */
    static int leerEnteroPositivo(Scanner teclado) {
        while (true) {
            try {
                // Integer.parseInt convierte el texto "5" en el número 5
                int valor = Integer.parseInt(teclado.nextLine().trim());
                if (valor > 0) {
                    return valor;
                }
                System.out.print("  Tiene que ser positivo: ");
            } catch (NumberFormatException e) {
                // Si el texto no es un número, volvemos a pedir
                System.out.print("  Escribe un número entero: ");
            }
        }
    }
}