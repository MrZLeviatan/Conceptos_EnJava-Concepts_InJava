package MrZLeviatan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppFibonacci {


    /**
     * MAKES THE CLASS EXECUTABLE.
     */
    public static void main(String[] args) {
        System.out.println(" --Exercise Fibonacci-- ");
        int numero = hallarNumero();
        System.out.println("\n" + "Result: ");
        demostrar(numero,0);
    }

    /**
     * RECURSIVE METHOD TO FIND THE NUMBERS BELONGING TO FIBONACCI.
     */
    public static int fibonacci (int numero){
        if ((numero == 0) || (numero==1))
            return numero;
        else
            return fibonacci(numero-1) + fibonacci(numero-2);
    }

    /**
     * RECURSIVE METHOD TO PROVE THE RESULT.
     */
    public static void demostrar (int numero, int i){
        if (fibonacci(i) <= numero){
            System.out.print(fibonacci(i)+" ");
            demostrar(numero, i + 1);
        }
    }

    /**
     * RECURSIVE METHOD TO SCAN THE NUMEROUS BY CONSOLE.
     */
    public static int hallarNumero (){
        Scanner sc = new Scanner(System.in);
        System.out.print("\n" + "Enter the number: ");
        int numero;
        try {
            numero = sc.nextInt();
            return numero;

        }catch (InputMismatchException e){
            System.out.println("Error: Must be an integer");
            return hallarNumero();
        }
    }
}