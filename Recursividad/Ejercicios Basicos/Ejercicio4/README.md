# _Ejercicio 04 / Exercise 04_

En este ejercicio se pide la suma de las cifras 
de un valor pedido por consola utilizando los 
metodos de recursividad.
>In this exercise we ask for the sum of the figures
of a value requested by console using the
recursion methods.

## _Problematica: Problematic:_
Sume las cifras de un número. Parámetros: int n
>Add the digits of a number. Parameters: int n

## _Tool_
- Java 17
- Maven
- IDE Intellij

___________

# _Class_

### _MainApp_
Inicia la aplicacion pidiendo un valor 
>Start the application asking for a value
<br>
</br>

> [!IMPORTANT]
> Se denota el uso de <strong> Excepciones </strong>. Verse en la carpeta de [Excepciones](/../main/Exception).
>>  The use of <strong>Exceptions </strong> is denoted. See the [Exceptions](/../main/Exceptio) exercises.


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
