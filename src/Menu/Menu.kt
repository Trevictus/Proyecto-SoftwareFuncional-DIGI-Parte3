package Menu

import Connection.MySQL
import Model.Cita
import Model.Usuario

class Menu(val objeto: MySQL) {
    fun mostrarMenu() {
        println("Bienvenido a \"Caja y espiga\".\n1.-> Reservar cita.\n2.-> Modificar cita\n3.-> Eliminar cita.\n4.-> Salir.")
    }

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

    fun pedirDatosUsuario(): Usuario {
        val usuario = Usuario()
        val nombre = usuario.pedirNombre()
        val email = usuario.pedirEmail()
        val telefono = usuario.pedirTelefono()

        return Usuario(nombre, email, telefono)
    }
}