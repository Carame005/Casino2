package juegos
import economia.Ficha
import economia.BolsaDeFichas

class Blackjack(nombre: String) : Juego(nombre) {
    //Flujo rincipal del BlackJack
    override fun iniciarJuego(bolsaDeFichas: BolsaDeFichas<Int>) {
        println("🃏 Bienvenido a $nombre")
        val ficha = solicitarFicha()

        if (!apostar(bolsaDeFichas, ficha)) return

        val jugador = (1..11).random() + (1..11).random()
        val casa = (1..11).random() + (1..11).random()

        println("🃏 Tus cartas suman: $jugador")
        println("🏠 La casa tiene: $casa")

        when {
            jugador > 21 -> {
                println("💥 Te pasaste de 21. Perdiste ${ficha.valor} fichas.")
                bolsaDeFichas.agregarFicha(Ficha(-ficha.valor))
            }
            casa > 21 || jugador > casa -> {
                val premio = ficha.valor * 2
                println("🎉 Ganaste! Recibes $premio fichas.")
                bolsaDeFichas.agregarFicha(Ficha(premio))
            }
            else -> {
                println("🏠 La casa gana. Perdiste ${ficha.valor} fichas.")
                bolsaDeFichas.agregarFicha(Ficha(-ficha.valor))
            }
        }
        readln()
    }
}


