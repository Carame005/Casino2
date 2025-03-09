package juegos
import economia.BolsaDeFichas
import economia.Ficha

abstract class Juego(val nombre: String) {
    val bolsaDeFichas = BolsaDeFichas<Int>()

    abstract fun iniciarJuego()

    fun apostar(ficha: Ficha<Int>): Boolean {
        if (bolsaDeFichas.totalFichas() >= ficha.valor) {
            bolsaDeFichas.quitarFicha(ficha)
            return true
        } else {
            println("⚠ No tienes suficientes fichas para apostar esa cantidad.")
            return false
        }
    }



    fun solicitarFicha(): Ficha<Int> {
        while (true) {
            println("Ingrese el valor de la ficha a apostar: ")
            val input = readLine()

            val cantidad = input?.toIntOrNull()
            if (cantidad == null || cantidad <= 0) {
                println("⚠ Error: Ingrese un número válido mayor que 0.")
                continue
            }

            return Ficha(cantidad)
        }
    }


    abstract fun mostrarResultados()
}
