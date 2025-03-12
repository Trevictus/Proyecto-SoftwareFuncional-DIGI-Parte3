import Connection.MySQL
import Menu.Menu

fun main() {

    val objeto = MySQL()

    objeto.connect()

    val menu = Menu(objeto)

    menu.elegirOpcion()

    objeto.disconnect()


}