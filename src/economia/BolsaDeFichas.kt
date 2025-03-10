package economia

//Clase genérica bolsa de fichas
class BolsaDeFichas<T : Number> {
    private val fichas = mutableListOf<Ficha<T>>()

    //Agregar fichas a la bolsa
    fun agregarFicha(ficha: Ficha<T>) {
        fichas.add(ficha)
    }

    //Contar el total de fichas
    fun totalFichas(): Int {
        return maxOf(fichas.sumOf { (it.valor as? Int) ?: 0 }, 0)
    }

    //Quitar fichas de la bolsa
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

}
