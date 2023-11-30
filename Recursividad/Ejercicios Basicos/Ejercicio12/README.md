
# _Ejercicio 12 / Exercise 12_

En este ejercicio se pide la potencia de una bases y un potenciados pedidos por consola utilizando los metodos de recursividad.
>In this exercise, the power of a base and a boosted request are requested by console using recursion methods.

## _Problematica: / Problematic:_

Programar un algoritmo recursivo que permita calcular y retornar cualquier potencia para cualquier número. Por ejemplo base 2 potencia 3.
>Program a recursive algorithm that allows you to calculate and return any power for any number. For example base 2 power 3.

## _Tool_

- Java 17
- Maven
- IDE Intellij

_______

# _Class_

### _MainApp_
Inicia la aplicacion pidiendo dos valores.
>Start the application requesting two values.
<br>
</br>

> [!IMPORTANT]
> Se denota el uso de <strong> Excepciones </strong>. Verse en la carpeta de [Excepciones](/../main/Exception).
>>  The use of <strong>Exceptions </strong> is denoted. See the [Exceptions](/../main/Exceptio) exercises.
```java

public class App12 {

    public static void main(String[] args) {


        System.out.println(" --EJERCICIO 12-- ");

        int base = obtenerBase();
        int potencia = obtenerPotencia();

        System.out.printf(" El numero %d potenciado en %d es: "
                + calcular(base,potencia),base,potencia);

        }

    public static int calcular (int base, int potencia){
        int total;
        if (base == 0){
            if (potencia ==0) {
                total = 1;
            }else {
                total = 0;
            }
        }else{

            if (potencia == 0){
                total= 1;
            }else{

                if( potencia != 1){
                    total= base* calcular(base,potencia-1);
                }else{
                    total =base;
                }
            }
        }
        return total;
    }

    public static int obtenerBase () {

        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.println(" Digite un numero Por favor: ");

        try {
            numero = sc.nextInt();
            return numero;

        } catch (InputMismatchException e) {
            System.out.println("Error: " + "El valor tecleado debe ser un entero");
            return obtenerBase();
        }
    }

    public static int obtenerPotencia () {

        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.println(" Digite la potencia: ");

        try {
            numero = sc.nextInt();
            return numero;

        } catch (InputMismatchException e) {
            System.out.println("Error: " + "El valor tecleado debe ser un entero");
            return obtenerPotencia();
        }
    }
}
```
