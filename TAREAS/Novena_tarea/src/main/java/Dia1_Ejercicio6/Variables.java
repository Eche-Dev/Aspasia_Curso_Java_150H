/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dia1_Ejercicio6;

/**
 * DIA 1 - EJERCICIO 6: clase Variables.
 *
 * El enunciado pide:
 *  1. Guardar en un atributo la variable "puntos_iniciales".
 *  2. Crear el constructor que da el valor inicial.
 *  3. Los getters y setters.
 *  4. Un toString() y un metodo mostrar_variables().
 *
 * OJO: para que esta clase exista al correr hay que compilar el proyecto
 * completo. Si solo se ejecuta el archivo que la usa (Shift+F6 = "Run File"),
 * NetBeans compila unicamente ese archivo y esta clase no se genera, dando el error:
 *     NoClassDefFoundError: Dia1_Ejercicio6/Variables
 * Solucion: usar F6 ("Run Project") o hacer "Clean and Build" una vez.
 *
 * @author mañana
 */
public class Variables {

    // ---------- 1. Atributo ----------
    private int puntos_iniciales; // valor inicial de la variable

    // ---------- 2. Constructor ----------
    /**
     * Al crear el objeto con new se guarda el numero que se le pase.
     */
    public Variables(int puntos_iniciales) {
        this.puntos_iniciales = puntos_iniciales;
    }

    // ---------- 3. Getter y setter ----------
    /**
     * Devuelve el valor del atributo.
     */
    public int getPuntos_iniciales() {
        return puntos_iniciales;
    }

    /**
     * Cambia el valor del atributo.
     */
    public void setPuntos_iniciales(int puntos_iniciales) {
        this.puntos_iniciales = puntos_iniciales;
    }

    /**
     * Devuelve el objeto escrito en texto (no lo muestra, solo lo devuelve).
     */
    @Override
    public String toString() {
        return "Variables{" + "puntos_iniciales=" + puntos_iniciales + '}';
    }

    // ---------- 4. mostrar_variables() ----------
    /**
     * Muestra la variable en pantalla.
     */
    public void mostrar_variables() {
        System.out.println("Variable: " + puntos_iniciales);
    }

}