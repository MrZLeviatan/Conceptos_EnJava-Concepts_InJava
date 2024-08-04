
package MrZLeviatan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App12 {


    /**
     * CONVERT THE CLASS INTO AN EXECUTABLE. IT IS CALLED THE METHOD solicitarNumero.
     */
    public static void main(String[] args) {

        System.out.println(" --Exercise 12-- ");

        int base = solicitarNumero("Enter the base: ");
        int potencia = solicitarNumero("Enter the power: ");

        System.out.printf(" The number %d powered by %d is: "
                + calcular(base,potencia),base,potencia);

        }


    /**
     * METHOD TO CALCULATE THE BASE AND POWER.
     */
    public static int calcular(int base, int potencia) {
        // Base case: any number to the power of 0 is 1.
        if (potencia == 0) return 1;
        // Base case: 0 raised to any positive power is 0.
        if (base == 0) return 0;
        // Recursive step.
        return base * calcular(base, potencia - 1);
    }


    /**
     * METHOD TO REQUEST NUMBERS FROM THE SCANNER.
     */
    public static int solicitarNumero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.println(mensaje);
            try {
                numero = sc.nextInt();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Error: The typed value must be an integer");
                sc.next();             // Clear the scanner buffer to avoid an infinite loop.
                return solicitarNumero(mensaje);   // Recursive Call.
            }
    }
}