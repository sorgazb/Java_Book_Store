# Java Book Store

![Java](https://img.shields.io/badge/Java-22-f89820?style=for-the-badge&logo=openjdk)&nbsp;![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.3-6db33f?style=for-the-badge&logo=springboot)&nbsp;![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-ORM-6db33f?style=for-the-badge&logo=spring)&nbsp;![MySQL](https://img.shields.io/badge/MySQL-Database-4479a1?style=for-the-badge&logo=mysql)&nbsp;![Lombok](https://img.shields.io/badge/Lombok-Annotations-e53935?style=for-the-badge)&nbsp;![Maven](https://img.shields.io/badge/Maven-Build-c71a36?style=for-the-badge&logo=apachemaven)

> **Java Book Store** es una aplicación de escritorio que simula el funcionamiento de una tienda de libros, desarrollada en Java con **Spring Boot 3.3.3** y **Spring Data JPA**. Gestiona el catálogo de libros, clientes y pedidos con persistencia en **MySQL**, siguiendo el patrón de arquitectura MVC.

---

## 📋 Descripción

La aplicación permite gestionar una tienda de libros de forma completa desde una interfaz de consola/escritorio. Entre sus funcionalidades principales:

- **Gestión del catálogo**: alta, baja y modificación de libros.
- **Gestión de clientes**: registro y consulta de clientes.
- **Persistencia con JPA**: mapeo objeto-relacional con Spring Data JPA y MySQL.
- **Lombok**: reducción de código boilerplate (getters, setters, constructores).
- **Arquitectura MVC**: separación clara entre modelo, repositorio, servicio y vista.

---

## 🏗️ Estructura del Proyecto

```txt
Java_Book_Store/
└── tienda_libros/
    ├── src/
    │   ├── main/
    │   │   ├── java/sob/tienda_libros/
    │   │   │   ├── modelo/           # Entidades JPA (Libro, Cliente, Pedido...)
    │   │   │   ├── repositorio/      # Interfaces Spring Data JPA
    │   │   │   ├── servicio/         # Lógica de negocio
    │   │   │   ├── vista/            # Capa de presentación / menús
    │   │   │   └── TiendaLibrosApplication.java
    │   │   └── resources/
    │   │       └── application.properties  # Configuración DB y JPA
    │   └── test/                         # Tests unitarios
    ├── pom.xml                           # Dependencias Maven
    ├── mvnw / mvnw.cmd                   # Maven Wrapper
    └── .gitignore
```

---

## 📹 Demo

<p align="center">
  <video src="https://github.com/user-attachments/assets/503b8e4d-8219-4a29-8b74-6b52fce11bba" controls width="700"></video>
</p>

---

## ⚙️ Instalación y Ejecución

Clona el repositorio:
```txt
git clone https://github.com/sorgazb/Java_Book_Store.git
cd Java_Book_Store/tienda_libros
```

Configura la base de datos en `src/main/resources/application.properties`:
```txt
spring.datasource.url=jdbc:mysql://localhost:3306/tienda_libros
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

Compila y ejecuta con Maven:
```txt
./mvnw spring-boot:run
```

---

## 🤝 Contribución

Haz fork del repositorio.

Crea una rama de trabajo:

```txt
git checkout -b feature/nueva-funcionalidad
```

Realiza tus cambios y haz commit.

Abre un Pull Request describiendo tus mejoras.

---

<p align="center">Proyecto Personal &ndash; Sergio Orgaz Bravo</p>
