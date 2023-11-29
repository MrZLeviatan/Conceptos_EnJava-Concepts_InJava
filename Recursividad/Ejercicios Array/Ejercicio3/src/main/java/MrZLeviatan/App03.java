package MrZLeviatan;

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