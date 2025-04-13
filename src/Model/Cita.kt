package Model

import java.sql.Time
import java.text.SimpleDateFormat
import java.sql.Date

/**
 * Represents an appointment (Cita) with details about the client, purpose, date, time, and budget.
 *
 * @property cliente Name of the client.
 * @property motivo Reason for the appointment.
 * @property fecha Date of the appointment (java.sql.Date).
 * @property hora Time of the appointment (java.sql.Time).
 * @property presupuesto Optional budget for the appointment, default is 0.0.
 */
open class Cita(
    val cliente: String,
    val motivo: String,
    val fecha: Date?,
    val hora: Time?,
    val presupuesto: Double = 0.0
) {

    /**
     * Default constructor initializing all properties with default values.
     */
    constructor() : this(cliente = "", motivo = "", fecha = null, hora = null, presupuesto = 0.0)

    /**
     * Registers the reason for the appointment by presenting options to the user
     * and returning the selected option as a string.
     *
     * @return The chosen reason as a string.
     */
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

    /**
     * Prompts the user to input a date in the "dd/MM/yyyy" format and validates it.
     * If valid, returns the date as a java.sql.Date.
     *
     * @return The valid date input by the user or null if unsuccessful.
     */
    fun registrarFecha(): Date? {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        dateFormat.isLenient = false
        var fecha: Date? = null

        try {
            while (true) {
                println("Introduce la fecha (dd/MM/yyyy): ")
                val input = readln()
                try {
                    val utilDate = dateFormat.parse(input)  // Utilizes java.util.Date
                    fecha = Date(utilDate.time)  // Converts java.util.Date to java.sql.Date
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

    /**
     * Prompts the user to input a time in the "HH:mm" format and validates it.
     * If valid, returns the time as a java.sql.Time.
     *
     * @return The valid time input by the user or null if unsuccessful.
     */
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

    /**
     * Creates a new appointment (Cita) by prompting the user to input the reason, date, and time.
     *
     * @param cliente The name of the client for whom the appointment is being booked.
     * @return A new Cita object containing the registered details.
     */
    fun reservarCita(cliente: String): Cita {
        val motivo = registrarMotivo()
        val fecha = registrarFecha()
        val hora = registrarHora()

        return Cita(cliente, motivo, fecha, hora)
    }
}
