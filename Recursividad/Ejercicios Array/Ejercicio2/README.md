# _Ejercicio 02 / Exercise 02_

En este ejercicio se pide encontrar las veces que se repite el numero 0 en un Array ya quemado utilizando los metodos de recursividad. La idea es poder recorrer el Array de derecha 
a izquierda y viceversa contanto las veces que se repite el 0.
>In this exercise you are asked to find the number of times the number 0 is repeated in an already burned Array using recursion methods. The idea is to be able to traverse the Array on the right
to the left and vice versa counting the number of times the 0 is repeated.
<br>
</br>

## _Problematica: / Problematic:_
Contar la cantidad de ceros que se encuentran dentro de un arreglo unidimensional de enteros. Parámetros: int arreglo[], int n.
>Count the number of zeros found within a one-dimensional array of integers. Parameters: int array[], int n.


> [!NOTE]
> En este ejercicio de igual forma se puede buscar cualquier numero deseado, solo es cambiar los parametros de busqueda quemados del numero "0" por el numero seleccionado.
> >In this exercise you can also search for any desired number, just change the search parameters burned from the number "0" to the selected number.
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

