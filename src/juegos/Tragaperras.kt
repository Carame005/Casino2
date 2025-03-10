package juegos
import economia.Ficha
import economia.BolsaDeFichas

class Tragaperras(nombre: String) : Juego(nombre) {
    //Constante con los simbolos
    companion object{
        val SIMBOLOS_DE_RULETA = arrayOf("☆", "♕", "☺", "♢", "7")
    }
    //Flujo principal de la tragaperras
    override fun iniciarJuego(bolsaDeFichas: BolsaDeFichas<Int>) {
        println("🎰 Bienvenido a $nombre")
        val ficha = solicitarFicha()

        if (!apostar(bolsaDeFichas, ficha)) return

        val resultado = girarRuleta()
        println("🎰 Resultado: ${resultado.joinToString(" ")}")

        if (resultado.distinct().size == 1) {
            val premio = ficha.valor * 5
            println("🎉 Jackpot! Ganaste $premio fichas.")
            bolsaDeFichas.agregarFicha(Ficha(premio))
        } else {
            println("😢 No ganaste esta vez.")
            bolsaDeFichas.agregarFicha(Ficha(-ficha.valor)) // Solo restamos al perder
        }
        readln()
    }
    //Funcion para girar la ruleta
    private fun girarRuleta(): Array<String> {
        return Array(3) { SIMBOLOS_DE_RULETA.random() }
    }
}

