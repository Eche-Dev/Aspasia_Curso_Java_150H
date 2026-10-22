/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Dia3_Ejercicio1;

import java.util.Scanner;

/**
 * Pide por teclado la base y la altura de un triangulo
 * y calcula su area con la formula: area = (base * altura) / 2
 *
 * @author mañana
 */
public class AreaTriangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // ---------- 1. Pedir la base ----------
        System.out.print("Introduce la base del triangulo: ");
        double base = Double.parseDouble(teclado.nextLine());

        // ---------- 2. Pedir la altura ----------
        System.out.print("Introduce la altura del triangulo: ");
        double altura = Double.parseDouble(teclado.nextLine());

        // ---------- 3. Calcular el area ----------
        // el area de un triangulo es base por altura partido entre 2
        double area = (base * altura) / 2;

        // ---------- 4. Mostrar el resultado ----------
        System.out.println("===========================");
        System.out.println("Base  : " + base);
        System.out.println("Altura: " + altura);
        System.out.printf("Area del triangulo: %.2f%n", area);
        System.out.println("===========================");

        teclado.close();
    }

}
