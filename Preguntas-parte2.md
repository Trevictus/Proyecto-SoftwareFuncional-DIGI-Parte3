# Proyecto-SoftwareFuncional-DIGI

## Introduccion y objetivos del proyecto
### Objetivos
El proposito principal es crear un software que permita la reserva de citas de manera eficiente y efectiva en la carpinteria "Caja y espiga". Esta reserva citas a los clientes para impartir cursos, utilizar maquinaria, arreglo de muebles e incluso competiciones de carpinteria.  

**Ciclo de vida del dato**  
- **Recopilación de datos**  
Para la recopilación de datos se implementarán formularios que solo recopilen la información necesaria del cliente y se asegurarán que los datos sean validos y seguros.
- **Almacenamiento de datos**  
Se utilizará MySQL para el almacenamiento de datos.  
- **Procesamiento de datos**  
Se procesaran automaticamente las reservas, actualizando el estado en la base de datos.  
- **Eliminación de datos**  
Para evitar tecnicas forenses de recopilación de datos se pueden usar programas para sobrescribir los datos como SDelete.  

**Seguridad**  

- **Almacenamiento en la nube**  
Además del almacenamiento en bases de datos locales, se implementará una solución de almacenamiento en la nube para garantizar la disponibilidad y seguridad de los datos, así como la facilidad de acceso y recuperación en caso de fallos del sistema.
- Se evaluarán diferentes proveedores de servicios en la nube para elegir la opción más adecuada en términos de seguridad, costo y funcionalidad.  

**Diseño y desarrollo del software**  
- **Desarrollo de la interfaz de usuario**  
Se diseñará una interfaz de usuario amigable e intuitiva para facilitar el uso del sistema de reservas por parte de los clientes y administradores.  
Se implementarán formularios de entrada de datos que recojan la información necesaria de manera eficiente y aseguren la validez y seguridad de los datos ingresados.   
- **Desarrollo del sistema de backend**  
El sistema se desarrollará utilizando tecnologías modernas y eficientes para garantizar un rendimiento óptimo.  
La lógica de procesamiento de reservas se implementará de manera que las actualizaciones del estado de las reservas en la base de datos sean automáticas y rápidas.  
- **Pruebas y validación**  
Se realizarán pruebas para asegurar que el sistema cumpla con los requisitos funcionales y no funcionales.  
Se implementarán pruebas de seguridad para identificar y mitigar posibles vulnerabilidades en el sistema.  


### Preguntas a responder
**Ciclo de vida del dato (5b):**  
- **¿Cómo se gestionan los datos desde su generación hasta su eliminación en tu proyecto?**  
Se recopilan mediante formularios para validarlos, se almacenan en la base de datos, se procesan automaticamente para actualizar las reservas y se eliminan usando SDelete.  
- **¿Qué estrategia sigues para garantizar la consistencia e integridad de los datos?**  
Se implementan formularios para garantizar la validez de estos y el sistema backend procesa y actualiza automaticamente estos en la base de datos.  
- **Si no trabajas con datos, ¿cómo podrías incluir una funcionalidad que los gestione de forma eficiente?**  
Con un sistema de base de datos relacional.

**Almacenamiento en la nube (5f):**  
- **Si tu software utiliza almacenamiento en la nube, ¿cómo garantizas la seguridad y disponibilidad de los datos?**  
Mediante la evaluación de diferentes proveedores de servicios en la nube.  
- **¿Qué alternativas consideraste para almacenar datos y por qué elegiste tu solución actual?**  
Consideré tanto base de datos locales como almacenamiento en la nube. Para facilitar el acceso y la recuperacion de los datos en caso de fallo del sistema.  
- **Si no usas la nube, ¿cómo podrías integrarla en futuras versiones?**  
Migrando los datos existentes a la nube y asegurando que las interfaces de usuario y backend se adapten para trabajar con servicios en la nube.

**Seguridad y regulación (5i):**  
- **¿Qué medidas de seguridad implementaste para proteger los datos o procesos en tu proyecto?**  
Validación de datos en formularios, el uso de base de datos seguras y programas para la sobreescritura de datos.  
- **¿Qué normativas (e.g., GDPR) podrían afectar el uso de tu software y cómo las has tenido en cuenta?**  
Normativas de seguridad y privacidad.
- **Si no implementaste medidas de seguridad, ¿qué riesgos potenciales identificas y cómo los abordarías en el futuro?**  
La exposición de datos sensibles y la manipulación de reservas. Se pueden abordar con autenticación de usuarios, encriptación de datos y auditorías de seguridad.

**Implicación de las THD en negocio y planta (2e):**  
- **¿Qué impacto tendría tu software en un entorno de negocio o en una planta industrial?**  
En un negocio, la gestión eficiente de reservas, la mejora de la satisfacción del cliente y la optimización de recursos.
En una planta industrial, coordinar el uso de maquinaria y la programación de tareas.
- **¿Cómo crees que tu solución podría mejorar procesos operativos o la toma de decisiones?**  
Automatizando la gestión de reservas y proporcionando datos en tiempo real y facilitando la toma de decisiones basada en datos precisos.  
- **Si tu proyecto no aplica directamente a negocio o planta, ¿qué otros entornos podrían beneficiarse?**  
Espacios de coworking, de centros educativos o restaurantes y eventos entre otros.

**Mejoras en IT y OT (2f):**  
- **¿Cómo puede tu software facilitar la integración entre entornos IT y OT?**  
Mediante la centralizacion de los datos y automatización de los datos.  
- **¿Qué procesos específicos podrían beneficiarse de tu solución en términos de automatización o eficiencia?**  
El uso de la maquinaria, la gestión de los recursos y la planificación del mantenimiento.  
- **Si no aplica a IT u OT, ¿cómo podrías adaptarlo para mejorar procesos tecnológicos concretos?**  
Se podría integrar con sistemas existentes de monitorización y gestión de recursos.

**Tecnologías Habilitadoras Digitales (2g):**  
- **¿Qué tecnologías habilitadoras digitales (THD) has utilizado o podrías integrar en tu proyecto?**  
Utilizo MySQL y se podría integrar en mi proyecto IoT, para el monitoreo en tiempo real de la maquinaría.  
- **¿Cómo mejoran estas tecnologías la funcionalidad o el alcance de tu software?**  
Permitiendo una gestión segura y eficiente de los datos, la automatización de procesos y la disponibilidad de los datos en cualquier momento.  
- **Si no has utilizado THD, ¿cómo podrías implementarlas para enriquecer tu solución?**  
Con la integración del analisis de Big Data o la Inteligencia Artificial.  
