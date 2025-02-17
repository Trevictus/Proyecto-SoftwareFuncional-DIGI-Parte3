import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

open class Cita(
    val cliente: String,
    val motivo: String,
    val fecha: Date,
    val hora: Time,
    val empleado: String,
    val presupuesto: Double = 0.0
) {

    fun registrarCliente(): String {
        var cliente = ""
        try {
            while (true) {
                println("Introduce tu nombre: ")
                cliente = readln()
                if (cliente.isNotBlank()) {
                    return cliente
                } else {
                    println("El nombre no puede estar vacío.")
                }
            }
        } catch (e: IllegalArgumentException) {
            println("El nombre no puede estar vacío.")
        }
        return cliente
    }

    fun registrarMotivo(): String {
        while (true) {
            println("Elija la opción del motivo por el cuál reserva cita.\n1.-> Reparación.\n2.-> Alquiler de maquinária.\n3.-> Compra de materiales.")
            try {
                val opcion = readln().toInt()
                return when (opcion) {
                    1 -> "Ha elegido usted: Reparación."
                    2 -> "Ha elegido usted: Alquiler de maquinária."
                    3 -> "Ha elegido usted: Compra de materiales."
                    else -> {
                        println("Esa opción no está disponible.")
                        continue
                    }
                }
            } catch (e: NumberFormatException) {
                println("Debe elegir una opción correcta.")
            }
        }
    }

    fun registrarFecha(): Date? {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        dateFormat.isLenient = false
        var fecha: Date? = null

        try {
            while (true) {
                println("Introduce la fecha (dd/MM/yyyy): ")
                val input = readln()
                try {
                    fecha = dateFormat.parse(input)
                    return fecha
                } catch (e: Exception) {
                    println("La fecha no es válida. Por favor, introduce una fecha en el formato correcto (dd/MM/yyyy).")
                }
            }
        } catch (e: IllegalArgumentException) {
            println("Ocurrió un error: ${e.message}")
        }
        return fecha
    }


    fun registrarHora(): Time? {
        val timeFormat = SimpleDateFormat("HH:mm")
        timeFormat.isLenient = false
        var hora: Time? = null

        try {
            while (true) {
                println("Introduce la hora (HH:mm): ")
                val input = readln()
                try {
                    val parsedDate = timeFormat.parse(input)
                    hora = Time(parsedDate.time)
                    return hora
                } catch (e: Exception) {
                    println("La hora no es válida. Por favor, introduce una hora en el formato correcto (HH:mm).")
                }
            }
        } catch (e: IllegalArgumentException) {
            println("Ocurrió un error: ${e.message}")
        }
        return hora
    }





    fun reservarCita(){
        registrarCliente()
        registrarMotivo()
        registrarFecha()
        registrarHora()
    }
}