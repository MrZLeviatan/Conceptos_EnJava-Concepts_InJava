
# _Ejercicio Fibonacci_

En este ejercicio se halla la ecuacion fibonacci con el 
limite del numero pedido por consola; Utilizando los metodos de 
recursividad.

## _Problematica_
Crear una aplicativo para hallar la serie Fibonacci.


## _Tool_
- Java 17
- Maven
- IDE Intellij

___________

# _Class_

## _MainApp_

```java

public class AppFibonacci {


     System.out.println(" --EJERCICIO Fibonacci-- ");
        int numero = hallarNumero();
        System.out.println("\n" + "Resultado: ");
        demostrar(numero,0);
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
