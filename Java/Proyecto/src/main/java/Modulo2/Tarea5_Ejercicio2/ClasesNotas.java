/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Modulo2.Tarea5_Ejercicio2;

// Importamos Scanner para poder leer lo que el usuario escribe por teclado
import java.util.Scanner;

/**
 *
 * @author mañana
 */
public class ClasesNotas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creamos el objeto Scanner, que lee del teclado (System.in)
        Scanner teclado = new Scanner(System.in);

        // print no salta de línea, para que el usuario escriba en la misma línea
        System.out.print("Nombre del alumno: ");
        // nextLine lee una línea completa de texto
        String nombre = teclado.nextLine();

        System.out.print("Cuantas notas vas a introducir? ");
        // nextInt lee un número entero
        int numeroNotas = teclado.nextInt();

        // Array de doubles (decimales) con el tamaño que ha escrito el usuario
        double[] notas = new double[numeroNotas];
        // Acumulador: empieza en 0 porque vamos a ir sumando
        double suma = 0;

        // Bucle for: i va desde 0 hasta numeroNotas - 1
        for (int i = 0; i < numeroNotas; i++) {
            // (i + 1) porque para el usuario la primera nota es la 1, no la 0
            System.out.print("Nota " + (i + 1) + ": ");
            // Guardamos la nota leída en su posición del array
            notas[i] = teclado.nextDouble();
            // += es lo mismo que suma = suma + notas[i]
            suma += notas[i];
        }

        // La media es la suma dividida entre cuántas notas hay
        double media = suma / numeroNotas;

        // println sí salta de línea; el \n deja una línea en blanco antes
        System.out.println("\nNotas de " + nombre + ":");
        // Recorremos el array entero para mostrar cada nota
        for (int i = 0; i < notas.length; i++) {
            System.out.println("  Nota " + (i + 1) + ": " + notas[i]);
        }

        // Concatenamos con + para unir texto y número en la misma frase
        System.out.println("Media: " + media);

        // Si la media es 5 o más, el alumno aprobado; si no, suspenso
        if (media >= 5) {
            System.out.println("Resultado: APTO");
        } else {
            System.out.println("Resultado: SUSPENSO");
        }

        // Cerramos el Scanner para liberar recursos
        teclado.close();
    }
}