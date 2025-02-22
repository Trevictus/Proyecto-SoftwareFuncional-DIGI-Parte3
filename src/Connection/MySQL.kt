package Connection

import Model.Usuario
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException

class MySQL {
    private val URL = "jdbc:mysql://localhost:3306/carpinteria"
    private val user = "root"
    private val psswrd = "2991"

    private lateinit var connection: Connection

    fun connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
            println("Driver encontrado.")
            connection = DriverManager.getConnection(URL, user, psswrd)
            println("Conexión establecida.")
        }catch (e: ClassNotFoundException){
            println("No se ha encontrado el driver.")
        }catch (e: SQLException){
            println("Conexión fallida.")
        }
    }

    private lateinit var preparadorDeSentencias: PreparedStatement

    fun registrarUsuario(usuario: Usuario){
        var insercionEnTabla = "INSERT INTO usuario (nombre, email, telefono) " +
                "VALUES (?,?,?)"
        preparadorDeSentencias = connection.prepareStatement(insercionEnTabla)
        preparadorDeSentencias.setString(1,usuario.nombre)
        preparadorDeSentencias.setString(2,usuario.email)
        preparadorDeSentencias.setInt(3,usuario.telefono)

        preparadorDeSentencias.executeUpdate()
        preparadorDeSentencias.close()
    }
}