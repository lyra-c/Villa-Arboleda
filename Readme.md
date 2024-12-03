## Sistema de Información para Empresa Villa Arboleda


## Índice

- [1. CONTEXTO](#1-CONTEXTO)
- [2. OBJETIVOS DEL PROYECTO](#2-OBJETIVOS_DEL_PROYECTO)
- [3. REQUISITOS DEL SISTEMA](#3-REQUISITOS_DEL_SISTEMA)
- [4. ESTRUCTURA DEL PROYECTO](#4-ESTRUCTURA_DEL_PROYECTO)
- [5. MODELO DE DATOS](#5-MODELO_DE_DATOS)


## 1. CONTEXTO

Creación de un sistema de gestión de Propietarios de una inmobiliaria, con API, 
Pruebas Unitarias y modelo MVC.


## 2. OBJETIVOS DEL PROYECTO

* Desarrollar un sitio web dinámico bajo el patrón de diseño MVC.
* Conectar el sitio web a una base de datos MySQL empleando JPA-Hibernate.
* Implementar servlets y JSP para manejar la lógica del sistema.
* Implementar una API Rest para el sistema.


## 3. REQUISITOS DEL SISTEMA
*Java (JEE):** Servlets para manejar la lógica de negocio.
*JSP:** Para generar contenido dinámico en el frontend.
*Base de Datos:** Almacena toda la información relacionada con los clientes, capacitaciones, pagos, etc.
*Apache Tomcat:** Servidor de aplicaciones utilizado para desplegar el proyecto.
*Control de Versiones (GitHub):** El proyecto se encuentra en un repositorio público en GitHub.

## 4. ESTRUCTURA DEL PROYECTO
*Clases Java:** Manejan la lógica del sistema.**Interfaces:** Para definir los contratos de las funcionalidades.
*JSP:** Para la presentación dinámica del contenido.
*Hojas de Estilo:** Definición de estilos responsivos compartidos entre todas las páginas.

## 5. MODELO DE DATOS
El sistema utiliza una base de datos Oracle con las siguientes tablas principales acorde a la funcionalidad:

*Propietarios
*Saldos

Las demás tablas están presentes dentro de la base de datos