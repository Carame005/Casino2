package economia

class BolsaDeFichas<T : Number> {
    private val fichas = mutableListOf<Ficha<T>>()

    fun agregarFicha(ficha: Ficha<T>) {
        fichas.add(ficha)
    }

    fun totalFichas(): Int {
        return fichas.sumOf { it.valor.toInt() }
    }

    fun quitarFichas(cantidad: Int): Boolean {
        if (totalFichas() < cantidad) return false

        var restante = cantidad
        val iterador = fichas.iterator()

        while (iterador.hasNext() && restante > 0) {
            val ficha = iterador.next()
            val valorFicha = ficha.valor.toInt()

            if (valorFicha <= restante) {
                iterador.remove()
                restante -= valorFicha
            }
        }

        return true
    }

    fun mostrarFichas() {
        println(fichas)
    }
}
