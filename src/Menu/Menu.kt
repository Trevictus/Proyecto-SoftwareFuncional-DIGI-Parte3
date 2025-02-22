package Menu

import Model.Usuario

class Menu {
    fun mostrarMenu() {
        println("Bienvenido a \"Caja y espiga\".\n1.-> Reservar cita.\n2.-> Modificar cita\n3.-> Eliminar cita.\n4.-> Salir.")
    }

    fun elegirOpcion() {
        try {
            while (true) {
                mostrarMenu()
                println("***Elija opción***\n")
                val opcion = readln().toInt()
                if (opcion == 1) {
//                    reservarCita()
                }
                if (opcion == 2) {
//                    modificarCita()
                }
                if (opcion == 3) {
//                    eliminarCita()
                }
                if (opcion == 4) {
                    println("¡Hasta la próxima!")
                    break
                } else {
                    println("Esa opción no está disponible.")
                }
            }
        } catch (e: NumberFormatException) {
            println("Debe elegir una opción correcta.")
        }
    }

    fun usuarioExiste(): Boolean {
        println("¿Estás registrado? (s/n): ")
        val opcion = readln()
        if (opcion == "s") {
            return true
        } else if (opcion == "n") {
            return false
        } else {
            println("Esa opción es incorrecta.")
            usuarioExiste()
        }
        return false
    }

    fun usuarioNoExiste() {
        var usuario = Usuario()
        val nombre = usuario.pedirNombre()
        val email = usuario.pedirEmail()
        val telefono = usuario.pedirTelefono()

        usuario = Usuario(nombre, email, telefono)
    }
}