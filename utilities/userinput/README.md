# UserInput Package

El paquete `UserInput` es una utilidad sencilla y flexible para manejar la entrada del usuario en aplicaciones Java. Permite recibir tanto enteros como dobles, así como cadenas de texto, con la capacidad de aplicar validaciones personalizadas como el rango de valores, la longitud de las cadenas, y el formato de las entradas (por ejemplo, correos o electrónicos).

## Características

- **Entrada de Números**: Maneja la entrada de enteros y números decimales con validación opcional.
- **Entrada de Cadenas**: Permite validar cadenas de texto en función de la longitud, mayúsculas/minúsculas, o patrones específicos como correos electrónicos.
- **Validadores Personalizables**: Utiliza predicados para aplicar reglas de validación personalizadas.


## Uso Básico

### Entrada de Entero Sin Validación

```java
import userinput.InputHandler;

public class Main {
    public static void main(String[] args) {
        int number = InputHandler.getInteger("Ingrese un número: ");
        System.out.println("Número ingresado: " + number);
    }
}
```

### Entrada de Entero con Validación de Rango

```java
import userinput.InputHandler;
import userinput.ValidatorFactory;

public class Main {
    public static void main(String[] args) {
        // Crear un validador para un rango específico
        Predicate<Integer> rangoValidador = ValidatorFactory.betweenInclusive(1, 100);

        int number = InputHandler.getInteger("Ingrese un número entre 1 y 100: ", rangoValidador);
        System.out.println("Número ingresado dentro del rango: " + number);
    }
}
```

### Entrada de Cadena con Validación de Longitud y Mayúsculas

```java
import com.userinput.InputHandler;
import com.userinput.ValidatorFactory;

public class Main {
    public static void main(String[] args) {
        // Validar una cadena que tenga entre 5 y 10 caracteres y esté en mayúsculas
        Predicate<String> validador = ValidatorFactory.lengthBetween(5, 10)
                                        .and(ValidatorFactory.isUpperCase());

        String texto = UserInput.getString("Ingrese un texto en mayúsculas de 5 a 10 caracteres: ", validador);
        System.out.println("Texto válido ingresado: " + texto);
    }
}
```

### Entrada de Correo Electrónico Válido

```java
import com.userinput.InputHandler;
import com.userinput.ValidatorFactory;

public class Main {
    public static void main(String[] args) {
        // Validar un correo electrónico utilizando expresiones regulares
        Predicate<String> emailValidador = ValidatorFactory.isEmail();

        String email = InputHandler.getString("Ingrese su correo electrónico: ", emailValidador);
        System.out.println("Correo electrónico válido: " + email);
    }
}
```


## Validadores Disponibles

El paquete incluye una serie de validadores predefinidos que se pueden usar para controlar la entrada del usuario:

- **`betweenInclusive(int min, int max)`**: Valida que un número entero esté dentro de un rango inclusivo.
- **`lengthBetween(int minLength, int maxLength)`**: Valida que la longitud de una cadena esté dentro de un rango inclusivo.
- **`isUpperCase()`**: Valida que todos los caracteres de una cadena estén en mayúsculas.
- **`isLowerCase()`**: Valida que todos los caracteres de una cadena estén en minúsculas.
- **`isEmail()`**: Valida que una cadena cumpla con el formato de correo electrónico.