package juegos
import economia.Ficha

class Tragaperras : Juego("Tragaperras") {
    override fun iniciarJuego() {
        val ficha = solicitarFicha()
        if (apostar(ficha)) {
            val resultado = girarRuleta()
            println("Tragaperras: ${resultado.joinToString(" ")}")

            if (resultado.distinct().size == 1) {
                val ganancia = ficha.valor * 5
                bolsaDeFichas.agregarFicha(Ficha(ganancia))
                println("¡Ganaste! Se te agregan $ganancia créditos en fichas.")
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

