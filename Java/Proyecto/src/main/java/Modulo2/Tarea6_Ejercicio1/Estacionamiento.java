package Modulo2.Tarea6_Ejercicio1;

import java.util.ArrayList;

/**
 * Control de estacionamiento encapsulado.
 *
 * Los datos son privados: nadie desde fuera puede tocar las listas ni
 * recalcular a su manera. Para trabajar con el estacionamiento se usan
 * los métodos públicos, que son la única puerta de entrada.
 *
 * Tarifa: las primeras 2 horas a 2,00 €/hora; cada hora adicional a 1,50 €.
 * Si el vehículo ha estado más de 5 horas, se aplica un 10 % de descuento.
 *
 * @author mañana
 */
public class Estacionamiento {

    // Constantes de la tarifa: privadas porque son cosa interna de la clase
    private static final double PRECIO_HORA_INICIAL = 2.00;
    private static final int HORAS_INICIALES = 2;
    private static final double PRECIO_HORA_EXTRA = 1.50;
    private static final double DESCUENTO = 0.10;
    private static final int HORAS_PARA_DESCUENTO = 5;

    // Estado del estacionamiento: privado, solo se lee con los get()
    private final ArrayList<Integer> horas = new ArrayList<>();
    private final ArrayList<Double> precios = new ArrayList<>();

    /**
     * Añade un vehículo con sus horas y guarda ya su precio calculado.
     * Es el único modo de meter datos.
     */
    public void agregarVehiculo(int horas) {
        this.horas.add(horas);
        this.precios.add(calcularPrecio(horas));
    }

    /**
     * Calcula el precio de un vehículo según sus horas.
     * Es privado: el cálculo es un detalle interno, no se pide desde fuera.
     */
    private double calcularPrecio(int horas) {
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

    /** Recaudación total: suma de todos los precios guardados. */
    public double getRecaudacion() {
        double total = 0;
        for (double p : precios) {
            total += p;
        }
        return total;
    }

    /** Cuántos vehículos tienen descuento. */
    public int getConDescuento() {
        int cuenta = 0;
        for (int h : horas) {
            if (h > HORAS_PARA_DESCUENTO) {
                cuenta++;
            }
        }
        return cuenta;
    }

    /** Cuántos vehículos hay registrados. */
    public int getCantidad() {
        return horas.size();
    }

    /** Imprime el precio de cada vehículo. */
    public void mostrarInforme() {
        System.out.println();
        System.out.println("PRECIOS");
        for (int i = 0; i < horas.size(); i++) {
            System.out.printf("  Vehículo %d: %d h -> %.2f €%n",
                    (i + 1), horas.get(i), precios.get(i));
        }
    }
}