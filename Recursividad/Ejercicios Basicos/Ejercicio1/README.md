# _Ejercicio 01 / Exercise 01_

En este ejercicio se pide contar las cifras de un valor pedido por consola utilizando los metodos de recursividad.
>In this exercise you are asked to count the figures of a value requested by console using recursion methods.

<br>
</br>


## _Problematica: / Problematic:_
Hallar la cantidad de cifras de un número entero usando la recursividad. Parámetro: n (número entero)
>Find the number of digits of an integer using recursion. Parameter: n (integer)

> [!IMPORTANT]
> Se denota el uso de <strong> Excepciones </strong>. Verse en la carpeta de [Excepciones](/../main/Exception).
>>  The use of <strong>Exceptions </strong> is denoted. See the [Exceptions](/../main/Exceptio) exercises.

<br>
</br>


## _Tool_

 - Java 17
 - Maven
 - IDE Intellij

_______

# _Class_

### _MainApp_
Inicia la aplicacion pidiendo un valor 
>Start the application asking for a value

```java
public Class App {

    public static void main(String[] args) {

        System.out.println(" --EJERCICIO 1-- ");
        obtenerDatos();

    }
    public static int contarDigitos ( int numero){
        int res;
        if (numero < 10) {
            res = 1;

        } else {
            numero = numero / 10;
            res = 1 + contarDigitos(numero);
        }
        return res;
    }

    public static void obtenerDatos () {

        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.println(" Digite un numero Por favor: ");

            try {
                numero = sc.nextInt();
                int sumaDigitos = contarDigitos(numero);
                System.out.println("La cantidad de digitos en el anterior ejemplo es: " + sumaDigitos);

            } catch (InputMismatchException e) {
                System.out.println("Error: " + "El valor tecleado debe ser un entero");
                obtenerDatos();

            }
    }

}
