# _Ejercicio 10 / Exercise 10_

En este ejercicio se pide invertir una palabra pedida por consola utilizando los metodos recursivos.
>In this exercise you are asked to reverse a word requested by the console using recursive methods.

## _Problematica: / Problematic:_
Invertir una palabra de forma recursiva.
>Reverse a word recursively.

## _Tool_

- Java 17
- Maven
- IDE Intellij

-----

# _Class_

### _MainApp_

Se inica la aplicacion pidiendo un String por consola.
>The application starts asking for a String through the console.

```java

public class App10 {

    public static void main(String[] args) {

        System.out.println(" --EJERCICIO 10-- ");

        Scanner sc = new Scanner(System.in);
        String palabra;
        int longitud;
        System.out.println("");
        System.out.println(" Digite una palabra por favor: ");

        palabra = sc.nextLine();
        longitud = palabra.length()-1;
        System.out.println("La palabra invertida es: " + invertirPalabra(palabra,longitud));

    }

    public static String invertirPalabra (String palabra, int longitud){

        if (longitud == 0){
            return palabra.charAt(longitud) + " ";
        }
        else{
            return palabra.charAt(longitud) + " " + invertirPalabra(palabra,longitud-1);
        }
    }
}
```
