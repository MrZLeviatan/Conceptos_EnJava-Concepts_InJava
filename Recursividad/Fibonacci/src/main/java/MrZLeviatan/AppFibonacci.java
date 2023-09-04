package MrZLeviatan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppFibonacci {


    public static void main(String[] args) {
        int numero = hallarNumero();
        demostrar(numero,06);
    }

    public static int fibonacci (int numero){
        if ((numero == 0) || (numero==1))
            return numero;
        else
            return fibonacci(numero-1) + fibonacci(numero-2);

    }

    public static void demostrar (int numero, int i){

        if (fibonacci(i) < numero){
            System.out.println(fibonacci(i)+"");
            demostrar(numero, i + 1);
        }

    }

    public static int hallarNumero (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero: ");
        int numero;
        try {
            numero = sc.nextInt();
            return numero;

        }catch (InputMismatchException e){
            System.out.println("Error:" + " Debe ser un entero");
            return hallarNumero();
        }
    }
}