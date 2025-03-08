package juegos
import economia.Ficha

class Ruleta : Juego("Ruleta") {
    override fun iniciarJuego() {
        println("Ingrese el valor de la ficha a apostar: ")
        val cantidad = readLine()!!.toInt()
        val ficha = Ficha(cantidad)

        if (apostar(ficha)) {
            println("Elige un número entre 0 y 36:")
            val apuestaNumero = readLine()!!.toInt()

            val resultado = girarRuleta()
            println("La ruleta cayó en el número: $resultado")

            if (apuestaNumero == resultado) {
                bolsaDeFichas.agregarFicha(Ficha(cantidad * 10))
                println("¡Ganaste! Se te agregan ${cantidad * 10} créditos en fichas.")
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
