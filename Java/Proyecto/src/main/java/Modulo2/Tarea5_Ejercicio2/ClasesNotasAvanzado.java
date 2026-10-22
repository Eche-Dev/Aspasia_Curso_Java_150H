/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Modulo2.Tarea5_Ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Control de notas usando Scanner a un nivel más avanzado:
 * validación antes de leer, conversión con control de errores y delimitadores.
 *
 * @author mañana
 */
public class ClasesNotasAvanzado {

    /** Nota mínima para aprobar. */
    static final double NOTA_APTO = 5.0;

    /** Nota máxima permitida. */
    static final double NOTA_MAXIMA = 10.0;

    public static void main(String[] args) {

        // Por defecto Scanner corta por espacios y saltos de línea
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nombre del alumno: ");
        String nombre = teclado.nextLine();

        System.out.print("¿Cuántas notas vas a introducir? ");
        // nextLine + parseo: así el cursor no se descoloca al mezclar métodos
        int pedidas = Integer.parseInt(teclado.nextLine().trim());

        // ArrayList porque no sabemos cuántas notas válidos acabaremos guardando
        ArrayList<Double> notas = new ArrayList<>();
        double suma = 0;
        double maxima = 0;
        double minima = NOTA_MAXIMA;

        // while con contador propio: si una nota falla, NO pierde el turno,
        // que es justo lo que un for con i++ no permite hacer
        int guardadas = 0;
        while (guardadas < pedidas) {

            System.out.print("  Nota " + (guardadas + 1) + " de " + pedidas + ": ");

            // hasNext() mira si queda algo sin consumirlo; si no hay entrada,
            // salimos en lugar de reventar con NoSuchElementException
            if (!teclado.hasNext()) {
                System.out.println("\nNo queda ninguna nota por leer.");
                break;
            }

            // next() devuelve el token como texto, para poder revisarlo antes
            String token = teclado.next();

            Double nota = convertir(token);

            // Si convertir() devolvió null, el texto no era un número
            if (nota == null) {
                System.out.println("    '" + token + "' no es una nota. Inténtalo otra vez.");
                continue; // vuelve al while sin incrementar guardadas
            }

            // Validamos el rango antes de guardarla
            if (nota < 0 || nota > NOTA_MAXIMA) {
                System.out.println("    Descartada: debe estar entre 0 y " + (int) NOTA_MAXIMA + ".");
                continue;
            }

            notas.add(nota);
            suma += nota;
            // Math.max / Math.min comparan y devuelven el mayor y el menor
            maxima = Math.max(maxima, nota);
            minima = Math.min(minima, nota);
            guardadas++;
        }

        // --- Control de errores: si no se escribió ninguna nota válida ---
        if (notas.isEmpty()) {
            System.out.println("No se ha introducido ninguna nota válida.");
            teclado.close();
            return; // sale del main sin llegar al final
        }

        double media = suma / notas.size();

        // --- reset: devuelve el Scanner a su estado inicial ---
        teclado.reset();

        // --- Salida ---
        System.out.println();
        System.out.println("Informe de " + nombre);
        System.out.println("  Notas guardadas: " + notas.size() + " de " + pedidas + " pedidas");
        for (int i = 0; i < notas.size(); i++) {
            System.out.println("    " + (i + 1) + ") " + notas.get(i));
        }
        System.out.println("  Nota máxima: " + maxima);
        System.out.println("  Nota mínima: " + minima);
        System.out.printf("  Media: %.2f%n", media);
        System.out.println("  Resultado: " + (media >= NOTA_APTO ? "APTO" : "SUSPENSO"));

        teclado.close();
    }

    /**
     * Convierte el texto tecleado en un double, o devuelve null si no es un número.
     * Acepta "7.5" y también "7,5": Double.parseDouble() solo entiende el punto.
     */
    static Double convertir(String texto) {
        try {
            // replace() cambia la coma por un punto antes de convertir
            return Double.parseDouble(texto.trim().replace(",", "."));
        } catch (NumberFormatException e) {
            // Si el texto no es un número, atrapamos el error y devolvemos null
            // en vez de dejar que el programa se caiga
            return null;
        }
    }
}