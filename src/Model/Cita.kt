package Model

import java.sql.Time
import java.text.SimpleDateFormat
import java.sql.Date


open class Cita(
    val cliente: String,
    val motivo: String,
    val fecha: Date?,
    val hora: Time?,
    val presupuesto: Double = 0.0
) {

    constructor() : this(cliente = "", motivo = "", fecha = null, hora = null, presupuesto = 0.0)

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
                    fecha = dateFormat.parse(input) as Date?
                    return fecha
                } catch (e: Exception) {
                    println("La fecha no es válida. Por favor, introduce una fecha en el formato correcto (dd/MM/yyyy).$e")
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





    fun reservarCita(cliente: String): Cita{
        val motivo = registrarMotivo()
        val fecha = registrarFecha()
        val hora = registrarHora()

        return Cita(cliente, motivo, fecha, hora)

    }


}