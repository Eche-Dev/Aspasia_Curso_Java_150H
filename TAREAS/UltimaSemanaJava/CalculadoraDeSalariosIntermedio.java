package Capitulo4;

import java.util.Scanner;

public class CalculadoraDeSalariosIntermedio {

    static final double PRECIO_HORA = 10.00;
    static final double PRECIO_HORA_EXTRA = 15.00;
    static final double HORAS_NORMALES = 40;
    static final double RETENCION = 0.10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarBienvenida();

        String nombre = pedirNombre(scanner);
        double horasTrabajadas = pedirHoras(scanner);
        boolean esLegal = pedirTipoContrato(scanner);

        double salarioBruto = calcularSalarioBruto(horasTrabajadas);
        double retencion = 0;
        double salarioFinal;

        if (esLegal) {
            retencion = calcularRetencion(salarioBruto);
            salarioFinal = calcularSalarioFinal(salarioBruto, retencion);
        } else {
            salarioFinal = salarioBruto;
        }

        mostrarNomina(nombre, salarioBruto, retencion, salarioFinal, esLegal);

        scanner.close();
    }

    private static void mostrarBienvenida() {
        System.out.println("========================================");
        System.out.println(" CALCULADORA DE SALARIOS SEMANALES");
        System.out.println("         (NIVEL INTERMEDIO)");
        System.out.println("========================================");
    }

    private static String pedirNombre(Scanner scanner) {
        System.out.print("Nombre del trabajador: ");
        return scanner.nextLine();
    }

    private static double pedirHoras(Scanner scanner) {
        System.out.print("Horas trabajadas en la semana: ");
        return scanner.nextDouble();
    }

    private static boolean pedirTipoContrato(Scanner scanner) {
        System.out.println();
        System.out.println("Tipo de trabajo:");
        System.out.println("1 - Legal (con seguro)");
        System.out.println("2 - En negro (sin seguro)");
        System.out.print("Elija una opcion (1 o 2): ");
        int opcion = scanner.nextInt();
        return opcion == 1;
    }

    private static double calcularSalarioBruto(double horas) {
        double salarioBase = 0;

        if (horas <= HORAS_NORMALES) {
            salarioBase = horas * PRECIO_HORA;
        } else {
            double horasNormales = HORAS_NORMALES;
            double horasExtras = horas - HORAS_NORMALES;
            salarioBase = (horasNormales * PRECIO_HORA) + (horasExtras * PRECIO_HORA_EXTRA);
        }

        return salarioBase;
    }

    private static double calcularRetencion(double salarioBruto) {
        return salarioBruto * RETENCION;
    }

    private static double calcularSalarioFinal(double salarioBruto, double retencion) {
        return salarioBruto - retencion;
    }

    private static void mostrarNomina(String nombre, double bruto, double retencion, double final_, boolean esLegal) {
        System.out.println();
        System.out.println("=========== NOMINA SEMANAL ===========");
        System.out.println("TRABAJADOR: " + nombre);
        System.out.println("SALARIO BRUTO: " + bruto + "$");

        if (esLegal) {
            System.out.println("RETENCION (10%): -" + retencion + "$");
            System.out.println("SALARIO FINAL: " + final_ + "$");
            System.out.println("ESTADO: Empleado legal (asegurado)");
        } else {
            System.out.println("RETENCION: 0$");
            System.out.println("SALARIO FINAL: " + final_ + "$");
            System.out.println("ESTADO: Trabajo en negro (sin seguro)");
            System.out.println("NOTA: No se aplica retencion porque");
            System.out.println("      el trabajador no esta asegurado.");
        }
        System.out.println("======================================");
    }
}
