# _Ejercicio 4_

En este ejercicio se pide la suma de las cifras 
de un valor pedido por consola utilizando los 
metodos de recursividad.

## _Problematica_
Sume las cifras de un número. Parámetros: int n

## _Tool_
- Java 17
- Maven
- IDE Intellij

___________

# _Class_

## _MainApp_

```java

public class App04 {

        public static void main(String[] args) {

        System.out.println(" --EJERCICIO 4-- ");
            obtenerDatos();

        }

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