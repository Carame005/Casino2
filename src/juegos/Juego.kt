package juegos
import economia.BolsaDeFichas
import economia.Ficha


abstract class Juego(val nombre: String) {
    //Funcion principal que varía dependiendo del juego
    abstract fun iniciarJuego(bolsaDeFichas: BolsaDeFichas<Int>)

    //Metodo para apostar fichas
    fun apostar(bolsaDeFichas: BolsaDeFichas<Int>, ficha: Ficha<Int>): Boolean {
        if (bolsaDeFichas.totalFichas() >= ficha.valor) {
            return true
        } else {
            println("⚠ No tienes suficientes fichas para apostar esa cantidad.")
            return false
        }
    }


    //Metodo para solicitar el numero de fichas que desee apostar
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
