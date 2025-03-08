package juegos
import kotlin.random.Random

class Blackjack(nombre: String, monto: Int) : Juego(nombre, monto) {
    override fun iniciarJuego() {
        println("Ingrese una cantidad a apostar: ")
        var cantidad: Int
        do {
            cantidad = readLine()!!.toInt()
        } while (!apostar(cantidad))

        val jugador = generarCartas()
        println("Tus cartas suman: $jugador")
        if (jugador == 21) {
            println("¡Blackjack! Ganaste.")
            monto += cantidad * 3
        } else if (jugador > 21) {
            println("Te pasaste. Perdiste :(")
        } else {
            println("No hiciste Blackjack. Perdiste :(")
        }
    }

    private fun generarCartas(): Int {
        return Random.nextInt(4, 22)
    }

    override fun mostrarResultados() {
        println(ultimoResultado)
    }
}