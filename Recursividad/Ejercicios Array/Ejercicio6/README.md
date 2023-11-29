# _Ejercicio 6_

En este ejercicio se pide recorrer un array de forma bidireccional
utilizando los metodos recursivos.

## _Problematica_
Recorrer un array de forma recursiva

## _Tool_
- Java 17
- Maven
- IDE Intellij

___________

# _Class_

## _MainApp_

```java

    package MrZLeviatan;

public class App06 {

    public static void main(String[] args) {

        System.out.println(" --EJERCICIO 6-- ");

        int [] array= { 1,2,3,4,5,6};
        mostrarArreglo(array,0);

        System.out.println("Y de forma invertida: ");
        mostrarArregloInvertido(array,array.length-1);
        
    }

    public static void mostrarArreglo (int [] arreglo, int posicion){

        if (posicion != arreglo.length){
            System.out.println (arreglo[posicion]);
            mostrarArreglo(arreglo,posicion+1);
        }

    }

    public static void mostrarArregloInvertido (int [] arreglo, int posicion){
        if (posicion >= 0){
            System.out.println(arreglo[posicion]);
            mostrarArregloInvertido(arreglo,posicion-1);
        }

    }
}