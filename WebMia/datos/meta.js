/* ============================================================
   KINDRED.JAVA - METADATOS (ARCHIVO QUE EDITAS TÚ)
   ------------------------------------------------------------
   Los TÍTULOS y los ENLACES se sacan solos de tus carpetas:
   el script ACTUALIZAR.bat los lee y escribe en js\datos.js.

   En este archivo solo pones lo que una máquina no puede saber:
   la DESCRIPCIÓN y las ETIQUETAS de cada trabajo.

   Cuando añadas un trabajo nuevo a una carpeta no hace falta
   tocar este archivo: el script lo detecta y lo enseña con un
   texto por defecto. Rellena aquí solo si quieres nicer el texto.

    CÓMO AÑADIR ALGO NUEVO:
      1. Copia la carpeta a su sitio del proyecto:
             ..\Tareas\        trabajos de clase  (ejemplo: Sexta-tarea)
             ..\Practicas\     prácticas manuales de casa
             ..\Java\          ejercicios de Java
             ..\Recursos\      PDF, fotos y apuntes de clase
             ..\Ejercicios_IA\ proyectos hechos con IA
             ..\LibreriaProfe\ componentes del profe
      2. Doble clic en  ACTUALIZAR.bat
      3. Listo: la tarjeta aparece sola en la web.

   OJO: dentro de los { } las claves van entre comillas ("desc")
   y NO se pueden poner comentarios; los comentarios van con //
   en su propia línea.
   ============================================================ */


// ---- ORDEN DE LAS CARPETAS DE TAREAS ----
// El orden en el que se ven las tarjetas.
// Las carpetas que NO estén en esta lista saldrán al final
// por orden alfabético.
var ORDEN_TAREAS = [
    "Primera_Tarea",
    "Segunda_Tarea",
    "Tercera_Tarea",
    "Cuarta_tarea",
    "Quinta_tarea-Js-dentro-de-html",
    "Sexta-tarea",
    "Septima_tarea"
];


// ---- TRABAJOS DE CLASE (dentro de ..\Tareas) ----
//
// CÓMO SE AGRUPA (lo hace el script solo):
//   Cada CARPETA que tenga un .html es una tarjeta de la web.
//   El PDF de al lado se asigna a esa misma tarjeta. Por eso en la
//   Cuarta Tarea salen dos tarjetas: Tarea1 y Tarea2.
//
// QUÉ ESCRIBE AQUÍ CADA TARJETA:
//   "nombre"  = la etiqueta que sale arriba ("Cuarta Tarea")
//   "titulo"  = si lo pones, gana al <title> de la página
//   "desc"    = la descripción
//   "tags"    = las etiquetas de color
//   "badge"   = el texto de la etiqueta verde
//   "grupos"  = opcional: cosas que solo aplican a UNA subcarpeta
//   "botones" = opcional: cambiar el texto de un botón
//   "enunciados" = opcional: cambiar el texto de un PDF
var META_TAREAS = {

    "Primera_Tarea": {
        "nombre": "Primera Tarea",
        "desc": "Estructura básica de una página web con las etiquetas semánticas de HTML5 (header, nav, main, aside y footer) maquetadas con Flexbox.",
        "tags": ["HTML", "CSS"],
        "badge": "Completada"
    },

    "Segunda_Tarea": {
        "nombre": "Segunda Tarea",
        "desc": "Página con tabla de imágenes: 6 fotos de personajes colocadas en filas y columnas, con efecto hover que amplía y gira la imagen.",
        "tags": ["HTML", "CSS"],
        "badge": "Completada"
    },

    "Tercera_Tarea": {
        "nombre": "Tercera Tarea",
        "tarjetas": [
            {
                "titulo": "Actividades | Venezuela Natural",
                "botones": ["actividades.html"]
            }
        ],
        "omitirNoListadas": true,
        "botones": {
            "actividades.html": "Actividades"
        },
        "desc": "Web completa de turismo rural: galería de paisajes, tabla de precios, formulario de contacto y enlaces internos con identificadores (id).",
        "tags": ["HTML", "CSS"],
        "badge": "Completada"
    },

    // Esta entrega tiene DOS ejercicios en subcarpetas, así que cada
    // uno tiene su propia tarjeta (con su página y su PDF)
    "Cuarta_tarea": {
        "nombre": "Cuarta Tarea",
        "tags": ["HTML", "JS"],
        "badge": "Completada",
        "grupos": {
            "Tarea1": {
                "titulo": "JavaScript - Ejercicios de funciones",
                "desc": "5 ejercicios de funciones: saludar, mostrar un nombre, sumar, calcular el doble con return y calcular el precio total de una compra.",
                "botones": { "index.html": "Ver tarea" }
            },
            "Tarea2": {
                "titulo": "JavaScript - Variables y document.write()",
                "desc": "5 ejercicios de variables: datos personales, cálculo de un producto, edad, precio con descuento y resumen de compra completo.",
                "botones": { "index.html": "Ver tarea" }
            }
        }
    },

    "Quinta_tarea-Js-dentro-de-html": {
        "nombre": "Quinta Tarea - JavaScript en el HTML",
        "tags": ["HTML", "JS"],
        "badge": "Completada",

        // "tarjetas" es opcional: te permite decidir tú cómo se reparten
        // las páginas de una entrega en varias tarjetas de la web.
        //   "botones" = los archivos .html que van en cada tarjeta
        //   "titulo" / "desc" = el texto de esa tarjeta
        // (las páginas que no pongas aquí se agrupan solas en una tarjeta
        //  llamada "Otros ejercicios", para que no se pierda ningún archivo)
        "tarjetas": [
            {
                "titulo": "Ejercicios de variables y funciones",
                "desc": "Los mismos 10 ejercicios de la Cuarta Tarea (5 de variables y 5 de funciones), pero con el JavaScript escrito <em>dentro</em> de la propia etiqueta <em>&lt;script&gt;</em> en vez de en un archivo externo.",
                "botones": ["inicio-variables-funciones.html"]
            },
            {
                "titulo": "Variables, condicionales y bucles",
                "desc": "Ejercicios interactivos de variables, bucles y condicionales: utiliza un bucle for para contar hasta un número elegido y comprueba con if / else si un número es par o impar.",
                "botones": ["variables.html"]
            }
        ],
        "omitirNoListadas": true,

        // texto de los botones: la clave es el nombre del archivo
        "botones": {
            "variables.html": "Ver tarea",
            "inicio-variables-funciones.html": "Ver tarea"
        }
    },

    // Programa que pide la edad, el carnet y los años de experiencia
    "Sexta-tarea": {
        "nombre": "Sexta Tarea - ¿Puedo conducir?",
        "titulo": "¿Puedo conducir? (if / else)",
        "desc": "Programa con if / else y botones: primero pides la edad, luego eliges con botones Sí / No si tienes carnet, y solo si lo tienes te pregunta los años de experiencia. Con menos de 18 años o sin carnet no puede conducir y el programa se detiene; con carnet y de 2 a 5 años de experiencia es de nivel medio, y con más de 5 años, experimentado.",
        "tags": ["HTML", "JS"],
        "badge": "Completada"
    },

    // Selector de color con HTML, CSS y JavaScript en archivos separados
    "Septima_tarea": {
        "nombre": "Septima Tarea - Selector de color",
        "titulo": "Selector de color",
        "desc": "Selector de color con eventos y funciones: eliges un color con el input type=\"color\" o con una paleta de 5 botones, y la previa cambia de color mostrando su valor en HEX y en RGB. Incluye botón de color aleatorio y otro para copiarlo al portapapeles.",
        "tags": ["HTML", "CSS", "JS"],
        "badge": "Completada",
        "botones": {
            "Selector_de_color.html": "Abrir selector"
        }
    }

};


// ---- PRÁCTICAS DE CASA (dentro de ..\Practicas) ----
var META_PRACTICAS = {

    "Practicas/HTML-Practice/Proyecto1.html": {
        "desc": "Página hecha a mano con las etiquetas semánticas de HTML5 (header, nav, main, aside y footer) y un fondo de Kindred.",
        "tags": ["HTML"],
        "badge": "Abierta"
    },

    "Practicas/JS-Practice/js.html": {
        "desc": "Ejercicios de variables con let, const y tipos de datos. Los resultados se ven en la consola del navegador (pulsa F12 > Console).",
        "tags": ["JS"],
        "badge": "Abierta"
    },

    "Practicas/CSS-Practice/Style.css": {
        "desc": "Mi archivo de estilos manual: reset con box-sizing, base de 20px y estilos generales del body, con comentarios explicando cada línea.",
        "tags": ["CSS"],
        "badge": "Código"
    },

    "Practicas/Py-Practice/calculadora.py": {
        "desc": "Calculadora en Python: pide el nombre, el precio y la cantidad de un producto, calcula el coste total y aplica un 10 % de descuento con if / else si el total llega a 100 € o más.",
        "tags": ["Python"],
        "badge": "Código"
    },

    "Practicas/Py-Practice/temp.py": {
        "titulo": "Temperaturas de la semana (Python)",
        "desc": "Pede la temperatura de los 7 días y calcula la más alta, la más baja y la promedio con max, min y las f-strings de Python.",
        "tags": ["Python"],
        "badge": "Código"
    }

};


// ---- EJERCICIOS DE JAVA (dentro de ..\Java) ----
//
// Son los ejercicios del proyecto de Java. La clave es la ruta del .java
// con "/" en vez de "\" (ejemplo: "Java/Proyecto/src/main/java/Modulo2/Tarea4_Ejercicio3/TempSemanales2.java").
//
//   "desc"  = la descripción de la tarjeta
//   "titulo" = el nombre que se muestra (si no, sale el de la clase)
//   "tags"   = las etiquetas de color
//   "badge"  = el texto de la etiqueta verde
//
// Si un .java no está aquí, aparece igual con una descripción por defecto.
var META_JAVA = {

    // ---- Día 1: variables, tipos de datos y clases ----
    "Java/Proyecto/src/main/java/Modulo1/Dia1_Ejercicio1/Ej1.java": {
        "titulo": "Variables y tipos de datos",
        "desc": "Declara una variable de cada tipo básico (String, double, int y boolean) y las muestra por pantalla.",
        "tags": ["Java"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo1/Dia1_Ejercicio2/PProducto.java": {
        "titulo": "Datos de un producto",
        "desc": "Muestra una ficha con el nombre, el precio, las unidades disponibles y si el producto está en oferta.",
        "tags": ["Java"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo1/Dia1_Ejercicio3/YoSolito.java": {
        "titulo": "Ficha personal",
        "desc": "Presenta mis datos personales: país, ciudad, edad, cumpleaños, dirección y estudios.",
        "tags": ["Java"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo1/Dia1_Ejercicio4/Alumno.java": {
        "titulo": "Clase Alumno",
        "desc": "Primera clase con atributos y métodos: crea la ficha de un alumno (nombre, nota, faltas) y dice si ha aprobado.",
        "tags": ["Java", "POO"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo1/Dia1_Ejercicio5/PAlumno.java": {
        "titulo": "Probando la clase Alumno",
        "desc": "Crea un objeto de la clase Alumno con datos de prueba e imprime su ficha completa por pantalla.",
        "tags": ["Java", "POO"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo1/Dia1_Ejercicio6/Variables.java": {
        "titulo": "Atributos y setters",
        "desc": "Guarda los puntos iniciales en un atributo de la clase yPractica el getter y el setter para leerlo y cambiarlo.",
        "tags": ["Java", "POO"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo1/Dia1_Ejercicio7/VariableRun.java": {
        "titulo": "Puntos iniciales",
        "desc": "Crea un objeto con 10 puntos de valor inicial y muestra su número y su texto.",
        "tags": ["Java", "POO"],
        "badge": "Hecho"
    },

    // ---- Día 2: entrada por teclado y operadores ----
    "Java/Proyecto/src/main/java/Modulo1/Dia2_Ejercicio1/AngelEjercicio.java": {
        "titulo": "Datos con Scanner",
        "desc": "Pide por teclado el nombre, la edad y la altura y muestra después una ficha con los tres datos.",
        "tags": ["Java", "Scanner"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo1/Dia2_Ejercicio2/PercioConDescuentos.java": {
        "titulo": "Precio con descuentos",
        "desc": "Calcula el precio final de una compra aplicando un 10 % de descuento y después un 21 % de IVA.",
        "tags": ["Java"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo1/Dia2_Ejercicio3/AngelEjercios2.java": {
        "titulo": "Triángulo completo",
        "desc": "Pide la base y la altura por teclado y calcula el área, la hipotenusa y el perímetro del triángulo.",
        "tags": ["Java", "Scanner"],
        "badge": "Hecho"
    },

    // ---- Día 3: condicionales ----
    "Java/Proyecto/src/main/java/Modulo1/Dia3_Ejercicio1/AreaTriangulo.java": {
        "titulo": "Área de un triángulo",
        "desc": "Pide la base y la altura por teclado y muestra el área del triángulo (base x altura / 2).",
        "tags": ["Java", "Scanner"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo1/Dia3_Ejercicio2/Calculadora.java": {
        "titulo": "Calculadora de la compra",
        "desc": "Calcula el importe de una compra y le aplica un 10 % de descuento solo si supera los 100 €, más un 21 % de IVA.",
        "tags": ["Java", "Condicionales"],
        "badge": "Hecho"
    },

    // ---- Tarea 4: métodos, clases y arrays ----
    "Java/Proyecto/src/main/java/Modulo2/Tarea4_Ejercicio1/PrecioConDescuentoEIVA.java": {
        "titulo": "Precio con descuento e IVA",
        "desc": "Versión sencilla (todo dentro del main) del precio final de 3 zapatillas con un 10 % de descuento y un 21 % de IVA.",
        "tags": ["Java", "Tarea"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo2/Tarea4_Ejercicio2/Compra.java": {
        "titulo": "Clase Compra",
        "desc": "El mismo cálculo del precio final pero con los datos guardados en los atributos de una clase y cada cálculo en su método.",
        "tags": ["Java", "POO", "Tarea"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo2/Tarea4_Ejercicio3/TemperaturaSemanales.java": {
        "titulo": "Temperaturas de la semana (con clase)",
        "desc": "Guarda las 7 temperaturas en un array y calcula en métodos aparte la suma, la media, la máxima, la mínima y los días por encima de la media.",
        "tags": ["Java", "Arrays", "Tarea"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo2/Tarea4_Ejercicio3/TempSemanales2.java": {
        "titulo": "Temperaturas de la semana (sencillo)",
        "desc": "El mismo ejercicio con las temperaturas escritas a mano y todo el cálculo dentro del main, sin clases ni métodos.",
        "tags": ["Java", "Arrays", "Tarea"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo2/Tarea4_Ejercicio3/TempSemanalesTeclado.java": {
        "titulo": "Temperaturas de la semana (por teclado)",
        "desc": "El mismo ejercicio pero el programa pregunta la temperatura de cada día con un Scanner y la guarda en un array.",
        "tags": ["Java", "Arrays", "Scanner", "Tarea"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo2/Tarea4_Ejercicio1/precioDescuento.java": {
        "titulo": "Precio con descuento e IVA (Tarea 9)",
        "desc": "Tercera versión del ejercicio del precio final: 5 productos de 50 € con un 10 % de descuento y un 21 % de IVA, con los porcentajes como variables.",
        "tags": ["Java", "Tarea"],
        "badge": "Hecho"
    },

    // ---- Tarea 5: clases con Scanner ----
    "Java/Proyecto/src/main/java/Modulo2/Tarea5_Ejercicio2/ClasesNotas.java": {
        "titulo": "Control de notas (básico)",
        "desc": "Primer contacto con Scanner: pide las notas por teclado y muestra el resultado de los cálculos.",
        "tags": ["Java", "Scanner", "Tarea"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo2/Tarea5_Ejercicio2/ClasesNotasIntermedio.java": {
        "titulo": "Control de notas (intermedio)",
        "desc": "Control de notas de varios alumnos con una clase propia, métodos separados y una lista de objetos.",
        "tags": ["Java", "POO", "Scanner", "Tarea"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo2/Tarea5_Ejercicio2/ClasesNotasAvanzado.java": {
        "titulo": "Control de notas (avanzado)",
        "desc": "Control de notas con Scanner a nivel avanzado: validación antes de leer, conversión con control de errores y delimitadores.",
        "tags": ["Java", "POO", "Scanner", "Tarea"],
        "badge": "Hecho"
    },

    // ---- Tarea 6: estacionamiento encapsulado ----
    "Java/Proyecto/src/main/java/Modulo2/Tarea6_Ejercicio1/EstacionamientoBasico.java": {
        "titulo": "Estacionamiento (básico)",
        "desc": "Control de estacionamiento, nivel básico: pregunta cuántos vehículos hay y las horas de cada uno, calcula el precio, la recaudación total y cuántos vehículos tienen descuento. Tarifa: 2 horas a 2,00 €/hora y cada hora adicional a 1,50 €, con un 10 % de descuento si el vehículo pasa de 5 horas.",
        "tags": ["Java", "Tarea"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo2/Tarea6_Ejercicio1/EstacionamientoIntermedio.java": {
        "titulo": "Estacionamiento (intermedio)",
        "desc": "El mismo cálculo que el básico, pero el main solo coordina: cada cosa vive en su método y los datos van en listas de objetos en vez de arrays de tamaño fijo.",
        "tags": ["Java", "POO", "Tarea"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo2/Tarea6_Ejercicio1/EstacionamientoAvanzado.java": {
        "titulo": "Estacionamiento (avanzado)",
        "desc": "Nivel avanzado: cada vehículo es un objeto con sus propios datos, la entrada se valida con try/catch y, además del total y los descuentos, se calculan estadísticas de quién ha estado más horas y quién paga más.",
        "tags": ["Java", "POO", "Excepciones", "Tarea"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo2/Tarea6_Ejercicio1/Estacionamiento.java": {
        "titulo": "Clase Estacionamiento",
        "desc": "La clase del estacionamiento con los datos privados: nadie desde fuera toca las listas ni recalcula a su manera, todo pasa por sus métodos públicos.",
        "tags": ["Java", "POO", "Encapsulación", "Tarea"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo2/Tarea6_Ejercicio1/EstacionamientoMain.java": {
        "titulo": "Main del estacionamiento",
        "desc": "El main del proyecto: solo pide datos por teclado con Scanner y llama a los métodos públicos de Estacionamiento, con validación de enteros y try/catch para que el programa no se caiga.",
        "tags": ["Java", "POO", "Scanner", "Tarea"],
        "badge": "Hecho"
    },

    "Java/Proyecto/src/main/java/Modulo2/Tarea6_Ejercicio1/ControlAparcamiento.java": {
        "titulo": "Control de Aparcamiento",
        "desc": "Borrador inicial del control de estacionamiento: la primera versión del ejercicio, con el cálculo de la tarifa y el descuento por permanencia.",
        "tags": ["Java", "Tarea"],
        "badge": "Hecho"
    }

};


// ---- NOTAS Y ANÁLISIS (archivos .md de ..\Recursos) ----
var META_NOTAS = {

    "Recursos/Analisis_de_la_infomacion_de_clase_con_IA/analisis-Del-Profesor.md": {
        "titulo": "Análisis de la información del profesor",
        "desc": "Resumen de los apuntes de clase analizados con IA."
    },

    "Recursos/Analisis_de_la_infomacion_de_clase_con_IA/AnalisisCompleto.md": {
        "titulo": "Análisis completo",
        "desc": "Documento completo con todo lo visto en clase, ordenado por temas."
    },

    "Recursos/Paginas-Externa/paginas.md": {
        "titulo": "Mis páginas de apoyo",
        "desc": "Lista guardada de las páginas externas que uso para practicar."
    }

};


// ---- FOTOS DE CLASE (imágenes de ..\Recursos) ----
var META_FOTOS = {

    "Recursos/CSS-Informacion/CSS-INFO-2/WhatsApp Image 2026-09-17 at 09.58.40.jpeg": {
        "titulo": "Apunte CSS - 17/09"
    },

    "Recursos/CSS-Informacion/CSS-INFO-2/WhatsApp Image 2026-09-17 at 09.59.23.jpeg": {
        "titulo": "Apunte CSS - 17/09 (2)"
    },

    "Recursos/CSS-Informacion/CSS-INFO-2/WhatsApp Image 2026-09-23 at 09.38.49.jpeg": {
        "titulo": "Apunte CSS - 23/09"
    }

};


// ---- RECURSOS PDF (de ..\Recursos) ----
// El título sale del nombre del archivo; aquí puedes ponerlo más bonito.
var META_RECURSOS = {

    // ---- HTML ----
    "Recursos/HTML-Informacion/HTML-INFO-1/HTML y CSS_HTML5.pdf": { "titulo": "HTML5 (inicial)" },
    "Recursos/HTML-Informacion/HTML-INFO-1/HTML y CSS_Organizacion de un sitio web.pdf": { "titulo": "Organización de un sitio web" },
    "Recursos/HTML-Informacion/HTML-INFO-2/html-cheatsheet-2026.pdf": { "titulo": "HTML cheatsheet 2026" },
    "Recursos/HTML-Informacion/HTML-INFO-2/html5-cheatsheet-lite.pdf": { "titulo": "HTML5 cheatsheet lite" },
    "Recursos/HTML-Informacion/HTML-INFO-3/estructura_html.pdf": { "titulo": "Estructura HTML" },
    "Recursos/HTML-Informacion/HTML-INFO-3/tutorial-emmet1.pdf": { "titulo": "Tutorial Emmet" },

    // ---- CSS ----
    "Recursos/CSS-Informacion/CSS-INFO-1/css-cheatsheet-2026.pdf": { "titulo": "CSS cheatsheet 2026" },
    "Recursos/CSS-Informacion/CSS-INFO-1/css3-cheatsheet-lite.pdf": { "titulo": "CSS3 cheatsheet lite" },
    "Recursos/CSS-Informacion/CSS-INFO-3/box-sizing-border-box-explicacion.pdf": { "titulo": "box-sizing: border-box" },
    "Recursos/CSS-Informacion/CSS-INFO-3/propiedadesbordersmarginspaddings.pdf": { "titulo": "Borders, margins y paddings" },
    "Recursos/CSS-Informacion/CSS-INFO-3/unidades-css-px-rem-vh.pdf": { "titulo": "Unidades: px, rem y vh" },

    // ---- Manual HTML + CSS ----
    "Recursos/HTML_Y_CSS-Informacion/MANUAL-HTML-Y-CSS.pdf": { "titulo": "Manual HTML y CSS (juntos)" },

    // ---- Visual Studio Code ----
    "Recursos/VsCODE-Informacion/Extensiones-esenciales-para-Visual-Studio-Code.pdf": { "titulo": "Extensiones esenciales" },
    "Recursos/VsCODE-Informacion/HTML y CSS_El editor Visual Studio Code.pdf": { "titulo": "El editor Visual Studio Code" },
    "Recursos/VsCODE-Informacion/Navegadores principales.pdf": { "titulo": "Navegadores principales" },

    // ---- Java ----
    "Recursos/TEORIA JAVA/1-sintaxis-java.pdf": { "titulo": "Sintaxis Java" },
    "Recursos/TEORIA JAVA/2-presentacion_variables_operadores_java_25_paginas.pdf": { "titulo": "Variables y operadores" },
    "Recursos/TEORIA JAVA/3-presentacion_condicionales_validacion_java_25_paginas_v2.pdf": { "titulo": "Condicionales y validación" },
    "Recursos/TEORIA JAVA/4-bucles_depuracion_java_25_paginas_v2.pdf": { "titulo": "Bucles y depuración" },
    "Recursos/TEORIA JAVA/5-presentacion_metodos_descomposicion_java_25_paginas.pdf": { "titulo": "Métodos y descomposición" },
    "Recursos/TEORIA JAVA/6-presentacion_arrays_colecciones_java_25_paginas_ampliada.pdf": { "titulo": "Arrays y colecciones" },
    "Recursos/TEORIA JAVA/7-presentacion_poo_java_35_paginas_ampliada.pdf": { "titulo": "Programación orientada a objetos" },
    "Recursos/TEORIA JAVA/Bloque1_Introduccion_a_Java.pdf": { "titulo": "Introducción a Java" },
    "Recursos/TEORIA JAVA/Guia_Java_Terminal_VSCode.pdf": { "titulo": "Guía Java, Terminal y VS Code" },
    "Recursos/TEORIA JAVA/empezando.pdf": { "titulo": "Empezando con Java" },
    "Recursos/TEORIA JAVA/instalacion_jdk_java.pdf": { "titulo": "Instalación del JDK" },
    "Recursos/TEORIA JAVA/Pildora_teorica_Scanner_Java.pdf": { "titulo": "Píldora teórica: Scanner en Java" },
    "Recursos/TEORIA JAVA/Rutas_Terminal_Java_VSCode.pdf": { "titulo": "Rutas y terminal en Java con VS Code" }

};


// ---- PÁGINAS EXTERNAS ----
// Estas NO se escanean (son direcciones de internet), se escriben aquí.
// Añade las que quieras y aparecerán en la web sin tocar el HTML.
var EXTERNAS = [
    { "url": "https://validator.w3.org/", "titulo": "Validador W3C", "desc": "Comprueba si mi HTML está bien escrito." },
    { "url": "https://responsively.app/", "titulo": "Responsively App", "desc": "Para ver cómo se ve mi web en móvil, tablet y PC." },
    { "url": "https://flukeout.github.io/", "titulo": "CSS Diner", "desc": "Juego para practicar los selectores de CSS." },
    { "url": "http://ww.cdmon.com/es/", "titulo": "cdmon", "desc": "Tutoriales de HTML y CSS en español." }
];


// ---- PROYECTOS HECHOS CON IA (carpetas dentro de ..\Ejercicios_IA) ----
//
// La clave es el NOMBRE DE LA CARPETA del proyecto. Si no pones nada
// aquí, el script enseña el proyecto con un texto por defecto.
//
//   "titulo"    = gana al <title> de la primera página
//   "desc"      = la descripción de la tarjeta
//   "tags"      = etiquetas de color (por defecto HTML, CSS y JS)
//   "badge"     = texto de la etiqueta verde (por defecto "Con IA")
//   "principal" = nombre del archivo que abre el botón principal
var META_IA = {
};


// ---- COLECCIÓN DE COMPONENTES WEB (carpetas dentro de ..\LibreriaProfe) ----
//
// La clave es el NOMBRE DE LA CARPETA del componente. Si no pones nada
// aquí, el script lo deja con un texto por defecto: para 116 componentes
// no compensa rellenarlo todo, solo añade los que quieras retocar.
//
//   "titulo" = gana al título que se arma con el nombre de la carpeta
//   "desc"   = la descripción de la tarjeta
//   "tags"   = etiquetas de color (por defecto se detectan solas:
//              siempre HTML, y CSS / JS si la carpeta trae esos archivos)
//   "badge"  = texto de la etiqueta verde (por defecto "Listo")
var META_BIBLIOTECA = {
};
