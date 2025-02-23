📌 Descripción del Proyecto:

Un sistema que permita a los usuarios suscribirse a diferentes tipos de notificaciones sobre el mercado financiero, como cambios en los precios de acciones, alertas de volatilidad, o noticias relevantes. Las notificaciones se enviarán en tiempo real a través de WebSocket.

Tecnologías a Utilizar:

✅ Spring Boot (para el backend)
✅ Spring WebSocket (para comunicación en tiempo real)
✅ Spring Data JPA (para persistencia)
✅ PostgreSQL/MySQL (base de datos)
✅ Arquitectura Hexagonal (con DDD)
✅ Patrones de Diseño:
•	Singleton: Para gestionar la configuración del sistema o servicios compartidos.
•	Strategy: Para definir diferentes estrategias de notificación (correo, WebSocket, SMS).
•	Observer: Para suscribir usuarios a eventos de mercado y notificarles cuando ocurran cambios.

⚡ Módulos del Proyecto
1.	Módulo de Notificaciones
•	Permite a los usuarios suscribirse a diferentes eventos del mercado.
•	Notifica a los usuarios cuando hay cambios importantes.
2.	Módulo de Usuarios
•	Registra a los usuarios y permite configurar sus preferencias de notificación.
3.	Módulo de WebSocket
•	Envía notificaciones en tiempo real a los clientes suscritos.
4.	Módulo de Integración con API Externa
•	Obtiene información de mercado desde una API pública o simulada.

🔥 Casos de Uso Principales

✅ Un usuario se registra y elige recibir notificaciones de ciertas acciones.
✅ Cuando el precio de una acción cambia significativamente, el sistema notifica a los usuarios suscritos.
✅ El sistema puede enviar notificaciones por WebSocket, email o SMS dependiendo de la configuración del usuario.
✅ Los clientes conectados a WebSocket reciben actualizaciones en tiempo real.


🔥 Estructura de Módulos (Hexagonal con DDD)

1️⃣ Módulo de Notificaciones
•	Responsabilidad: Gestionar las suscripciones y enviar notificaciones según las preferencias de los usuarios.
•	Capas:
•	Dominio: Entidades (Notification, Subscription), interfaces de repositorio, servicios de negocio.
•	Aplicación: Casos de uso (enviar notificaciones, manejar suscripciones).
•	Infraestructura: Implementaciones concretas para email, SMS y WebSocket.

2️⃣ Módulo de Usuarios
•	Responsabilidad: Registrar usuarios, autenticar, y gestionar preferencias de notificación.
•	Capas:
•	Dominio: Entidad User, UserPreferences.
•	Aplicación: Casos de uso (registro, autenticación, actualización de preferencias).
•	Infraestructura: Conexión con la base de datos y autenticación (Spring Security opcional).

3️⃣ Módulo de WebSocket
•	Responsabilidad: Enviar actualizaciones en tiempo real a los clientes conectados.
•	Capas:
•	Dominio: Interfaces para manejar conexiones activas.
•	Aplicación: Casos de uso (enviar eventos a clientes, gestionar conexiones).
•	Infraestructura: Implementación con Spring WebSocket.

4️⃣ Módulo de Integración con API Externa
•	Responsabilidad: Obtener datos financieros en tiempo real.
•	Capas:
•	Dominio: Interfaces para obtener datos externos.
•	Aplicación: Casos de uso (sincronización periódica, actualización de precios).
•	Infraestructura: Conexión con la API externa (REST).

📋 Historias de Usuario (User Stories)

🌍 Módulo de Notificaciones
•	Como usuario, quiero suscribirme a las notificaciones de ciertas acciones para recibir alertas de cambios de precio.
•	Como usuario, quiero elegir el canal de notificación (WebSocket, correo o SMS) según mis preferencias.
•	Como sistema, quiero enviar notificaciones en tiempo real cuando ocurra un evento importante en el mercado.

👤 Módulo de Usuarios
•	Como usuario, quiero registrarme en el sistema con mis datos personales.
•	Como usuario, quiero poder iniciar sesión con mis credenciales para gestionar mis notificaciones.
•	Como usuario, quiero actualizar mis preferencias de notificación en cualquier momento.

🔌 Módulo de WebSocket
•	Como usuario conectado, quiero recibir actualizaciones instantáneas a través de WebSocket sin necesidad de refrescar la página.
•	Como sistema, quiero gestionar múltiples conexiones simultáneas de WebSocket.

🔗 Módulo de Integración con API Externa
•	Como sistema, quiero obtener actualizaciones de precios cada minuto para mantener la información al día.
•	Como administrador, quiero configurar la frecuencia de actualización de datos desde la API externa.

✅ Casos de Uso Detallados

🛎️ Notificación de Evento de Mercado

Actores: Sistema, Usuario suscrito
Flujo principal:
1.	La API externa detecta un cambio significativo en el precio de una acción.
2.	El sistema verifica los usuarios suscritos a la acción.
3.	Se aplica la estrategia de notificación según las preferencias de cada usuario.
4.	Se envía la notificación a través de WebSocket, correo o SMS.
5.	El usuario recibe la alerta en tiempo real.

📥 Registro de Usuario y Configuración de Preferencias

Actores: Usuario
Flujo principal:
1.	El usuario se registra proporcionando sus datos básicos.
2.	El usuario establece sus preferencias de notificación (acciones, métodos de alerta).
3.	El sistema guarda la configuración en la base de datos.

🔄 Actualización de Datos del Mercado

Actores: Sistema (tarea en segundo plano)
Flujo principal:
1.	El sistema consulta la API externa a intervalos regulares.
2.	Actualiza los precios y detecta cambios relevantes.
3.	Si hay un evento significativo, dispara el caso de uso de notificación.

🏗️ Siguientes Pasos para Empezar el Proyecto
1.	Configurar el proyecto en Spring Boot con los módulos principales.
2.	Definir las entidades del dominio (User, Notification, Subscription).
3.	Crear interfaces de repositorio usando Spring Data JPA.
4.	Implementar la conexión WebSocket con Spring WebSocket.
5.	Simular o conectar una API externa para pruebas iniciales.

🔍 Detalles de la estructura REST y WebSocket:
•	Las rutas REST se manejan a través de los controladores en el paquete web.controller (por ejemplo, UserController, NotificationController), donde cada controlador expone endpoints típicos como:
•	POST /users para registrar usuarios
•	POST /subscriptions para gestionar suscripciones
•	GET /notifications para obtener el historial de notificaciones
•	Las conexiones en tiempo real se manejan con Spring WebSocket en el paquete infrastructure.websocket, usando la ruta /ws/notifications para enviar datos a los clientes en tiempo real.

🔗 Cómo se comunican los módulos
1.	API REST
•	Los usuarios gestionan suscripciones, configuraciones y obtienen información mediante llamadas REST.
•	Ejemplo:
•	POST /subscriptions → Suscribir a nuevas alertas.
•	GET /users/{id}/subscriptions → Ver suscripciones activas.
2.	WebSocket (Tiempo real)
•	Cuando ocurre un evento importante en el mercado, se envía una notificación instantánea a los clientes conectados por WebSocket.
•	Ejemplo: El sistema detecta un cambio de precio → Los usuarios conectados reciben la notificación en tiempo real sin necesidad de refrescar la página.
3.	Backend con Arquitectura Hexagonal (DDD)
•	Las capas de dominio no dependen de la infraestructura REST ni de WebSocket.
•	La lógica de negocio es independiente y puede ser probada sin preocuparse por los detalles de la infraestructura.

