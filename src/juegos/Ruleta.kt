package juegos
import economia.Ficha

class Ruleta : Juego("Ruleta") {
    override fun iniciarJuego() {
        val ficha = solicitarFicha()
        if (apostar(ficha)) {
            println("Elige un número entre 0 y 36:")
            val apuestaNumero = readLine()!!.toInt()

            val resultado = girarRuleta()
            println("La ruleta cayó en el número: $resultado")

            if (apuestaNumero == resultado) {
                val ganancia = ficha.valor * 10
                bolsaDeFichas.agregarFicha(Ficha(ganancia))
                println("¡Ganaste! Se te agregan $ganancia créditos en fichas.")
            } else {
                println("No acertaste. Perdiste la apuesta.")
            }
        }
    }

    private fun girarRuleta(): Int {
        return (0..36).random()
    }

    override fun mostrarResultados() {
        bolsaDeFichas.mostrarFichas()
    }
}
