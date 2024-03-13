package MrZLeviatan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    /*
        CASO BASE:

            -CUANDO EL NUMERO SEA MENOR QUE 10, LA RESPUESTA ES 1 DIGITO/CIFRA

        CASO RECURSIVO:

            -DIVIDIR EL NUMERO ENTRE 10
            -CONTAR +1 DIGITO OH EN EL SUMATORIO
            -LLAMAR LA RECURSIVIDAD, CON EL NUEVO VALOR
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



    public static void obtenerDatos () {

        Scanner sc = new Scanner(System.in);
        Scanner nm = new Scanner(System.in);
        int numero;
        int n;
        System.out.println(" Digite un numero Por favor: ");

            try {
                numero = sc.nextInt();
                int sumaDigitos = contarDigitos(numero);
                System.out.println("La cantidad de digitos en el anterior ejemplo es: " + sumaDigitos);

            } catch (InputMismatchException e) {
                    System.out.println("Error: " + "El valor tecleado debe ser un entero");
                    obtenerDatos();

            }
    }



    public static void main(String[] args) {

        System.out.println(" --EJERCICIO 1-- ");
        obtenerDatos();

    }

}



