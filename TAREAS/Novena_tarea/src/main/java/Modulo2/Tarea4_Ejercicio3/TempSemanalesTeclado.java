/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tarea4_Ejercicio3;

import java.util.Scanner;

/**
 * TAREA 4 - Temperaturas de la semana pedidas por teclado.
 *
 * Mismo ejercicio que los anteriores, pero en vez de escribir las temperaturas
 * a mano en el codigo, el programa le PREGUNTA al usuario la temperatura de
 * cada uno de los 7 dias.
 *
 * Para saber cuanto vale cada dia se usa un array con los nombres de los dias
 * y un bucle for que va tomando una temperatura por cada nombre.
 *
 * @author mañana
 */
public class TempSemanalesTeclado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---------- 1. Los nombres de los 7 dias ----------
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

        // ---------- 2. El Scanner para leer el teclado ----------
        Scanner teclado = new Scanner(System.in);

        double[] temp = new double[dias.length]; // array vacio donde guardar cada temperatura

        // ---------- 3. Preguntar la temperatura de cada dia ----------
        // el for repite 7 veces: una por cada dia del array "dias"
        for (int i = 0; i < dias.length; i++) {
            System.out.print("Temperatura del " + dias[i] + " (en grados): "); // pregunta al usuario
            temp[i] = teclado.nextDouble(); // lee el numero que escribe y lo guarda
            // OJO: en un ordenador en espanol el decimal se escribe con COMA (15,5)
        }

        // ---------- 4. Recorrer el array y buscar suma, maxima y minima ----------
        double suma = 0;          // suma de todas las temperaturas
        double maxima = temp[0];  // la maxima empieza siendo la del primer dia
        double minima = temp[0];  // la minima tambien

        for (int i = 0; i < temp.length; i++) {
            suma += temp[i];         // se acumula la temperatura del dia
            if (temp[i] > maxima) {  // si es mas calurosa que la maxima
                maxima = temp[i];
            }
            if (temp[i] < minima) {  // si es mas fria que la minima
                minima = temp[i];
            }
        }

        // ---------- 5. Calcular la media de la semana ----------
        double media = suma / temp.length; // suma dividida entre los 7 dias

        // ---------- 6. Contar los dias que superan la media ----------
        int sobre_media = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > media) { // solo los dias mas calurosos que la media
                sobre_media++;
            }
        }

        // ---------- 7. Mostrar los resultados ----------
        System.out.println();
        System.out.println("===== TEMPERATURAS DE LA SEMANA =====");
        // %.2f muestra el numero con 2 decimales
        System.out.printf("Media    : %.2f grados%n", media);
        System.out.printf("Maxima   : %.2f grados%n", maxima);
        System.out.printf("Minima   : %.2f grados%n", minima);
        System.out.printf("Suma de todas las temperatura: %.2f grados%n", suma);
        System.out.println("Dias por encima de la media: " + sobre_media);
        System.out.println("=======================================");

        teclado.close(); // se cierra el Scanner
    }

}