import presentacion.Consola
import presentacion.Login

fun main() {
    val consola = Consola()
    val (email, contraseña) = consola.obtenerCredenciales()
    // Llamamos al login
    val login = Login(email, contraseña)
    readln()
    //Llamada a la consola para abrir el casino
    consola.menu()
}
