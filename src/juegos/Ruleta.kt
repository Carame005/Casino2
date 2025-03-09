package juegos
import economia.Ficha
import economia.BolsaDeFichas

class Ruleta(nombre: String) : Juego(nombre) {
    override fun iniciarJuego(bolsaDeFichas: BolsaDeFichas<Int>) {
        println("🎡 Bienvenido a $nombre")
        val ficha = solicitarFicha()

        if (!apostar(bolsaDeFichas, ficha)) return

        println("Elige un número entre 0 y 36:")
        val numeroElegido = readLine()?.toIntOrNull() ?: -1

        if (numeroElegido !in 0..36) {
            println("❌ Número fuera de rango. Se cancela la apuesta.")
            bolsaDeFichas.agregarFicha(ficha)
            return
        }

        val resultado = (0..36).random()
        println("🎡 La ruleta gira... y cae en el número: $resultado")

        if (numeroElegido == resultado) {
            val premio = ficha.valor * 36
            println("🎉 ¡Acertaste! Ganaste $premio fichas.")
            bolsaDeFichas.agregarFicha(Ficha(premio))
        } else {
            println("😢 No acertaste esta vez.")
            bolsaDeFichas.agregarFicha(Ficha(-ficha.valor))
        }
        readln()
    }
}
