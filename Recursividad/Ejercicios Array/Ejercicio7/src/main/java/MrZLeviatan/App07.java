package MrZLeviatan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App07 {

    public static void main(String[] args) {

        String[] array = {"nicolas", "juan", "carlos","nicolas"};

        int cantidad;

        String tipo = "Avanzando";

        System.out.println(" --EJERCICIO 7-- ");

        String elem = obtenerTipo();

        cantidad = mostrarCantidadAvanzando(array,0,elem);
            demostracion(cantidad,elem,tipo);


        tipo = "Retrocediendo";
        cantidad = mostrarCantidadRetroceciendo(array,array.length-1,elem);
            demostracion(cantidad,elem,tipo);

    }

    public static String obtenerTipo() {

        Scanner sc = new Scanner(System.in);
        String nombre;
        System.out.println(" Digite un elemento por favor: ");
        nombre = sc.next();
        return nombre;
    }

    public static int mostrarCantidadAvanzando(String[] array, int posicion, String nombre) {

        if (posicion >= array.length) {
            return 0;
        }else{

            if (array[posicion].equals(nombre)) {
                return 1 + mostrarCantidadAvanzando(array, posicion + 1,nombre);
            } else {
                return 0 + mostrarCantidadAvanzando(array, posicion + 1,nombre);
            }
        }

    }

    public static int mostrarCantidadRetroceciendo (String [] array, int posicion, String nombre){

        if (posicion < 0){
            return 0;
        }else{

            if (array[posicion].equals(nombre)){
                return 1 + mostrarCantidadRetroceciendo(array,posicion-1,nombre);
            }else{
                return mostrarCantidadRetroceciendo(array,posicion-1,nombre);
            }
        }
    }

    public static void demostracion (int cantidad,String elem, String tipo){

        if(cantidad != 0){
            System.out.printf("La cantidad de %s en el arreglo %s ",elem,tipo +
                    "es de :" + cantidad);
            System.out.println("");
        }else {
            System.out.printf(" No se encontro el elemento %s en el arreglo",elem);
        }
    }






}