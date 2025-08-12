# FORO HUB

## Descripción del proyecto
Este proyecto es una aplicación Java desarrollada con **Spring Boot 3**, que permite la gestión de tópicos dentro de un sistema educativo.  
Los tópicos están relacionados con **usuarios** y **cursos**, de forma que:
- Un usuario puede tener múltiples tópicos.
- Un curso puede tener múltiples tópicos.

## Funcionalidades
- **Creación de tópicos**: Registrar nuevos tópicos indicando su título, mensaje, usuario y curso.
- **Listado de tópicos**: Consultar todos los tópicos.
- **Detalle de un tópico**: Obtener información detallada de un tópico por su ID.
- **Actualización de tópicos**: Modificar datos de un tópico existente.
- **Eliminación de tópicos**: Borrar tópicos de la base de datos.
- **Persistencia en base de datos**: Conexión a una base de datos relacional usando **Spring Data JPA**.
- **Migraciones con Flyway**: Control de versiones de la base de datos.
- **Validaciones**: Uso de anotaciones para garantizar la integridad de los datos.
- **Control de transacciones**: Implementación con `@Transactional` para asegurar operaciones consistentes.

## Tecnologías utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Web** (para la creación de API REST)
- **Spring Data JPA** (persistencia de datos)
- **Flyway** (migraciones de base de datos)
- **MySQL** (base de datos relacional)
- **Maven** (gestión de dependencias)
- **Lombok** (reducción de código boilerplate)
- **Hibernate** (implementación de JPA)
- **Insomnia/Postman** (pruebas de la API)

## Cómo usarlo
1. **Clonar el repositorio**
   git clone https://github.com/usuario/repositorio.git
   cd repositorio
