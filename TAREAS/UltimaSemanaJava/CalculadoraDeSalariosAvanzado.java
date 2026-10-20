package Capitulo4;

import java.util.Scanner;

public class CalculadoraDeSalariosAvanzado {

    static final double TARIFA_HORA_NORMAL = 10.00;
    static final double TARIFA_HORA_EXTRA = 15.00;
    static final double HORAS_NORMALES = 8.0;
    static final double RETENCION_LEGAL = 0.10;
    static final double PRECIO_COMIDA_EMPRESA = 5.00;
    static final double PRECIO_COMIDA_FUERA = 8.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarEncabezado();

        String nombre = pedirNombre(scanner);
        String departamento = pedirDepartamento(scanner);
        double horaLlegada = pedirHora(scanner, "hora de llegada");
        double horaSalida = pedirHora(scanner, "hora de salida");

        double horasTotales = calcularHorasTrabajadas(horaLlegada, horaSalida);
        double horasNormales = calcularHorasNormales(horasTotales);
        double horasExtras = calcularHorasExtras(horasTotales);

        double salarioNormal = calcularSalarioNormal(horasNormales);
        double salarioExtras = calcularSalarioExtras(horasExtras);
        double salarioBruto = salarioNormal + salarioExtras;

        double propina = pedirPropina(scanner);

        int opcionComida = pedirOpcionComida(scanner);
        double descuentoComida = calcularDescuentoComida(opcionComida, horasTotales);

        double totalGanado = salarioBruto + propina;
        double retencion = calcularRetencion(totalGanado);
        double salarioNeto = totalGanado - retencion - descuentoComida;

        mostrarNominaCompleta(
                nombre, departamento,
                horaLlegada, horaSalida, horasTotales,
                horasNormales, horasExtras,
                salarioNormal, salarioExtras, salarioBruto,
                propina, totalGanado,
                retencion, descuentoComida, salarioNeto,
                opcionComida
        );

        scanner.close();
    }

    private static void mostrarEncabezado() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║        SISTEMA DE NÓMINA DE SALARIOS SEMANALES          ║");
        System.out.println("║              EMPRESA DE PARTICULARES                    ║");
        System.out.println("║                 VERSIÓN AVANZADA                        ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println();
    }

    private static String pedirNombre(Scanner scanner) {
        System.out.print("▶ Nombre completo del empleado: ");
        return scanner.nextLine().trim();
    }

    private static String pedirDepartamento(Scanner scanner) {
        System.out.print("▶ Departamento/Cargo: ");
        return scanner.nextLine().trim();
    }

    private static double pedirHora(Scanner scanner, String descripcion) {
        System.out.print("▶ Ingrese la " + descripcion + " (formato 24h, ej: 8.5 = 8:30): ");
        double hora = scanner.nextDouble();

        while (hora < 0 || hora > 24) {
            System.out.print("  ⚠ Hora inválida. Intente de nuevo: ");
            hora = scanner.nextDouble();
        }

        return hora;
    }

    private static double pedirPropina(Scanner scanner) {
        System.out.print("▶ Propinas recibidas esta semana ($): ");
        double propina = scanner.nextDouble();

        while (propina < 0) {
            System.out.print("  ⚠ No puede ser negativa. Intente de nuevo: ");
            propina = scanner.nextDouble();
        }

        return propina;
    }

    private static int pedirOpcionComida(Scanner scanner) {
        System.out.println();
        System.out.println("  ┌─────────────────────────────────────┐");
        System.out.println("  │  OPCIONES DE COMIDA DEL EMPLEADO     │");
        System.out.println("  ├─────────────────────────────────────┤");
        System.out.println("  │  1. Come en la empresa (gratis)      │");
        System.out.println("  │  2. Se lleva comida a casa (-$5/día) │");
        System.out.println("  │  3. No quiere comida (-$0)           │");
        System.out.println("  └─────────────────────────────────────┘");
        System.out.print("▶ Seleccione opción (1-3): ");
        int opcion = scanner.nextInt();

        while (opcion < 1 || opcion > 3) {
            System.out.print("  ⚠ Opción inválida. Intente de nuevo (1-3): ");
            opcion = scanner.nextInt();
        }

        return opcion;
    }

    private static double calcularHorasTrabajadas(double llegada, double salida) {
        double horas = salida - llegada;
        return horas > 0 ? horas : 0;
    }

    private static double calcularHorasNormales(double horasTotales) {
        return Math.min(horasTotales, HORAS_NORMALES);
    }

    private static double calcularHorasExtras(double horasTotales) {
        return Math.max(0, horasTotales - HORAS_NORMALES);
    }

    private static double calcularSalarioNormal(double horas) {
        return horas * TARIFA_HORA_NORMAL;
    }

    private static double calcularSalarioExtras(double horas) {
        return horas * TARIFA_HORA_EXTRA;
    }

    private static double calcularRetencion(double ingresoTotal) {
        return ingresoTotal * RETENCION_LEGAL;
    }

    private static double calcularDescuentoComida(int opcion, double horasTotales) {
        double diasTrabajados = Math.ceil(horasTotales / HORAS_NORMALES);

        switch (opcion) {
            case 1:
                return 0;
            case 2:
                return diasTrabajados * PRECIO_COMIDA_EMPRESA;
            case 3:
                return diasTrabajados * PRECIO_COMIDA_FUERA;
            default:
                return 0;
        }
    }

    private static void mostrarNominaCompleta(
            String nombre, String departamento,
            double llegada, double salida, double horasTotales,
            double horasNormales, double horasExtras,
            double salarioNormal, double salarioExtras, double salarioBruto,
            double propina, double totalGanado,
            double retencion, double descuentoComida, double salarioNeto,
            int opcionComida
    ) {
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                    📋 NÓMINA SEMANAL                    ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("  INFORMACIÓN DEL EMPLEADO");
        System.out.println("  ─────────────────────────");
        System.out.println("  Nombre:        " + nombre);
        System.out.println("  Departamento:  " + departamento);
        System.out.println();
        System.out.println("  HORARIO DE TRABAJO");
        System.out.println("  ─────────────────");
        System.out.println("  Hora llegada:  " + formatearHora(llegada));
        System.out.println("  Hora salida:   " + formatearHora(salida));
        System.out.println("  Total horas:   " + horasTotales + " horas");
        System.out.println();
        System.out.println("  DETALLE DE HORAS");
        System.out.println("  ────────────────");
        System.out.println("  Horas normales (" + HORAS_NORMALES + "h máx):  " + horasNormales + "h  x  " + TARIFA_HORA_NORMAL + "$ = " + String.format("%.2f", salarioNormal) + "$");
        System.out.println("  Horas extras (1.5x):     " + horasExtras + "h  x  " + TARIFA_HORA_EXTRA + "$ = " + String.format("%.2f", salarioExtras) + "$");
        System.out.println("  ─────────────────────────────────────────────────────────");
        System.out.println("  SALARIO BRUTO:                          " + String.format("%.2f", salarioBruto) + "$");
        System.out.println("  PROPINAS:                               " + String.format("%.2f", propina) + "$");
        System.out.println("  ═══════════════════════════════════════════════════════");
        System.out.println("  TOTAL GANADO:                           " + String.format("%.2f", totalGanado) + "$");
        System.out.println();
        System.out.println("  DEDUCCIONES");
        System.out.println("  ───────────");
        System.out.println("  Retención legal (10%):   -" + String.format("%.2f", retencion) + "$");
        System.out.println("  Comida:                  -" + String.format("%.2f", descuentoComida) + "$  (" + obtenerDescripcionComida(opcionComida) + ")");
        System.out.println("  ─────────────────────────────────────────────────────────");
        System.out.println("  TOTAL DEDUCCIONES:      -" + String.format("%.2f", retencion + descuentoComida) + "$");
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════════╗");
        System.out.println("  ║   SALARIO NETO A PAGAR: " + String.format("%.2f", salarioNeto) + "$                     ║");
        System.out.println("  ╚══════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("  Fecha de emisión: " + obtenerFechaActual());
        System.out.println("  ─────────────────────────────────────────────────────────");
    }

    private static String formatearHora(double hora) {
        int horas = (int) hora;
        int minutos = (int) ((hora - horas) * 60);
        return String.format("%02d:%02d", horas, minutos);
    }

    private static String obtenerDescripcionComida(int opcion) {
        switch (opcion) {
            case 1:
                return "Come en empresa";
            case 2:
                return "Se lleva a casa";
            case 3:
                return "No desea comida";
            default:
                return "N/A";
        }
    }

    private static String obtenerFechaActual() {
        java.time.LocalDate fecha = java.time.LocalDate.now();
        return java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy").format(fecha);
    }
}
