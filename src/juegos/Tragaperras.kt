package juegos
import kotlin.random.Random

class Tragaperras(nombre : String,monto : Int) : Juego(nombre,monto) {
    override fun iniciarJuego() {
        do {
            println("Ingrese una cantidad a apostar: ")
            val cantidad = readLine()!!.toInt()
            if (!apostar(cantidad)) {
                println("No tiene suficiente dinero para esta apuesta.")
            }
        } while (!apostar(cantidad))
        println(girarRuleta())
    }

    companion object{
        val SIMBOLOS_DE_RULETA = arrayOf("☆","♕","☺","♢")
    }

    fun girarRuleta(): Array<String> {
        val simbolos = Array(3) { SIMBOLOS_DE_RULETA.random() }
        return simbolos
    }


    override fun mostrarResultados() {
        TODO("Not yet implemented")
    }
}