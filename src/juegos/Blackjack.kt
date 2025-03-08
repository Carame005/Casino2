package juegos
import economia.Ficha

class Blackjack : Juego("Blackjack") {
    override fun iniciarJuego() {
        println("Ingrese el valor de la ficha a apostar: ")
        val cantidad = readLine()!!.toInt()
        val ficha = Ficha(cantidad)

        if (apostar(ficha)) {
            val resultadoJugador = generarCartas()
            val resultadoCrupier = generarCartas()

            println("Tu mano: $resultadoJugador")
            println("Mano del crupier: $resultadoCrupier")

            when {
                resultadoJugador > 21 -> println("Te pasaste de 21. Pierdes.")
                resultadoCrupier > 21 || resultadoJugador > resultadoCrupier -> {
                    bolsaDeFichas.agregarFicha(Ficha(cantidad * 2))
                    println("¡Ganaste! Se te agregan ${cantidad * 2} créditos en fichas.")
                }
                resultadoJugador == resultadoCrupier -> {
                    bolsaDeFichas.agregarFicha(Ficha(cantidad)) // Se devuelve la apuesta
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
