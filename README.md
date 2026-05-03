# Music Rights WEB

## Propósito

Music Rights es una aplicación web para la gestión de derechos musicales con tres tipos de usuario: ADMIN, MUSICIAN y USER. Cada uno accede a la información que le corresponde según su rol.

Proyecto en un unico respositorio con:

- **backend** (Spring Boot, puerto 8085): API REST con autenticación JWT y endpoints para obras, conciertos, músicos, reclamaciones, documentos y usuarios.
- **frontend** (React + TypeScript + Vite, puerto 5173): SPA que consume la API.

## Funcionalidades

- **Autenticación JWT**: pantallas de login y registro. El JWT se persiste en `localStorage` para mantener la sesión entre recargas.

- **Protección de rutas**: rutas privadas envueltas en un componente que valida sesión y rol de usuario.

- **Estado global**: AuthContext con `useReducer` que centraliza la sesión y expone `login`, `logout` y el estado actual mediante un custom hook `useAuth`.

- **Capa de servicios**: cliente Axios centralizado con interceptores que añaden el JWT automáticamente y limpian la sesión en caso de 401. Los servicios por entidad (`authService`, `workService`) se construyen sobre ese cliente.

- **Dashboard**: tabla con búsqueda reactiva por título o género, ordenación bidireccional por columna, tres tarjetas resumen (totales, registradas, géneros distintos) y manejo explícito de los estados de carga, error, vacío y datos.

- **Vista por rol**: el dashboard adapta el contenido al rol del usuario (mensaje contextual y columnas mostradas).

- **Tests unitarios**: tres tests con Vitest sobre el reducer del AuthContext, cubriendo las acciones INITIALIZE, LOGIN y LOGOUT.

## Decisiones técnicas

**Tailwind CSS**. Estilos por clases utilitarias para un sistema visual coherente sin escribir CSS personalizado.

**Decodificación del JWT en el cliente**. Se extrae el username y el rol con `jwt-decode` sin necesidad de un endpoint adicional. La validación real está en el backend.

**Arquitectura por capas en el frontend**: `api` (cliente HTTP), `services` (operaciones por entidad), `hooks` (lógica reutilizable como `useWorks`), `contexts` (estado global), `components` y `pages`. Cada capa tiene una sola responsabilidad.

**Interceptores Axios**. Añaden la cabecera `Authorization` automáticamente y limpian la sesión ante respuestas 401. Los servicios no se ocupan de autenticación.

**`ProtectedRoute` parametrizable**. Un único componente que verifica autenticacion y rol mediante una prop opcional `allowedRoles`.

**CORS habilitado en el backend** para el origen del frontend de desarrollo.


## Arranque

Backend:

cd backend
docker compose -f docker-compose.dev.yaml up -d
mvn spring-boot:run -Dspring-boot.run.profiles=dev

Frontend:

cd frontend
npm install
npm run dev

Tests:

cd frontend
npm test