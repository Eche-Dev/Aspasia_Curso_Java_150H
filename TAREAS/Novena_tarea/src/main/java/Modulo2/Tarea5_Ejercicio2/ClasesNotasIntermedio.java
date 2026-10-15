/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Modulo2.Tarea5_Ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Control de notas de varios alumnos, en nivel intermedio:
 * una clase propia, métodos separados y una lista de objetos.
 *
 * @author mañana
 */
public class ClasesNotasIntermedio {

    static final double NOTA_APTO = 5.0;

    /**
     * Clase interna: representa a un alumno y sus notas.
     * Al tener atributos propios, cada objeto guarda sus propios datos.
     */
    static class Estudiante {

        private final String nombre;
        private final ArrayList<Double> notas = new ArrayList<>();

        /** Constructor: recibe el nombre al crear el objeto. */
        Estudiante(String nombre) {
            this.nombre = nombre;
        }

        void addNota(double nota) {
            notas.add(nota);
        }

        int numeroNotas() {
            return notas.size();
        }

        /** Calcula la media. Devuelve 0 si no hay notas, para no dividir por cero. */
        double media() {
            if (notas.isEmpty()) {
                return 0;
            }
            double suma = 0;
            for (double nota : notas) {
                suma += nota;
            }
            return suma / notas.size();
        }

        boolean aprobado() {
            return media() >= NOTA_APTO;
        }

        String getNombre() {
            return nombre;
        }
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArrayList<Estudiante> lista = new ArrayList<>();

        // while + confirmación del usuario: el bucle puede repetirse
        boolean seguir = true;
        while (seguir) {
            lista.add(pedirAlumno(teclado));

            System.out.print("¿Añadir otro alumno? (s/n): ");
            // nextLine devuelve la línea entera, con o sin espacios alrededor
            seguir = teclado.nextLine().trim().equalsIgnoreCase("s");
        }

        mostrarInforme(lista);
        mostrarMejorMediador(lista);
        contarAprobados(lista);

        teclado.close();
    }

    /** Pide un alumno por consola y lo devuelve ya relleno. */
    static Estudiante pedirAlumno(Scanner teclado) {

        System.out.print("Nombre del alumno: ");
        String nombre = teclado.nextLine();

        // Creamos el objeto: a partir de aquí es un Estudiante
        Estudiante alumno = new Estudiante(nombre);

        // Leemos SIEMPRE con nextLine() y convertimos después.
        // Mezclar nextInt()/nextDouble() con nextLine() descoloca el cursor:
        // el nextDouble() se come el salto de línea y la siguiente línea
        // se lee como vacía.
        System.out.print("Número de notas: ");
        // Integer.parseInt() convierte el texto "3" en el número 3
        int cantidad = Integer.parseInt(teclado.nextLine().trim());

        for (int i = 0; i < cantidad; i++) {
            System.out.print("  Nota " + (i + 1) + ": ");
            alumno.addNota(convertir(teclado.nextLine()));
        }

        return alumno;
    }

    /**
     * Convierte el texto tecleado en un double.
     * Acepta "7.5" y también "7,5", que es como se escribe en España:
     * Double.parseDouble() solo entiende el punto y con la coma peta.
     */
    static double convertir(String texto) {
        // replace() cambia la coma por un punto
        return Double.parseDouble(texto.trim().replace(",", "."));
    }

    /** Imprime la tabla con las medias y el resultado de cada alumno. */
    static void mostrarInforme(ArrayList<Estudiante> lista) {

        System.out.println();
        System.out.println("INFORME");
        System.out.println("------------------------------");

        for (Estudiante alumno : lista) {
            System.out.printf("%-20s %5.2f  %s%n",
                    alumno.getNombre(),
                    alumno.media(),
                    alumno.aprobado() ? "APTO" : "SUSPENSO");
        }

        System.out.println("------------------------------");
    }

    /** Recorre la lista una vez buscando la media más alta. */
    static void mostrarMejorMediador(ArrayList<Estudiante> lista) {

        if (lista.isEmpty()) {
            return;
        }

        // Guion bajo: variable que nos sirve de referencia para comparar
        Estudiante mejor = lista.get(0);

        for (Estudiante alumno : lista) {
            if (alumno.media() > mejor.media()) {
                mejor = alumno;
            }
        }

        System.out.printf("Mejor media: %s (%.2f)%n", mejor.getNombre(), mejor.media());
    }

    /** Cuenta cuántos han aprobado y cuántos no, con dos contadores. */
    static void contarAprobados(ArrayList<Estudiante> lista) {

        int aprobados = 0;
        int suspender = 0;

        for (Estudiante alumno : lista) {
            if (alumno.aprobado()) {
                aprobados++;
            } else {
                suspender++;
            }
        }

        System.out.printf("Aprobados: %d | Suspendidos: %d%n", aprobados, suspender);
    }
}