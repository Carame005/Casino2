import juegos.Ruleta
import juegos.Dados
import juegos.Blackjack
import juegos.Tragaperras
import economia.Ficha

fun main() {
    val casino = listOf(Tragaperras(), Dados(), Blackjack(), Ruleta())

    casino.forEach { juego ->
        juego.bolsaDeFichas.agregarFicha(Ficha(100))
        juego.bolsaDeFichas.agregarFicha(Ficha(50))
        juego.bolsaDeFichas.agregarFicha(Ficha(20))
    }

    while (true) {
        println("\nBienvenido al Casino! Elige un juego:")
        casino.forEachIndexed { index, juego ->
            println("${index + 1}. ${juego.nombre} (Fichas disponibles: ${juego.bolsaDeFichas.totalFichas()})")
        }
        println("5. Salir")
        println("6. Mostrar fichas")

        val opcion = readLine()!!.toInt()
        when (opcion) {
            in 1..4 -> casino[opcion - 1].iniciarJuego()
            5 -> break
            6 -> casino.forEach { it.mostrarResultados() }
            else -> println("Opción no válida")
        }
    }
}

