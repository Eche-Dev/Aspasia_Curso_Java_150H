/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Dia3_Ejercicio2;

import java.util.Scanner;

/**
 * DIA 3 - EJERCICIO 2: Calculadora de compras con descuento por importe.
 *
 * El enunciado pide:
 *  1. Pedir al usuario el nombre del producto.
 *  2. Pedir al usuario el precio de una unidad.
 *  3. Pedir al usuario la cantidad que desea comprar.
 *  4. Calcular el importe de la compra (precio unidad * cantidad).
 *  5. Aplicar un descuento del 10 % si el importe es igual o superior a 100 euros.
 *  6. Calcular el importe del descuento aplicado.
 *  7. Calcular el importe de la compra tras el descuento.
 *  8. Calcular el IVA del 21 % sobre el importe YA descontado.
 *  9. Calcular el precio final (importe descontado + IVA).
 * 10. Mostrarlo todo en pantalla.
 *
 * @author mañana
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---------- 1, 2 y 3. Pedir los datos al usuario ----------
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nombre del producto: ");
        // nextLine() ya devuelve un String, no hay que convertirlo
        String nombre = teclado.nextLine();

        System.out.print("Precio por unidad: ");
        double unidad = Double.parseDouble(teclado.nextLine());

        System.out.print("Cantidad que desea comprar: ");
        double cantidad = Double.parseDouble(teclado.nextLine());

        // ---------- 4. Importe de la compra ----------
        // se multiplica el precio de UNA unidad por la cantidad comprada
        double importe = unidad * cantidad;

        // ---------- 5. Descuento del 10 % a partir de 100 euros ----------
        double porcentaje_descuento = 10; // el 10 % que se descuenta
        double importe_minimo = 100;       // el importe minimo para tener descuento

        // la variable descuento empieza a 0 y solo cambia si el importe es suficiente
        double descuento = 0;
        if (importe >= importe_minimo) {
            // el porcentaje se divide entre 100 para pasarlo a decimal (10 / 100 = 0.10)
            descuento = importe * (porcentaje_descuento / 100);
        }

        // ---------- 6. Importe de la compra tras el descuento ----------
        // es el importe de la compra menos el descuento aplicado
        double importe_descuento = importe - descuento;

        // ---------- 7. IVA del 21 % ----------
        // el IVA se calcula SOBRE EL IMPORTE YA DESCONTADO, no sobre el importe original.
        // el porcentaje se divide entre 100 para pasarlo a decimal (21 / 100 = 0.21)
        double porcentaje_iva = 21;
        double importe_iva = importe_descuento * (porcentaje_iva / 100);

        // ---------- 8. Precio final ----------
        // es el importe ya descontado mas el IVA
        double precio_final = importe_descuento + importe_iva;

        // ---------- 9 y 10. Mostrar todo el resultado ----------
        // %.2f muestra el numero con 2 decimales
        System.out.println("===========================");
        System.out.println("Producto: " + nombre);
        System.out.printf("Precio por unidad: %.2f euros%n", unidad);
        System.out.println("Cantidad: " + cantidad);
        System.out.printf("Importe de la compra: %.2f euros%n", importe);

        if (descuento > 0) {
            System.out.printf("Descuento aplicado (10 %%): -%.2f euros%n", descuento);
        } else {
            System.out.println("Descuento aplicado: no cumple el minimo de 100 euros");
        }

        System.out.printf("Importe tras el descuento: %.2f euros%n", importe_descuento);
        System.out.printf("IVA aplicado (21 %%): %.2f euros%n", importe_iva);
        System.out.printf("PRECIO FINAL: %.2f euros%n", precio_final);
        System.out.println("===========================");

        teclado.close();
    }

}