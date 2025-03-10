package juegos
import economia.Ficha
import economia.BolsaDeFichas

class Ruleta(nombre: String) : Juego(nombre) {
    //Flujo principal de la Ruleta
    override fun iniciarJuego(bolsaDeFichas: BolsaDeFichas<Int>) {
        println("🎡 Bienvenido a $nombre")
        val ficha = solicitarFicha()

        if (!apostar(bolsaDeFichas, ficha)) return

        println("Elige tu tipo de apuesta:")
        println("1. Apostar a un número (0-36) 🎯")
        println("2. Apostar al color (Rojo o Negro) ⚫🔴")

        val tipoApuesta = readLine()?.toIntOrNull() ?: -1

        when (tipoApuesta) {
            1 -> apostarNumero(bolsaDeFichas, ficha)
            2 -> apostarColor(bolsaDeFichas, ficha)
            else -> println("❌ Opción inválida. Se cancela la apuesta.")
        }
        readln()
    }
    //Metodo para apostar numero
    private fun apostarNumero(bolsaDeFichas: BolsaDeFichas<Int>, ficha: Ficha<Int>) {
        println("Elige un número entre 0 y 36:")
        val numeroElegido = readLine()?.toIntOrNull() ?: -1

        if (numeroElegido !in 0..36) {
            println("❌ Número fuera de rango. Se cancela la apuesta.")
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
    }
    //Metodo para apostar color
    private fun apostarColor(bolsaDeFichas: BolsaDeFichas<Int>, ficha: Ficha<Int>) {
        println("Elige un color: Rojo (R) o Negro (N)")
        val eleccionColor = readLine()?.uppercase()

        if (eleccionColor != "R" && eleccionColor != "N") {
            println("❌ Opción inválida. Se cancela la apuesta.")
            return
        }

        val resultado = (0..36).random()
        val esRojo = resultado in rojo // Comprueba si es un número rojo

        val colorResultado = if (esRojo) "Rojo" else "Negro"
        println("🎡 La ruleta gira... y cae en el número: $resultado ($colorResultado)")

        if ((eleccionColor == "R" && esRojo) || (eleccionColor == "N" && !esRojo)) {
            val premio = ficha.valor * 2
            println("🎉 ¡Acertaste! Ganaste $premio fichas.")
            bolsaDeFichas.agregarFicha(Ficha(premio))
        } else {
            println("😢 No acertaste esta vez.")
            bolsaDeFichas.agregarFicha(Ficha(-ficha.valor))
        }
    }

    // Números que son rojos en la ruleta
    companion object {
        private val rojo = setOf(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36)
    }
}

