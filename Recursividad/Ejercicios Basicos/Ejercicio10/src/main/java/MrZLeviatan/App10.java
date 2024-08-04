package MrZLeviatan;

import java.util.Scanner;

public class App10 {


    /**
     * THE CLASS BECOMES EXECUTABLE.
     */
    public static void main(String[] args) {

        System.out.println(" --Exercisesssssssss 10-- ");

        Scanner sc = new Scanner(System.in); // Call the keyboard scanner.
        String palabra;
        int longitud;
        System.out.println(" Please type a word: ");

        palabra = sc.nextLine();
        longitud = palabra.length()-1;
        System.out.println("The inverted word is: " + invertirPalabra(palabra,longitud));

    }

    /**
     * RECURSIVE METHOD TO INVERT THE WORD REQUESTED BY THE SCANNER.
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