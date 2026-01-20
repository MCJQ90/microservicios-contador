Microservicios Contador – Spring Cloud

Proyecto académico utilizando Spring Boot

Arquitectura

El proyecto implementa una arquitectura de microservicios compuesta por:
Eureka Server → Registro y descubrimiento de servicios
Gateway → Punto único de acceso a la aplicación
msvc-solicitud → Gestión de solicitudes
msvc-asignaciones → Gestión de asignaciones
MongoDB → Persistencia de datos

Los microservicios usan puertos dinámicos y se registran automáticamente en Eureka.

Tecnologías
Java 21
Spring Boot
Spring Cloud Eureka
Spring Cloud Gateway (Reactive)
Spring Data MongoDB
Maven

Puertos
Eureka Server: 8761
Gateway: 8080
Microservicios: puertos dinámicos

Endpoints (vía Gateway)
Solicitudes
POST /solicitudes
GET  /solicitudes
GET  /solicitudes/{id}

Asignaciones
GET /asignaciones

Pruebas
Las pruebas se realizaron usando Postman, accediendo a los microservicios a través del Gateway.
En las respuestas se incluye el puerto del microservicio para evidenciar el uso de puertos dinámicos y el descubrimiento de servicios con Eureka.

Autor
María del Carmen Jaramillo