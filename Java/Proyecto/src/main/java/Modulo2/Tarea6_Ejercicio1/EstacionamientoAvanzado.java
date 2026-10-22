package Modulo2.Tarea6_Ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Control de estacionamiento, nivel avanzado.
 *
 * Cada vehículo es un objeto con sus propios datos, la entrada se valida
 * con try/catch y, además del total y los descuentos, se calculan
 * estadísticas: quién ha estado más horas y quién paga más.
 *
 * Tarifa: las primeras 2 horas a 2,00 €/hora; cada hora adicional a 1,50 €.
 * Si el vehículo ha estado más de 5 horas, se aplica un 10 % de descuento.
 *
 * @author mañana
 */
public class EstacionamientoAvanzado {

    static final double PRECIO_HORA_INICIAL = 2.00;
    static final int HORAS_INICIALES = 2;
    static final double PRECIO_HORA_EXTRA = 1.50;
    static final double DESCUENTO = 0.10;
    static final int HORAS_PARA_DESCUENTO = 5;

    /** Representa un vehículo aparcado: número, horas, precio y descuento. */
    static class Vehiculo {

        final int numero;
        final int horas;
        final double precio;
        final boolean conDescuento;

        /** Constructor: calcula el precio y el descuento al crear el objeto. */
        Vehiculo(int numero, int horas) {
            this.numero = numero;
            this.horas = horas;
            this.precio = calcularPrecio(horas);
            this.conDescuento = horas > HORAS_PARA_DESCUENTO;
        }
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Número de vehículos: ");
        int numero = leerEnteroPositivo(teclado);

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        for (int i = 0; i < numero; i++) {
            System.out.print("Horas del vehículo " + (i + 1) + ": ");
            int h = leerEnteroPositivo(teclado);
            vehiculos.add(new Vehiculo(i + 1, h));
        }

        // Informe
        System.out.println();
        System.out.println("PRECIOS");
        for (Vehiculo v : vehiculos) {
            // Si tiene descuento, se añade una marca al final de la línea
            System.out.printf("  Vehículo %d: %d h -> %.2f €%s%n",
                    v.numero, v.horas, v.precio,
                    v.conDescuento ? " (descuento)" : "");
        }

        // Recaudación total y vehículos con descuento
        double recaudacion = 0;
        int conDescuento = 0;
        for (Vehiculo v : vehiculos) {
            recaudacion += v.precio;
            if (v.conDescuento) {
                conDescuento++;
            }
        }

        // Estadísticas: Collections.max devuelve el mayor según el comparador
        Vehiculo masHoras = Collections.max(vehiculos,
                Comparator.comparingInt(v -> v.horas));
        Vehiculo masCaro = Collections.max(vehiculos,
                Comparator.comparingDouble(v -> v.precio));

        System.out.println("------------------------------");
        System.out.printf("Recaudación total: %.2f €%n", recaudacion);
        System.out.println("Vehículos con descuento: " + conDescuento);
        System.out.printf("Más horas: vehículo %d (%d h)%n",
                masHoras.numero, masHoras.horas);
        System.out.printf("Precio más alto: vehículo %d (%.2f €)%n",
                masCaro.numero, masCaro.precio);

        teclado.close();
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

    /**
     * Lee un entero positivo preguntando otra vez si no lo es.
     * El try/catch evita que el programa se caiga si el usuario escribe texto.
     */
    static int leerEnteroPositivo(Scanner teclado) {
        while (true) {
            try {
                // Integer.parseInt convierte el texto "5" en el número 5
                int valor = Integer.parseInt(teclado.nextLine().trim());
                if (valor > 0) {
                    return valor;
                }
                System.out.print("  Tiene que ser positivo: ");
            } catch (NumberFormatException e) {
                // Si el texto no es un número, volvemos a pedir
                System.out.print("  Escribe un número entero: ");
            }
        }
    }
}