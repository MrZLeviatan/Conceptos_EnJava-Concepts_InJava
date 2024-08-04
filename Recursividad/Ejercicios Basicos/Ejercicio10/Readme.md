<h1 align="center">  Ejercicio 10 / Exercise 10  </h1>  

In this exercise, you are asked to reverse a word entered through the console using recursive methods.
>En este ejercicio, se solicita invertir una palabra ingresada por consola utilizando métodos recursivos.

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

## _App10_
This Java code is a simple application that reverses a word entered by the user and displays the result.
>Este código en Java es una simple aplicación que invierte una palabra ingresada por el usuario y muestra el resultado.


- <H3> Métodos / Methods: </H3>

    -  <H4> Main: </H4>
         The main method is the entry point of the program. First, calculate the length of the word
         entered and adjusts this value to use it as an index (that is why 1 is subtracted, since the indices in
         Java start at 0). Calls the InvertirPalabra method, passing the entered word and its length
         set as arguments, and then prints the result of this method.
    
       > El método main es el punto de entrada del programa. Primero, calcula la longitud de la palabra
       ingresada y ajusta este valor para usarlo como índice (por eso se resta 1, ya que los índices en
       Java comienzan en 0). Llama al método invertirPalabra, pasando la palabra ingresada y su longitud
       ajustada como argumentos, y luego imprime el resultado de este método.

  -  <H4> InvertirPalabra: </H4> 
        This method reverses the entered word using recursion.
        
        - Base case: If length is 0, it means that the method has reached the first letter of the
             original word (remember that it started from the end of the word). In this case, simply
             returns the first character of the word followed by a space.
     
        - Recursive step: If length is not 0, the method takes the character at the length position of the
           word, appends it to a space and then makes a recursive call to itself, but this time with
           length-1 to move to the next character towards the beginning of the word. This process is
           Repeat until the base case is reached.
  
        >Este método invierte la palabra ingresada utilizando la recursividad.
        > - Caso base: Si longitud es 0, significa que el método ha llegado a la primera letra de la
        palabra original (recuerda que comenzó desde el final de la palabra). En este caso, simplemente
        devuelve el primer carácter de la palabra seguido de un espacio.
        > - Paso recursivo: Si longitud no es 0, el método toma el carácter en la posición longitud de la
        palabra, lo añade a un espacio y luego hace una llamada recursiva a sí mismo, pero esta vez con
        longitud-1 para moverse al siguiente carácter hacia el inicio de la palabra. Este proceso se
        repite hasta que se alcanza el caso base.


```java

public class App10 {

    public static void main(String[] args) {

        System.out.println(" --EJERCICIO 10-- ");

        Scanner sc = new Scanner(System.in);
        String palabra;
        int longitud;
        System.out.println("");
        System.out.println(" Digite una palabra por favor: ");

        palabra = sc.nextLine();
        longitud = palabra.length()-1;
        System.out.println("La palabra invertida es: " + invertirPalabra(palabra,longitud));

    }

    public static String invertirPalabra (String palabra, int longitud){

        if (longitud == 0){
            return palabra.charAt(longitud) + " ";
        }
        else{
            return palabra.charAt(longitud) + " " + invertirPalabra(palabra,longitud-1);
        }
    }
}
```
