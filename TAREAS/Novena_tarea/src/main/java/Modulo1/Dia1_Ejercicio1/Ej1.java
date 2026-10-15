/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Modulo1.Dia1_Ejercicio1;

/**
 * PRIMER EJERCICIO FACIL - Ejercicio 1.
 *
 * El enunciado pide declarar una variable de cada tipo basico y mostrarlas:
 *  1. Un String (texto).
 *  2. Un double (numero con decimales).
 *  3. Un int (numero entero).
 *  4. Un boolean (verdadero o falso).
 *
 * @author mañana
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---------- 1. Declarar las variables ----------
        String nombre = "Angel";       // texto: entre comillas dobles
        double nota = 9.8;             // numero con decimales
        int faltas_clases = 1;         // numero entero, sin decimales
        boolean evaluacion = true;     // solo puede ser true (verdadero) o false (falso)

        // ---------- 2. Mostrar las variables ----------
        // println() saca el texto y despues hace un salto de linea.
        // Con + se une texto con numeros (el numero se convierte solo a texto).
        System.out.println("Nombre: " + nombre);
        System.out.println("Nota: " + nota);
        System.out.println("Faltas: " + faltas_clases);
        System.out.println("Evaluacion: " + evaluacion);
    }

}