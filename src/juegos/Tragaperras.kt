package juegos
import economia.Ficha

class Tragaperras : Juego("Tragaperras") {
    override fun iniciarJuego() {
        println("Ingrese el valor de la ficha a apostar: ")
        val cantidad = readLine()!!.toInt()
        val ficha = Ficha(cantidad)

        if (apostar(ficha)) {
            val resultado = girarRuleta().joinToString(" ")
            println("Tragaperras: $resultado")

            if (resultado.distinct().size == 1) {
                bolsaDeFichas.agregarFicha(Ficha(cantidad * 5))
                println("¡Ganaste! Te llevas ${cantidad * 5} créditos en fichas.")
            } else {
                println("Perdiste la apuesta.")
            }
        }
    }

    private fun girarRuleta(): Array<String> {
        val SIMBOLOS = arrayOf("☆", "♕", "☺", "♢")
        return Array(3) { SIMBOLOS.random() }
    }

    override fun mostrarResultados() {
        bolsaDeFichas.mostrarFichas()
    }
}
