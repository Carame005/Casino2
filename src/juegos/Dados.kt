package juegos
import economia.Ficha

class Dados : Juego("Dados") {
    override fun iniciarJuego() {
        val ficha = solicitarFicha()
        if (apostar(ficha)) {
            val resultado = tirarDados()
            println("Tiraste los dados y obtuviste: $resultado")

            if (resultado > 7) {
                val ganancia = ficha.valor * 2
                bolsaDeFichas.agregarFicha(Ficha(ganancia))
                println("¡Ganaste! Se te agregan $ganancia créditos en fichas.")
            } else {
                println("Perdiste la apuesta.")
            }
        }
    }


    private fun tirarDados(): Int {
        return (1..6).random() + (1..6).random()
    }

    override fun mostrarResultados() {
        bolsaDeFichas.mostrarFichas()
    }
}
