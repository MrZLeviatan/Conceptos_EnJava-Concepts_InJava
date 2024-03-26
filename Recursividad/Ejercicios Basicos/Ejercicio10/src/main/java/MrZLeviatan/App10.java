package MrZLeviatan;

import java.util.Scanner;

public class App10 {


    /**
     * SE VUELVE EJECUTABLE LA CLASE.
     */
    public static void main(String[] args) {

        System.out.println(" --EJERCICIO 10-- ");

        Scanner sc = new Scanner(System.in);            // Llama al escáner del teclado.
        String palabra;
        int longitud;
        System.out.println("");
        System.out.println(" Digite una palabra por favor: ");

        palabra = sc.nextLine();
        longitud = palabra.length()-1;
        System.out.println("La palabra invertida es: " + invertirPalabra(palabra,longitud));

    }

    /**
     * MÉTODO RECURSIVO PARA INVERTIR LA PALABRA PEDIDA POR EL ESCÁNER.
     */
    public static String invertirPalabra (String palabra, int longitud){

        if (longitud == 0){
            return palabra.charAt(longitud) + " ";
        }
        else{
            return palabra.charAt(longitud) + " " + invertirPalabra(palabra,longitud-1);
        }
    }
}