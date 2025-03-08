package economia

class BolsaDeFichas<T> {
    private val fichas = mutableListOf<Ficha<T>>()

    fun agregarFicha(ficha: Ficha<T>) {
        fichas.add(ficha)
    }

    fun quitarFicha(ficha: Ficha<T>): Boolean {
        return if (fichas.contains(ficha)) {
            fichas.remove(ficha)
            true
        } else {
            false
        }
    }

    fun mostrarFichas() {
        println("Fichas en la bolsa: $fichas")
    }

    fun totalFichas(): Int {
        return fichas.size
    }
}
