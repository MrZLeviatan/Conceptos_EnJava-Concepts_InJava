package MrZLeviatan;

import java.util.Scanner;

public class App10 {

    public static void main(String[] args) {

        System.out.println(" --EJERCICIO 10-- ");

        Scanner sc = new Scanner(System.in);
        String palabra;
        int longitud;
        System.out.println("");
        System.out.println(" Digite una palabra por favor: ");

        palabra = sc.nextLine();
        longitud = palabra.length()-1;
        System.out.println("La palabra invertida es: " + invertirPalabra(palabra,longitud));

    }

    public static String invertirPalabra (String palabra, int longitud){

        if (longitud == 0){
            return palabra.charAt(longitud) + " ";
        }
        else{
            return palabra.charAt(longitud) + " " + invertirPalabra(palabra,longitud-1);
        }
    }
}