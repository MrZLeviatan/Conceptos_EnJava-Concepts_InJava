<h1 align="center"> Ejercicio 04 / Exercise 04 </h1>

En este ejercicio se pide la suma de las cifras 
de un valor pedido por consola utilizando los
métodos de recursividad.
>In this exercise we ask for the sum of the figures
of a value requested by console using the
recursion methods.

___

## _Badges:_


- <H3> Backend:</H3>

    - [![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ](https://www.oracle.com/co/java/technologies/downloads/#java21)


- <H3>  IDEs/ Editors: </H3>

    - [![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/es-es/idea/) [![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org/)

___

<H1 align="center"> 

_Classes_

</H1>


# _App04_
Este código en Java es una simple aplicación que suma las cifras de un número entero proporcionado por el usuario.
>This Java code is a simple application that adds the digits of an integer provided by the user.

- <H3> Métodos / Methods: </H3>
    
    -  <H4> Main: </H4> 
    El método main es el punto de entrada del programa. Primero, imprime un mensaje para indicar que se está 
    iniciando el ejercicio 4 y luego llama al método obtenerDatos() para comenzar el proceso de obtener el número 
    del usuario y calcular la suma de sus cifras.
    >The main method is the entry point of the program. First, it prints a message to indicate that it is
  starting exercise 4 and then calling the obtenerDatos() method to begin the process of obtaining the number
  of the user and calculate the sum of their figures.

    -  <H4> SumasCifras: </H4>
     Este es un método recursivo diseñado para sumar las cifras de un número entero n.

    - Si n es menor que 10 (es decir, tiene una sola cifra), simplemente devuelve n, ya que no hay más cifras que sumar.
    - Si n es 10 o mayor, divide n entre 10 y toma el residuo (n % 10, que es la última cifra del número) y 
    lo suma al resultado de llamar recursivamente al mismo método con n / 10 (el número n sin la última cifra). 
    Este proceso se repite hasta que n es menor que 10.
    > This is a recursive method designed to add the digits of an integer n.
    > - If n is less than 10 (that is, it has a single digit), it simply returns n, since there are no more digits to add.
    > - If n is 10 or greater, divide n by 10 and take the remainder (n % 10, which is the last digit of the number) and
    adds it to the result of recursively calling the same method with n / 10 (the number n without the last figure).
    This process is repeated until n is less than 10.

    -  <H4> ObtenerDatos: </H4>
    Este método gestiona la interacción con el usuario. 
      
    - Si el valor ingresado es un entero válido, llama
      al método sumarDigitos(número) con el número ingresado y luego imprime la cantidad de dígitos del
      número.
    - Si el valor ingresado no es un entero captura la excepción e imprime un mensaje de error. Luego,
          hace una llamada recursiva a sí mismo para permitir al usuario intentarlo nuevamente.

      > This method handles the interaction with the user.
      > - If the entered value is a valid integer, call
          to the sumarDigitos(number) method with the entered number and then prints the number of digits of the
          number.
      > - If the value entered is not an integer, catch the exception and print an error message. Then,
        makes a recursive call to itself to allow the user to try again.

<br>

> [!IMPORTANT]
> Se denota el uso de <strong> Excepciones </strong>. Verse en la carpeta de [Excepciones](/../main/Exception).
>>  The use of <strong>Exceptions </strong> is denoted. See the [Exceptions](/../main/Exceptio) exercises.

<br>

```java

public class App04 {

        public static void main(String[] args) {

        System.out.println(" --EJERCICIO 4-- ");
            obtenerDatos();

        }

        public static int sumaCifras (int n){
            if(n<10){
                return n;
            }else {
                return (n % 10) + sumaCifras(n /10);
            }
        }

        public static void obtenerDatos(){
            Scanner sc = new Scanner(System.in);
            int numero;
            System.out.println("Digite el numero por favor: ");

                try {
                    numero = sc.nextInt();
                    int sumaDIgitos = sumaCifras(numero);
                    System.out.println("La suma de los digitos en el anterior ejemplo es: " + sumaDIgitos);

                }catch (InputMismatchException ex){
                    System.out.println("!! Debe ser obligatoriamente un entero !!");
                    sc.next();

                }
        }
}
