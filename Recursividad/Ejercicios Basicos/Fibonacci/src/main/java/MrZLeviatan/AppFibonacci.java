package MrZLeviatan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppFibonacci {


    /**
     * CONVIERTE LA CLASE EN EJECUTABLE.
     */
    public static void main(String[] args) {
        System.out.println(" --EJERCICIO Fibonacci-- ");
        int numero = hallarNumero();
        System.out.println("\n" + "Resultado: ");
        demostrar(numero,0);
    }

    /**
     * MÉTODO RECURSIVO PARA HALLAR LOS NÚMEROS PERTENECIENTES AL FIBONACCI.
     */
    public static int fibonacci (int numero){
        if ((numero == 0) || (numero==1))
            return numero;
        else
            return fibonacci(numero-1) + fibonacci(numero-2);
    }

    /**
     * MÉTODO RECURSIVO PARA DEMOSTRAR EL RESULTADO
     */
    public static void demostrar (int numero, int i){
        if (fibonacci(i) <= numero){
            System.out.print(fibonacci(i)+" ");
            demostrar(numero, i + 1);
        }
    }

    /**
     * MÉTODO RECURSIVO PARA ESCANEAR EL NUMEROSO POR CONSOLA.
     */
    public static int hallarNumero (){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n" + "Introduce el numero: ");
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