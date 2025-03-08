package juegos
import kotlin.random.Random

class Dados(nombre: String, monto: Int) : Juego(nombre, monto) {
    override fun iniciarJuego() {
        println("Ingrese una cantidad a apostar: ")
        var cantidad: Int
        do {
            cantidad = readLine()!!.toInt()
        } while (!apostar(cantidad))

        val resultado = tirarDados()
        println("Resultado: ${resultado[0]} y ${resultado[1]}")
        if (resultado.sum() > 7) {
            println("¡Ganaste!")
            monto += cantidad * 2
        } else {
            println("Perdiste :(")
        }
    }

    private fun tirarDados() = arrayOf(Random.nextInt(1, 7), Random.nextInt(1, 7))
    override fun mostrarResultados() {
        println(ultimoResultado)
    }
}