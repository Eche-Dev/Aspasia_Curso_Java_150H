/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UltimaSemana;

import java.util.Scanner;

/**
 * Gestión de nóminas de una empresa.
 *
 * El programa pide cuántos trabajadores se registran y, para cada uno, su
 * nombre, horas trabajadas, precio por hora y años de antigüedad. Con esos
 * datos calcula el salario bruto, el complemento por antigüedad, la
 * retención, el salario neto mensual y el neto anual (12 pagas).
 *
 * Requisitos cubiertos: Scanner, bucle for, if / else if / else,
 * métodos void y con return, parámetros en los métodos y ninguna
 * entrada negativa.
 */
public class GestiosNomina {

    // Complemento por antigüedad
    static final double ANTIGUEDAD_MENOR_3 = 0.00;
    static final double ANTIGUEDAD_ENTRE_3_Y_5 = 0.05;
    static final double ANTIGUEDAD_MAS_5 = 0.10;

    // Retención sobre (bruto + complemento)
    static final double RETENCION_MENOR_1200 = 0.08;
    static final double RETENCION_ENTRE_1200_Y_2000 = 0.12;
    static final double RETENCION_MAS_2000 = 0.15;

    static final int NUMERO_DE_PAGAS = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarBienvenida();

        int numTrabajadores = pedirNumTrabajadores(scanner);

        double totalNetosMensuales = 0;
        String trabajadorConMasSalario = "";
        double salarioMasAlto = -1;

        for (int i = 0; i < numTrabajadores; i++) {
            System.out.println();
            System.out.println("--- Trabajador " + (i + 1) + " de " + numTrabajadores + " ---");

            String nombre = pedirNombre(scanner);
            double horas = pedirHoras(scanner);
            double precioHora = pedirPrecioHora(scanner);
            int aniosAntiguedad = pedirAniosAntiguedad(scanner);

            double salarioBruto = calcularSalarioBruto(horas, precioHora);
            double complemento = calcularComplementoAntiguedad(salarioBruto, aniosAntiguedad);
            double baseRetencion = salarioBruto + complemento;
            double tipoRetencion = calcularTipoRetencion(baseRetencion);
            double retencion = baseRetencion * tipoRetencion;
            double netoMensual = calcularSalarioNeto(baseRetencion, retencion);
            double netoAnual = calcularSalarioNetoAnual(netoMensual);

            mostrarNomina(nombre, horas, precioHora, aniosAntiguedad, salarioBruto,
                    complemento, baseRetencion, tipoRetencion, retencion,
                    netoMensual, netoAnual);

            totalNetosMensuales += netoMensual;

            if (netoMensual > salarioMasAlto) {
                salarioMasAlto = netoMensual;
                trabajadorConMasSalario = nombre;
            }
        }

        mostrarResumen(totalNetosMensuales, numTrabajadores,
                trabajadorConMasSalario, salarioMasAlto);

        scanner.close();
    }

    // ---------- Métodos void de entrada / salida ----------

    private static void mostrarBienvenida() {
        System.out.println("========================================");
        System.out.println("   GESTIÓN DE NÓMINAS DE UNA EMPRESA");
        System.out.println("========================================");
    }

    private static int pedirNumTrabajadores(Scanner scanner) {
        int num = 0;
        do {
            System.out.print("Número de trabajadores a registrar: ");
            num = scanner.nextInt();
            if (num <= 0) {
                System.out.println("El número de trabajadores debe ser mayor que 0.");
            }
        } while (num <= 0);
        return num;
    }

    private static String pedirNombre(Scanner scanner) {
        System.out.print("Nombre: ");
        // Tras leer un número queda un salto de línea pendiente, por eso
        // se descartan las líneas vacías antes de leer el nombre real.
        String nombre = scanner.nextLine();
        while (nombre.trim().isEmpty()) {
            nombre = scanner.nextLine();
        }
        return nombre.trim();
    }

    private static double pedirHoras(Scanner scanner) {
        double horas = 0;
        do {
            System.out.print("Horas trabajadas durante el mes: ");
            horas = scanner.nextDouble();
            if (horas < 0) {
                System.out.println("Las horas no pueden ser negativas.");
            }
        } while (horas < 0);
        return horas;
    }

    private static double pedirPrecioHora(Scanner scanner) {
        double precio = 0;
        do {
            System.out.print("Precio por hora: ");
            precio = scanner.nextDouble();
            if (precio < 0) {
                System.out.println("El precio por hora no puede ser negativo.");
            }
        } while (precio < 0);
        return precio;
    }

    private static int pedirAniosAntiguedad(Scanner scanner) {
        int anios = 0;
        do {
            System.out.print("Años de antigüedad: ");
            anios = scanner.nextInt();
            if (anios < 0) {
                System.out.println("Los años de antigüedad no pueden ser negativos.");
            }
        } while (anios < 0);
        return anios;
    }

    private static void mostrarNomina(String nombre, double horas, double precioHora,
            int aniosAntiguedad, double salarioBruto, double complemento,
            double baseRetencion, double tipoRetencion, double retencion,
            double netoMensual, double netoAnual) {
        System.out.println();
        System.out.println("=========== NÓMINA ===========");
        System.out.println("Trabajador:        " + nombre);
        System.out.println("Horas trabajadas:  " + horas);
        System.out.println("Precio por hora:   " + precioHora + " €");
        System.out.println("Antigüedad:        " + aniosAntiguedad + " años");
        System.out.println("Salario bruto:     " + redondear(salarioBruto) + " €");
        System.out.println("Complemento antig.: " + redondear(complemento) + " €");
        System.out.println("Base imponible:    " + redondear(baseRetencion) + " €");
        System.out.println("Retención (" + (tipoRetencion * 100) + "%): "
                + redondear(retencion) + " €");
        System.out.println("Salario neto mes:  " + redondear(netoMensual) + " €");
        System.out.println("Salario neto año:  " + redondear(netoAnual) + " €");
        System.out.println("===============================");
    }

    private static void mostrarResumen(double totalNetosMensuales, int numTrabajadores,
            String trabajadorConMasSalario, double salarioMasAlto) {
        System.out.println();
        System.out.println("========== RESUMEN ==========");
        System.out.println("Total de salarios netos mensuales: "
                + redondear(totalNetosMensuales) + " €");
        System.out.println("Salario neto mensual medio:         "
                + redondear(calcularSalarioMedio(totalNetosMensuales, numTrabajadores)) + " €");
        System.out.println("Trabajador con el salario más alto: "
                + trabajadorConMasSalario + " (" + redondear(salarioMasAlto) + " €)");
        System.out.println("=================================");
    }

    // ---------- Métodos con return (cálculos) ----------

    private static double calcularSalarioBruto(double horas, double precioHora) {
        return horas * precioHora;
    }

    private static double calcularComplementoAntiguedad(double salarioBruto, int aniosAntiguedad) {
        if (aniosAntiguedad < 3) {
            return salarioBruto * ANTIGUEDAD_MENOR_3;
        } else if (aniosAntiguedad <= 5) {
            return salarioBruto * ANTIGUEDAD_ENTRE_3_Y_5;
        } else {
            return salarioBruto * ANTIGUEDAD_MAS_5;
        }
    }

    private static double calcularTipoRetencion(double baseRetencion) {
        if (baseRetencion < 1200) {
            return RETENCION_MENOR_1200;
        } else if (baseRetencion <= 2000) {
            return RETENCION_ENTRE_1200_Y_2000;
        } else {
            return RETENCION_MAS_2000;
        }
    }

    private static double calcularSalarioNeto(double baseRetencion, double retencion) {
        return baseRetencion - retencion;
    }

    private static double calcularSalarioNetoAnual(double netoMensual) {
        return netoMensual * NUMERO_DE_PAGAS;
    }

    private static double calcularSalarioMedio(double totalNetos, int numTrabajadores) {
        if (numTrabajadores == 0) {
            return 0;
        }
        return totalNetos / numTrabajadores;
    }

    private static double redondear(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}

