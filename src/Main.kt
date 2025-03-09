import juegos.Ruleta
import juegos.Dados
import juegos.Blackjack
import juegos.Tragaperras
import economia.Ficha
import economia.BolsaDeFichas

fun main() {
    val bolsaDeFichas = BolsaDeFichas<Int>() // Instancia única para todos los juegos
    bolsaDeFichas.agregarFicha(Ficha(100)) // Se agregan fichas iniciales
    bolsaDeFichas.agregarFicha(Ficha(50))
    bolsaDeFichas.agregarFicha(Ficha(20))

    val casino = listOf(
        Tragaperras("Tragaperras"),
        Dados("Dados"),
        Blackjack("Blackjack"),
        Ruleta("Ruleta")
    )

    while (bolsaDeFichas.totalFichas() > 0) {
        println("\n🎰 Bienvenido al Casino! Elige un juego:")
        casino.forEachIndexed { index, juego ->
            println("${index + 1}. ${juego.nombre}")
        }
        println("5. Salir")
        println("Fichas disponibles: ${bolsaDeFichas.totalFichas()}")

        val opcion = readLine()?.toIntOrNull() ?: -1
        when (opcion) {
            in 1..4 -> casino[opcion - 1].iniciarJuego(bolsaDeFichas)
            5 -> break
            else -> println("❌ Opción no válida")
        }
    }

    println("\n🏁 El juego ha terminado. Te has quedado sin fichas.")
}

