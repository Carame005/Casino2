package juegos
import kotlin.random.Random

class Ruleta(nombre: String, monto: Int) : Juego(nombre, monto) {
    override fun iniciarJuego() {
        println("Ingrese una cantidad a apostar: ")
        var cantidad: Int
        do {
            cantidad = readLine()!!.toInt()
        } while (!apostar(cantidad))

        println("Apuesta por un número (0-36) o 'rojo'/'negro': ")
        val apuesta = readLine()!!
        val resultado = girarRuleta()

        println("Resultado: $resultado")
        if (apuesta == resultado.toString() || (apuesta == "rojo" && resultado % 2 == 1) || (apuesta == "negro" && resultado % 2 == 0)) {
            println("¡Ganaste!")
            monto += cantidad * 2
        } else {
            println("Perdiste :(")
        }
    }

    private fun girarRuleta() = Random.nextInt(0, 37)
    override fun mostrarResultados() {
        println(ultimoResultado)
    }
}
