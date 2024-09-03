# Paquete `consolemenu`

El paquete `consolemenu` proporciona una estructura para crear menús interactivos en la consola. Incluye interfaces y clases que permiten definir comandos, opciones de menú, y manejar la entrada del usuario.

## Contenido del Paquete

### 1. `Command.java`

- **Descripción**:
  Define una interfaz `Command` que contiene un único método `execute()`. Esta interfaz representa una acción que puede ser ejecutada en el contexto del menú.

- **Métodos**:
    - `void execute()`: Ejecuta la acción definida por el comando.

### 2. `ConsoleMenu.java`

- **Descripción**:
  Implementa la clase `ConsoleMenu`, que gestiona un menú en la consola. La clase permite agregar opciones al menú, mostrar el menú y procesar la entrada del usuario para ejecutar las opciones seleccionadas.

- **Atributos**:
    - `String title`: El título del menú.
    - `List<MenuOption> options`: Lista de opciones del menú.
    - `MenuInputHandler inputHandler`: Manejador de la entrada del usuario.
    - `boolean exit`: Indica si el menú debe cerrarse.

- **Métodos**:
    - `public ConsoleMenu(String title, MenuInputHandler inputHandler)`: Constructor que inicializa el menú con un título y un manejador de entrada.
    - `public void addOption(MenuOption option)`: Añade una opción al menú.
    - `public void display()`: Muestra el menú y maneja la selección del usuario.
    - `private void processInput(int choice)`: Procesa la entrada del usuario y ejecuta la opción seleccionada.

### 3. `MenuCommand.java`

- **Descripción**:
  Implementa la interfaz `Command`. Esta clase encapsula una acción (`Runnable`) que se ejecuta cuando el comando es invocado.

- **Atributos**:
    - `Runnable action`: La acción que se ejecutará cuando se invoque el comando.

- **Métodos**:
    - `public MenuCommand(Runnable action)`: Constructor que inicializa el comando con una acción.
    - `@Override public void execute()`: Ejecuta la acción encapsulada.

### 4. `MenuInputHandler.java`

- **Descripción**:
  Maneja la validación de la entrada del usuario en el contexto de un menú, utilizando un validador de entrada (`InputValidator`).

- **Atributos**:
    - `Predicate<Integer> rangoValidador`: Un validador que verifica que la entrada esté dentro de un rango válido.
    - `InputValidator validator`: El validador utilizado para verificar la entrada.

- **Métodos**:
    - `public MenuInputHandler(InputValidator validator)`: Constructor que inicializa el manejador con un validador de entrada.
    - `public int getValidatedInput(String prompt, int maxOption)`: Obtiene y valida la entrada del usuario, asegurando que esté dentro del rango permitido.

### 5. `MenuOption.java`

- **Descripción**:
  Define una interfaz `MenuOption` para las opciones del menú. Cada opción tiene un texto que la describe, un comando asociado y un método para ejecutar el comando.

- **Métodos**:
    - `String getText()`: Devuelve el texto que describe la opción del menú.
    - `Command getCommand()`: Devuelve el comando asociado a la opción.
    - `void execute()`: Ejecuta el comando asociado a la opción.

## Uso del Paquete

Este paquete está diseñado para ser utilizado en aplicaciones de consola donde se requiere un menú interactivo. Los desarrolladores pueden crear opciones de menú personalizadas implementando la interfaz `MenuOption` y definir acciones específicas utilizando la interfaz `Command`.

El siguiente es un ejemplo básico de cómo usar el paquete:

```java 
MenuCommand exitCommand = new MenuCommand(() -> System.exit(0));
MenuOption exitOption = new SimpleMenuOption("Exit", exitCommand);

ConsoleMenu menu = new ConsoleMenu("Main Menu", new MenuInputHandler(new SimpleInputValidator()));
menu.addOption(exitOption);
menu.display();
```


## Ejemplos de Uso

### Ejemplo 1: Menú Simple con Opción para Salir

En este ejemplo, creamos un menú simple con una sola opción para salir de la aplicación.

```java
import utilities.consolemenu.*;

public class MainMenuExample {

    public static void main(String[] args) {
        // Crear un comando para salir del programa
        MenuCommand exitCommand = new MenuCommand(() -> System.exit(0));

        // Crear una opción de menú que utilice el comando de salida
        MenuOption exitOption = new SimpleMenuOption("Salir", exitCommand);

        // Crear un manejador de entrada
        MenuInputHandler inputHandler = new MenuInputHandler(new SimpleInputValidator());

        // Crear el menú principal y añadir la opción de salida
        ConsoleMenu menu = new ConsoleMenu("Menú Principal", inputHandler);
        menu.addOption(exitOption);

        // Mostrar el menú
        menu.display();
    }
}
```

### Ejemplo 2: Menú con Varias Opciones

Este ejemplo muestra cómo crear un menú con varias opciones, cada una ejecutando una acción diferente.

```java
import utilities.consolemenu.*;

public class MultipleOptionsMenuExample {

    public static void main(String[] args) {
        // Crear comando para saludar
        MenuCommand greetCommand = new MenuCommand(() -> System.out.println("¡Hola, bienvenido!"));

        // Crear comando para mostrar la hora actual
        MenuCommand timeCommand = new MenuCommand(() -> System.out.println("Hora actual: " + java.time.LocalTime.now()));

        // Crear comando para salir
        MenuCommand exitCommand = new MenuCommand(() -> System.exit(0));

        // Crear opciones de menú
        MenuOption greetOption = new SimpleMenuOption("Saludar", greetCommand);
        MenuOption timeOption = new SimpleMenuOption("Mostrar hora actual", timeCommand);
        MenuOption exitOption = new SimpleMenuOption("Salir", exitCommand);

        // Crear un manejador de entrada
        MenuInputHandler inputHandler = new MenuInputHandler(new SimpleInputValidator());

        // Crear el menú principal y añadir las opciones
        ConsoleMenu menu = new ConsoleMenu("Menú de Opciones", inputHandler);
        menu.addOption(greetOption);
        menu.addOption(timeOption);
        menu.addOption(exitOption);

        // Mostrar el menú
        menu.display();
    }
}
```

### Ejemplo 3: Menú con Validación de Entrada

En este ejemplo, se muestra cómo usar un validador personalizado para restringir las opciones que el usuario puede seleccionar.

```java
import utilities.consolemenu.*;
import utilities.userinput.*;

public class ValidatedMenuExample {

    public static void main(String[] args) {
        // Crear comando para una operación ficticia
        MenuCommand operationCommand = new MenuCommand(() -> System.out.println("Operación realizada"));

        // Crear comando para salir
        MenuCommand exitCommand = new MenuCommand(() -> System.exit(0));

        // Crear opciones de menú
        MenuOption operationOption = new SimpleMenuOption("Realizar operación", operationCommand);
        MenuOption exitOption = new SimpleMenuOption("Salir", exitCommand);

        // Crear un validador que solo permite números entre 1 y 2
        InputValidator customValidator = ValidatorFactory.betweenInclusive(1, 2);
        MenuInputHandler inputHandler = new MenuInputHandler(customValidator);

        // Crear el menú principal y añadir las opciones
        ConsoleMenu menu = new ConsoleMenu("Menú Validado", inputHandler);
        menu.addOption(operationOption);
        menu.addOption(exitOption);

        // Mostrar el menú
        menu.display();
    }
}
```

### Ejemplo 4: Submenús Anidados

Este ejemplo muestra cómo crear un menú con submenús, permitiendo una estructura jerárquica.

```java
import utilities.consolemenu.*;

public class SubMenuExample {

    public static void main(String[] args) {
        // Crear comando para volver al menú principal
        MenuCommand returnCommand = new MenuCommand(() -> System.out.println("Volviendo al menú principal..."));

        // Crear comando para salir
        MenuCommand exitCommand = new MenuCommand(() -> System.exit(0));

        // Crear un submenú
        ConsoleMenu subMenu = new ConsoleMenu("Submenú", new MenuInputHandler(new SimpleInputValidator()));
        subMenu.addOption(new SimpleMenuOption("Volver", returnCommand));

        // Crear una opción que navegue al submenú
        MenuOption subMenuOption = new SimpleMenuOption("Ir al submenú", new MenuCommand(subMenu::display));
        MenuOption exitOption = new SimpleMenuOption("Salir", exitCommand);

        // Crear el menú principal y añadir las opciones
        ConsoleMenu menu = new ConsoleMenu("Menú Principal", new MenuInputHandler(new SimpleInputValidator()));
        menu.addOption(subMenuOption);
        menu.addOption(exitOption);

        // Mostrar el menú principal
        menu.display();
    }
}
```