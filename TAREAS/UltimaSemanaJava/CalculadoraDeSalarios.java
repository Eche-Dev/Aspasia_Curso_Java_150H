package Capitulo4;

import java.util.Scanner;

public class CalculadoraDeSalarios {

    static final double PRECIO_HORA_TRABAJO = 10.00;
    static final double PRECIO_HORA_EXTRA = 15.00;
    static final double RETENCION = 0.10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarBienvenida();

        String nombre = pedirNombre(scanner);
        double horasTrabajadas = pedirHoras(scanner);
        double precioPorHora = pedirPrecioPorHora(scanner);

        double salarioBruto = calcularSalarioBruto(horasTrabajadas, precioPorHora);
        double retencion = calcularRetencion(salarioBruto);
        double salarioFinal = calcularSalarioFinal(salarioBruto, retencion);

        mostrarNomina(nombre, salarioBruto, retencion, salarioFinal);

        scanner.close();
    }

    private static void mostrarBienvenida() {
        System.out.println("========================================");
        System.out.println(" BIENVENIDO A LA CALCULADORA");
        System.out.println(" DE SALARIO SEMANALES");
        System.out.println("========================================");
    }

    private static String pedirNombre(Scanner scanner) {
        System.out.print("Nombre del trabajador: ");
        return scanner.nextLine();
    }

    private static double pedirHoras(Scanner scanner) {
        System.out.print("Horas trabajadas: ");
        return scanner.nextDouble();
    }

    private static double pedirPrecioPorHora(Scanner scanner) {
        System.out.print("Precio por hora: ");
        return scanner.nextDouble();
    }

    private static double calcularSalarioBruto(double horas, double precio) {
        return horas * precio;
    }

    private static double calcularRetencion(double salarioBruto) {
        return salarioBruto * RETENCION;
    }

    private static double calcularSalarioFinal(double salarioBruto, double retencion) {
        return salarioBruto - retencion;
    }

    private static void mostrarNomina(String nombre, double bruto, double retencion, double final_) {
        System.out.println();
        System.out.println("--------- NOMINA ---------");
        System.out.println("TRABAJADOR: " + nombre);
        System.out.println("SALARIO BRUTO: " + bruto + "$");
        System.out.println("RETENCION (10%): " + retencion + "$");
        System.out.println("SALARIO FINAL: " + final_ + "$");
        System.out.println("--------------------------");
    }
}
