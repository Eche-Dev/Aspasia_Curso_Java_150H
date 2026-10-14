/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tarea4_Ejercicio3;

/**
 * TAREA 4 - Temperaturas de la semana (version sencilla, todo dentro del main).
 *
 * El enunciado pide:
 *  1. Crear un array con la temperatura de los 7 dias.
 *  2. Calcular la temperatura media de la semana.
 *  3. Sacar la temperatura maxima y la minima.
 *  4. Contar cuantos dias superan la media.
 *  5. Mostrarlo en pantalla.
 *
 * @author mañana
 */
public class TempSemanales2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---------- 1. Array con las 7 temperaturas ----------
        double[] temp = {15.5, 18.2, 21.0, 19.7, 24.3, 17.8, 16.1};

        double suma = 0;       // suma de todas las temperaturas
        double maxima = temp[0];// empieza por el primer dia
        double minima = temp[0];// empieza por el primer dia
        int sobre_media = 0;   // contador de dias calurosos

        // un solo recorrido sirve para la suma, la maxima y la minima
        for (int i = 0; i < temp.length; i++) {
            suma += temp[i];              // se acumula la temperatura del dia
            if (temp[i] > maxima) {        // si es mas calurosa que la maxima
                maxima = temp[i];
            }
            if (temp[i] < minima) {        // si es mas fria que la minima
                minima = temp[i];
            }
        }

        // ---------- 2. Temperatura media ----------
        double media = suma / temp.length; // suma dividida entre los 7 dias

        // ---------- 3. Dias que superan la media ----------
        // otro recorrido, este vez comparando cada dia con la media
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > media) {
                sobre_media++;
            }
        }

        // ---------- 4 y 5. Mostrar los resultados ----------
        System.out.println("===== TEMPERATURAS DE LA SEMANA =====");
        // %.2f muestra el numero con 2 decimales
        System.out.printf("Media    : %.2f grados%n", media);
        System.out.printf("Maxima   : %.2f grados%n", maxima);
        System.out.printf("Minima   : %.2f grados%n", minima);
        System.out.printf("Suma de todas las temperatura: %.2f grados%n", suma);
        System.out.println("Dias por encima de la media: " + sobre_media);
        System.out.println("=======================================");
    }

}