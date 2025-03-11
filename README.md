# Preguntas para la Evaluación

Este conjunto de preguntas está diseñado para ayudarte a reflexionar sobre cómo has aplicado los criterios de evaluación en tu proyecto. Al responderlas, **asegúrate de hacer referencia y enlazar al código relevante** en tu `README.md`, facilitando así la evaluación de tu trabajo.

#### **Criterio global 1: Instancia objetos y hacer uso de ellos**
- **(2.a, 2.b, 2.c, 2.d, 2.f, 2.h, 4.e, 4.f)**: Describe cómo has instanciado y utilizado objetos en tu proyecto. ¿Cómo has aplicado los constructores y pasado parámetros a los métodos? Proporciona ejemplos específicos de tu código.

Mi proyecto al ser un casino no tiene muchos parametros, los pocos que tienen son el email y la contraseña a la hora de iniciar sesion, el nombre de los juegos y poco más ya que el resto de cosas se manejan con las clases.

[Clase Juego](https://github.com/Carame005/Casino2/blob/master/src/juegos/Juego.kt#L6)

[Clase Login](https://github.com/Carame005/Casino2/blob/master/src/presentacion/Login.kt#L3)

#### **Criterio global 2: Crear y llamar métodos estáticos**
- **(4.h)**: ¿Has definido algún método/propiedad estático en tu proyecto? ¿Cuál era el objetivo y por qué consideraste que debía ser estático en lugar de un método/propiedad de instancia?
- **(2.e)**: ¿En qué parte del código se llama a un método estático o se utiliza la propiedad estática?

He definido cómo estático el método para validar el email.Para que se no dependa de una instancia para usarse.

[Metodo etático validar email](https://github.com/Carame005/Casino2/blob/master/src/presentacion/Login.kt#L16-L19)

#### **Criterio global 3: Uso de entornos**
- **(2.i)**: ¿Cómo utilizaste el IDE para el desarrollo de tu proyecto? Describe el proceso de creación, compilación, y prueba de tu programa.

Pues lo usé de forma que mi código se vea limpio, ordenandolo en carpetas, usando las funciones del IDE como la depuracion , etc...

Comencé creando la distribucion de carpetas, al principio solo usé la de Juego y probaba el flujo en el Main, más adelante creé la de Economía y la de Presentación.

Fuí añadiendo más funciones que mejoraban el programa a nivel estético y a nivel de código.

#### **Criterio global 4: Definir clases y su contenido**
- **(4.a, 4.b, 4.c, 4.d, 4.g)**: Explica sobre un ejemplo de tu código, cómo definiste las clases en tu proyecto, es decir como identificaste las de propiedades, métodos y constructores y modificadores del control de acceso a métodos y propiedades, para representar al objeto del mundo real. ¿Cómo contribuyen estas clases a la solución del problema que tu aplicación aborda?

[Clase BolsaDeFichas](https://github.com/Carame005/Casino2/blob/master/src/economia/BolsaDeFichas.kt#L4-L16)

BolsaDeFichas es una clase genérica que recibe un Number, como parametro fuera del constructor recibe una lista mutable de la clase Ficha y es privada para que no se pueda cambiar su valor, hace uso de dos métodos agregarFicha y totalfichas() que posteriormente serán usados por la clases derivadas de Juego para manejar la economia del casino.

#### **Criterio global 5: Herencia y uso de clases abstractas e interfaces**
- **(4.g, 7.a, 7.b, 7.c, 7.i, 7.j)**: Describe sobre tu código cómo has implementado la herencia y/o utilizado interfaces en tu proyecto. ¿Por qué elegiste este enfoque y cómo beneficia a la estructura de tu aplicación? ¿De qué manera has utilizado los principios SOLID para mejorar el diseño de tu proyecto? Mostrando tu código, contesta qué principios has utilizado y qué beneficio has obtenido.

Basicamente está distribuido así:

[Clase Juego](https://github.com/Carame005/Casino2/blob/master/src/juegos/Juego.kt#L6)

[BlackJack](https://github.com/Carame005/Casino2/blob/master/src/juegos/Blackjack.kt#L5)

[Dados](https://github.com/Carame005/Casino2/blob/master/src/juegos/Dados.kt#L5)

[Ruleta](https://github.com/Carame005/Casino2/blob/master/src/juegos/Ruleta.kt#L5)

[Tragaperras](https://github.com/Carame005/Casino2/blob/master/src/juegos/Tragaperras.kt#L5)


Elegí este método al ser una forma ordenada de clasificar las clases, como las 4 clases hija son juegos comparten algunas funciones comunes como la de apostar o la de solicitarFicha.

 Resumen de los principios SOLID aplicados:
1. **SRP (Responsabilidad Única)**: Cada clase tiene una única responsabilidad.Ya que cada clase es un juego distinto con mecánicas distintas.
2. **OCP (Abierto/Cerrado)**: Puedes extender la funcionalidad sin modificar el código existente.Ya que solo se debe modificar la clase juego para añadir mas funcionalidades.
3. **LSP (Sustitución de Liskov)**: Las clases hijas pueden reemplazar a la clase base sin problemas.
4. **ISP (Segregación de la Interfaz)**: Cada clase hija implementa solo lo necesario para su tipo de juego.Como se puede ver en cada clase que no hay metodos o funciones demás.

#### **Criterio global 6: Diseño de jerarquía de clases**
- **(7.d, 7.e, 7.f, 7.g)**: Presenta la jerarquía de clases que diseñaste. ¿Cómo probaste y depuraste esta jerarquía para asegurar su correcto funcionamiento? ¿Qué tipo de herencia has utilizado: Especificación, Especialización, Extensión, Construcción?

Pues la jerarquía es simple, una clase abstracta y 4 subclases que la heredan. La probé a base de ensayo y error, aunque no es muy difícil ya que únicamente se hereda una clase

Los tipos de herencia son:
- **Extensión**: Las clases hijas `Tragaperras`, `Dados`, `Blackjack`, y `Ruleta` extienden la funcionalidad común definida por la clase `Juego`.
- **Especialización**: Cada clase hija **especializa** la implementación del método `iniciarJuego` para adaptarse a su tipo de juego específico.
  
#### **Criterio global 7: Librerías de clases**
- **(2.g, 4.i)**: Describe cualquier librería externa que hayas incorporado en tu proyecto. Explica cómo y por qué las elegiste, y cómo las incorporaste en tu proyecto. ¿Cómo extendió la funcionalidad de tu aplicación? Proporciona ejemplos específicos de su uso en tu proyecto.

He implementado la libreria `java.util.UUID` y la libreria `java.time.LocalDate` en las variables [ID](https://github.com/Carame005/Casino2/blob/master/src/presentacion/Login.kt#L7) y [fecha](https://github.com/Carame005/Casino2/blob/master/src/presentacion/Login.kt#L8) para que el metodo [iniciarSesion()](https://github.com/Carame005/Casino2/blob/master/src/presentacion/Login.kt#L28-L30) muestre por pantalla la fecha en la que se inició sesion y un id único identificativo para el usuario.Esto hace que la interfaz de inicio de sesion se vea más completa pese a ser meramente estética.

#### **Criterio global 8: Documentado**
- **(7.h)**: Muestra ejemplos de cómo has documentado y comentado tu código. ¿Que herramientas has utilizado? ¿Cómo aseguras que tu documentación aporte valor para la comprensión, mantenimiento y depuración del código?

En el readme estoy dejando enlacess permanentes a fragmentos de código en formato md.
El IDE de IntelliJidea me da una forma simple de comentar el código.
Lo he comentado así:
```kotlin
//Texto de ejemplo
```
Me he asegurado de describir lo que hace cada método de forma simple, con una pequeña descripción de su función. También he explicado cosas como el por qué he usado un companion object en ciertos lugares

#### **Criterio global 9: Genéricos**
- **(6.f)**: Muestra ejemplos de tu código sobre cómo has implementado una clase con genéricos. ¿Qué beneficio has obtenido?

He implementado dos clases genéricas, fichas y bolsa de fichas. Ambas clases pertenecen al apartado de economía y sirven para manejar la cantidad de fichas que obtienes. Estas fichas podrían haberse cambiado por algún monto pero he preferido hacerlo más bonito usando clases genéricas. La bolsa de fichas cuenta con sus métodos para agregar o devolver una suma del total de fichas.

[Clase Ficha](https://github.com/Carame005/Casino2/blob/master/src/economia/Ficha.kt#L1-L8)

[Clase BolsaDeFichas](https://github.com/Carame005/Casino2/blob/master/src/economia/BolsaDeFichas.kt#L4-L16)

#### **Criterio global 10: Expresiones Regulares**
- **(6.g)**: Muestra ejemplos de tu código donde hayas utilizado las expresiones regulares. ¿Qué beneficio has obtenido?

[Variable regex](https://github.com/Carame005/Casino2/blob/master/src/presentacion/Login.kt#L5)

[Metodo para verificar el email](https://github.com/Carame005/Casino2/blob/master/src/presentacion/Login.kt#L15-L17)

Una variable simple para validar el correo electrónico cuando se inicia sesión, esto permite generar una interfaz que aunque sea más que nada decorativa es una buena forma de aplicar expresiones regulares.
