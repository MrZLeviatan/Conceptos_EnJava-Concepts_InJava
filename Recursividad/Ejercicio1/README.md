# _Ejercicio 01_

En este ejercicio se pide contar las cifras de un valor pedido por consola utilizando los metodos de recursividad.

## _Problematica_
Hallar la cantidad de cifras de un número entero usando la recursividad. Parámetro: n (número entero)

## _Tool_

 - Java 17
 - Maven
 - IDE Intellij

_______

# _Class_

### _MainApp_
Inicia la aplicacion pidiendo un valor 

```java
public Class App {

    public static void main(String[] args) {

        System.out.println(" --EJERCICIO 1-- ");
        obtenerDatos();

    }
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
        int numero;
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

}
