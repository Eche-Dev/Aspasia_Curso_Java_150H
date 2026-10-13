/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Dia1_Ejercicio2;

/**
 * PRIMER EJERCICIO FACIL - Ejercicio del producto.
 *
 * El enunciado pide declarar una variable de cada tipo basico con datos
 * de un producto y mostrarlos:
 *  1. Un String con el nombre del producto.
 *  2. Un double con el precio.
 *  3. Un int con las unidades disponibles.
 *  4. Un boolean que dice si esta en oferta.
 *
 * @author mañana
 */
public class PProducto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---------- 1. Declarar las variables ----------
        String nombre = "Aloe Vera"; // texto: el nombre del producto
        double precio = 20;          // numero con decimales (el precio)
        int unidad_disponible = 5;   // numero entero (cuantas unidades quedan)
        boolean oferta = false;      // false = no esta en oferta

        // ---------- 2. Mostrar las variables ----------
        // Con + se une texto con numeros.
        System.out.println("Nombre del producto: " + nombre);
        System.out.println("Precio: " + precio + " euros");
        System.out.println("Unidades disponibles: " + unidad_disponible);
        System.out.println("En oferta: " + oferta);
    }

}