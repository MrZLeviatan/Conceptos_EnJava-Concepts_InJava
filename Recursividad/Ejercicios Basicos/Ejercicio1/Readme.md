<h1 align="center"> Ejercicio 01 / Exercise 01  </h1> 

In this exercise, you are asked to count the digits of a number entered through the console using recursive methods.
>En este ejercicio, se solicita contar las cifras de un número ingresado por consola utilizando métodos recursivos.

---

## _Badges:_


- <H3> Backend:</H3>

    - [![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ](https://www.oracle.com/co/java/technologies/downloads/#java21)


- <H3>  IDEs/ Editors: </H3>

    - [![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/es-es/idea/) [![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org/)

___

<H1 align="center"> 

_Classes_

</H1>

## _App_
This Java code performs a simple exercise to count the number of digits of a user-supplied integer.
> Este código en Java realiza un ejercicio simple para contar la cantidad de dígitos de un número entero proporcionado por el usuario.

- <H3>  Variables: </H3>
    The App class contains the program entry point (main) and two additional static methods: contarDigitos(int number) and obtenerDatos().
  
    > La clase App contiene el punto de entrada del programa (main) y dos métodos estáticos adicionales: contarDigitos(int numero) y obtenerDatos().
  
  - <H3> Métodos / Methods: </H3>

      -  <H4> Main: </H4>           
          Here a message indicative of the exercise to be performed is simply printed and the obtenerDatos() method is called to initiate the interaction with the user.

         >  Aquí simplemente se imprime un mensaje indicativo del ejercicio que se va a realizar y se llama al método obtenerDatos() para iniciar la interacción con el usuario.
         
      -  <H4> ContarDigitos: </H4>
            This is a recursive method designed to count the number of digits of an integer. The logic is the following:
             
            - If the number is less than 10, it means that it only has 1 digit, so it returns 1.
            - If the number is 10 or greater, divide the number by 10 (removing the last digit) and call
            itself passing this new number as an argument, adding 1 to the result. This operation is
            repeats until the number is less than 10, at which point it enters the base condition, and
            It starts returning through recursive calls, accumulating the number of digits.

         > Este es un método recursivo diseñado para contar la cantidad de dígitos de un número entero.  La lógica es la siguiente:
         >  - Si el número es menor que 10, significa que solo tiene 1 dígito, por lo que retorna 1.
         >  - Si el número es 10 o mayor, divide el número por 10 (eliminando el último dígito) y llama a
          sí mismo pasando este nuevo número como argumento, sumando 1 al resultado. Esta operación se
          repite hasta que el número sea menor que 10, momento en el cual entra en la condición base y
          comienza a retornar a través de las llamadas recursivas, acumulando la cantidad de dígitos.

      -  <H4> ObtenerDatos: </H4>
         This method handles the interaction with the user.
       
          - If the entered value is a valid integer, call
           to the countDigits(number) method with the entered number and then prints the number of digits of the
           number.
         - If the value entered is not an integer, catch the exception and print an error message. Then,
           makes a recursive call to itself to allow the user to try again.
        
         > Este método maneja la interacción con el usuario.  
         > - Si el valor ingresado es un entero válido, llama 
          al método contarDigitos(número) con el número ingresado y luego imprime la cantidad de dígitos del 
          número.
         > - Si el valor ingresado no es un entero captura la excepción e imprime un mensaje de error. Luego, 
         hace una llamada recursiva a sí mismo para permitir al usuario intentarlo nuevamente.

<br>

> [!IMPORTANT]
>  The use of <strong>Exceptions </strong> is denoted. See the [Exceptions](/../main/Exceptio) exercises.
>> Se denota el uso de <strong> Excepciones </strong>. Verse en la carpeta de [Excepciones](/../main/Exception).

<br>

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
```