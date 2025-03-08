import juegos.Ruleta
import juegos.Dados
import juegos.Blackjack
import juegos.Tragaperras

fun main() {
    val casino = listOf(
        Tragaperras("Tragaperras", 100),
        Dados("Dados", 100),
        Blackjack("Blackjack", 100),
        Ruleta("Ruleta", 100)
    )

    while (true) {
        println("\nBienvenido al Casino! Elige un juego:")
        casino.forEachIndexed { index, juego -> println("${index + 1}. ${juego.nombre} (Saldo: ${juego.monto})") }
        println("5. Salir")

        val opcion = readLine()!!.toInt()
        when (opcion) {
            in 1..4 -> casino[opcion - 1].iniciarJuego()
            5 -> break
            else -> println("Opción no válida")
        }

    }
}
