/* ============================================================
   KINDRED.JAVA - PINTADO DE LAS TARJETAS (render.js)
   ------------------------------------------------------------
   Lee los datos de js\datos.js (archivo que genera ACTUALIZAR.bat)
   y crea el HTML de cada tarjeta.

   Así, cuando añades un trabajo nuevo a tus carpetas y ejecutas
   ACTUALIZAR.bat, la web se actualiza sola: no hay que tocar
   ningún archivo .html.

   Cada función solo trabaja si encuentra su "caja" en la página,
   por eso el mismo archivo sirve para las 4 páginas de la web.
   ============================================================ */


/* ============ ARRANQUE ============ */
/* Cuando el HTML ya está cargado, pintamos todo */

document.addEventListener('DOMContentLoaded', function () {

    pintarPortada();
    pintarTareas();
    pintarPracticas();
    pintarJava();
    pintarClase();
    pintarIA();
    pintarBiblioteca();

    /* Avisamos a los efectos de main.js de que hay elementos nuevos
       para que vuelvan a vigilar (animaciones, contadores, fotos...) */
    if (window.KJ) {
        KJ.reveal();
        KJ.contadores();
        KJ.barras();
        KJ.lightbox();
    }
});


/* ============ AYUDANTES ============ */

/* Devuelve el elemento con ese id, o null si no existe */
function caja(id) {
    return document.getElementById(id);
}

/* Convierte ["HTML","CSS"] en las etiquetas de colores de la web */
function verTags(lista) {
    if (!lista || lista.length === 0) { return ''; }
    var html = '<div class="tags">';
    for (var i = 0; i < lista.length; i++) {
        var t = lista[i];
        var clase = 'tag tag-' + t.toLowerCase();   /* HTML -> tag-html, CSS -> tag-css, JS -> tag-js */
        html += '<span class="' + clase + '">' + t + '</span>';
    }
    return html + '</div>';
}

/* Elige la clase del badge según el texto (verde "completada" o dorado) */
function claseBadge(texto) {
    if (texto && texto.toLowerCase().indexOf('digo') >= 0) {
        return 'badge badge-gold';     /* "Código" -> dorado */
    }
    return 'badge badge-done';         /* "Completada" / "Abierta" -> verde */
}

/* Convierte 7 en "07" para los numeritos de las tarjetas */
function dosCifras(numero) {
    return numero < 10 ? '0' + numero : '' + numero;
}


/* ============ PORTADA (index.html) ============ */
/* Rellena los contadores y la lista resumen con los números reales */

function pintarPortada() {

    /* --- contadores del hero ---
       En el HTML solo está data-dato="tareas" (de qué número es);
       aquí le decimos a main.js hasta cuánto tiene que contar */
    var numeros = {
        tareas: DATOS.resumenes.tareas,
        practicas: DATOS.resumenes.practicas,
        java: DATOS.resumenes.java,
        recursos: DATOS.resumenes.recursos
    };

    var contadores = document.querySelectorAll('[data-dato]');
    for (var i = 0; i < contadores.length; i++) {
        var clave = contadores[i].getAttribute('data-dato');
        if (numeros[clave] !== undefined) {
            contadores[i].setAttribute('data-target', numeros[clave]);
        }
    }

    /* --- lista resumen (los 4 números de la tarjeta de progreso) --- */
    var lista = caja('lista-resumen');
    if (!lista) { return; }

    var filas = [
        { num: DATOS.resumenes.tareas, txt: 'trabajos de clase guardados' },
        { num: DATOS.resumenes.practicas, txt: 'prácticas manuales en casa' },
        { num: DATOS.resumenes.java, txt: 'ejercicios de Java' },
        { num: DATOS.resumenes.pdf, txt: 'PDF y cheatsheets descargados' },
        { num: DATOS.resumenes.notas + DATOS.resumenes.fotos, txt: 'notas y fotos de clase' },
        { num: DATOS.resumenes.ia, txt: 'proyectos hechos con ayuda de IA' },
        { num: DATOS.resumenes.biblioteca, txt: 'componentes en la biblioteca del profe' }
    ];

    var html = '';
    for (var j = 0; j < filas.length; j++) {
        html += '<li>'
              + '    <span class="resumen-num">' + filas[j].num + '</span>'
              + '    <span class="resumen-txt">' + filas[j].txt + '</span>'
              + '</li>';
    }
    lista.innerHTML = html;
}


/* ============ TARJETAS DE TRABAJOS (tareas.html) ============ */
/* Una tarjeta por cada HTML encontrado en ..\Tareas */

function pintarTareas() {

    var contenedor = caja('lista-tareas');
    if (!contenedor) { return; }

    var html = '';

    for (var i = 0; i < DATOS.tareas.length; i++) {
        var t = DATOS.tareas[i];

        html += '<article class="glass-card tarea-card reveal">'
              + '    <div class="tarea-top">'
              + '        <span class="tarea-num">' + dosCifras(i + 1) + '</span>'
              + '        <span class="' + claseBadge(t.badge) + '">' + t.badge + '</span>'
              + '    </div>'
              + '    <span class="tarea-entrega">' + t.entrega + '</span>'
              + '    <h3>' + t.titulo + '</h3>'
              + '    <p>' + t.desc + '</p>'
              + verTags(t.tags)
              + '    <div class="tarea-btns">';

        /* Un botón por cada página de la tarea (el primero es el principal) */
        for (var b = 0; b < t.botones.length; b++) {
            var clase = (b === 0) ? 'btn btn-primary' : 'btn btn-secondary';
            html += '        <a class="' + clase + '" href="' + t.botones[b][0] + '">' + t.botones[b][1] + '</a>';
        }

        /* Y detrás los botones de los enunciados (los PDF de la tarea).
           Si hay más de uno se distinguen por el número: "Enunciado Tarea 1",
           "Enunciado Tarea 2"... El title es el nombre real del archivo. */
        if (t.enunciados) {
            for (var d = 0; d < t.enunciados.length; d++) {
                var enun = t.enunciados[d];
                html += '        <a class="btn btn-secondary" href="' + enun[0] + '"'
                      + '           title="' + enun[2] + '">' + enun[1] + '</a>';
            }
        }

        html += '    </div>'
              + '</article>';
    }

    contenedor.innerHTML = html;

    /* el badge de la cabecera de la página también se actualiza */
    var badge = caja('badge-tareas');
    if (badge) {
        badge.textContent = DATOS.tareas.length + ' tareas entregadas';
    }
}


/* ============ TARJETAS DE PRÁCTICAS (practicas.html) ============ */
/* Una tarjeta por cada HTML o CSS de ..\Practicas */

function pintarPracticas() {

    var contenedor = caja('lista-practicas');
    if (!contenedor) { return; }

    var html = '';

    for (var i = 0; i < DATOS.practicas.length; i++) {
        var p = DATOS.practicas[i];

        /* icono grande: HTML, JS, CSS o PY (cada uno con su color) */
        var icono = '<div class="practica-icon';
        var dibujo = '&lt;/&gt;';
        if (p.icono === 'JS') { icono += ' practica-icon-js'; dibujo = 'JS'; }
        else if (p.icono === 'CSS') { icono += ' practica-icon-css'; dibujo = '#'; }
        else if (p.icono === 'PY') { icono += ' practica-icon-py'; dibujo = 'PY'; }
        icono += '">' + dibujo + '</div>';

        /* el CSS y el Python se abren para ver el código, el HTML para verla */
        var textoBoton = (p.icono === 'CSS' || p.icono === 'PY') ? 'Ver código' : 'Ver práctica';

        html += '<article class="glass-card practica-card reveal">'
              + '    ' + icono
              + '    <div class="practica-body">'
              + '        <div class="practica-head">'
              + '            <h3>' + p.titulo + '</h3>'
              + '            <span class="' + claseBadge(p.badge) + '">' + p.badge + '</span>'
              + '        </div>'
              + '        <p>' + p.desc + '</p>'
              + verTags(p.tags)
              + '        <a class="btn ' + (p.icono === 'HTML' || p.icono === 'JS' ? 'btn-primary' : 'btn-secondary') + '" href="' + p.href + '">' + textoBoton + '</a>'
              + '    </div>'
              + '</article>';
    }

    contenedor.innerHTML = html;
}


/* ============ TARJETAS DE JAVA (java.html) ============ */
/* Una tarjeta por cada .java que haya dentro de ..\Java */

function pintarJava() {

    var contenedor = caja('lista-java');
    if (!contenedor || !DATOS.java) { return; }

    var html = '';

    for (var i = 0; i < DATOS.java.length; i++) {
        var j = DATOS.java[i];

html += '<article class="glass-card java-card reveal">'
              + '    <div class="java-card-body">'
              + '        <div class="java-head">'
              + '            <h3>' + j.titulo + '</h3>'
              + '            <span class="' + claseBadge(j.badge) + '">' + j.badge + '</span>'
              + '        </div>'
              + '        <span class="java-clase">' + j.carpeta + '</span>'
              + '        <p>' + j.desc + '</p>'
              + verTags(j.tags)
              + '        <a class="btn btn-primary" href="' + j.href + '"'
              + '           title="' + j.ruta + '">Ver código</a>'
              + '    </div>'
              + '</article>';
    }

    contenedor.innerHTML = html;

    /* el badge de la cabecera de la página también se actualiza */
    var badge = caja('badge-java');
    if (badge) {
        badge.textContent = DATOS.java.length + ' ejercicios guardados';
    }

    /* botón al índice resumen (lo genera ACTUALIZAR.bat en ..\Java) */
    var acciones = caja('java-acciones');
    if (acciones && DATOS.javaIndice) {
        acciones.innerHTML = '<a class="btn btn-secondary" href="' + DATOS.javaIndice + '">'
                           + 'Ver índice de todos los ejercicios</a>';
    }
}


/* ============ TARJETAS DE IA (ia.html) ============ */
/* Un grupo por cada proyecto de ..\Ejercicios_IA y un botón por página */

function pintarIA() {

    var contenedor = caja('lista-ia');
    if (!contenedor || !DATOS.ia) { return; }

    var html = '';

    for (var i = 0; i < DATOS.ia.length; i++) {
        var p = DATOS.ia[i];

        html += '<article class="glass-card tarea-card reveal">'
              + '    <div class="tarea-top">'
              + '        <span class="tarea-num">' + dosCifras(i + 1) + '</span>'
              + '        <span class="badge badge-done">' + p.badge + '</span>'
              + '    </div>'
              + '    <span class="tarea-entrega">' + p.proyecto + '</span>'
              + '    <h3>' + p.titulo + '</h3>'
              + '    <p>' + p.desc + '</p>'
              + verTags(p.tags)
              + '    <div class="tarea-btns">';

        for (var b = 0; b < p.botones.length; b++) {
            var clase = (b === 0) ? 'btn btn-primary' : 'btn btn-secondary';
            html += '        <a class="' + clase + '" href="' + p.botones[b][0] + '">' + p.botones[b][1] + '</a>';
        }

        html += '    </div>'
              + '</article>';
    }

    contenedor.innerHTML = html;

    var badge = caja('badge-ia');
    if (badge) { badge.textContent = DATOS.ia.length + ' proyectos con IA'; }
}


/* ============ BIBLIOTECA DE COMPONENTES (biblioteca.html) ============ */
/* Una tarjeta por cada componente de ..\LibreriaProfe, con buscador
   porque son más de cien y sin filtro costaría encontrar uno. */

function pintarBiblioteca() {

    var contenedor = caja('lista-biblioteca');
    if (!contenedor || !DATOS.biblioteca) { return; }

    var html = '';

    for (var i = 0; i < DATOS.biblioteca.length; i++) {
        var c = DATOS.biblioteca[i];

        /* texto de búsqueda en minúsculas: nombre + título + descripción */
        var buscar = (c.nombre + ' ' + c.titulo + ' ' + c.desc + ' ' + c.tags.join(' ')).toLowerCase();

        html += '<article class="glass-card comp-card reveal" data-buscar="' + buscar + '">'
              + '    <div class="comp-head">'
              + '        <h3>' + c.titulo + '</h3>'
              + '        <span class="badge badge-done">' + c.badge + '</span>'
              + '    </div>'
              + '    <span class="comp-nombre">' + c.nombre + '</span>'
              + '    <p>' + c.desc + '</p>'
              + verTags(c.tags)
              + '    <a class="btn btn-primary" href="' + c.href + '" title="' + c.ruta + '">Ver componente</a>'
              + '</article>';
    }

    contenedor.innerHTML = html;

    var badge = caja('badge-biblioteca');
    if (badge) {
        badge.textContent = DATOS.biblioteca.length + ' componentes guardados';
    }

    conectarBuscador(contenedor);
}


/* Filtro en vivo del buscador de la biblioteca: escribe y las tarjetas
   que no coinciden desaparecen. El contador de arriba avisa de cuántas
   quedan. */

function conectarBuscador(contenedor) {

    var campo = caja('buscador-biblioteca');
    if (!campo) { return; }

    var aviso = caja('contador-busqueda');
    var total = DATOS.biblioteca.length;

    campo.addEventListener('input', function () {

        var texto = campo.value.toLowerCase().trim();
        var tarjetas = contenedor.querySelectorAll('.comp-card');
        var visibles = 0;

        for (var i = 0; i < tarjetas.length; i++) {
            var coincide = (texto === '' || tarjetas[i].getAttribute('data-buscar').indexOf(texto) >= 0);
            tarjetas[i].style.display = coincide ? '' : 'none';
            if (coincide) { visibles++; }
        }

        if (aviso) {
            aviso.textContent = (texto === '')
                ? total + ' componentes'
                : visibles + ' de ' + total + ' componentes';
        }
    });
}

/* ============ RECURSOS DE CLASE (clase.html) ============ */
/* Pinta los PDF por grupos, las notas, las fotos y las páginas externas */

function pintarClase() {

    /* ---- 1. los 5 grupos de PDF ---- */
    var grupos = [
        { id: 'html', icono: '&lt;/&gt;', clase: 'icon-html', nombre: 'HTML5' },
        { id: 'css', icono: '{ }', clase: 'icon-css', nombre: 'CSS3' },
        { id: 'manual', icono: '&#128214;', clase: 'icon-manual', nombre: 'Manual completo' },
        { id: 'vscode', icono: '&#9653;', clase: 'icon-vscode', nombre: 'Visual Studio Code' },
        { id: 'java', icono: 'J', clase: 'icon-java', nombre: 'Java' }
    ];

    for (var g = 0; g < grupos.length; g++) {

        var lista = caja('lista-recursos-' + grupos[g].id);
        if (!lista) { continue; }

        var archivos = DATOS.recursos[grupos[g].id];
        var html = '';

        for (var i = 0; i < archivos.length; i++) {
            html += '<li><a href="' + archivos[i][0] + '">' + archivos[i][1] + '</a></li>';
        }
        lista.innerHTML = html;

        /* el "6 archivos" de la cabecera de la tarjeta */
        var contador = caja('cont-' + grupos[g].id);
        if (contador) {
            contador.textContent = archivos.length + (archivos.length === 1 ? ' archivo' : ' archivos');
        }
    }

    /* ---- 2. notas y análisis (.md) ---- */
    var listaNotas = caja('lista-notas');
    if (listaNotas) {
        var htmlNotas = '';
        for (var n = 0; n < DATOS.notas.length; n++) {
            var nota = DATOS.notas[n];
            htmlNotas += '<a class="glass-card nota-card reveal" href="' + nota[0] + '">'
                      + '    <span class="nota-ext">.' + nota[3] + '</span>'
                      + '    <h3>' + nota[1] + '</h3>'
                      + '    <p>' + nota[2] + '</p>'
                      + '    <span class="space-arrow">&rarr;</span>'
                      + '</a>';
        }
        listaNotas.innerHTML = htmlNotas;
    }

    /* ---- 3. fotos de clase (con el visor de fotos) ---- */
    var listaFotos = caja('lista-fotos');
    if (listaFotos) {
        var htmlFotos = '';
        for (var f = 0; f < DATOS.fotos.length; f++) {
            var foto = DATOS.fotos[f];
            htmlFotos += '<figure class="foto-item">'
                      + '    <img src="' + foto[0] + '" alt="' + foto[1] + '">'
                      + '    <figcaption>' + foto[1] + '</figcaption>'
                      + '</figure>';
        }
        listaFotos.innerHTML = htmlFotos;
    }

    /* ---- 4. páginas externas ---- */
    var listaExt = caja('lista-externas');
    if (listaExt) {
        var htmlExt = '';
        for (var e = 0; e < DATOS.externas.length; e++) {
            var ex = DATOS.externas[e];
            htmlExt += '<a class="glass-card externa-card reveal"'
                     + '   href="' + ex.url + '" target="_blank" rel="noopener noreferrer">'
                     + '    <h3>' + ex.titulo + '</h3>'
                     + '    <p>' + ex.desc + '</p>'
                     + '    <span class="externa-go">Abrir &nearr;</span>'
                     + '</a>';
        }
        listaExt.innerHTML = htmlExt;
    }

    /* ---- 5. el badge de la cabecera ("21 recursos guardados") ---- */
    var badge = caja('badge-recursos');
    if (badge) {
        badge.textContent = DATOS.resumenes.recursos + ' recursos guardados';
    }
}
