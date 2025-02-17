class Menu {
    fun mostrarMenu() {
        println("Bienvenido a \"Caja y espiga\".\n1.-> Reservar cita.\n2.-> Modificar cita\n3.-> Eliminar cita.\n4.-> Salir.")
    }

    fun elegirOpcion(){
        try {
            while (true){
                println("***Elija opción***\n")
                val opcion = readln().toInt()
                if(opcion == 1){
                    reservarCita()
                }
                if(opcion == 2){
                    modificarCita()
                }
                if(opcion == 3){
                    eliminarCita()
                }
                if (opcion == 4){
                    println("¡Hasta la próxima!")
                    break
                }
                else{
                    println("Esa opción no está disponible.")
                }
            }
        }catch (e: NumberFormatException){
            println("Debe elegir una opción correcta.")
        }
    }
}