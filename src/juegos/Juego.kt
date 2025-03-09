package juegos
import economia.BolsaDeFichas
import economia.Ficha


abstract class Juego(val nombre: String) {
    abstract fun iniciarJuego(bolsaDeFichas: BolsaDeFichas<Int>)

    fun apostar(bolsaDeFichas: BolsaDeFichas<Int>, ficha: Ficha<Int>): Boolean {
        return if (bolsaDeFichas.quitarFichas(ficha.valor)) {
            println("💰 Apostaste ${ficha.valor} fichas.")
            true
        } else {
            println("⚠ No tienes suficientes fichas para apostar esa cantidad.")
            false
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
}
