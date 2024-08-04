<h1 align="center" > Fibonacci </h1>

In this exercise, you are asked to calculate the Fibonacci sequence up to the limit number entered by console, 
using recursive methods.
> En este ejercicio, se solicita calcular la secuencia de Fibonacci hasta el número límite ingresado por 
consola, utilizando métodos recursivos.

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

## _AppFibonacci_
The class contains static methods to calculate Fibonacci numbers, print the sequence up to a number
given and request a number from the user.
>La clase contiene métodos estáticos para calcular números de Fibonacci, imprimir la secuencia hasta un número
dado y solicitar un número al usuario.

- <H3> Métodos / Methods: </H3>

    -  <H4> Main: </H4> 
        This method runs the program. Prompts the user for a number and then displays Fibonacci numbers that 
        do not exceed that number.

        >Este método ejecuta el programa. Solicita un número al usuario y luego muestra los números de 
        Fibonacci que no superan ese número.
       
    -  <H4> Fibonacci: </H4>
        Recursive method that calculates the Fibonacci number for the given position (number). If the number 
        is 0 or 1, it returns the same number (base case). For other cases, it returns the sum of the two 
        Fibonacci numbers above.

        > Método recursivo que calcula el número de Fibonacci para la posición dada (numero). Si el número es
       0 o 1, devuelve el mismo número (caso base). Para otros casos, devuelve la suma de los dos números de
       Fibonacci anteriores.
    
    -  <H4> Demostrar: </H4>
        Recursive method that prints Fibonacci numbers from position 0 until the calculated Fibonacci number
        is greater than the specified number value. I will be the current index for calculating the Fibonacci 
        number and is incremented with each recursive call.
    
        >Método recursivo que imprime los números de Fibonacci desde la posición 0 hasta que el número de
       Fibonacci calculado es mayor que el valor número especificado. I es el índice actual para calcular el
       número de Fibonacci y se incrementa con cada llamada recursiva.

    - <H4> HallarNumero: </H4>
        Prompts the user for a number and returns it. If the user does not enter an integer, displays a message
        error and requests the number again. Use exception handling to catch invalid input.
    
        >Solicita al usuario un número y lo devuelve. Si el usuario no ingresa un entero, muestra un mensaje
      de error y vuelve a solicitar el número. Usa manejo de excepciones para capturar entradas inválidas.
      
<br>

> [!IMPORTANT]
>  The use of <strong>Exceptions </strong> is denoted. See the [Exceptions](/../main/Exceptio) exercises.
>> Se denota el uso de <strong> Excepciones </strong>. Verse en la carpeta de [Excepciones](/../main/Exception).

<br>

```java

public class AppFibonacci {


     System.out.println(" --EJERCICIO Fibonacci-- ");
        int numero = hallarNumero();
        System.out.println("\n" + "Resultado: ");
        demostrar(numero,0);
     }

    public static int fibonacci (int numero){
        if ((numero == 0) || (numero==1))
            return numero;
        else
            return fibonacci(numero-1) + fibonacci(numero-2);

    }

    public static void demostrar (int numero, int i){

        if (fibonacci(i) <= numero){
            System.out.println(fibonacci(i)+"");
            demostrar(numero, i + 1);
        }

    }

    public static int hallarNumero (){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n" + "Introduce el numero: ");
        int numero;
        try {
            numero = sc.nextInt();
            return numero;

        }catch (InputMismatchException e){
            System.out.println("Error:" + " Debe ser un entero");
            return hallarNumero();
        }
    }
```