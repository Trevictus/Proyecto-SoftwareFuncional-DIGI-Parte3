import Connection.MySQL
import Menu.Menu
import Model.Cita
import Model.Usuario

fun main() {

    val objeto = MySQL()

    objeto.connect()

    val menu = Menu(objeto)

    menu.elegirOpcion()

    objeto.disconnect()


}