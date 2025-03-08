package economia

class Ficha<T>(val valor: T) {
    override fun toString(): String {
        return valor.toString()
    }
}