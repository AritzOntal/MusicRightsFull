# MusicRights API

API REST para la gestión de derechos musicales y royalties. Implementada en **Java 21** y **Spring Boot 3.2.5**.

## 🛠 Stack Tecnológico

* **Core:** Java 21, Spring Boot 3.2.5
* **Datos:** MariaDB (Prod/Dev)
* **Infraestructura:** Docker, Docker Compose
* **Documentación:** OpenAPI 3.0
* **Mocking:** WireMock Standalone
* **Testing:** JUnit 5, Mockito

## 🏗 Arquitectura

El proyecto sigue una arquitectura por capas:

1.  **Controller Layer:** Endpoints REST y manejo global de excepciones.
2.  **Service Layer:** Lógica de negocio y gestión de transacciones.
3.  **Repository Layer**: Capa de acceso a datos y operaciones CRUD.

## ⚙️ Configuración y Despliegue

### 1. Infraestructura y Ejecución

```bash
# 1. Levantar base de datos (Docker)
docker compose -f docker-compose.dev.yaml up -d

# 2. Ejecutar tests (Opcional)
mvn test

# 3. Arrancar la aplicación
mvn spring-boot:run
```

### 2. Documentación API

La definición oficial de la API se encuentra disponible en el archivo de especificación OpenAPI (YAML) incluido en el proyecto.

### Endpoints Principales

* `GET /musicians` : Listado de músicos.
* `POST /musicians` : Alta de nuevo músico.
* `POST /works` : Registro de obra y asociación de autores.
* `GET /claims` : Consulta de reclamaciones filtrada.
* `POST /claims` : Creación de proceso de reclamación.

### 3. Entorno de Mocking (WireMock)

Para desarrollo frontend o pruebas aisladas sin base de datos, el proyecto incluye un servidor de Mocks configurado con respuestas predefinidas (JSON).

```bash
# Ejecutar WireMock (Puerto 8081)
java -jar wiremock-standalone-3.13.2.jar --port 8081 --verbose
```

*Las definiciones de los endpoints simulados se encuentran en la carpeta mappings.*

### Autor: Aritz Ontalvilla


