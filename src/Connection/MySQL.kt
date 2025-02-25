package Connection

import Model.Cita
import Model.Usuario
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException
import java.sql.SQLIntegrityConstraintViolationException

class MySQL {
    private val url = "jdbc:mysql://localhost:3306/carpinteria"
    private val user = "root"
    private val psswrd = "2991"

    private lateinit var connection: Connection

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

    private lateinit var preparadorDeSentencias: PreparedStatement

    fun registrarUsuario(usuario: Usuario) {
        try {
            val insercionEnTabla = "INSERT INTO usuario (nombre, email, telefono) " +
                    "VALUES (?,?,?)"
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

    fun registrarCita(cita: Cita, usuario: Usuario) {
        try {
            val id_cliente = seleccionarIdCliente(usuario)
            val insercionEnTabla = "INSERT INTO cita (id_cliente, motivo, fecha, hora) " +
                    "VALUES (?,?,?,?)"
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

    fun seleccionarIdCliente(usuario: Usuario): Int {
        try {
            val insercionEnTabla = "SELECT id from usuario WHERE email = ?"
            preparadorDeSentencias = connection.prepareStatement(insercionEnTabla)
            preparadorDeSentencias.setString(1, usuario.email)

            preparadorDeSentencias.executeQuery()
            preparadorDeSentencias.close()
        } catch (e: SQLIntegrityConstraintViolationException) {
            println("ERROR clave repetida. $e")
        } catch (e: SQLException) {
            println("ERROR INESPERADO. $e")
        }
        return 0
    }

    fun disconnect() {
        connection.close()

    }
}