package juegos
import kotlin.random.Random

class Tragaperras(nombre: String, monto: Int) : Juego(nombre, monto) {
    override fun iniciarJuego() {
        println("Ingrese una cantidad a apostar: ")
        var cantidad: Int
        do {
            cantidad = readLine()!!.toInt()
        } while (!apostar(cantidad))

        val resultado = girarRuleta()
        println("Resultado: ${resultado.joinToString(" ")}")
        if (resultado.distinct().size == 1) {
            println("¡Ganaste!")
            monto += cantidad * 5
        } else {
            println("Perdiste :(")
        }
    }

    private fun girarRuleta(): Array<String> {
        val simbolos = arrayOf("☆", "♕", "☺", "♢")
        return Array(3) { simbolos.random() }
    }

    override fun mostrarResultados() {}
}