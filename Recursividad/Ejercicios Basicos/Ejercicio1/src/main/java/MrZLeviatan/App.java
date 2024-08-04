package MrZLeviatan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    /*
        BASE CASE:
        -WHEN THE NUMBER IS LESS THAN 10, THE ANSWER IS 1 DIGITAL.

        RECURSIVE CASE:
        -DIVIDE THE NUMBER BY 10 -COUNT +1 DIGIT OH IN THE SUM.
        -CALL THE RECURSIVE, WITH THE NEW VALUE.
  */
    public static int contarDigitos ( int numero){
        int res;
        if (numero < 10) {
            res = 1;

        } else {
            numero = numero / 10;
            res = 1 + contarDigitos(numero);
        }
        return res;
    }


    /**
     * METHOD WHICH OBTAINS THE REQUIRED DATA THROUGH THE CONSOLE.
     */
    public static void obtenerDatos () {

        Scanner sc = new Scanner(System.in);
        int numero;

        System.out.println(" Enter a number Please: ");

            try {
                numero = sc.nextInt();
                int sumaDigitos = contarDigitos(numero);
                System.out.println("The number of digits in the previous example is: " + sumaDigitos);

            } catch (InputMismatchException e) {
                    System.out.println("Error: The typed value must be an integer");
                    obtenerDatos();
            }
    }


    public static void main(String[] args) {
        System.out.println(" --Exercise 1-- ");
        obtenerDatos();
    }
}



