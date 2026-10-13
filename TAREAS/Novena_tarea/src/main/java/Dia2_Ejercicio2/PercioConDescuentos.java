/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Dia2_Ejercicio2;

/**
 * DIA 2 - EJERCICIO 2: precio con descuento e IVA.
 *
 * El enunciado pide:
 *  1. Declarar el precio y la cantidad.
 *  2. Calcular el importe total.
 *  3. Calcular un descuento del 10 %.
 *  4. Calcular cuanto dinero se descuenta.
 *  5. Restar el descuento al importe total.
 *  6. Calcular el IVA del 21 % sobre el precio ya descontado.
 *  7. Sumar el IVA para obtener el precio final.
 *  8. Mostrarlo en pantalla.
 *
 * @author mañana
 */
public class PercioConDescuentos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---------- 1. Variables: precio y cantidad ----------
        double precio = 50.00; // precio de UN producto
        int cantidad = 5;      // cuantos productos se compran

        // ---------- 2. Importe total ----------
        // precio por unidad * cantidad de unidades
        double total = precio * cantidad;

        // ---------- 3 y 4. Descuento del 10 % y dinero que se descuenta ----------
        // el porcentaje se divide entre 100 para pasarlo a decimal (10 / 100 = 0.10)
        double descuento = 10;
        double importeDescuento = total * descuento / 100;

        // ---------- 5. Precio despues del descuento ----------
        double precioDescontado = total - importeDescuento;

        // ---------- 6. IVA del 21 % (sobre el precio ya descontado) ----------
        double iva = 21;
        double importeIVA = precioDescontado * iva / 100;

        // ---------- 7. Precio final ----------
        // es el precio con descuento mas el IVA
        double precioFinal = precioDescontado + importeIVA;

        // ---------- 8. Mostrar todo en pantalla ----------
        // %.2f muestra el numero con 2 decimales
        System.out.println("========== TIENDA ==========");
        System.out.printf("Precio del producto  : %.2f euros%n", precio);
        System.out.println("Cantidad de producto : " + cantidad);
        System.out.printf("Importe inicial      : %.2f euros%n", total);
        System.out.printf("Importe del descuento: %.2f euros (10 %% de descuento)%n", importeDescuento);
        System.out.printf("Precio tras descuento: %.2f euros%n", precioDescontado);
        System.out.printf("Importe del IVA      : %.2f euros (21 %% de IVA)%n", importeIVA);
        System.out.printf("PRECIO FINAL         : %.2f euros%n", precioFinal);
        System.out.println("===========================");
    }

}