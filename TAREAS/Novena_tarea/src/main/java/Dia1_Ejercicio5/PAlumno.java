/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Dia1_Ejercicio5;

// La clase Alumno vive en la carpeta Dia1_Ejercicio4,
// asi que hay que importarla para poder usarla desde aqui.
import Dia1_Ejercicio4.Alumno;

/**
 * DIA 1 - EJERCICIO 5: uso de la clase Alumno.
 *
 * El enunciado pide crear un alumno y probarlo:
 *  1. Crear el objeto con "new" y los valores.
 *  2. Ver el toString() del objeto.
 *  3. Llamar al metodo mostrar().
 *
 * @author mañana
 */
public class PAlumno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---------- 1. Crear el objeto ----------
        // new Alumno(...) llama al constructor de la clase Alumno.
        Alumno alumno = new Alumno("Angel", 9.8, 1, true);

        // ---------- 2. Ver el toString() ----------
        // OJO: escribir alumno.toString(); sin println no muestra nada,
        // porque toString() solo DEVUELVE el texto.
        System.out.println(alumno.toString());

        // ---------- 3. Llamar al metodo mostrar() ----------
        // esta si imprime, porque mostrar() ya lleva el System.out.println dentro.
        alumno.mostrar();
    }

}