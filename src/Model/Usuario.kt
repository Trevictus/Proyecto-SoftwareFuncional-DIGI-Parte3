package Model

class Usuario(var nombre: String = "", var email: String = "", var telefono: Int = 0) {

    constructor(email: String) : this("", email, 0)

    /**
 * Solicita al usuario que introduzca su nombre a través de la consola.
 * La función asegura que el nombre introducido no esté en blanco, 
 * y seguirá pidiendo el nombre hasta que se introduzca uno válido.
 * 
 * @return El nombre introducido por el usuario.
 */
fun pedirNombre(): String {
    var nombre = "" // Variable para almacenar el nombre introducido.

    try {
        // Bucle infinito que sigue solicitando el nombre hasta que sea válido.
        while (true) {
            println("Introduce tu nombre: ")
            nombre = readln() // Lee el nombre desde la consola.

            // Verifica que el nombre no esté en blanco.
            if (nombre.isNotBlank()) {
                return nombre // Devuelve el nombre válido.
            } else {
                // Mensaje de error si el nombre está vacío.
                println("El nombre no puede estar vacío.")
            }
        }
    } catch (e: IllegalArgumentException) {
        // Captura la excepción y muestra un mensaje de error.
        println("El nombre no puede estar vacío.")
    }

    return nombre // Devuelve el nombre, aunque la estructura asegura que siempre será válido.
}

    /**
 * Solicita al usuario que introduzca su email a través de la consola.
 * Valida que el email no esté vacío y que cumpla con un formato válido.
 * 
 * El formato válido incluye caracteres alfanuméricos, puntos, guiones bajos
 * y guiones, seguido de un '@', un dominio y una extensión de al menos dos caracteres.
 *
 * @return El email válido introducido por el usuario.
 */
fun pedirEmail(): String {
    var email = "" // Variable para almacenar el email introducido.

    try {
        // Bucle infinito que sigue solicitando el email hasta que sea válido.
        while (true) {
            println("Introduce tu email: ")
            email = readln() // Lee el email desde la consola.

            // Verifica que el email no esté vacío.
            if (email.isNotBlank()) {
                // Expresión regular para validar el formato del email.
                val regex = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,}")
                
                // Verifica si el email cumple con el formato.
                if (regex.matches(email)) {
                    return email // Devuelve el email válido.
                } else {
                    // Mensaje de error si el formato no es válido.
                    println("El correo no es válido.")
                }
            } else {
                // Mensaje de error si el email está vacío.
                println("El email no puede estar vacío.")
            }
        }
    } catch (e: IllegalArgumentException) {
        // Captura la excepción y muestra un mensaje de error.
        println("El email no puede estar vacío.")
    }

    return email // Devuelve el email, aunque la estructura asegura que siempre será válido.
}

    /**
 * Solicita al usuario que introduzca su número de teléfono a través de la consola.
 * Valida que el número de teléfono tenga exactamente 9 dígitos. 
 * En caso de error, muestra un mensaje indicando el problema y vuelve a solicitar el número.
 * 
 * @return El número de teléfono introducido por el usuario como un entero.
 */
fun pedirTelefono(): Int {
    var telefono: String // Variable para almacenar el número de teléfono introducido.

    while (true) {
        try {
            print("Introduce tu número de teléfono (9 dígitos): ")
            telefono = readlnOrNull() ?: "" // Lee el número de teléfono desde la consola.

            // Comprueba que el número tenga exactamente 9 dígitos.
            if (telefono.length != 9) {
                throw IllegalArgumentException("El número de teléfono debe tener 9 dígitos.")
            }

            // Si el número tiene 9 dígitos, lo registra y lo convierte a entero.
            println("Número de teléfono registrado: $telefono")
            return telefono.toInt()
        } catch (e: IllegalArgumentException) {
            // Muestra el mensaje de error correspondiente.
            println(e.message)
        }
    }
}
}
