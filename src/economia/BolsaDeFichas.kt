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
}
