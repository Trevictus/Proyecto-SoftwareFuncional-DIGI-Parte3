## Motivación del Proyecto
En un mundo donde la digitalización está transformando la manera en que las empresas operan, la carpintería "Caja y espiga" busca aprovechar el potencial de las tecnologías modernas para llevar sus procesos y servicios al siguiente nivel. Este proyecto de desarrollo de software nace con el propósito de impulsar la eficiencia y la conectividad entre las distintas áreas de la empresa, consolidando así su posición en el mercado y mejorando la experiencia de sus clientes.  

La principal motivación es alinear las áreas de producción, negocio y comunicaciones mediante una herramienta que facilite la gestión de reservas de manera intuitiva y eficiente. Esta alineación permitirá a "Caja y espiga" optimizar sus operaciones y asegurar que tanto sus cursos, el uso de maquinaria, como la reparación de muebles y las competiciones de carpintería, se gestionen con excelencia.  

Además, el proyecto se enfoca en mejorar la calidad del código del software desarrollado, garantizando su accesibilidad y escalabilidad a largo plazo. Esto no solo fortalecerá la infraestructura tecnológica, sino que también permitirá adaptaciones futuras de acuerdo a las necesidades emergentes del negocio.  

Otro aspecto fundamental es la documentación y el análisis del impacto de la digitalización en las diferentes áreas de la empresa. Este enfoque permitirá identificar oportunidades de mejora y aprovechar al máximo los beneficios que la transformación digital puede brindar a "Caja y espiga", asegurando así un crecimiento sostenible y competitivo.  

En definitiva, este proyecto representa un paso significativo hacia la modernización y profesionalización de "Caja y espiga", motivado por el compromiso con la excelencia, la innovación y la satisfacción de sus clientes.  


## Guía de utilización:
### Windows:
**Requisitos previos**  
Instalar MySQL en la máquina que operará con la aplicación.
Instalar IntelliJIdea en la computadora.

**Configuración del entorno**  
Crear las tablas de la base de datos en la máquina mediante MySQL.
```sql
create database carpinteria;

use carpinteria;
create table usuario(
id int auto_increment primary key,
nombre varchar(50) not null,
email varchar(50) not null unique,
telefono int not null
);

use carpinteria;
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

**Ejecución**  
Ejecutar el archivo Main.kt mediante el IDE de IntelliJIdea una vez habiendo cargado el código en él.

AVISO: LA INFORMACIÓN INTRODUCIDA PARA CREAR LAS TABLAS SE ALMACENARÁ EN LA BASE DE DATOS, QUEDANDO REGISTRADA EN LA MÁQUINA.  

### Linux:  
**Requisitos previos**  
1. Instalar MySQL mediante los comandos: **sudo apt update** y **sudo apt install mysql-server** y activar el servicion mediante **sudo systemctl start mysql** y **sudo systemctl enable mysql**.  
2. Instalar IntelliJ IDEA: Descarga IntelliJ IDEA para Linux desde JetBrains. Una vez descargado, descomprime el archivo y sigue las instrucciones de instalación.  

**Configuración del entorno**  
1. Abrir MySQL en la terminal: **mysql -u root -p**.  
2. Luego, ejecuta las mismas instrucciones SQL para configurar la base de datos:  
```sql
create database carpinteria;

use carpinteria;
create table usuario(
    id int auto_increment primary key,
    nombre varchar(50) not null,
    email varchar(50) not null unique,
    telefono int not null
);

use carpinteria;
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

**Ejecución**  
1. Configurar IntelliJ IDEA: Abre IntelliJ IDEA en Linux. Importa tu proyecto o carga el archivo Main.kt.  
2. Ejecutar el proyecto: Asegúrate de tener instalado el SDK de Kotlin. Si no está instalado, puedes hacerlo desde la configuración de IntelliJ IDEA. Haz clic en el archivo Main.kt y selecciona la opción "Ejecutar" para iniciar tu aplicación.


## Ejemplos de uso
![image](https://github.com/user-attachments/assets/c1471fcf-da41-447b-b6b1-cb09fc3bc1fb)
![image](https://github.com/user-attachments/assets/ce580a08-f063-4b27-b5d4-313d302d3118)



