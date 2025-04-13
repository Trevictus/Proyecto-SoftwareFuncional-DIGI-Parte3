package Menu

import Connection.MySQL
import Model.Cita
import Model.Usuario

/**
 * Represents the menu system for managing appointments and user data 
 * in the "Caja y espiga" application.
 *
 * @property objeto MySQL instance used to interact with the database.
 */
class Menu(val objeto: MySQL) {

    /**
     * Displays the main menu options to the user.
     * Options include reserving, modifying, deleting appointments, and exiting.
     */
    fun mostrarMenu() {
        println("Bienvenido a \"Caja y espiga\".\n1.-> Reservar cita.\n2.-> Modificar cita\n3.-> Eliminar cita.\n4.-> Salir.")
    }

    /**
     * Handles user input to navigate through the menu options.
     * Based on the selected option, it performs actions such as reserving, modifying, 
     * or deleting appointments.
     */
    fun elegirOpcion() {
        try {
            while (true) {
                mostrarMenu()
                println("***Elija opción***\n")
                val opcion = readln().toInt()

                when (opcion) {
                    1 -> {
                        val usuario = pedirDatosUsuario()
                        if (!usuarioExiste(usuario, objeto)) {
                            println("Usuario no registrado. Procediendo al registro.")
                            objeto.registrarUsuario(usuario)
                        }
                        val cita = Cita().reservarCita(usuario.nombre)
                        objeto.registrarCita(cita, usuario)
                    }
                    2 -> {
                        println("Introduce el correo electrónico del usuario para buscar su cita:")
                        val email = readln()
                        if (objeto.seleccionarIdCliente(Usuario(email)) != 0) {
                            println("Introduce la nueva fecha (dd/MM/yyyy):")
                            val nuevaFecha = Cita().registrarFecha()
                            println("Introduce la nueva hora (HH:mm):")
                            val nuevaHora = Cita().registrarHora()
                            objeto.modificarCita(email, nuevaFecha, nuevaHora)
                        } else {
                            println("Usuario no encontrado.")
                        }
                    }
                    3 -> {
                        println("Introduce el correo electrónico del usuario para buscar su cita:")
                        val email = readln()
                        if (objeto.seleccionarIdCliente(Usuario(email)) != 0) {
                            objeto.eliminarCita(email)
                        } else {
                            println("Usuario no encontrado.")
                        }
                    }
                    4 -> {
                        println("¡Hasta la próxima!")
                        break
                    }
                    else -> {
                        println("Esa opción no está disponible.")
                    }
                }
            }
        } catch (e: NumberFormatException) {
            println("Debe elegir una opción correcta.")
        }
    }

    /**
     * Checks if a user exists in the database based on their registration status.
     *
     * @param usuario The user whose existence is being checked.
     * @param objeto MySQL instance used for database queries.
     * @return True if the user exists in the database; otherwise, false.
     */
    fun usuarioExiste(usuario: Usuario, objeto: MySQL): Boolean {
        println("¿Estás registrado? (s/n): ")
        val opcion = readln()
        if (opcion == "s") {
            return objeto.seleccionarIdCliente(usuario) != 0
        } else if (opcion == "n") {
            return false
        } else {
            println("Esa opción es incorrecta.")
            usuarioExiste(usuario, objeto)
        }
        return false
    }

    /**
     * Prompts the user to input their details, including name, email, and phone number.
     *
     * @return A new Usuario object with the entered details.
     */
    fun pedirDatosUsuario(): Usuario {
        val usuario = Usuario()
        val nombre = usuario.pedirNombre()
        val email = usuario.pedirEmail()
        val telefono = usuario.pedirTelefono()

        return Usuario(nombre, email, telefono)
    }
}
