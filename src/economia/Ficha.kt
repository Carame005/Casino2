package economia

//Clase genérica ficha
class Ficha<T>(val valor: T) {
    override fun toString(): String {
        return valor.toString()
    }
}