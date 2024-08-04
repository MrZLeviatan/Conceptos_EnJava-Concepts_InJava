<h1 align="center" >  Ejercicio 12 / Exercise 12 </h1>

In this exercise, you are asked to calculate the power of a base and an exponent entered through the console using recursive methods.
> En este ejercicio, se solicita calcular la potencia de una base y un exponente ingresados por consola utilizando métodos recursivos.

---

## _Badges:_


- <H3> Backend:</H3>

    - [![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ](https://www.oracle.com/co/java/technologies/downloads/#java21)


- <H3>  IDEs/ Editors: </H3>

    - [![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/es-es/idea/) [![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org/)

___

<H1 align="center"> 

_Classes_

</H1>

## _App12_
Program a recursive algorithm that allows you to calculate and return any power for any number.
>Programar un algoritmo recursivo que permita calcular y retornar cualquier potencia para cualquier número.

- <H3> Métodos / Methods: </H3>

    -  <H4> Main: </H4>
        This is the entry point of the program. Here two numbers are requested from the user: the base and the
        power. The result of raising the base to the specified power is then calculated and displayed.
    
        > Este es el punto de entrada del programa. Aquí se solicitan dos números al usuario: la base y la
       potencia. Después, se calcula y muestra el resultado de elevar la base a la potencia especificada.
       
    -  <H4> Calcular: </H4>
       Performs the calculation of raising a number (base) to a given power. It is implemented recursively.
       The basis of the recursive case is to verify each property of the power.

        >Realiza el cálculo de elevar un número (base) a una potencia dada. Se implementa de manera recursiva.
       La base del caso recursivo es verificar cada propiedad de la potencia.
    
  -  <H4> SolicitarNumero: </H4>
        This method is responsible for asking the user for an integer number, displaying a personalized message that
        receives as a parameter. Uses exception handling to ensure that the user enters a
        valid integer value.
    
        >Este método se encarga de pedir al usuario un número entero, mostrando un mensaje personalizado que
        recibe como parámetro. Utiliza un manejo de excepciones para asegurarse de que el usuario ingrese un
        valor entero válido.
    
<br>

> [!IMPORTANT]
>  The use of <strong>Exceptions </strong> is denoted. See the [Exceptions](/../main/Exceptio) exercises.
>> Se denota el uso de <strong> Excepciones </strong>. Verse en la carpeta de [Excepciones](/../main/Exception).

<br>

```java

public class App12 {
    
    
    public static void main(String[] args) {


        System.out.println(" --EJERCICIO 12-- ");

        int base = solicitarNumero("Digite la base: ");
        int potencia = solicitarNumero("Digite la potencia: ");

        System.out.printf(" El numero %d potenciado en %d es: "
                + calcular(base,potencia),base,potencia);

    }

    public static int calcular(int base, int potencia) {
      
        if (potencia == 0) return 1;
       
        if (base == 0) return 0;
        
        return base * calcular(base, potencia - 1);
    }


    public static int solicitarNumero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.println(mensaje);

        try {
            numero = sc.nextInt();
            return numero;
        } catch (InputMismatchException e) {
            System.out.println("Error: El valor tecleado debe ser un entero");
            sc.next();                              
            return solicitarNumero(mensaje);        
        }
    }
}
```