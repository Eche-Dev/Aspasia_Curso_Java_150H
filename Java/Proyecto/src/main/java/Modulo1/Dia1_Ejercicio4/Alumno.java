/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dia1_Ejercicio4;

/**
 * DIA 1 - EJERCICIO 4: creacion de una clase (POO).
 *
 * El enunciado pide crear la clase "Alumno" con los datos:
 *  1. Atributos: nombre, nota, faltas y evaluacion.
 *  2. Un constructor que da los valores iniciales.
 *  3. Los getters y setters de cada atributo.
 *  4. Un metodo toString() que devuelve el texto del alumno.
 *  5. Un metodo mostrar() que imprime el alumno en pantalla.
 *
 * Los atributos son "private" para que nadie los cambie por fuera de la clase:
 * se entra por el setter y se sale por el getter.
 *
 * @author mañana
 */
public class Alumno {

    // ---------- 1. Atributos ----------
    // private = solo se pueden usar desde dentro de la misma clase.
    private String nombre;    // texto del alumno
    private double nota;      // nota decimal
    private int faltas;       // numero de faltas
    private boolean evaluacion; // si el alumno esta evaluado o no

    /**
     * ---------- 2. Constructor ----------
     * Se ejecuta al crear el objeto con "new".
     * "this" significa "este objeto": this.nombre = nombre;
     * guarda en el atributo el valor que llega por parametro.
     */
    public Alumno(String nombre, double nota, int faltas, boolean apobado) {
        this.nombre = nombre;
        this.nota = nota;
        this.faltas = faltas;
        this.evaluacion = apobado;
    }

    // ---------- 3. Getters y setters ----------
    /**
     * Getter: devuelve el valor del atributo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter: cambia el valor del atributo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de la nota.
     */
    public double getNota() {
        return nota;
    }

    /**
     * Setter de la nota.
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    /**
     * Getter de las faltas.
     */
    public int getFaltas() {
        return faltas;
    }

    /**
     * Setter de las faltas.
     */
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    /**
     * Getter de la evaluacion.
     * Con boolean se usa "is" en vez de "get" (is = es).
     */
    public boolean isApobado() {
        return evaluacion;
    }

    /**
     * Setter de la evaluacion.
     */
    public void setApobado(boolean apobado) {
        this.evaluacion = apobado;
    }

    // ---------- 4. toString() ----------
    /**
     * Devuelve el alumno escrito en texto.
     * OJO: toString() NO muestra nada, solo devuelve el texto.
     * Para verlo hay que escribirlo: System.out.println(alumno.toString());
     *
     * @Override indica que este metodo ya existe en la clase Object
     * y lo estamos adaptando al alumno.
     */
    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre
                + ", nota=" + nota
                + ", faltas=" + faltas
                + ", apobado=" + evaluacion + '}';
    }

    // ---------- 5. mostrar() ----------
    /**
     * Muestra los datos del alumno uno a uno en pantalla.
     *Aqui si se imprime de verdad, porque el metodo llama a System.out.println().
     */
    public void mostrar() {
        System.out.println("====== ALUMNO ======");
        System.out.println("Nombre: " + nombre);
        System.out.println("Nota: " + nota);
        System.out.println("Faltas: " + faltas);
        System.out.println("Evaluacion: " + evaluacion);
        System.out.println("====================");
    }

}