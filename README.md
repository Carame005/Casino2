# Casino

### **💡 Concepto del Proyecto**

Crear una aplicación de casino en Kotlin con juegos básicos como **ruleta, blackjack, tragamonedas y dados**. Los jugadores podrán apostar con dinero ficticio y ver su historial de apuestas.

---

### **🛠️ Características y Requisitos Técnicos**

1. **POO y Herencia**
    
    - Clase base `Juego` con métodos como `iniciarJuego()`, `apostar()`, `mostrarResultados()`.
    - Subclases para cada juego: `Ruleta`, `Blackjack`, `Tragamonedas`, `Dados`.
2. **Genéricos**
    
    - Un sistema de apuestas `Apuesta<T>` donde `T` puede ser cualquier juego (`Ruleta`, `Blackjack`, etc.).
3. **Expresiones Regulares**
    
    - Validar entradas del usuario (por ejemplo, formatos de números para apuestas).
4. **Principios SOLID**
    
    - Aplicar separación de responsabilidades (`Single Responsibility`), uso de interfaces (`Interface Segregation`), y dependencia de abstracciones (`Dependency Inversion`).
5. **Librerías Externas**
    
    - **Kotlin Random** para generar números aleatorios en los juegos.
    - **Room Database** para almacenar historial de apuestas.
    - **Jetpack Compose** para una interfaz visual atractiva.

---

### **🎰 Juegos Disponibles**

1. **Ruleta** 🎡
    
    - El usuario apuesta a un número (0-36) o a rojo/negro.
    - Se genera un número aleatorio y se determina si ganó o perdió.
2. **Blackjack** 🃏
    
    - Implementar un sistema básico de cartas donde el jugador intenta llegar a 21 sin pasarse.
3. **Tragamonedas** 🎰
    
    - Se muestran tres símbolos aleatorios.
    - Si hay coincidencias, el usuario gana.
4. **Dados** 🎲
    
    - Se tiran dos dados y se apuesta por números específicos o pares/impares.

---
