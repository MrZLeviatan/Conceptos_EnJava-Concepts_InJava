<h1 align="center"> Ejercicio 03 / Exercise 03  </h1> 

This exercise requires finding the smallest number in a predefined array, traversing it in both directions
(from start to end and from end to start) using recursive methods.
>En este ejercicio se requiere encontrar el número menor en un arreglo predefinido, recorriéndolo en ambos sentidos
(de inicio a fin y de fin a inicio) utilizando métodos recursivos.

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

## _App03_

The class implements a program that loops through an array from start to finish. The stopping criterion is set 
when the start and end indices match.
>La clase implementa un programa que recorre un arreglo desde el inicio hasta el final. El criterio de detención se 
establece cuando los índices de inicio y fin coinciden.

- <H3> Métodos / Methods: </H3>

    -  <H4> Main: </H4>
        This method runs the program. Defines an array of integers array with some elements. Call the 
        mostrarCantidadAvanzando and mostrarCantidadRetrocediendo methods to count zeros in the array, 
        both moving forward and backward, and call the show method to display the results.

       >Este método ejecuta el programa. Define un arreglo de enteros array con algunos elementos. Llama a
       los métodos mostrarCantidadAvanzando y mostrarCantidadRetrocediendo para contar los ceros en el arreglo,
       tanto avanzando como retrocediendo, y llama al método demostracion para mostrar los resultados.

    -  <H4> MostrarCantidadAvanzando / ShowQuantityAdvancing: </H4> 
       This method recursively counts the number of zeros in the array starting from position and moving to 
        the end of the array. 

        - If the element at the current position is 0, increment the zero counter and recursively call the same
          method with the next position.
        - If the element is not 0, just recursively call the same method with the next position.

       > Este método cuenta recursivamente la cantidad de ceros en el arreglo comenzando desde la posición
       y avanzando hasta el final del arreglo.
       > - Si el elemento en la posición actual es 0, incrementa el contador de ceros y llama recursivamente al
           mismo método con la siguiente posición.
       > - Si el elemento no es 0, solo llama recursivamente al mismo método con la siguiente posición.

    - <H4> MostrarCantidadRetrocediendo / ShowQuantityGoingBack </H4>

      This method recursively counts the number of zeros in the array starting from the position and going
      back to the start of the array.
        - If the element at the current position is 0, increment the zero counter and recursively call the same
          method with the previous position.
        - If the element is not 0, just recursively call the same method with the previous position.

      >  Este método cuenta recursivamente la cantidad de ceros en el arreglo comenzando desde la posición
      y retrocediendo hasta el inicio del arreglo.
      >  - Si el elemento en la posición actual es 0, incrementa el contador de ceros y llama recursivamente al
           mismo método con la posición anterior.
      >  - Si el elemento no es 0, solo llama recursivamente al mismo método con la posición anterior.

      
```java

public class App03 {

    public static void main(String[] args) {

        int[] array = {9, 1, 2, 6, 0, 5, 0, 9};

        int posicion = 0;

        int fin = array.length - 1;

        int numeroMenor, posicionMenor;

        String tipo = "De izquierda a derecha";


        System.out.println(" --EJERCICIO 3-- ");

        numeroMenor = hallarNumeroMenorDerecha(array, posicion, fin);
        posicionMenor = hallarPosicionDerecha(array, posicion, numeroMenor);

            demostracion(numeroMenor,posicionMenor,tipo);


        posicion = array.length - 1;
        fin = 0;
        tipo= "De derecha a izquierda";

        numeroMenor = hallarNumeroMenorIzquierda(array, posicion, fin);
        posicionMenor = hallarPosicionIzquierda( array,posicion,numeroMenor);

            demostracion(numeroMenor,posicionMenor,tipo);
    }
    
    
    public static int hallarNumeroMenorDerecha(int[] array, int posicion, int fin) {

        if (posicion == fin) {
            return array[posicion];
        } else {

            int menor = hallarNumeroMenorDerecha(array, posicion + 1, fin);


            if (menor < array[posicion]) {
                return menor;
            } else {
                return array[posicion];
            }
        }
    }

    public static int hallarNumeroMenorIzquierda(int[] array, int posicion, int fin) {

        if (posicion == fin) {
            return array[posicion];
        } else {
            int menor = hallarNumeroMenorIzquierda(array, posicion - 1, fin);


            if (menor < array[posicion]) {
                return menor;
            } else {
                return array[posicion];
            }
        }
    }

    public static int hallarPosicionDerecha(int[] array, int posicion, int posicionMenor) {

        if (array[posicion] == posicionMenor) {
            return posicion;
        } else {
            return hallarPosicionDerecha(array, posicion + 1, posicionMenor);
        }
    }

    public static int hallarPosicionIzquierda(int[] array, int posicion, int posicionMenor) {
        if (array[posicion] == posicionMenor) {
            return posicion;
        } else {
            return hallarPosicionIzquierda(array, posicion - 1, posicionMenor);
        }
    }

    public static void demostracion(int numeroMenor, int posicionMenor, String tipo) {


        System.out.printf("El numero menor %s es: " + numeroMenor +
                " En la posicion: " + posicionMenor, tipo);
        System.out.println("");

    }
}
