package MrZLeviatan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App12 {


    /**
     * CONVIERTE LA CLASE EN UN EJECUTABLE. SE LLAMA EL MÉTODO solicitarNumero.
     */
    public static void main(String[] args) {

        System.out.println(" --EJERCICIO 12-- ");

        int base = solicitarNumero("Digite la base: ");
        int potencia = solicitarNumero("Digite la potencia: ");

        System.out.printf(" El numero %d potenciado en %d es: "
                + calcular(base,potencia),base,potencia);

        }


    /**
     * MÉTODO PARA CALCULAR LA BASE Y POTENCIA.
     */
    public static int calcular(int base, int potencia) {
        // Caso base: cualquier número a la potencia de 0 es 1.
        if (potencia == 0) return 1;
        // Caso base: 0 elevado a cualquier potencia positiva es 0.
        if (base == 0) return 0;
        // Paso recursivo.
        return base * calcular(base, potencia - 1);
    }


    /**
     * MÉTODO PARA SOLICITAR LOS NÚMEROS DESDE EL ESCÁNER.
     */
    public static int solicitarNumero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.println(mensaje);

            try {
                numero = sc.nextInt();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Error: El valor tecleado debe ser un entero");
                sc.next();                              // Limpia el buffer del scanner para evitar un bucle infinito.
                return solicitarNumero(mensaje);        // Llamada Recursiva.
            }
    }
}