package MrZLeviatan;

public class App02 {

    public static void main(String[] args) {

        // Initialize the array with values.
        int[] array = {0,1,2,3,4,5,4,0};

        // Variables for position and type of counting.
        int posicion = 0;
        int cantidadCeros;
        String tipo = "avanzando";

        // Print the exercise header.
        System.out.println(" --EJERCICIO 2-- ");

        // Count zeros advancing in the array and display the result.
        cantidadCeros = mostrarCantidadAvanzando(array, posicion);
        demostracion(cantidadCeros,tipo);

        // Change position to the end of the array and type to "retreating".
        posicion = array.length - 1;
        tipo = "retrocediendo";

        // Count zeros retreating in the array and display the result.
        cantidadCeros = mostrarCantidadRetrocediendo(array,posicion);
        demostracion(cantidadCeros,tipo);
    }


    // Method to count zeros advancing in the array
    public static int mostrarCantidadAvanzando(int[] array, int posicion) {
        if (posicion >= array.length) {
            return 0; // Base case: if position is outside the array, return 0.
        }
        // Increment count if the value is 0, and call recursively with the next position.
        return (array[posicion] == 0 ? 1 : 0) + mostrarCantidadAvanzando(array, posicion + 1);
    }


    // Method to count zeros retreating in the array
    public static int mostrarCantidadRetrocediendo(int[] array, int posicion) {
        if (posicion < 0) {
            return 0; // Base case: if position is outside the array, return 0
        }else if (array[posicion] == 0) {
            return 1 + mostrarCantidadRetrocediendo(array, posicion - 1);
        }
        // Increment count if the value is 0, and call recursively with the previous position
        return (array[posicion] == 0 ? 1 : 0) + mostrarCantidadRetrocediendo(array, posicion - 1);
    }


    // Method to display the result of counting zeros
    public static void demostracion (int cantidadCeros, String tipo){
        if(cantidadCeros != 0){
            System.out.printf("La cantidad de ceros en el arreglo %s " + "es de :" + cantidadCeros,tipo);
        }else {
            System.out.println(" No se encontraron ceros en el arreglo");
        }
    }

}


