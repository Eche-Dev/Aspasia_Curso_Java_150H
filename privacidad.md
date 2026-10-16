# Política de privacidad

Última actualización: 2026-10-16

## Quién trata tus datos

**Responsable del tratamiento:** [TU NOMBRE Y APELLIDOS] (proyecto "EcheDev" / Clash Strategist)

**Contacto:** Angel98dev26@gmail.com

Para cualquier cosa relativa a tus datos, ejercer tus derechos o presentar una reclamación, escribe a esa dirección.

## Qué datos guardamos

Esta app guarda tres tipos de datos:

1. **Un PIN anónimo** que la app genera automáticamente al entrar.
2. **Los drafts** de partidas que analizas.
3. **El resultado del análisis** que produce la inteligencia artificial sobre esos drafts.

No hay registro, ni contraseña, ni cuenta con nombre, email o teléfono. El PIN no se asocia a ningún dato que te identifique: es un código que vive en tu navegador. Si lo pierdes, pierdes el acceso a tu historial, y no hay mecanismo de recuperación.

Los drafts y los análisis se guardan en una base de datos en el servidor, con tu PIN como única clave de acceso. Mientras no uses el PIN, no hay forma de saber a quién pertenece un draft.

**Almacenamiento en tu navegador:** el PIN se guarda en el almacenamiento local de tu navegador. Es un almacenamiento técnico estrictamente necesario para que el servicio funcione, por lo que no requiere consentimiento.

**Importante:** no escribas datos personales (nombres reales, emails, teléfonos, etc.) en ningún campo de texto libre de la app, porque ese texto puede enviarse a los proveedores de IA.

## Para qué y con qué base legal

| Tratamiento | Base legal |
|---|---|
| Guardar tu PIN, tus drafts y sus análisis para prestarte el servicio | Ejecución del servicio solicitado (art. 6.1.b RGPD) |
| Enviar tus picks y vetos a los proveedores de IA para generar el análisis que has pedido | Ejecución del servicio solicitado (art. 6.1.b RGPD) |
| Tratar tu IP y datos técnicos de conexión (los generan Vercel y Railway) por seguridad y disponibilidad | Interés legítimo en mantener el servicio seguro y operativo (art. 6.1.f RGPD) |
| Analítica de uso y rendimiento (Vercel Analytics y Speed Insights) | Consentimiento (art. 6.1.a RGPD) |
| Mostrar perfiles de jugadores consultados mediante la API de Riot | Interés legítimo (art. 6.1.f RGPD) |

La analítica solo se activa si aceptas en el aviso de cookies. Si rechazas, esas librerías no se cargan y no se recoge nada. Puedes revisar o cambiar tu decisión en cualquier momento desde esta misma web.

No usamos tus datos para publicidad, no los vendemos y no los compartimos con nadie fuera de los proveedores que operan el servicio.

## Edad mínima

El servicio está pensado para personas de **14 años o más**. Si eres menor de esa edad, no uses la app.

## A quién se envían tus datos

Cuando pides un análisis, tus picks y tus vetos se envían a uno o más de estos proveedores de IA:

- **Google Gemini** (Google LLC, Estados Unidos). Modelo de lenguaje para el análisis de draft.
- **OpenRouter** (OpenRouter Inc., Estados Unidos). Agrega varios proveedores de modelos tras una sola interfaz.
- **Cerebras** (Cerebras Systems Inc., Estados Unidos). Inferencia de modelos de lenguaje.
- **NVIDIA NIM** (NVIDIA Corporation, Estados Unidos). Modelos Nemotron para el análisis.
- **Mistral AI** (Mistral AI S.A.S., Francia, Unión Europea). Modelo de lenguaje para el análisis.
- **GitHub Models** (GitHub, Inc. / Microsoft Corporation, Estados Unidos). Modelo GPT-4o mini para el análisis.
- **BazaarLink** (pasarela, Estados Unidos). Sirve modelos de terceros; el destino concreto depende del modelo pedido.

Cada proveedor recibe únicamente los picks, los vetos y lo que la aplicación necesita para hacer la consulta. No enviamos datos que te identifiquen, más allá de lo que el propio proveedor pueda obtener de la petición técnica (por ejemplo, la dirección IP del servidor desde el que se hace la consulta).

Cada proveedor tiene sus propias condiciones y políticas de privacidad, que pueden incluir el uso de los datos recibidos para mejorar sus modelos. Por eso te pedimos que no introduzcas datos personales en la app.

El detalle técnico de cada origen de datos, con el enlace a sus condiciones, está en `DATA_SOURCES.md`. Este documento de privacidad es el que tiene valor legal; aquel es informativo.

## Alojamiento y servicios técnicos

- **Vercel Inc.** (Estados Unidos). Alojamiento, CDN y despliegue del frontend.
- **Railway Corp.** (Estados Unidos). Alojamiento del backend y de la base de datos.
- **Vercel Analytics y Speed Insights** (Vercel Inc., Estados Unidos). Analítica de uso y rendimiento. Solo se activa si das consentimiento; si no, nunca se carga.
- **Sentry** (Functional Software, Inc., Estados Unidos). Monitorización de errores del backend. Puede registrar datos técnicos como la dirección IP. Base legal: interés legítimo en detectar y corregir fallos (art. 6.1.f RGPD). *[BORRAR ESTA LÍNEA SI NO USAS SENTRY]*
- **Riot Games, Inc.** (Estados Unidos). Data Dragon (campeones, objetos, imágenes y notas de parche) y API oficial de Riot Games.

## Transferencias fuera del Espacio Económico Europeo

La mayoría de los proveedores anteriores están en Estados Unidos. Cuando un dato tuyo sale del Espacio Económico Europeo se produce una transferencia internacional, que el RGPD (arts. 44 y ss.) somete a condiciones.

Cuando sea aplicable, estas transferencias se apoyan en una decisión de adecuación de la Comisión Europea (art. 45) para las empresas adheridas al Marco de Privacidad de Datos UE-EE. UU. (EU-U.S. Data Privacy Framework), o en Cláusulas Contractuales Tipo (art. 46) en el resto de los casos. Puedes pedirnos información sobre las garantías concretas escribiendo a la dirección de contacto.

Cada transferencia tiene como único fin el tratamiento descrito en esta política. Si un proveedor dejara de estar cubierto por estas garantías, dejaríamos de enviarle datos.

## Perfiles de jugadores que consultamos

El apartado de perfil muestra datos de un jugador que tú elijas: rango, winrate, KDA, últimas partidas y campeones. Estos datos proceden **exclusivamente de la API oficial de Riot Games**.

Esto significa que tratamos también datos personales de jugadores que no son usuarios de esta app: su nombre de invocador, rango, historial de partidas e icono de perfil. Son datos que el propio jugador hace públicos al jugar, pero siguen siendo suyos.

Los tratamos únicamente para mostrártelos (interés legítimo, art. 6.1.f RGPD). Solo se consultan los jugadores que se buscan: no hay un listado de jugadores ni se recorren sus partidas. La copia temporal que pueda tener el sistema se borra a los 20 minutos.

Si eres uno de esos jugadores y prefieres que tu perfil no aparezca, escríbenos y no lo consultaremos. Tienes derecho a oponerte a este tratamiento (art. 21 RGPD).

## Durante cuánto tiempo

- **Drafts y análisis:** se conservan durante **12 meses desde la última actividad** asociada a tu PIN. Pasado ese plazo, se borran. Si vuelves después, empiezas de cero.
- **Registro de cuota de uso de IA** (para evitar abusos): se conserva **90 días** y después se borra. Contiene únicamente los datos técnicos necesarios para limitar el uso *[VERIFICAR: indica aquí qué guarda exactamente, por ejemplo "tu PIN o un identificador técnico"]*.
- **Logs de acceso del servidor:** se conservan **30 días** por motivos de seguridad.

## Tus derechos

Tienes los derechos que te reconoce el RGPD (arts. 15 a 22) y la normativa complementaria:

- **Acceso:** saber qué datos tenemos tuyos.
- **Portabilidad:** recibirlos en un archivo JSON.
- **Supresión:** que los borremos.
- **Rectificación:** corregir datos inexactos. Los análisis de IA son un resultado generado, no un dato tuyo: si no te convence, puedes generar uno nuevo.
- **Oposición y limitación:** pedirnos que dejemos de tratar tus datos o que limitemos el tratamiento, escribiendo a la dirección de contacto.
- **Retirar el consentimiento:** puedes retirar en cualquier momento el consentimiento de cookies y analítica, sin que ello afecte a la licitud del tratamiento anterior.

Acceso, portabilidad y supresión puedes ejercerlos tú mismo desde la sección **Tu cuenta**. Para los demás, escribe a la dirección de contacto y responderemos en el plazo de un mes que fija el art. 12 RGPD.

## Si no estás conforme: reclamar

Si crees que no hemos tratado bien tus datos, escríbenos primero. Si la respuesta no te convence, puedes presentar una reclamación ante la **Agencia Española de Protección de Datos (AEPD)**: [www.aepd.es](https://www.aepd.es).

## Borrar mi cuenta

En **Tu cuenta** tienes un botón para borrarlo todo. Esta acción:

- Borra todas tus sesiones de draft y los análisis de IA asociados.
- Deja tu PIN **inutilizado**: no se reasigna a nadie.
- Conserva únicamente un registro técnico vacío con el identificador, sin contenido. No es un dato personal: solo indica que ese identificador existió y evita su reutilización.

**Lo que no se borra:** el log de accesos del servidor. Es necesario para detectar y responder a incidentes de seguridad y contiene direcciones IP y rutas. Se conserva 30 días y no se asocia a tu persona, porque el sistema no sabe quién eres.

## Qué pasa si cambia esto

Si cambiamos algo importante, lo avisaremos en la app. Para cambios menores (erratas, aclaraciones), actualizaremos la fecha de "última actualización" sin avisar.
