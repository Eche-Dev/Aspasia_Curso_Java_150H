/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Dia1_Ejercicio7;

// La clase Variables vive en la carpeta Dia1_Ejercicio6,
// asi que hay que importarla para poder usarla desde aqui.
import Dia1_Ejercicio6.Variables;

/**
 * DIA 1 - EJERCICIO 7: uso de la clase Variables.
 *
 * El enunciado pide:
 *  1. Crear el objeto con un valor inicial.
 *  2. Mostrar la variable.
 *  3. Ver el toString() del objeto.
 *
 * @author mañana
 */
public class VariableRun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---------- 1. Crear el objeto ----------
        // El tipo de la variable debe ser "Variables" (la clase que se
        // instancia con new), no "VariableRun".
        // Antes estaba asi:
        //     VariableRun variables = new Variables(10);
        // y el error era:
        //     incompatible types: Variables cannot be converted to VariableRun
        // porque un objeto "Variables" no se puede guardar en una variable
        // de tipo "VariableRun".
        Variables variables = new Variables(10);

        // ---------- 2. Mostrar la variable ----------
        variables.mostrar_variables();

        // ---------- 3. Ver el toString() ----------
        // toString() solo devuelve el texto, asi que hay que imprimirlo.
        System.out.println(variables.toString());
    }

}