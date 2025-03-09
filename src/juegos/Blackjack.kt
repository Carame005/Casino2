package juegos
import economia.Ficha

class Blackjack : Juego("Blackjack") {
    override fun iniciarJuego() {
        val ficha = solicitarFicha()
        if (apostar(ficha)) {
            val resultadoJugador = generarCartas()
            val resultadoCrupier = generarCartas()

            println("Tu mano: $resultadoJugador")
            println("Mano del crupier: $resultadoCrupier")

            when {
                resultadoJugador > 21 -> println("Te pasaste de 21. Pierdes.")
                resultadoCrupier > 21 || resultadoJugador > resultadoCrupier -> {
                    val ganancia = ficha.valor * 2
                    bolsaDeFichas.agregarFicha(Ficha(ganancia))
                    println("¡Ganaste! Se te agregan $ganancia créditos en fichas.")
                }
                resultadoJugador == resultadoCrupier -> {
                    bolsaDeFichas.agregarFicha(ficha) // Se devuelve la apuesta en caso de empate
                    println("Empate. Te devolvemos tu apuesta.")
                }
                else -> println("El crupier gana. Perdiste la apuesta.")
            }
        }
    }


    private fun generarCartas(): Int {
        return (1..11).random() + (1..11).random()
    }

    override fun mostrarResultados() {
        bolsaDeFichas.mostrarFichas()
    }
}
