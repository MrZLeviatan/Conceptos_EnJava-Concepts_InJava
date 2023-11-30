# _Ejercicio 03 / Exercise 03_

En este ejercicio se pide encontrar el 
numero menor del arreglo ya quemado en ambos 
sentidos del mismo utilizando recursividad.
>In this exercise you are asked to find the
smallest number of the arrangement already burned in both
meanings of it using recursion.
<br>
</br>

## _Problematica: / Problematic:_
El recorrido del arreglo se realiza de inicio a fin. El criterio de parada es cuando inicio y fin son iguales.
Parámetros: vector[] (es el arreglo en el cual se encuentran los elementos), inicio (Es el inicio del arreglo), fin (Es el fin del arreglo y su valor es el tamaño del arreglo - 1).
>The arrangement tour is carried out from start to finish. The stopping criterion is when start and end are equal.
Parameters: vector[] (it is the array in which the elements are found), start (It is the beginning of the array), end (It is the end of the array and its value is the size of the array - 1).
<br>
</br>

## _Tool_
- Java 17
- Maven
- IDE Intellij

___________

# _Class_

### _MainApp_

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
