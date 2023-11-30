# _Ejercicio 05 / Exercise 05_

En este ejercicio se pide hallar la cantidad de veces que 
se repite un numero pedido por consola en un array quemando utilizando 
los metodos recursivos.
>In this exercise you are asked to find the number of times that
a number requested by console is repeated in an array burning using
recursive methods.
<br>
</br>

## _Problematica: / Problematic:_
Recorra el arreglo desde la primera posición hasta 
la última posición y retorne el número de veces que se 
repite el elemento.  Parámetros: vector[] (arreglo en el 
cual se encuentran los elementos), inicio (es el inicio del vector), fin (es el fin del vector), elem (es el número a buscar dentro del arreglo).
>Cycle through the arrangement from the first position to
the last position and return the number of times it was
repeat the element. Parameters: vector[] (array in the
which elements are found), start (it is the start of the vector), end (it is the end of the vector), elem (it is the number to search within the array).
<br>
</br>


## _Tool_
- Java 17
- Maven
- IDE Intellij

___________

# _Class_

### _MainApp_
> [!IMPORTANT]
> Se denota el uso de <strong> Excepciones </strong>. Verse en la carpeta de [Excepciones](/../main/Exception).
>>  The use of <strong>Exceptions </strong> is denoted. See the [Exceptions](/../main/Exceptio) exercises.


```java

public class App05 {

    public static void main(String[] args) {

        int[] array = {0, 1, 2, 3, 4, 5, 4, 0, 3, 3};

        int posicion = 0;

        int cantidadValor;

        String tipo = "avanzando";

        System.out.println(" --EJERCICIO 5-- ");

        int elem = valorObtenido();

        cantidadValor = mostrarCantidadAvanzando(array, posicion,elem);
            demostracion(cantidadValor,elem,tipo);


        posicion = array.length - 1;
        tipo = "retrocediendo";

        cantidadValor = mostrarCantidadRetrocediendo(array,posicion,elem);
            demostracion(cantidadValor,elem,tipo);

    }

    public static int mostrarCantidadAvanzando(int[] array, int posicion, int elem) {

        if (posicion >= array.length) {
            return 0;
        }else{

            if (array[posicion] == elem) {
                return 1 + mostrarCantidadAvanzando(array, posicion + 1,elem);
            } else {
                return 0 + mostrarCantidadAvanzando(array, posicion + 1,elem);
            }
        }

    }

    public static int mostrarCantidadRetrocediendo(int[] array, int posicion, int elem) {

        if (posicion < 0) {
            return 0;
        }else if (array[posicion] == elem) {
            return 1 + mostrarCantidadRetrocediendo(array, posicion - 1,elem);
        } else {
            return 0 + mostrarCantidadRetrocediendo(array, posicion - 1,elem);
        }
    }

    public static void demostracion (int cantidadCeros, int elem, String tipo){

        if(cantidadCeros != 0){
            System.out.printf("La cantidad de %d en el arreglo %s",elem, tipo +
                    "es de: " + cantidadCeros);
            System.out.println("");
        }else {
            System.out.printf(" No se encontro el numero %s",tipo);
            System.out.println("");
        }
    }

    public static int valorObtenido () {

        Scanner sc = new Scanner(System.in);
        System.out.println(" Digite un numero Por favor: ");
        int elem;

        try {
            elem = sc.nextInt();
            return elem;

        } catch (InputMismatchException e) {

            System.out.println("Error: " + "El valor tecleado debe ser un entero");
             return valorObtenido();
        }
    }
}
