package presentacion
import juegos.Ruleta
import juegos.Dados
import juegos.Blackjack
import juegos.Tragaperras
import economia.Ficha
import economia.BolsaDeFichas

class Consola() {
    //Menu principal
    fun menu() {
        val bolsaDeFichas = BolsaDeFichas<Int>() // Instancia única para todos los juegos
        bolsaDeFichas.agregarFicha(Ficha(100)) // Se agregan fichas iniciales
        bolsaDeFichas.agregarFicha(Ficha(50))
        bolsaDeFichas.agregarFicha(Ficha(20))

        //Lista que contiene una instancia de cada juego
        val casino = listOf(
            Tragaperras("Tragaperras"),
            Dados("Dados"),
            Blackjack("Blackjack"),
            Ruleta("Ruleta")
        )

        //Flujo principal del programa
        while (bolsaDeFichas.totalFichas() > 0) {
            limpiarPantalla()
            println("\n🎰 Bienvenido al Casino! Elige un juego:")
            casino.forEachIndexed { index, juego ->
                println("${index + 1}. ${juego.nombre}")
            }
            println("5. Salir")
            println("Fichas disponibles: ${bolsaDeFichas.totalFichas()}")

            val opcion = readLine()?.toIntOrNull() ?: -1
            when (opcion) {
                in 1..4 -> casino[opcion - 1].iniciarJuego(bolsaDeFichas)
                5 -> break
                else -> println("❌ Opción no válida")
            }
        }
        println("\n🏁 El juego ha terminado. Te has quedado con ${bolsaDeFichas.totalFichas()} fichas.")
    }

    //Funcion simple para limpiar pantalla ya que en este IDE no existe el metodo como tal
    fun limpiarPantalla() {
        repeat(50) { println() } // Imprime 50 líneas en blanco para "borrar" la pantalla
    }

    // Función que maneja el menú de las credenciales y devuelve email y contraseña
    fun obtenerCredenciales(): Pair<String, String> {
        var email: String? = null
        var contraseña: String? = null

        while (email == null || contraseña == null) {
            println("Bienvenido, ¿qué desea hacer?")
            println("1. Iniciar sesión")
            println("2. Registrarse")

            when (readln().toIntOrNull()) {
                1 -> {
                    println("📩 Ingrese su email:")
                    email = readln()

                    println("🔑 Ingrese su contraseña:")
                    contraseña = readln()
                }

                2 -> {
                    email = "caramelodecereza@gmail.com"
                    contraseña = "CarameloDeCereza_69"
                    println("🎉 Registro exitoso. Ahora puedes iniciar sesión.")
                }

                else -> println("❌ Opción inválida. Intente de nuevo.")
            }
        }
        return email to contraseña
    }
}