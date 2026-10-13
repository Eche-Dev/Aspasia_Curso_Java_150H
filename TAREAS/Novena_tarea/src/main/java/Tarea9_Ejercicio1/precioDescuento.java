/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tarea9_Ejercicio1;

/**
 * TERCER DIA - Precio con descuento e IVA.
 *
 * El enunciado pide:
 *  1. Crear la variable para la cantidad y el precio.
 *  2. Calcular el importe total.
 *  3. Calcular un descuento del 10 %.
 *  4. Calcular cuanto dinero se descuenta en total.
 *  5. Restar el descuento al importe total.
 *  6. Calcular el IVA del 21 % sobre el precio despues de aplicar el descuento.
 *  7. Obtener el precio final.
 *  8. Mostrarlo en pantalla.
 *
 * @author mañana
 */
public class precioDescuento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---------- 1. Variables: cantidad y precio ----------
        double precio = 50.00; // precio de UN producto
        int cantidad = 5;      // cuantos productos se compran

        // ---------- 2. Importe total ----------
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
        System.out.printf("Precio del producto: %.2f euros%n", precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.printf("Importe inicial: %.2f euros%n", total);
        System.out.printf("Descuento aplicado: %.2f euros (10 %% de descuento)%n", importeDescuento);
        System.out.printf("Precio con descuento: %.2f euros%n", precioDescontado);
        System.out.printf("IVA aplicado: %.2f euros (21 %% de IVA)%n", importeIVA);
        System.out.printf("Precio final: %.2f euros%n", precioFinal);
        System.out.println("===========================");
    }

}