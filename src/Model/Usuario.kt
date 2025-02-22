package Model

class Usuario(var nombre: String = "", var email: String = "", var telefono: Int = 0) {

    fun pedirNombre(): String {
        var nombre = ""
        try {
            while (true) {
                println("Introduce tu nombre: ")
                nombre = readln()
                if (nombre.isNotBlank()) {
                    return nombre
                } else {
                    println("El nombre no puede estar vacío.")
                }
            }
        } catch (e: IllegalArgumentException) {
            println("El nombre no puede estar vacío.")
        }
        return nombre
    }

    fun pedirEmail(): String {
        var email = ""
        try {
            while (true) {
                println("Introduce tu email: ")
                email = readln()
                if (email.isNotBlank()) {
                    val regex = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,}")
                    if (regex.matches(email)) {
                        return email
                    } else {
                        println("El correo no es válido.")
                    }
                } else {
                    println("El email no puede estar vacío.")
                }
            }
        } catch (e: IllegalArgumentException) {
            println("El email no puede estar vacío.")
        }
        return email
    }

    fun pedirTelefono(): Int {
        var telefono: String

        while (true) {
            try {
                print("Introduce tu número de teléfono (9 dígitos): ")
                telefono = readlnOrNull() ?: ""

                if (telefono.length != 9) {
                    throw IllegalArgumentException("El número de teléfono debe tener 9 dígitos.")
                }

                // Si el número tiene exactamente 9 dígitos, salimos del bucle
                println("Número de teléfono registrado: $telefono")
                return telefono.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
