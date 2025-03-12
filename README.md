# Proyecto-SoftwareFuncional-DIGI-Parte2-

## Guía de utilización:
**Paso 1**
Instalar MySQL en la máquina que operará con la aplicación.

**Paso 2**
Crear las tablas de la base de datos en la máquina mediante MySQL.
```sql
create database carpinteria;

use carpinteria;
drop table usuario;
create table usuario(
id int auto_increment primary key,
nombre varchar(50) not null,
email varchar(50) not null unique,
telefono int not null
);

use carpinteria;
drop table cita;
create table cita(
id_cita int auto_increment primary key,
id_cliente int,
motivo varchar(500) not null,
fecha date not null,
hora time not null,
presupuesto double
);

alter table cita add foreign key(id_cliente) references usuario(id) on delete cascade;
```

**Paso 3**
Instalar un IDE en la máquina que pueda procesar el código, en este caso con el lenguaje de programación Kotlin.

**Paso 4**
Ejecutar el archivo Main.kt mediante el IDE.

AVISO: LA INFORMACIÓN INTRODUCIDA PARA CREAR LAS TABLAS SE ALMACENARÁ EN LA BASE DE DATOS, QUEDANDO REGISTRADA EN LA MÁQUINA.
