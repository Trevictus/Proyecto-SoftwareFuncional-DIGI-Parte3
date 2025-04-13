package Connection

import Model.Cita
import Model.Usuario
import java.sql.*
import java.util.Date

/**
 * Handles MySQL database operations for the "carpinteria" application.
 * Includes methods for connecting to the database, managing users, and managing appointments.
 */
class MySQL {
    private val url = "jdbc:mysql://localhost:3306/carpinteria" // Database URL
    private val user = "root" // Database username
    private val psswrd = "2991" // Database password

    private lateinit var connection: Connection // Database connection object

    /**
     * Establishes a connection to the MySQL database.
     * Prints messages to indicate success or failure.
     */
    fun connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
            println("Driver encontrado.")
            connection = DriverManager.getConnection(url, user, psswrd)
            println("Conexión establecida.")
        } catch (e: ClassNotFoundException) {
            println("No se ha encontrado el driver.")
        } catch (e: SQLException) {
            println("Conexión fallida.")
        }
    }

    private lateinit var preparadorDeSentencias: PreparedStatement // Prepared statement object

    /**
     * Registers a new user in the database.
     * 
     * @param usuario The user to be registered.
     */
    fun registrarUsuario(usuario: Usuario) {
        try {
            val insercionEnTabla = "INSERT INTO usuario (nombre, email, telefono) VALUES (?,?,?)"
            preparadorDeSentencias = connection.prepareStatement(insercionEnTabla)
            preparadorDeSentencias.setString(1, usuario.nombre)
            preparadorDeSentencias.setString(2, usuario.email)
            preparadorDeSentencias.setInt(3, usuario.telefono)

            preparadorDeSentencias.executeUpdate()
            preparadorDeSentencias.close()
        } catch (e: SQLIntegrityConstraintViolationException) {
            println("ERROR clave repetida. $e")
        } catch (e: SQLException) {
            println("ERROR INESPERADO. $e")
        }
    }

    /**
     * Registers a new appointment (Cita) in the database.
     * 
     * @param cita The appointment details to be registered.
     * @param usuario The user associated with the appointment.
     */
    fun registrarCita(cita: Cita, usuario: Usuario) {
        try {
            val id_cliente = seleccionarIdCliente(usuario)
            val insercionEnTabla = "INSERT INTO cita (id_cliente, motivo, fecha, hora) VALUES (?,?,?,?)"
            preparadorDeSentencias = connection.prepareStatement(insercionEnTabla)
            preparadorDeSentencias.setInt(1, id_cliente)
            preparadorDeSentencias.setString(2, cita.motivo)
            preparadorDeSentencias.setDate(3, cita.fecha)
            preparadorDeSentencias.setTime(4, cita.hora)

            preparadorDeSentencias.executeUpdate()
            preparadorDeSentencias.close()
        } catch (e: SQLIntegrityConstraintViolationException) {
            println("ERROR clave repetida. $e")
        } catch (e: SQLException) {
            println("ERROR INESPERADO. $e")
        }
    }

    /**
     * Updates an existing appointment in the database with a new date and time.
     * 
     * @param email The email of the user associated with the appointment.
     * @param nuevaFecha The new date for the appointment.
     * @param nuevaHora The new time for the appointment.
     */
    fun modificarCita(email: String, nuevaFecha: Date?, nuevaHora: Time?) {
        if (seleccionarIdCliente(Usuario(email)) != 0) {
            val id_cliente = seleccionarIdCliente(Usuario(email))
            val actualizacionEnTabla = "UPDATE cita SET fecha = ?, hora = ? WHERE id_cliente = ?"

            val preparadorDeSentencias = connection.prepareStatement(actualizacionEnTabla)
            preparadorDeSentencias.setDate(1, nuevaFecha as java.sql.Date?)
            preparadorDeSentencias.setTime(2, nuevaHora)
            preparadorDeSentencias.setInt(3, id_cliente)

            preparadorDeSentencias.executeUpdate()
            preparadorDeSentencias.close()

            println("Cita actualizada correctamente.")
        } else {
            println("Usuario no encontrado.")
        }
    }

    /**
     * Deletes an appointment associated with a user's email from the database.
     * 
     * @param email The email of the user whose appointment is to be deleted.
     */
    fun eliminarCita(email: String) {
        if (seleccionarIdCliente(Usuario(email)) != 0) {
            val id_cliente = seleccionarIdCliente(Usuario(email))
            val eliminacionEnTabla = "DELETE FROM cita WHERE id_cliente = ?"

            val preparadorDeSentencias = connection.prepareStatement(eliminacionEnTabla)
            preparadorDeSentencias.setInt(1, id_cliente)

            preparadorDeSentencias.executeUpdate()
            preparadorDeSentencias.close()

            println("Cita eliminada correctamente.")
        } else {
            println("Usuario no encontrado.")
        }
    }

    /**
     * Retrieves the ID of a client from the database based on their email.
     * 
     * @param usuario The user whose ID is being retrieved.
     * @return The ID of the client, or 0 if not found.
     */
    fun seleccionarIdCliente(usuario: Usuario): Int {
        var idCliente = 0
        try {
            val consulta = "SELECT id FROM usuario WHERE email = ?"
            val preparadorDeSentencias = connection.prepareStatement(consulta)
            preparadorDeSentencias.setString(1, usuario.email)

            val resultado = preparadorDeSentencias.executeQuery()
            if (resultado.next()) {
                idCliente = resultado.getInt("id")
            }
            preparadorDeSentencias.close()
        } catch (e: SQLException) {
            println("ERROR INESPERADO. $e")
        }
        return idCliente
    }

    /**
     * Closes the database connection.
     */
    fun disconnect() {
        connection.close()
    }
}
