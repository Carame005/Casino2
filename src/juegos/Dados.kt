package juegos
import economia.Ficha
import economia.BolsaDeFichas

class Dados(nombre: String) : Juego(nombre) {
    //Flujo principal de los dados
    override fun iniciarJuego(bolsaDeFichas: BolsaDeFichas<Int>) {
        println("🎲 Bienvenido a $nombre")
        val ficha = solicitarFicha()

        if (!apostar(bolsaDeFichas, ficha)) return

        println("Elige tu tipo de apuesta:")
        println("1. Apostar a un número exacto (2-12) 🎯")
        println("2. Apostar a Par o Impar 🔢")

        val tipoApuesta = readLine()?.toIntOrNull() ?: -1

        when (tipoApuesta) {
            1 -> apostarNumero(bolsaDeFichas, ficha)
            2 -> apostarParImpar(bolsaDeFichas, ficha)
            else -> println("❌ Opción inválida. Se cancela la apuesta.")
        }
        readln()
    }
    //Funcion para apostar al número
    private fun apostarNumero(bolsaDeFichas: BolsaDeFichas<Int>, ficha: Ficha<Int>) {
        println("Elige un número entre 2 y 12:")
        val numeroElegido = readLine()?.toIntOrNull() ?: -1

        if (numeroElegido !in 2..12) {
            println("❌ Número fuera de rango. Se cancela la apuesta.")
            return
        }

        val dado1 = (1..6).random()
        val dado2 = (1..6).random()
        val suma = dado1 + dado2

        println("🎲 Sacaste $dado1 y $dado2 (Total: $suma)")

        if (suma == numeroElegido) {
            val premio = ficha.valor * 5
            println("🎉 ¡Acertaste el número exacto! Ganaste $premio fichas.")
            bolsaDeFichas.agregarFicha(Ficha(premio))
        } else {
            println("😢 No acertaste esta vez.")
            bolsaDeFichas.agregarFicha(Ficha(-ficha.valor))
        }
    }
    //Funcion para apostar a si es par o impar
    private fun apostarParImpar(bolsaDeFichas: BolsaDeFichas<Int>, ficha: Ficha<Int>) {
        println("Elige: Par (P) o Impar (I)")
        val eleccion = readLine()?.uppercase()

        if (eleccion != "P" && eleccion != "I") {
            println("❌ Opción inválida. Se cancela la apuesta.")
            return
        }

        val dado1 = (1..6).random()
        val dado2 = (1..6).random()
        val suma = dado1 + dado2
        val esPar = suma % 2 == 0

        println("🎲 Sacaste $dado1 y $dado2 (Total: $suma)")

        if ((eleccion == "P" && esPar) || (eleccion == "I" && !esPar)) {
            val premio = ficha.valor * 2
            println("🎉 ¡Acertaste! Ganaste $premio fichas.")
            bolsaDeFichas.agregarFicha(Ficha(premio))
        } else {
            println("😢 No acertaste esta vez.")
            bolsaDeFichas.agregarFicha(Ficha(-ficha.valor))
        }
    }
}

