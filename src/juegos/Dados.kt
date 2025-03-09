package juegos
import economia.Ficha
import economia.BolsaDeFichas

class Dados(nombre: String) : Juego(nombre) {
    override fun iniciarJuego(bolsaDeFichas: BolsaDeFichas<Int>) {
        println("🎲 Bienvenido a $nombre")
        val ficha = solicitarFicha()

        if (!apostar(bolsaDeFichas, ficha)) return

        val dado1 = (1..6).random()
        val dado2 = (1..6).random()
        val suma = dado1 + dado2

        println("🎲 Sacaste $dado1 y $dado2 (Total: $suma)")

        when (suma) {
            7, 11 -> {
                val premio = ficha.valor * 2
                println("🎉 ¡Ganaste! Recibes $premio fichas.")
                bolsaDeFichas.agregarFicha(Ficha(premio))
            }

            else -> {
                println("😢 No ganaste esta vez.")
                bolsaDeFichas.agregarFicha(Ficha(-ficha.valor))
            }
        }
        readln()
    }
}

