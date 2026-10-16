# Auditoría: ¿el código cumple lo que dicen la política de privacidad y los términos?

## Instrucciones para el agente

Eres un auditor técnico. Tu tarea es revisar el código de este repositorio (frontend en Vercel, backend y base de datos en Railway) y comprobar si coincide con lo que afirman `privacidad.md` y `terminos.md`.

**Reglas:**

- **No modifiques ningún archivo.** Solo lee, busca y reporta.
- Para cada punto indica un veredicto: ✅ CUMPLE, ❌ NO CUMPLE o ⚠️ NO SE PUEDE VERIFICAR.
- Cita siempre la evidencia: ruta del archivo, número de línea y un fragmento breve del código.
- Si algo no se puede comprobar desde el código (por ejemplo, la configuración de Vercel o Railway), dilo y explica dónde debe mirarlo el responsable.
- No inventes. Si no encuentras algo, di que no lo encontraste.

Al final entrega el informe con el formato de la sección "Formato del informe".

---

## BLOQUE A: Datos que se guardan

### A1. Generación del PIN
- ¿El PIN lo genera la app automáticamente al entrar, o lo puede elegir el usuario?
- ¿Cuántos caracteres tiene y con qué generador se crea? Debe ser un generador criptográficamente seguro (por ejemplo `crypto.getRandomValues`, `secrets`, `crypto.randomBytes`), **no** `Math.random()`.
- ¿Qué longitud mínima se exige si el usuario puede elegirlo?
- **Esperado:** PIN aleatorio de 12 caracteres o más, generado con un generador seguro.

### A2. Qué se guarda en la base de datos
- Lista todas las tablas y columnas. Indica cuáles contienen datos personales o identificadores (PIN, IP, user-agent, etc.).
- ¿Se guarda algo más que el PIN, los drafts y los análisis de IA? Si es así, señálalo.
- **Esperado:** solo PIN, drafts, análisis de IA, tabla de cuota y el registro vacío del identificador.

### A3. Tabla de cuota de uso de IA
- ¿Qué columnas tiene? ¿Guarda la IP, el PIN u otro identificador?
- ¿Cuánto tiempo se conservan los registros?
- **Esperado:** se borran a los 90 días. Anota exactamente qué guarda, porque la política debe nombrarlo.

### A4. Almacenamiento en el navegador
- Busca todo uso de `localStorage`, `sessionStorage`, `IndexedDB` y cookies en el frontend.
- Lista qué se guarda en cada uno y para qué.
- **Esperado:** solo el PIN y la decisión del banner de cookies. Cualquier otra cosa debe quedar reflejada en la política.

---

## BLOQUE B: Consentimiento y analítica

### B1. Carga de Vercel Analytics y Speed Insights
- Localiza dónde se importan o inicializan (`@vercel/analytics`, `@vercel/speed-insights` u otros).
- ¿Se cargan **solo después** de que el usuario acepta el banner? ¿O se cargan siempre?
- **Esperado:** si el usuario no ha aceptado, no se carga nada y no se hace ninguna petición a servicios de analítica.

### B2. Otros rastreadores
- Busca cualquier otro script de terceros: Google Analytics, Google Tag Manager, Hotjar, píxeles de seguimiento, fuentes de Google Fonts cargadas desde `fonts.googleapis.com`, CDNs externos, etc.
- Para cada uno, indica si se carga antes del consentimiento.
- **Esperado:** ninguno que no esté declarado en la política. Si usas Google Fonts desde su CDN, se transmite la IP del usuario a Google y debe declararse (o alojarse localmente).

### B3. Banner de cookies
- ¿Existe un botón de **Rechazar** con el mismo peso visual que **Aceptar** (mismo tamaño, color y nivel)?
- ¿Se guarda la decisión y se respeta al volver?
- ¿Hay una forma visible de cambiar la decisión después, como dice la política ("desde esta misma página")?
- **Esperado:** rechazar es tan fácil como aceptar, y la decisión se puede cambiar.

---

## BLOQUE C: Datos enviados a proveedores de IA

### C1. Qué se envía exactamente
- Localiza todas las llamadas a Gemini, OpenRouter, Cerebras, NVIDIA NIM, Mistral, GitHub Models y BazaarLink.
- Para cada proveedor, copia el contenido del prompt que se construye (system prompt y user prompt) y los campos que se envían.
- ¿Se envía el PIN, la IP, el user-agent, algún identificador de sesión o cualquier dato que identifique al usuario?
- **Esperado:** solo picks, vetos y el contexto necesario del juego. Nada que identifique al usuario.

### C2. Texto libre del usuario
- ¿Hay algún campo de texto libre que acabe en el prompt?
- Si lo hay, indica si se sanea o si se advierte al usuario de no escribir datos personales.

### C3. Lista de proveedores
- Compara los proveedores del código con los de la política: Gemini, OpenRouter, Cerebras, NVIDIA NIM, Mistral AI, GitHub Models, BazaarLink.
- Señala cualquier proveedor que esté en el código y **no** en la política, y al revés.

### C4. Secretos y claves
- Busca claves de API en el código fuente, en el frontend o en el historial reciente de git (`.env` subidos, claves en el bundle del cliente).
- Verifica que las llamadas a los proveedores de IA se hacen **desde el backend** y no desde el navegador.
- **Esperado:** ninguna clave expuesta en el frontend ni versionada.

---

## BLOQUE D: Datos de Riot y otras fuentes

### D1. Origen de los datos de jugadores
- Localiza todas las llamadas HTTP salientes del backend y del frontend. Lista cada dominio al que se conecta.
- Busca en especial: `op.gg`, `lolalytics`, `u.gg`, `leagueofgraphs`, `mobalytics`, `blitz`, y cualquier scraping (`cheerio`, `puppeteer`, `playwright`, `BeautifulSoup`, `requests` a webs que no sean APIs oficiales).
- **Esperado:** solo la API oficial de Riot y Data Dragon (`ddragon.leagueoflegends.com`), además de los proveedores de IA. Cualquier otro dominio debe aparecer en `DATA_SOURCES.md` y en la política.

### D2. Contenido copiado de internet
- Busca textos, tablas, estadísticas, tier lists o imágenes que parezcan copiados de otras webs (datos estáticos grandes, JSON con estadísticas, comentarios del tipo "fuente: ...").
- Lista cada uno con su posible origen, si se puede deducir.
- Revisa que `DATA_SOURCES.md` los menciona con enlace y licencia.

### D3. Uso de la API de Riot
- ¿Qué clave de API se usa? Indica si parece una clave de desarrollo (suelen empezar por `RGAPI-` y caducan a las 24 horas) o de producción.
- ¿Se respetan los límites de peticiones (rate limits) y se gestionan los errores 429?
- ¿Se almacena en base de datos algún dato de jugadores obtenido de la API de Riot? Si es así, ¿cuánto tiempo?
- **Esperado:** la política dice que la copia temporal se borra a los 20 minutos. Verifica el TTL de caché real.

### D4. Perfiles de jugadores
- ¿Hay algún listado, búsqueda masiva o recorrido automático de jugadores?
- ¿Existe un mecanismo para excluir a jugadores que pidan no aparecer (lista de bloqueo)?
- **Esperado:** solo se consulta a quien se busca explícitamente, como dice la política.

---

## BLOQUE E: Retención y borrado

### E1. Borrado automático
- Busca tareas programadas (cron, workers, TTL en base de datos, `pg_cron`, `setInterval`, jobs de Railway) que borren:
  - drafts y análisis tras 12 meses sin actividad;
  - registros de cuota tras 90 días;
  - caché de perfiles tras 20 minutos.
- ¿Existen realmente y están activos? ¿O solo está escrito en la política?
- **Esperado:** los tres borrados existen y funcionan. Si alguno no existe, repórtalo como ❌.

### E2. Botón "Borrar mi cuenta"
- Describe paso a paso qué hace el endpoint de borrado.
- ¿Borra todas las sesiones de draft y todos los análisis asociados al PIN?
- ¿Qué ocurre con el PIN después? ¿Queda inutilizado y no reasignable, queda libre para reutilizarse, o sigue siendo válido?
- ¿Qué queda en la base de datos tras el borrado?
- **Esperado:** el comportamiento debe coincidir con lo que dice `privacidad.md` ("el PIN queda inutilizado: no se reasigna a nadie"). Si el código hace otra cosa, indica cuál y propón cómo corregir el texto o el código.

### E3. Exportación de datos (portabilidad)
- ¿Existe la función que exporta los datos en JSON desde "Tu cuenta"?
- ¿Incluye todos los drafts y análisis del usuario?
- ¿Y existe la función de acceso (ver los datos)?
- **Esperado:** acceso, portabilidad y supresión funcionan desde "Tu cuenta".

### E4. Logs
- Revisa la configuración de logging del backend. ¿Se registran IPs, rutas, cabeceras, PINs, cuerpos de peticiones o prompts?
- ¿Aparece el PIN en los logs o en las URLs? Un PIN en la URL puede acabar en logs de acceso y en el historial del navegador.
- ¿Cuánto tiempo se conservan los logs? Si es configurable, indica dónde (Vercel y Railway se configuran en sus paneles).
- **Esperado:** el PIN no debe aparecer en URLs ni en logs; los logs de acceso se conservan 30 días como máximo.

---

## BLOQUE F: Seguridad del PIN y de la API

### F1. Protección contra adivinación de PINs
- ¿Existe límite de intentos (rate limiting) en los endpoints que aceptan el PIN?
- ¿Hay bloqueo temporal o alguna protección contra fuerza bruta?
- ¿Se devuelven respuestas distintas para "PIN no existe" y "PIN sin datos"? Eso permitiría enumerar PINs válidos.
- **Esperado:** limitación de peticiones por IP y respuestas indistinguibles.

### F2. Autorización
- Revisa cada endpoint que lee o escribe drafts y análisis. ¿Siempre exige el PIN y filtra los resultados por ese PIN?
- Busca fallos tipo IDOR: ¿se puede acceder a un draft de otro usuario cambiando un ID en la URL o el cuerpo?
- **Esperado:** ninguna consulta devuelve datos que no pertenezcan al PIN que la pide.

### F3. Configuración general
- CORS: ¿está limitado a tu dominio o es `*`?
- ¿Hay endpoints de administración o depuración abiertos?
- ¿Se usa HTTPS en todas las comunicaciones, incluida la conexión del backend con la base de datos?
- ¿Los datos de la base de datos se guardan en una región de la UE o de EE. UU.? (Esto se ve en el panel de Railway; si no se puede ver desde el código, márcalo ⚠️.)

### F4. Sentry
- ¿Está instalado y configurado (`SENTRY_DSN`)?
- ¿Con qué opciones? En concreto, ¿está activado `sendDefaultPii`? ¿Se envían cuerpos de peticiones, cabeceras o prompts a Sentry?
- **Esperado:** si Sentry está activo, debe estar declarado en la política. Si no se usa, la línea de Sentry debe borrarse de `privacidad.md`.

---

## BLOQUE G: Textos visibles en la web

### G1. Enlaces
- Comprueba que existen y funcionan estas rutas: `/privacidad`, `/terminos`, `/DATA_SOURCES.md`.
- En el pie de página, ¿hay enlaces visibles a privacidad y términos en **todas** las páginas?
- En los términos, el enlace de "Tu cuenta" debe apuntar a la página de cuenta, no a `/terminos`.

### G2. Aviso de Riot
- ¿Aparece el aviso "Clash Strategist was created under Riot Games' 'Legal Jibber Jabber' policy using assets owned by Riot Games. Riot Games does not endorse or sponsor this project." de forma visible en la web?
- ¿Se usa el nombre o el logo de Riot o de League of Legends de una forma que pueda sugerir que la web es oficial?

### G3. Advertencia de IA
- ¿Se muestra la advertencia de que el análisis puede contener errores en la pantalla de análisis de cada draft, como dicen los términos?

### G4. Contenido de los textos
- Comprueba que `privacidad.md` y `terminos.md` están publicados tal cual y que no quedan marcas como `[TU NOMBRE Y APELLIDOS]`, `[VERIFICAR...]` o `[BORRAR...]`.
- Corrige nada: solo repórtalo.

---

## BLOQUE H: Cosas que NO se pueden verificar desde el código

Lista estos puntos en el informe como ⚠️ y señala dónde debe comprobarlos una persona:

1. **Certificación de cada proveedor de IA en el EU-U.S. Data Privacy Framework.** Debe consultarse en [dataprivacyframework.gov](https://www.dataprivacyframework.gov/) buscando cada empresa (Google, OpenRouter, Cerebras, NVIDIA, GitHub/Microsoft). Si algún proveedor no figura, hay que revisar si ofrece un acuerdo de tratamiento de datos con Cláusulas Contractuales Tipo.
2. **Uso de los datos para entrenar modelos.** Cada proveedor tiene condiciones distintas en sus planes gratuitos. Hay que leer sus políticas.
3. **Cumplimiento de las políticas de Riot Games** al enviar datos de la API a proveedores de IA, y validez de la clave de API para una web pública. Debe consultarse el [portal de desarrolladores de Riot](https://developer.riotgames.com/policies/general) y, si procede, registrar el producto para obtener una clave de producción.
4. **Región de la base de datos y retención de logs** en los paneles de Railway y Vercel.
5. **Licencias del contenido copiado de internet** (si el punto D2 encuentra algo).

---

## Formato del informe

Entrega el informe con esta estructura:

### 1. Resumen
Un párrafo con el estado general y la lista de los problemas más graves (❌), ordenados por prioridad.

### 2. Tabla de resultados

| Punto | Veredicto | Evidencia (archivo:línea) | Comentario |
|---|---|---|---|
| A1 | ✅ / ❌ / ⚠️ | `ruta/archivo.ts:42` | breve explicación |

Una fila por cada punto (A1 a G4).

### 3. Discrepancias entre texto y código
Una lista de cada frase de `privacidad.md` o `terminos.md` que **no coincide** con el comportamiento real, indicando:
- la frase exacta del texto;
- lo que hace realmente el código;
- recomendación: cambiar el texto o cambiar el código.

### 4. Riesgos de seguridad
Cualquier problema encontrado (claves expuestas, IDOR, PIN en URLs, ausencia de rate limiting, etc.), con su gravedad (alta, media, baja).

### 5. Pendientes manuales
La lista del Bloque H con lo que debe comprobar el responsable.
