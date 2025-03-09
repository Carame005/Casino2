package presentacion

class Login(private val email: String, private val contraseña: String) {
    private val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()

    init {
        if (!validarCorreo()) {
            throw IllegalArgumentException("❌ Correo inválido: $email")
        }
        if (contraseña.isEmpty()) {
            throw IllegalArgumentException("⚠ La contraseña no puede estar vacía.")
        }
        iniciarSesion()
    }

    private fun validarCorreo(): Boolean {
        return email.matches(emailRegex)
    }

    private fun iniciarSesion() {
        println("✅ Inicio de sesión exitoso con el correo: $email")
    }
}