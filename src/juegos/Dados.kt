package juegos
import economia.Ficha

class Dados : Juego("Dados") {
    override fun iniciarJuego() {
        println("Ingrese el valor de la ficha a apostar: ")
        val cantidad = readLine()!!.toInt()
        val ficha = Ficha(cantidad)

        if (apostar(ficha)) {
            val resultado = tirarDados()
            println("Tiraste los dados y obtuviste: $resultado")

            if (resultado > 7) {
                bolsaDeFichas.agregarFicha(Ficha(cantidad * 2))
                println("¡Ganaste! Se te agregan ${cantidad * 2} créditos en fichas.")
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
