/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Dia2_Ejercicio3;

import java.util.Scanner;

/**
 * DIA 2 - EJERCICIO 3: triangulo (area y perimetro) pidiendo datos por teclado.
 *
 * El enunciado pide:
 *  1. Pedir la base del triangulo.
 *  2. Pedir la altura.
 *  3. Calcular el area: (base * altura) / 2.
 *  4. Calcular la hipotenusa con el teorema de Pitagoras.
 *  5. Calcular el perimetro sumando los 3 lados.
 *  6. Mostrar el resultado.
 *
 * @author mañana
 */
public class AngelEjercios2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---------- 1. Crear el Scanner ----------
        // Scanner( System.in ) significa "lee de la entrada estandar (el teclado)".
        Scanner teclado = new Scanner(System.in);

        // ---------- 2. Pedir la base ----------
        // print (sin ln) deja el cursor en la misma linea para que el
        // usuario escriba justo despues del texto.
        System.out.print("Introduce la base del triangulo (metros): ");
        // nextLine() devuelve un String, asi que lo convertimos con Double.parseDouble().
        double base = Double.parseDouble(teclado.nextLine());

        // ---------- 3. Pedir la altura de la misma manera ----------
        System.out.print("Introduce la altura del triangulo (metros): ");
        double altura = Double.parseDouble(teclado.nextLine());

        // ---------- 4. AREA del triangulo = (base * altura) / 2 ----------
        double area = (base * altura) / 2;

        // ---------- 5. Hipotenusa con el teorema de Pitagoras ----------
        // hipotenusa = raiz cuadrada de (base^2 + altura^2)
        // Math.sqrt( ... ) es la raiz cuadrada y Math.pow( x, 2 ) es x al cuadrado.
        double hipotenusa = Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));

        // ---------- 6. PERIMETRO = base + altura + hipotenusa ----------
        // es la suma de los 3 lados del triangulo.
        double perimetro = base + altura + hipotenusa;

        // ---------- 7. Mostrar el resultado ----------
        // Con + se une texto con numeros.
        System.out.println("-----------------------------");
        System.out.println("Base: " + base + " metros");
        System.out.println("Altura: " + altura + " metros");
        System.out.printf("Area del triangulo: %.2f m2%n", area);
        System.out.printf("Hipotenusa: %.2f metros%n", hipotenusa);
        System.out.printf("Perimetro: %.2f metros%n", perimetro);
        System.out.println("-----------------------------");

        // ---------- 8. Cerrar el Scanner ----------
        // se cierra para liberar los recursos del teclado.
        teclado.close();
    }

}