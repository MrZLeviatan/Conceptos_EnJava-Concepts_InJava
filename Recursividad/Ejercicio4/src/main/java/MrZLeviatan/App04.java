package MrZLeviatan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App04 {
        /*
         CASO BASE:
             -El modulo (%) del numero en 10, es el ultimo digito a sumar
        */
        public static void main(String[] args) {

            System.out.println(" --EJERCICIO 4-- ");
            obtenerDatos();

        }

        /*
         CASO RECURSIVO:
                -DIVIDIR EL MODULO ENTRE 10
                -CONTAR EL NUMERO DADO EN UNA SUMA
                -LLAMAR LA RECURSIVIDAD, CON EL NUEVO VALOR Y DIVIDIDO ENTRE 10
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
            System.out.println("Digite el numero por favor: ");

                try {
                    numero = sc.nextInt();
                    int sumaDIgitos = sumaCifras(numero);
                    System.out.println("La suma de los digitos en el anterior ejemplo es: " + sumaDIgitos);

                }catch (InputMismatchException ex){
                    System.out.println("!! Debe ser obligatoriamente un entero !!");
                    sc.next();

                }
        }
    }