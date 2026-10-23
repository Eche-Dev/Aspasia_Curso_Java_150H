================================================================
 RESUMEN DE LOS EJERCICIOS DE JAVA
----------------------------------------------------------------
 Este archivo lo crea ACTUALIZAR.bat con los encabezados que
 tiene cada ejercicio. NO lo edites a mano: se reescribe solo.
 Generado el 23/10/2026 10:32
================================================================

 Hay 32 ejercicios. Cada bloque es un ejercicio:
 primero su carpeta, luego su titulo y su descripcion, y al final
 los encabezados que lleva escritos el propio archivo .java.

================================================================
 Proyecto - Dia1 Ejercicio1
================================================================

 Variables y tipos de datos
   Declara una variable de cada tipo básico (String, double, int y boolean) y las muestra por pantalla.

   Archivo: Java/Proyecto/src/main/java/Modulo1/Dia1_Ejercicio1/Ej1.java
   Encabezados del ejercicio:
     * PRIMER EJERCICIO FACIL - Ejercicio 1.
     * El enunciado pide declarar una variable de cada tipo basico y mostrarlas:
     * 1. Un String (texto).
     * 2. Un double (numero con decimales).
     * 3. Un int (numero entero).
     * 4. Un boolean (verdadero o falso).

================================================================
 Proyecto - Dia1 Ejercicio2
================================================================

 Datos de un producto
   Muestra una ficha con el nombre, el precio, las unidades disponibles y si el producto está en oferta.

   Archivo: Java/Proyecto/src/main/java/Modulo1/Dia1_Ejercicio2/PProducto.java
   Encabezados del ejercicio:
     * PRIMER EJERCICIO FACIL - Ejercicio del producto.
     * El enunciado pide declarar una variable de cada tipo basico con datos
     * de un producto y mostrarlos:
     * 1. Un String con el nombre del producto.
     * 2. Un double con el precio.
     * 3. Un int con las unidades disponibles.
     * 4. Un boolean que dice si esta en oferta.

================================================================
 Proyecto - Dia1 Ejercicio3
================================================================

 Ficha personal
   Presenta mis datos personales: país, ciudad, edad, cumpleaños, dirección y estudios.

   Archivo: Java/Proyecto/src/main/java/Modulo1/Dia1_Ejercicio3/YoSolito.java
   Encabezados del ejercicio:
     * PRIMER EJERCICIO FACIL - Presentacion personal ("Yo solito").
     * El enunciado pide declarar una variable para cada dato personal
     * (texto, enteros y booleanos) y mostrarlos todos en pantalla.

================================================================
 Proyecto - Dia1 Ejercicio4
================================================================

 Clase Alumno
   Primera clase con atributos y métodos: crea la ficha de un alumno (nombre, nota, faltas) y dice si ha aprobado.

   Archivo: Java/Proyecto/src/main/java/Modulo1/Dia1_Ejercicio4/Alumno.java
   Encabezados del ejercicio:
     * DIA 1 - EJERCICIO 4: creacion de una clase (POO).
     * El enunciado pide crear la clase "Alumno" con los datos:
     * 1. Atributos: nombre, nota, faltas y evaluacion.
     * 2. Un constructor que da los valores iniciales.
     * 3. Los getters y setters de cada atributo.
     * 4. Un metodo toString() que devuelve el texto del alumno.
     * 5. Un metodo mostrar() que imprime el alumno en pantalla.
     * Los atributos son "private" para que nadie los cambie por fuera de la clase:
     * se entra por el setter y se sale por el getter.

================================================================
 Proyecto - Dia1 Ejercicio5
================================================================

 Probando la clase Alumno
   Crea un objeto de la clase Alumno con datos de prueba e imprime su ficha completa por pantalla.

   Archivo: Java/Proyecto/src/main/java/Modulo1/Dia1_Ejercicio5/PAlumno.java
   Encabezados del ejercicio:
     * DIA 1 - EJERCICIO 5: uso de la clase Alumno.
     * El enunciado pide crear un alumno y probarlo:
     * 1. Crear el objeto con "new" y los valores.
     * 2. Ver el toString() del objeto.
     * 3. Llamar al metodo mostrar().

================================================================
 Proyecto - Dia1 Ejercicio6
================================================================

 Atributos y setters
   Guarda los puntos iniciales en un atributo de la clase yPractica el getter y el setter para leerlo y cambiarlo.

   Archivo: Java/Proyecto/src/main/java/Modulo1/Dia1_Ejercicio6/Variables.java
   Encabezados del ejercicio:
     * DIA 1 - EJERCICIO 6: clase Variables.
     * El enunciado pide:
     * 1. Guardar en un atributo la variable "puntos_iniciales".
     * 2. Crear el constructor que da el valor inicial.
     * 3. Los getters y setters.
     * 4. Un toString() y un metodo mostrar_variables().
     * OJO: para que esta clase exista al correr hay que compilar el proyecto
     * completo. Si solo se ejecuta el archivo que la usa (Shift+F6 = "Run File"),
     * NetBeans compila unicamente ese archivo y esta clase no se genera, dando el error:
     * NoClassDefFoundError: Dia1_Ejercicio6/Variables
     * Solucion: usar F6 ("Run Project") o hacer "Clean and Build" una vez.

================================================================
 Proyecto - Dia1 Ejercicio7
================================================================

 Puntos iniciales
   Crea un objeto con 10 puntos de valor inicial y muestra su número y su texto.

   Archivo: Java/Proyecto/src/main/java/Modulo1/Dia1_Ejercicio7/VariableRun.java
   Encabezados del ejercicio:
     * DIA 1 - EJERCICIO 7: uso de la clase Variables.
     * El enunciado pide:
     * 1. Crear el objeto con un valor inicial.
     * 2. Mostrar la variable.
     * 3. Ver el toString() del objeto.

================================================================
 Proyecto - Dia2 Ejercicio1
================================================================

 Datos con Scanner
   Pide por teclado el nombre, la edad y la altura y muestra después una ficha con los tres datos.

   Archivo: Java/Proyecto/src/main/java/Modulo1/Dia2_Ejercicio1/AngelEjercicio.java
   Encabezados del ejercicio:
     * DIA 2 - EJERCICIO 1: pedir datos por teclado.
     * El enunciado pide:
     * 1. Pedir el nombre por teclado.
     * 2. Pedir la edad por teclado.
     * 3. Pedir la altura por teclado.
     * 4. Mostrar los tres datos.

================================================================
 Proyecto - Dia2 Ejercicio2
================================================================

 Precio con descuentos
   Calcula el precio final de una compra aplicando un 10 % de descuento y después un 21 % de IVA.

   Archivo: Java/Proyecto/src/main/java/Modulo1/Dia2_Ejercicio2/PercioConDescuentos.java
   Encabezados del ejercicio:
     * DIA 2 - EJERCICIO 2: precio con descuento e IVA.
     * El enunciado pide:
     * 1. Declarar el precio y la cantidad.
     * 2. Calcular el importe total.
     * 3. Calcular un descuento del 10 %.
     * 4. Calcular cuanto dinero se descuenta.
     * 5. Restar el descuento al importe total.
     * 6. Calcular el IVA del 21 % sobre el precio ya descontado.
     * 7. Sumar el IVA para obtener el precio final.
     * 8. Mostrarlo en pantalla.

================================================================
 Proyecto - Dia2 Ejercicio3
================================================================

 Triángulo completo
   Pide la base y la altura por teclado y calcula el área, la hipotenusa y el perímetro del triángulo.

   Archivo: Java/Proyecto/src/main/java/Modulo1/Dia2_Ejercicio3/AngelEjercios2.java
   Encabezados del ejercicio:
     * DIA 2 - EJERCICIO 3: triangulo (area y perimetro) pidiendo datos por teclado.
     * El enunciado pide:
     * 1. Pedir la base del triangulo.
     * 2. Pedir la altura.
     * 3. Calcular el area: (base * altura) / 2.
     * 4. Calcular la hipotenusa con el teorema de Pitagoras.
     * 5. Calcular el perimetro sumando los 3 lados.
     * 6. Mostrar el resultado.

================================================================
 Proyecto - Dia3 Ejercicio1
================================================================

 Área de un triángulo
   Pide la base y la altura por teclado y muestra el área del triángulo (base x altura / 2).

   Archivo: Java/Proyecto/src/main/java/Modulo1/Dia3_Ejercicio1/AreaTriangulo.java
   Encabezados del ejercicio:
     * Pide por teclado la base y la altura de un triangulo
     * y calcula su area con la formula: area = (base * altura) / 2

================================================================
 Proyecto - Dia3 Ejercicio2
================================================================

 Calculadora de la compra
   Calcula el importe de una compra y le aplica un 10 % de descuento solo si supera los 100 €, más un 21 % de IVA.

   Archivo: Java/Proyecto/src/main/java/Modulo1/Dia3_Ejercicio2/Calculadora.java
   Encabezados del ejercicio:
     * DIA 3 - EJERCICIO 2: Calculadora de compras con descuento por importe.
     * El enunciado pide:
     * 1. Pedir al usuario el nombre del producto.
     * 2. Pedir al usuario el precio de una unidad.
     * 3. Pedir al usuario la cantidad que desea comprar.
     * 4. Calcular el importe de la compra (precio unidad * cantidad).
     * 5. Aplicar un descuento del 10 % si el importe es igual o superior a 100 euros.
     * 6. Calcular el importe del descuento aplicado.
     * 7. Calcular el importe de la compra tras el descuento.
     * 8. Calcular el IVA del 21 % sobre el importe YA descontado.
     * 9. Calcular el precio final (importe descontado + IVA).
     * 10. Mostrarlo todo en pantalla.

================================================================
 Proyecto - Tarea4 Ejercicio1
================================================================

 Precio con descuento e IVA
   Versión sencilla (todo dentro del main) del precio final de 3 zapatillas con un 10 % de descuento y un 21 % de IVA.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea4_Ejercicio1/PrecioConDescuentoEIVA.java
   Encabezados del ejercicio:
     * TAREA 4 - Precio con descuento e IVA (version sencilla, todo dentro del main).
     * El enunciado pide:
     * 1. Crear la variable para la cantidad y el precio.
     * 2. Calcular el importe total.
     * 3. Calcular un descuento del 10 %.
     * 4. Calcular cuanto dinero se descuenta en total.
     * 5. Restar el descuento al importe total.
     * 6. Calcular el IVA del 21 % sobre el precio despues de aplicar el descuento.
     * 7. Obtener el precio final.
     * 8. Mostrarlo en pantalla.

================================================================
 Proyecto - Tarea4 Ejercicio1
================================================================

 Precio con descuento e IVA (Tarea 9)
   Tercera versión del ejercicio del precio final: 5 productos de 50 € con un 10 % de descuento y un 21 % de IVA, con los porcentajes como variables.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea4_Ejercicio1/precioDescuento.java
   Encabezados del ejercicio:
     * TERCER DIA - Precio con descuento e IVA.
     * El enunciado pide:
     * 1. Crear la variable para la cantidad y el precio.
     * 2. Calcular el importe total.
     * 3. Calcular un descuento del 10 %.
     * 4. Calcular cuanto dinero se descuenta en total.
     * 5. Restar el descuento al importe total.
     * 6. Calcular el IVA del 21 % sobre el precio despues de aplicar el descuento.
     * 7. Obtener el precio final.
     * 8. Mostrarlo en pantalla.

================================================================
 Proyecto - Tarea4 Ejercicio2
================================================================

 Clase Compra
   El mismo cálculo del precio final pero con los datos guardados en los atributos de una clase y cada cálculo en su método.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea4_Ejercicio2/Compra.java
   Encabezados del ejercicio:
     * TAREA 4 - Precio con descuento e IVA (version con clase).
     * En vez de hacer todos los calculos dentro del main, se guardan los datos
     * (nombre, cantidad y precio) en los atributos de la clase y cada calculo
     * se hace en su propio metodo. Asi el programa queda mas ordenado y la clase
     * se puede reutilizar desde cualquier otro sitio.
     * Una comparacion detallada de las dos versiones esta en el archivo DIFERENCIAS.md.

================================================================
 Proyecto - Tarea4 Ejercicio3
================================================================

 Temperaturas de la semana (con clase)
   Guarda las 7 temperaturas en un array y calcula en métodos aparte la suma, la media, la máxima, la mínima y los días por encima de la media.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea4_Ejercicio3/TemperaturaSemanales.java
   Encabezados del ejercicio:
     * TAREA 4 - Temperaturas de una semana (version con clase).
     * Se guardan las 7 temperaturas de la semana en un array y cada calculo
     * (promedio, maxima, minima, dias por encima del promedio...) se hace en su
     * propio metodo, de forma que la clase se pueda reutilizar mas adelante.

================================================================
 Proyecto - Tarea4 Ejercicio3
================================================================

 Temperaturas de la semana (sencillo)
   El mismo ejercicio con las temperaturas escritas a mano y todo el cálculo dentro del main, sin clases ni métodos.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea4_Ejercicio3/TempSemanales2.java
   Encabezados del ejercicio:
     * TAREA 4 - Temperaturas de la semana (version sencilla, todo dentro del main).
     * El enunciado pide:
     * 1. Crear un array con la temperatura de los 7 dias.
     * 2. Calcular la temperatura media de la semana.
     * 3. Sacar la temperatura maxima y la minima.
     * 4. Contar cuantos dias superan la media.
     * 5. Mostrarlo en pantalla.

================================================================
 Proyecto - Tarea4 Ejercicio3
================================================================

 Temperaturas de la semana (por teclado)
   El mismo ejercicio pero el programa pregunta la temperatura de cada día con un Scanner y la guarda en un array.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea4_Ejercicio3/TempSemanalesTeclado.java
   Encabezados del ejercicio:
     * TAREA 4 - Temperaturas de la semana pedidas por teclado.
     * Mismo ejercicio que los anteriores, pero en vez de escribir las temperaturas
     * a mano en el codigo, el programa le PREGUNTA al usuario la temperatura de
     * cada uno de los 7 dias.
     * Para saber cuanto vale cada dia se usa un array con los nombres de los dias
     * y un bucle for que va tomando una temperatura por cada nombre.

================================================================
 Proyecto - Tarea5 Ejercicio2
================================================================

 Control de notas (básico)
   Primer contacto con Scanner: pide las notas por teclado y muestra el resultado de los cálculos.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea5_Ejercicio2/ClasesNotas.java

================================================================
 Proyecto - Tarea5 Ejercicio2
================================================================

 Control de notas (avanzado)
   Control de notas con Scanner a nivel avanzado: validación antes de leer, conversión con control de errores y delimitadores.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea5_Ejercicio2/ClasesNotasAvanzado.java
   Encabezados del ejercicio:
     * Control de notas usando Scanner a un nivel más avanzado:
     * validación antes de leer, conversión con control de errores y delimitadores.

================================================================
 Proyecto - Tarea5 Ejercicio2
================================================================

 Control de notas (intermedio)
   Control de notas de varios alumnos con una clase propia, métodos separados y una lista de objetos.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea5_Ejercicio2/ClasesNotasIntermedio.java
   Encabezados del ejercicio:
     * Control de notas de varios alumnos, en nivel intermedio:
     * una clase propia, métodos separados y una lista de objetos.

================================================================
 Proyecto - Tarea6 Ejercicio1
================================================================

 Control de Aparcamiento
   Borrador inicial del control de estacionamiento: la primera versión del ejercicio, con el cálculo de la tarifa y el descuento por permanencia.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea6_Ejercicio1/ControlAparcamiento.java

================================================================
 Proyecto - Tarea6 Ejercicio1
================================================================

 Clase Estacionamiento
   La clase del estacionamiento con los datos privados: nadie desde fuera toca las listas ni recalcula a su manera, todo pasa por sus métodos públicos.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea6_Ejercicio1/Estacionamiento.java
   Encabezados del ejercicio:
     * Control de estacionamiento encapsulado.
     * Los datos son privados: nadie desde fuera puede tocar las listas ni
     * recalcular a su manera. Para trabajar con el estacionamiento se usan
     * los métodos públicos, que son la única puerta de entrada.
     * Tarifa: las primeras 2 horas a 2,00 €/hora; cada hora adicional a 1,50 €.
     * Si el vehículo ha estado más de 5 horas, se aplica un 10 % de descuento.

================================================================
 Proyecto - Tarea6 Ejercicio1
================================================================

 Estacionamiento (avanzado)
   Nivel avanzado: cada vehículo es un objeto con sus propios datos, la entrada se valida con try/catch y, además del total y los descuentos, se calculan estadísticas de quién ha estado más horas y quién paga más.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea6_Ejercicio1/EstacionamientoAvanzado.java
   Encabezados del ejercicio:
     * Control de estacionamiento, nivel avanzado.
     * Cada vehículo es un objeto con sus propios datos, la entrada se valida
     * con try/catch y, además del total y los descuentos, se calculan
     * estadísticas: quién ha estado más horas y quién paga más.
     * Tarifa: las primeras 2 horas a 2,00 €/hora; cada hora adicional a 1,50 €.
     * Si el vehículo ha estado más de 5 horas, se aplica un 10 % de descuento.

================================================================
 Proyecto - Tarea6 Ejercicio1
================================================================

 Estacionamiento (básico)
   Control de estacionamiento, nivel básico: pregunta cuántos vehículos hay y las horas de cada uno, calcula el precio, la recaudación total y cuántos vehículos tienen descuento. Tarifa: 2 horas a 2,00 €/hora y cada hora adicional a 1,50 €, con un 10 % de descuento si el vehículo pasa de 5 horas.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea6_Ejercicio1/EstacionamientoBasico.java
   Encabezados del ejercicio:
     * Control de estacionamiento, nivel básico.
     * Pregunta cuántos vehículos hay y las horas de cada uno, calcula el precio
     * y la recaudación total, y cuenta cuántos vehículos tienen descuento.
     * Tarifa: las primeras 2 horas a 2,00 €/hora; cada hora adicional a 1,50 €.
     * Si el vehículo ha estado más de 5 horas, se aplica un 10 % de descuento.

================================================================
 Proyecto - Tarea6 Ejercicio1
================================================================

 Estacionamiento (intermedio)
   El mismo cálculo que el básico, pero el main solo coordina: cada cosa vive en su método y los datos van en listas de objetos en vez de arrays de tamaño fijo.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea6_Ejercicio1/EstacionamientoIntermedio.java
   Encabezados del ejercicio:
     * Control de estacionamiento, nivel intermedio.
     * Mismo cálculo que el básico, pero el main solo coordina:
     * cada cosa vive en su método, y los datos van en listas de objetos
     * en vez de arrays de tamaño fijo.
     * Tarifa: las primeras 2 horas a 2,00 €/hora; cada hora adicional a 1,50 €.
     * Si el vehículo ha estado más de 5 horas, se aplica un 10 % de descuento.

================================================================
 Proyecto - Tarea6 Ejercicio1
================================================================

 Main del estacionamiento
   El main del proyecto: solo pide datos por teclado con Scanner y llama a los métodos públicos de Estacionamiento, con validación de enteros y try/catch para que el programa no se caiga.

   Archivo: Java/Proyecto/src/main/java/Modulo2/Tarea6_Ejercicio1/EstacionamientoMain.java
   Encabezados del ejercicio:
     * Main del control de estacionamiento.
     * Aquí solo se pide datos por teclado y se llaman los métodos públicos
     * de Estacionamiento. La clase Estacionamiento guarda y calcula; este
     * main no toca sus datos privados.

================================================================
 Sueltos
================================================================

 Primerclase
   Ejercicio de Java: Sueltos.

   Archivo: Java/Sueltos/PrimerClase.java

================================================================
 UltimaSemana
================================================================

 Calculadora de salarios
   Pide nombre, horas trabajadas y precio por hora, y calcula el salario bruto, la retención del 10% y el salario final con Scanner y métodos.

   Archivo: Java/UltimaSemana/CalculadoraDeSalarios.java

================================================================
 UltimaSemana
================================================================

 Calculadora de salarios (avanzado)
   Trabaja por jornada: pide departamento, hora de llegada y salida, parte entre horas normales y extras, y suma la comida de la empresa o de fuera.

   Archivo: Java/UltimaSemana/CalculadoraDeSalariosAvanzado.java

================================================================
 UltimaSemana
================================================================

 Calculadora de salarios (intermedio)
   Separa horas normales (40) de horas extras a 15€ y pregunta el tipo de contrato: si es legal aplica la retención y si no, paga entero.

   Archivo: Java/UltimaSemana/CalculadoraDeSalariosIntermedio.java

================================================================
 UltimaSemana
================================================================

 Gestión de nóminas
   Registra a los trabajadores de una empresa (nombre, horas, precio hora y antigüedad) y calcula el salario bruto, el complemento, la retención, el neto mensual y el neto anual de 12 pagas.

   Archivo: Java/UltimaSemana/GestiosNomina.java
   Encabezados del ejercicio:
     * Gestión de nóminas de una empresa.
     * El programa pide cuántos trabajadores se registran y, para cada uno, su
     * nombre, horas trabajadas, precio por hora y años de antigüedad. Con esos
     * datos calcula el salario bruto, el complemento por antigüedad, la
     * retención, el salario neto mensual y el neto anual (12 pagas).
     * Requisitos cubiertos: Scanner, bucle for, if / else if / else,
     * métodos void y con return, parámetros en los métodos y ninguna
     * entrada negativa.

