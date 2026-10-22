/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea4_Ejercicio3;

/**
 * TAREA 4 - Temperaturas de una semana (version con clase).
 *
 * Se guardan las 7 temperaturas de la semana en un array y cada calculo
 * (promedio, maxima, minima, dias por encima del promedio...) se hace en su
 * propio metodo, de forma que la clase se pueda reutilizar mas adelante.
 *
 * @author mañana
 */
public class TemperaturaSemanales {

    // ---------- constantes ----------
    private static final int DIAS_SEMANA = 7; // lunes + martes + ... + domingo
    private static final String[] NOMBRES_DIAS = {
        "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"
    };

    // ---------- atributo: las 7 temperaturas ----------
    private double[] temperaturas;

    /**
     * Constructor: recibe las temperaturas de la semana y las guarda.
     */
    public TemperaturaSemanales(double[] temperaturas) {
        this.temperaturas = temperaturas;
    }

    // ---------- 1. suma de todas las temperaturas ----------
    /**
     * Recorre el array sumando cada temperatura en un acumulador.
     */
    public double getSuma() {
        double suma = 0; // arranca en cero para poder ir sumando
        for (int i = 0; i < temperaturas.length; i++) {
            suma += temperaturas[i]; // se acumula el valor de cada dia
        }
        return suma;
    }

    // ---------- 2. temperatura media de la semana ----------
    /**
     * Media = suma de las temperaturas / numero de dias.
     */
    public double getPromedio() {
        return getSuma() / temperaturas.length;
    }

    // ---------- 3. temperatura maxima ----------
    /**
     * Empezamos por la del primer dia y vamos comparando con el resto.
     */
    public double getMaxima() {
        double maxima = temperaturas[0]; // el dia 0 es el punto de partida
        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] > maxima) { // si el dia es mas caluroso
                maxima = temperaturas[i]; // ese dia pasa a ser el maximo
            }
        }
        return maxima;
    }

    // ---------- 4. temperatura minima ----------
    /**
     * Mismo recorrido que la maxima, pero buscando el valor mas bajo.
     */
    public double getMinima() {
        double minima = temperaturas[0];
        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] < minima) { // si el dia es mas frio
                minima = temperaturas[i];
            }
        }
        return minima;
    }

    // ---------- 5. dias que superan la temperatura media ----------
    /**
     * Se cuenta cada dia cuya temperatura es mayor que el promedio.
     */
    public int getDiasSobrePromedio() {
        int contador = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] > getPromedio()) { // solo los dias mas calurosos
                contador++;
            }
        }
        return contador;
    }

    // ---------- 6. mostrar los datos por pantalla ----------
    /**
     * Imprime la tabla de la semana y todos los calculos.
     */
    public void mostrar() {
        System.out.println("===== TEMPERATURAS DE LA SEMANA =====");
        for (int i = 0; i < temperaturas.length; i++) {
            System.out.printf("%-10s: %.2f grados%n", NOMBRES_DIAS[i], temperaturas[i]);
        }
        System.out.println("---------------------------------------");
        System.out.printf("Suma      : %.2f%n", getSuma());
        System.out.printf("Promedio  : %.2f grados%n", getPromedio());
        System.out.printf("Maxima    : %.2f grados%n", getMaxima());
        System.out.printf("Minima    : %.2f grados%n", getMinima());
        System.out.printf("Suma de todas las temperatura: %.2f grados%n", getSuma());
        System.out.println("Dias por encima del promedio: " + getDiasSobrePromedio());
        System.out.println("=======================================");
    }

    // ---------- getters y setters ----------
    public double[] getTemperaturas() {
        return temperaturas;
    }

    public void setTemperaturas(double[] temperaturas) {
        this.temperaturas = temperaturas;
    }

    @Override
    public String toString() {
        return "TemperaturaSemanales{" + "promedio=" + getPromedio()
                + ", maxima=" + getMaxima()
                + ", minima=" + getMinima() + '}';
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // se declaran las temperaturas de los 7 dias de la semana
        double[] semana = {15.5, 18.2, 21.0, 19.7, 24.3, 17.8, 16.1};

        // se crea el objeto con esos datos y se muestra todo
        TemperaturaSemanales semana_temperaturas = new TemperaturaSemanales(semana);
        semana_temperaturas.mostrar();
    }

}