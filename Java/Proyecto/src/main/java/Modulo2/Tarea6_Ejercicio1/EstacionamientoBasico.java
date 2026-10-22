package Modulo2.Tarea6_Ejercicio1;

import java.util.Scanner;

/**
 * Control de estacionamiento, nivel básico.
 *
 * Pregunta cuántos vehículos hay y las horas de cada uno, calcula el precio
 * y la recaudación total, y cuenta cuántos vehículos tienen descuento.
 *
 * Tarifa: las primeras 2 horas a 2,00 €/hora; cada hora adicional a 1,50 €.
 * Si el vehículo ha estado más de 5 horas, se aplica un 10 % de descuento.
 *
 * @author mañana
 */
public class EstacionamientoBasico {

    /** Precio de cada una de las primeras horas. */
    static final double PRECIO_HORA_INICIAL = 2.00;

    /** Número de horas que se cobran al precio inicial. */
    static final int HORAS_INICIALES = 2;

    /** Precio de cada hora a partir de las iniciales. */
    static final double PRECIO_HORA_EXTRA = 1.50;

    /** Descuento: 0,10 es lo mismo que el 10 %. */
    static final double DESCUENTO = 0.10;

    /** Hay que superar estas horas para que toque descuento. */
    static final int HORAS_PARA_DESCUENTO = 5;

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Número de vehículos: ");
        int numero = teclado.nextInt();

        // Arrays paralelos: uno guarda las horas y otro el precio de cada vehículo
        int[] horas = new int[numero];
        double[] precios = new double[numero];

        double recaudacion = 0;
        int conDescuento = 0;

        // Lectura de horas y cálculo del precio de cada vehículo
        for (int i = 0; i < numero; i++) {
            System.out.print("Horas del vehículo " + (i + 1) + ": ");
            int h = teclado.nextInt();

            // Las horas tienen que ser positivas: si no, se pide otra vez
            while (h <= 0) {
                System.out.print("  Tiene que ser positivo. Horas: ");
                h = teclado.nextInt();
            }
            horas[i] = h;

            // Primeras horas al precio inicial, resto al precio extra
            double precio;
            if (h <= HORAS_INICIALES) {
                precio = h * PRECIO_HORA_INICIAL;
            } else {
                precio = HORAS_INICIALES * PRECIO_HORA_INICIAL
                       + (h - HORAS_INICIALES) * PRECIO_HORA_EXTRA;
            }

            // Descuento si supera las horas que tocan
            if (h > HORAS_PARA_DESCUENTO) {
                precio = precio * (1 - DESCUENTO);
                conDescuento++;
            }

            precios[i] = precio;
            recaudacion += precio;
        }

        // Informe
        System.out.println();
        System.out.println("PRECIOS");
        for (int i = 0; i < numero; i++) {
            // %d para el entero, %.2f para el decimal con dos decimales
            System.out.printf("  Vehículo %d: %d h -> %.2f €%n",
                    (i + 1), horas[i], precios[i]);
        }

        System.out.println("------------------------------");
        System.out.printf("Recaudación total: %.2f €%n", recaudacion);
        System.out.println("Vehículos con descuento: " + conDescuento);

        teclado.close();
    }
}