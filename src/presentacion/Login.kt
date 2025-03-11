package presentacion

class Login(private val email: String, private val contraseña: String) {

    //Validar que ambas condiciones se cumplen
    init {
        require(validarCorreo(email)){throw IllegalArgumentException("❌ Correo inválido: $email")}
        require(contraseña.isNotEmpty()){throw IllegalArgumentException("⚠ La contraseña no puede estar vacía.")}
        iniciarSesion()
    }

    companion object{
        //Expresion regular para validar el correo
        private val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()

        //Metodo estático para validar el correo electronico
        private fun validarCorreo(email: String): Boolean {
            return email.matches(emailRegex)
        }
    }

    //Mensaje por pantalla simple para dar a saber que se inició sesion
    private fun iniciarSesion() {
        println("✅ Inicio de sesión exitoso con el correo: $email")
    }
}