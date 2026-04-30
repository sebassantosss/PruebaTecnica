# 🐳 Guía Práctica de Docker para tu Proyecto

¡Hola! Si eres nuevo en el mundo de Docker, no te preocupes. Esta guía está diseñada para explicarte paso a paso y con palabras sencillas exactamente qué fue lo que construimos para tu proyecto (Frontend, Backend y Base de Datos).

---

## 🏗️ 1. ¿Qué es Docker y por qué lo usamos?
Imagina que construyes una aplicación en tu computadora. Funciona perfecto. Pero cuando se la pasas a un amigo o la subes a un servidor, deja de funcionar porque "falta una versión específica de Java" o "MySQL no está configurado igual". 

**Docker soluciona esto metiendo tu aplicación en una "Caja Mágica" (llamada Contenedor).** 
Esa caja contiene TODO lo que tu aplicación necesita para funcionar (código, herramientas, configuraciones). Si la caja corre en tu computadora, correrá exactamente igual en cualquier otra computadora del mundo.

---

## 🛠️ 2. ¿Qué hicimos en el Backend (Java/Spring Boot)?
Creamos un archivo llamado `Dockerfile` en la carpeta de tu backend (`farmacia/Dockerfile`). Este archivo son las "instrucciones" para armar la caja mágica del backend.

Usamos una técnica avanzada pero muy útil llamada **Multi-stage build (Construcción en múltiples etapas)**:
1. **Etapa 1 (El Constructor):** Usamos una imagen pesada que tiene "Maven" instalado. Metemos tu código fuente y lo compilamos (`mvn package`). El resultado es un archivo ejecutable `.jar`.
2. **Etapa 2 (La imagen final):** Descartamos la imagen pesada de Maven y tomamos una imagen muy liviana que **solo tiene Java** instalado (`eclipse-temurin`). Copiamos el `.jar` de la etapa anterior aquí adentro.

> [!TIP]
> **¿Por qué hacerlo así?**
> Para que la caja final que envíes a producción sea muy ligera y rápida de descargar, ya que no necesita tener Maven instalado adentro, solo necesita ejecutar el `.jar`.

---

## 🎨 3. ¿Qué hicimos en el Frontend (React/Vite)?
Al igual que en el backend, creamos un `Dockerfile` (`mi-proyecto-react/Dockerfile`), pero con herramientas distintas.

1. **Etapa 1 (El Constructor):** Usamos una imagen con `Node.js`. Copiamos tu código de React y ejecutamos `npm run build`. Esto convierte todo tu código React en archivos web estáticos simples (HTML, CSS y JS puro).
2. **Etapa 2 (El Servidor Web):** Descartamos Node.js y usamos una imagen con **Nginx** (un servidor web ultrarrápido). Copiamos esos archivos estáticos adentro de Nginx para que los sirva al público.

Además, agregamos dos archivos extra muy importantes:
* **`.dockerignore`:** Le dice a Docker que no copie tu carpeta `node_modules`. Si no hacemos esto, la compilación sería lentísima.
* **`nginx.conf`:** Una configuración para Nginx que asegura que si recargas la página en cualquier sección de tu app, no te salga un "Error 404", sino que React pueda manejar la ruta correctamente.

---

## 🗄️ 4. La Base de Datos
Para MySQL no tuvimos que crear un `Dockerfile` porque ya existe una "Caja" oficial lista para usar.
Lo único que hicimos fue decirle a Docker: *"Oye, cuando prendas esta caja de MySQL por primera vez, inyecta este archivo `DB_FARMACIA.sql` para que las tablas se creen solas"*.

---

## 🎼 5. El Director de Orquesta: Docker Compose
Teníamos 3 cajas (contenedores) separadas: Base de Datos, Backend y Frontend. 
Para no tener que prenderlas una por una manualmente, creamos el archivo maestro `docker-compose.yml`.

Docker Compose funciona como un "Director de Orquesta":
1. Crea una **Red Privada** para que las cajas puedan hablar entre ellas de forma segura.
2. Levanta la Base de Datos.
3. Levanta el Backend, pero le pasa una **Variable de Entorno (`DB_HOST=db`)**. (Por esto cambiamos tu `application.properties`). Así el backend sabe que no debe buscar la base de datos en tu computadora local, sino en la caja vecina llamada `db`.
4. Levanta el Frontend y lo publica en el puerto 80 para que puedas verlo en tu navegador.

---

## 🚀 6. Comandos útiles para sobrevivir a Docker

Abre tu terminal en la carpeta principal del proyecto (donde está el `docker-compose.yml`) y usa estos comandos:

* **Para prender todo el proyecto en segundo plano:**
  ```bash
  docker compose up -d
  ```
  *(Añade `--build` al final si cambiaste algo en tu código y quieres que Docker lo recompile)*

* **Para apagar todo el proyecto:**
  ```bash
  docker compose down
  ```

* **Para ver si hubo errores (ver los logs):**
  ```bash
  docker compose logs -f
  ```

¡Y eso es todo! Ahora tu proyecto es moderno, portátil y fácil de desplegar en cualquier servidor del mundo.
