<h1 align="center"> Ejercicio 02 / Exercise 02 </h1>

In this exercise you are asked to find the number of times the number 0 is repeated in an already burned 
Array using recursion methods. The idea is to be able to traverse the Array on the right to the left and vice 
versa counting the number of times the 0 is repeated.
>En este ejercicio se pide encontrar las veces que se repite el numero 0 en un Array ya quemado utilizando los
metodos de recursividad. La idea es poder recorrer el Array de derecha a izquierda y viceversa contanto las
veces que se repite el 0.


> [!NOTE]
> In this exercise, you can search for any desired number. It is only necessary to change the search parameter "0" to the desired number.
> >En este ejercicio, se puede buscar cualquier número deseado. Solo es necesario cambiar el parámetro de búsqueda "0" por el número que se desee.

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

## _App02_
The class implements a program that counts the number of zeros in an array of integers. 
The program traverses the array in two directions: first, it moves forward from the beginning to the end, 
and then it moves backwards from the end to the beginning. Finally, print the results obtained in both directions.
>La clase implementa un programa que cuenta la cantidad de ceros en un arreglo de enteros. 
El programa recorre el arreglo en dos direcciones: primero, avanza desde el inicio hasta el final y luego, 
retrocede desde el final hacia el inicio. Finalmente, imprime los resultados obtenidos en ambas direcciones.

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

public class App02 {

    public static void main(String[] args) {

        int[] array = {0, 1, 2, 3, 4,5,4,0};

        int posicion = 0;

        int cantidadCeros;
        
        String tipo = "avanzando";
        
        System.out.println(" --EJERCICIO 2-- ");
        

        cantidadCeros = mostrarCantidadAvanzando(array, posicion);
            demostracion(cantidadCeros,tipo);


        posicion = array.length - 1;
        tipo = "retrocediendo";

        cantidadCeros = mostrarCantidadRetrocediendo(array,posicion);
            demostracion(cantidadCeros,tipo);
            
    }


    public static int mostrarCantidadAvanzando(int[] array, int posicion) {

        if (posicion >= array.length) {
            return 0;
        }else{

            if (array[posicion] == 0) {
                return 1 + mostrarCantidadAvanzando(array, posicion + 1);
            } else {
                return 0 + mostrarCantidadAvanzando(array, posicion + 1);
            }
        }

    }


    public static int mostrarCantidadRetrocediendo(int[] array, int posicion) {

        if (posicion < 0) {
            return 0;
        }else if (array[posicion] == 0) {
                return 1 + mostrarCantidadRetrocediendo(array, posicion - 1);
            } else {
                return 0 + mostrarCantidadRetrocediendo(array, posicion - 1);
            }
        }

    public static void demostracion (int cantidadCeros, String tipo){

        if(cantidadCeros != 0){
            System.out.printf("La cantidad de ceros en el arreglo %s " +
                    "es de :" + cantidadCeros,tipo);
            System.out.println("");
        }else {
            System.out.println(" No se encontraron ceros en el arreglo");
        }
    }
}

