package juegos
import economia.BolsaDeFichas
import economia.Ficha

abstract class Juego(val nombre: String) {
    val bolsaDeFichas = BolsaDeFichas<Int>()

    abstract fun iniciarJuego()

    fun apostar(ficha: Ficha<Int>): Boolean {
        return if (bolsaDeFichas.quitarFicha(ficha)) {
            println("Apostaste una ficha de ${ficha.valor} créditos.")
            true
        } else {
            println("No tienes fichas suficientes para apostar.")
            false
        }
    }

    abstract fun mostrarResultados()
}
