package juegos

abstract class Juego (val nombre : String, var monto : Int){

    abstract fun iniciarJuego()

    fun apostar(cantidad: Int): Boolean {
        return if (cantidad <= monto) {
            monto -= cantidad
            true
        } else {
            false
        }
    }


    fun esPar(numero : Int) : Boolean{
        return if (numero % 2 == 0){
            true
        } else{
            false
        }
    }


    abstract fun mostrarResultados()

}