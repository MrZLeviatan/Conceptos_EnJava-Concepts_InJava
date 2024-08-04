package MrZLeviatan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App04 {

        /*
        BASE CASE:
            -The module (%) of the number in 10 is the last digit to add
        */
        public static void main(String[] args) {

            System.out.println(" --Exercise 4-- ");
            obtenerDatos();

        }


        /*
        RECURSIVE CASE:
            -DIVIDE THE MODULE BY 10.
            -COUNT THE GIVEN NUMBER IN A SUM.
            -CALL THE RECURSIVE, WITH THE NEW VALUE AND DIVIDED BY 10.
        */
        public static int sumaCifras (int n){
            if(n<10){
                return n;
            }else {
                return (n % 10) + sumaCifras(n /10);
            }
        }

        public static void obtenerDatos(){
            Scanner sc = new Scanner(System.in);
            int numero;
            System.out.println(" Enter a number Please: ");

                try {
                    numero = sc.nextInt();
                    int sumaDIgitos = sumaCifras(numero);
                    System.out.println(" The sum of the digits in the previous example is: " + sumaDIgitos);

                }catch (InputMismatchException ex){
                    System.out.println("Error: The typed value must be an integer");
                    sc.next();
                }
        }
    }