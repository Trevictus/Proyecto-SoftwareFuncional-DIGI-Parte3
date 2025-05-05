📌 GitHub Wiki - Documentación para Desarrolladores  

📜 Introducción
Bienvenido a la wiki del proyecto [nombre del proyecto]. Aquí encontrarás toda la documentación necesaria para entender, desarrollar y contribuir al proyecto.  

📁 Estructura de la Wiki
- Inicio - Descripción general del proyecto y objetivos.
- Instalación - Pasos para configurar el entorno de desarrollo.
- Guía para Desarrolladores - Cómo contribuir al proyecto y mejores prácticas.
- Estructura del Código - Explicación de los módulos, clases y archivos clave.
- Base de Datos - Especificaciones de la API y diseño de la base de datos.
- Preguntas Frecuentes (FAQ) - Respuestas a dudas comunes de los desarrolladores.  

## Inicio
El proposito principal es crear un software que permita la reserva de citas de manera eficiente y efectiva en la carpinteria "Caja y espiga". Esta reserva citas a los clientes para impartir cursos, utilizar maquinaria, arreglo de muebles e incluso competiciones de carpinteria.

🛠 Instalación y Configuración
Requisitos previos
- MySQL e IntellijIdea.
- Kotlin y SQL.

Instrucciones
- Clona el repositorio:git clone https://github.com/Trevictus/Proyecto-SoftwareFuncional-DIGI-Parte3.git
- Accede al directorio del proyecto:cd Proyecto-SoftwareFuncional-DIGI-Parte3

- Instala las dependencias necesarias: En este caso el .jar de mysql-connector está incluido en el proyecto por lo que no habrá que interactuar con el de forma manual.

- Configurar el entorno no es necesario.  

🖥 Cómo Contribuir
Crear un Fork y una Rama
- Haz un fork del repositorio en GitHub.
- Crea una nueva rama para tu contribución:git checkout -b nombre-de-la-rama


Realizar Cambios y Enviar un Pull Request
- Realiza los cambios necesarios en tu rama.
- Confirma los cambios:git add .
git commit -m "Descripción del cambio"

- Sube tu rama al repositorio:git push origin nombre-de-la-rama

- Envía un Pull Request en GitHub.

📂 Estructura del Proyecto
📁 src/
   ├── 📂 Connection/       # Manejo de la conexión con la base de datos  
   │   └── 📄 MySQL.kt      # Clase para gestionar la conexión y operaciones con MySQL  
   ├── 📂 Menu/            # Gestión del menú de opciones para el usuario  
   │   └── 📄 Menu.kt      # Clase que maneja la interacción con el usuario  
   ├── 📂 Model/           # Definición de modelos utilizados en la aplicación  
   │   ├── 📄 Cita.kt      # Modelo de citas (reservas de servicios)  
   │   ├── 📄 Usuario.kt   # Modelo de usuario (clientes que interactúan con el sistema)  
   └── 📄 Main.kt          # Punto de entrada del programa  

🔗 Base de Datos
Incluye:
- Diseño de la base de datos.  
![Diagrama_BBDD](https://github.com/Trevictus/Proyecto-SoftwareFuncional-DIGI-Parte3/blob/main/BBDD_cajayespiga.png)

❓ FAQ - Preguntas Frecuentes
¿Cómo reportar errores?  
Puedes crear un "Issue" en GitHub aquí.  
¿Cómo solicitar nuevas funcionalidades?  
Abre una propuesta de mejora en la sección de "Issues".  

# 📜 Licencia y Contribución

## 🔹 Licencia
Este proyecto está protegido bajo la licencia **MIT**. Esto significa que los usuarios pueden utilizar, modificar y distribuir el código libremente, siempre que se incluya el aviso de copyright original.

**MIT License:**  
Copyright (c) 2025 Víctor G.T.  
Se concede por la presente permiso, sin cargo, a cualquier persona que obtenga una copia de este software y los archivos de documentación asociados (el "Software"), para utilizar el Software sin restricciones, incluyendo, sin limitación, los derechos de uso, copia, modificación, fusión, publicación, distribución, sublicencia y/o venta de copias del Software, y para permitir a las personas a las que el Software se les proporcione hacerlo, sujeto a las siguientes condiciones:
El aviso de derechos de autor anterior y este aviso de permiso se incluirán en todas las copias o partes sustanciales del Software.
EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO, EXPRESA O IMPLÍCITA, INCLUYENDO PERO NO LIMITADA A GARANTÍAS DE COMERCIALIZACIÓN, IDONEIDAD PARA UN PROPÓSITO PARTICULAR Y NO INFRACCIÓN. EN NINGÚN CASO LOS AUTORES O TITULARES DEL COPYRIGHT SERÁN RESPONSABLES POR NINGUNA RECLAMACIÓN, DAÑO U OTRA RESPONSABILIDAD, YA SEA EN UNA ACCIÓN DE CONTRATO, AGRAVIO O CUALQUIER OTRA FORMA, DERIVADA DE, O RELACIONADA CON EL SOFTWARE O EL USO U OTRAS OPERACIONES EN EL SOFTWARE.
