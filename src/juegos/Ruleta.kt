package juegos
import kotlin.random.Random

class Ruleta (nombre : String,monto : Int) : Juego(nombre,monto) {
    override fun iniciarJuego() {
        var apuesta = false
        println("Ingrese una cantidad a apostar: ")
        while (apuesta == false) {
            val cantidad = readLine()!!.toInt()
            apuesta = apostar(cantidad)
        }
    }

    fun girarRuleta(){
        TODO()
    }


    override fun mostrarResultados() {
        TODO("Not yet implemented")
    }
}