/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Dia1_Ejercicio3;

/**
 * PRIMER EJERCICIO FACIL - Presentacion personal ("Yo solito").
 *
 * El enunciado pide declarar una variable para cada dato personal
 * (texto, enteros y booleanos) y mostrarlos todos en pantalla.
 *
 * @author mañana
 */
public class YoSolito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---------- 1. Datos de texto (String) ----------
        String pais = "Venezuela";
        String ciudad = "Apure";
        String municipio = "San Fernando";
        String direccion = "Calle begona N6 - 2B";
        String estudios = "Bachillerato y TSU administracion de empresas";

        // ---------- 2. Fechas tambien son texto ----------
        String celebracion = "14-07-2000"; // fecha de la celebracion del estado
        String mi_cumpleaños = "08 SEP";   // el dia y mes de mi cumpleanos

        // ---------- 3. Numeros enteros (int) ----------
        int años = 500;                  // tiempo en el pais
        int mi_edad = 28;                // edad actual
        int año_de_nacimiento = 1998;    // anio en que nacio
        int dinero_que_tengo = 500;      // dinero guardado

        // ---------- 4. Condicion (boolean) ----------
        boolean pais_nacimiento = true;  // true = si, este es el pais de nacimiento

        // ---------- 5. Mostrar todo en pantalla ----------
        System.out.println("========== SOBRE MI ==========");
        System.out.println("Pais: " + pais);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Municipio: " + municipio);
        System.out.println("Years en el pais: " + años);
        System.out.println("Pais de nacimiento: " + pais_nacimiento);
        System.out.println("Mi cumpleanos: " + mi_cumpleaños);
        System.out.println("Mi edad: " + mi_edad);
        System.out.println("Anio de nacimiento: " + año_de_nacimiento);
        System.out.println("Dinero que tengo: " + dinero_que_tengo);
        System.out.println("Direccion: " + direccion);
        System.out.println("Celebracion del estado: " + celebracion);
        System.out.println("Estudios realizados: " + estudios);
        System.out.println("================================");
    }

}