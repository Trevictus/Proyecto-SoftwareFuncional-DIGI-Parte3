import Connection.MySQL
import Menu.Menu

/**
 * Main entry point for the application.
 * Establishes a connection to the database, initializes the menu, and handles user interactions.
 */
fun main() {
    val objeto = MySQL() // Create an instance of the MySQL connection handler.

    objeto.connect() // Connect to the MySQL database.

    val menu = Menu(objeto) // Create an instance of the Menu class with the MySQL object.

    menu.elegirOpcion() // Display the menu and allow the user to choose an option.

    objeto.disconnect() // Disconnect from the MySQL database.
}
