/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Dia2_Ejercicio1;

import java.util.Scanner;

/**
 * DIA 2 - EJERCICIO 1: pedir datos por teclado.
 *
 * El enunciado pide:
 *  1. Pedir el nombre por teclado.
 *  2. Pedir la edad por teclado.
 *  3. Pedir la altura por teclado.
 *  4. Mostrar los tres datos.
 *
 * @author mañana
 */
public class AngelEjercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---------- 1. Crear el Scanner ----------
        // Scanner( System.in ) significa "lee de la entrada estandar (el teclado)".
        Scanner teclado = new Scanner(System.in);

        // ---------- 2. Pedir el nombre ----------
        // print (sin ln) deja el cursor en la misma linea para que el
        // usuario escriba justo despues del texto.
        // nextLine() devuelve un String, asi que no hay que convertirlo.
        System.out.print("Introduce tu nombre: ");
        String nombre = teclado.nextLine();

        // ---------- 3. Pedir la edad ----------
        // nextLine() devuelve texto, asi que Integer.parseInt() lo convierte a numero entero.
        System.out.print("Introduce tu edad: ");
        int edad = Integer.parseInt(teclado.nextLine());

        // ---------- 4. Pedir la altura ----------
        // Double.parseDouble() lo convierte a numero con decimales.
        System.out.print("Introduce tu altura: ");
        double altura = Double.parseDouble(teclado.nextLine());

        // ---------- 5. Mostrar los datos ----------
        System.out.println("====== FICHA ======");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura + " metros");
        System.out.println("===================");

        // ---------- 6. Cerrar el Scanner ----------
        // se cierra para liberar los recursos del teclado.
        teclado.close();
    }

}