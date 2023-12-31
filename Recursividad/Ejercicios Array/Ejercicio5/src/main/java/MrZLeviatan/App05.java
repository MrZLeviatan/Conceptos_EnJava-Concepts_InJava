import java.util.InputMismatchException;
import java.util.Scanner;

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
