package Modulo2.Tarea6_Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Control de estacionamiento, nivel intermedio.
 *
 * Mismo cálculo que el básico, pero el main solo coordina:
 * cada cosa vive en su método, y los datos van en listas de objetos
 * en vez de arrays de tamaño fijo.
 *
 * Tarifa: las primeras 2 horas a 2,00 €/hora; cada hora adicional a 1,50 €.
 * Si el vehículo ha estado más de 5 horas, se aplica un 10 % de descuento.
 *
 * @author mañana
 */
public class EstacionamientoIntermedio {

    static final double PRECIO_HORA_INICIAL = 2.00;
    static final int HORAS_INICIALES = 2;
    static final double PRECIO_HORA_EXTRA = 1.50;
    static final double DESCUENTO = 0.10;
    static final int HORAS_PARA_DESCUENTO = 5;

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Número de vehículos: ");
        int numero = Integer.parseInt(teclado.nextLine().trim());

        // ArrayList: crece solo, sin necesidad de saber el tamaño de antemano
        ArrayList<Integer> horas = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();

        for (int i = 0; i < numero; i++) {
            System.out.print("Horas del vehículo " + (i + 1) + ": ");
            int h = leerPositivo(teclado);
            horas.add(h);
            precios.add(calcularPrecio(h));
        }

        // Informe
        System.out.println();
        System.out.println("PRECIOS");
        for (int i = 0; i < horas.size(); i++) {
            System.out.printf("  Vehículo %d: %d h -> %.2f €%n",
                    (i + 1), horas.get(i), precios.get(i));
        }

        System.out.println("------------------------------");
        System.out.printf("Recaudación total: %.2f €%n", sumaPrecios(precios));
        System.out.println("Vehículos con descuento: " + contarConDescuento(horas));

        teclado.close();
    }

    /** Lee un entero y se asegura de que sea positivo. */
    static int leerPositivo(Scanner teclado) {
        int valor = Integer.parseInt(teclado.nextLine().trim());
        while (valor <= 0) {
            System.out.print("  Tiene que ser positivo: ");
            valor = Integer.parseInt(teclado.nextLine().trim());
        }
        return valor;
    }

    /** Precio según las horas, con descuento a partir de las 6. */
    static double calcularPrecio(int horas) {
        double precio;
        if (horas <= HORAS_INICIALES) {
            precio = horas * PRECIO_HORA_INICIAL;
        } else {
            precio = HORAS_INICIALES * PRECIO_HORA_INICIAL
                   + (horas - HORAS_INICIALES) * PRECIO_HORA_EXTRA;
        }
        if (horas > HORAS_PARA_DESCUENTO) {
            precio = precio * (1 - DESCUENTO);
        }
        return precio;
    }

    /** Suma todos los precios de la lista. */
    static double sumaPrecios(ArrayList<Double> precios) {
        double total = 0;
        for (double p : precios) {
            total += p;
        }
        return total;
    }

    /** Cuenta cuántos vehículos superan las horas de descuento. */
    static int contarConDescuento(ArrayList<Integer> horas) {
        int cuenta = 0;
        for (int h : horas) {
            if (h > HORAS_PARA_DESCUENTO) {
                cuenta++;
            }
        }
        return cuenta;
    }
}