<h1 align="center">  Parqueadero / Parking: </h1> 

Implementar un algoritmo usando backtracking que permita solucionar el siguiente problema:
En un parqueadero usted tiene dos lugares disponibles(R1 y R2). En cada lugar usted quiere 
parquear un carro, es decir tiene 2 carros para parquear. Una vez realice el parqueo de un 
carro se dispone a parquear el siguiente carro. Un parqueadero se puede representar en forma 
de matriz parqueadero[i][j].
    
> Implement an algorithm using backtracking that allows solving the following problem:
In a parking lot you have two spaces available (R1 and R2). In every place you want
park a car, that is, you have 2 cars to park. Once you have parked a
car is preparing to park the next car. A parking lot can be represented in the form
of parking matrix[i][j].

<H3> Reglas / Rules: </H3>

- R significar que es un espacio reservado

- <img align='leg' src="https://github.com/MrZLeviatan/Conceptos_EnJava/blob/main/Backtracking/Parqueadero/src/main/resources/images/ImagenDis.png?raw=true" width="40"> L significa que es un espacio libre para discapacitados. Parqueadero[i][j]= “discapacitado”.

- <img align='leg' src="https://github.com/MrZLeviatan/Conceptos_EnJava/blob/main/Backtracking/Parqueadero/src/main/resources/images/imagenCar.png?raw=true" width="40"> C significa que es un espacio ocupado por un carro. parqueadero[i][j]= “carro”.
- parqueadero[i][j]= " ", significa que es un pasillo.
- Se tienen 2 carros a parquear.
- Solo se puede estacionar en algunos de los 2 puntos reservados R1 o R2.
- Cada carro va en un espacio R1 o R2.
- Dejar una marca “+” en la posición[i][j] por donde va pasando el carro (solo por pasillos).

    > - R means it is a reserved space
    > - <img align='leg' src="https://github.com/MrZLeviatan/Conceptos_EnJava/blob/main/Backtracking/Parqueadero/src/main/resources/images/ImagenDis.png?raw=true" width=" 40"> L means it is a handicap free space. parking[i][j]= “disabled”.
    > - <img align='leg' src="https://github.com/MrZLeviatan/Conceptos_EnJava/blob/main/Backtracking/Parqueadero/src/main/resources/images/imagenCar.png?raw=true" width=" 40"> C means that it is a space occupied by a car. parking[i][j]= “car”.
    > - parking[i][j]= " ", means it is a hallway.
    > - There are 2 cars to park.
    > - You can only park in some of the 2 reserved spots R1 or R2.
    > - Each car goes in a space R1 or R2.
    > - Leave a “+” mark in position [i][j] were the cart passes (only in aisles).



<p align="center">
  <img src="https://i.postimg.cc/bNRrjMGg/Imagen-Parq.png" />
</p>

---

## _Tools:_


- <H3> Backend:</H3>

    - [![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ](https://www.oracle.com/co/java/technologies/downloads/#java21)


- <H3>  IDEs/ Editors: </H3>

    - [![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/es-es/idea/) [![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org/)


---

<H1 align="center"> 

_Classes_

</H1>

## _Class AppParqueadero:_

Este código representa un programa Java diseñado para simular el proceso de encontrar lugares para estacionar en un parqueadero.
> This code represents a Java program designed to simulate the process of finding parking spaces in a parking lot.
    
- <H3>  Variables: </H3> 
El programa utiliza un arreglo bidimensional para representar las diferentes secciones del parqueadero, y mediante una búsqueda, intenta encontrar lugares específicos marcados como "R1" y "R2" para estacionar dos carros.
> The program uses a two-dimensional array to represent the different sections of the parking lot, and through a search, tries to find specific places marked "R1" and "R2" to park two cars.

-  <H3> Métodos / Methods: </H3>

    -  <H4> Main: </H4> 
        Inicia el programa, imprime el nombre del parqueadero, crea una instancia de AppParqueadero, y llama al método resuelve para iniciar la búsqueda de los lugares "R1" y "R2", empezando desde la posición [11, 0] del arreglo. Luego, imprime el estado final del parqueadero y un mensaje indicando el fin del programa.
        
       > Start the program, print the name of the parking lot, create an instance of AppParqueadero, and call the resolve method to start searching for locations "R1" and "R2", starting from position [11, 0] of the array. Then, it prints the final status of the parking lot and a message indicating the end of the program.

   -  <H4> Resuelve: </H4>
         Marca el inicio de la búsqueda. Llama al método movimiento para explorar el parqueadero desde la posición dada y luego marca esa posición con "S".

        > Marks the beginning of the search. Call the move method to explore the parking lot from the given position and then mark that position with "S".

   -  <H4> EsPasoValido: </H4>
        Verifica si la posición dada está dentro de los límites del arreglo parqueadero. Esto previene errores por intentar acceder a posiciones fuera del arreglo.
    
        > Checks if the given position is within the limits of the parking arrangement. This prevents errors from trying to access positions outside the array.

   -  <H4> Movimiento: </H4>
        Realiza la búsqueda recursiva para encontrar los lugares "R1" y "R2". Si encuentra uno de estos lugares, lo marca con "//" y reimprime el estado del parqueadero, indicando que se ha estacionado un carro. Este método también evita moverse a lugares ocupados, caminos ya explorados, o fuera de los límites.
    
        > Perform the recursive search to find locations "R1" and "R2". If it finds one of these places, it marks it with "//" and reprints the parking status, indicating that a car has been parked. This method also avoids moving to busy locations, already explored paths, or out of bounds.
      
   -  <H4> Imprimir: </H4>
        Imprime el estado actual del parqueadero, mostrando cómo están distribuidos los diferentes elementos dentro de él. Utiliza recursividad para iterar a través de las filas y columnas del arreglo.

        > Prints the current status of the parking lot, showing how the different elements are distributed within it. It uses recursion to iterate through the rows and columns of the array.

<br>

> [!IMPORTANT]
> Se denota el uso y conocimiento previo de [Recursividad](/Recursividad).
> > The use and prior knowledge of [Recursion](/Recursividad) is denoted.

<br>


```java

public class AppParqueadero {

    public static String[][] parqueadero = {

            {"L", " ", "L", "C", "R1", "L", " "},
            {"L", " ", "L", "C", " ", "L", " "},
            {" ", " ", " ", "C", " ", " ", " "},
            {"C", " ", " ", "C", "I", "I", " "},      
            {"C", " ", " ", " ", " ", "L", " "},      
            {"C", " ", "C", " ", " ", "L", " "},      
            {"C", " ", "C", " ", "C", "C", " "},      
            {" ", " ", "C", " ", " ", " ", " "},      
            {"C", " ", "C", " ", "C", " ", "C"},
            {"C", " ", "R", " ", "C", " ", "R"},
            {" ", " ", "R", " ", "C", "C", "R"},
            {" ", " ", "R", " ", " ", " ", "R2"},
            
    };

    public static void main(String[] args) {
        System.out.println("""
                       
                        -- PARQUEADERO LA CHINGADA  --    
                """);
        AppParqueadero m = new AppParqueadero();
        m.resuelve(11, 0);
        imprimir(0, 0);
        System.out.println("FIN DEL PROGRAMA");
    }

    public void resuelve(int x, int y) {
        movimiento(x, y);
        parqueadero[x][y] = "S";

    }

    private boolean esPasoValido(int x, int y) {

        if (x >= 0 && x <= parqueadero.length - 1 && y >= 0 && y <= parqueadero[x].length - 1) { //PARA QUE NO SE DESBORDE DE LA MATRIZ
            return true;
        } else {
            return false;
        }
    }

    public boolean movimiento(int x, int y) {
        if (!esPasoValido(x, y)) {   
            return false;
        }

        if (parqueadero[x][y].equals("R1")) {
            parqueadero[x][y] = "//";
            imprimir(0, 0);
            System.out.println(" --- SE PARQUEO EL PRIMER CARRO ---");
            System.out.println("");
            return true;
        }

        if (parqueadero[x][y].equals("R2")) {
            parqueadero[x][y] = "//";
            imprimir(0, 0);
            System.out.println(" --- SE PARQUEO EL SEGUNDO CARRO ---");
            System.out.println("");
            return true;
        }

        if (parqueadero[x][y].equals("L") || parqueadero[x][y].equals("C") || parqueadero[x][y].equals("R")
                || parqueadero[x][y].equals("I")) {
            return false;
        }
        if (parqueadero[x][y].equals("/") || parqueadero[x][y].equals("+")) {
            return false;
        }

        parqueadero[x][y] = "+";   

        boolean result;

        result = movimiento(x, y + 1); 
        result = movimiento(x + 1, y); 
        result = movimiento(x - 1, y);
        result = movimiento(x, y - 1); 

        parqueadero[x][y] = " ";  
        return false;

    }

    public static void imprimir(int i, int j) {  

        if (parqueadero.length - 1 == ) {
            if (parqueadero[0].length - 1 == j) {
                System.out.println(parqueadero[i][j] + "\n");
            } else {
                System.out.print(parqueadero[i][j] + " ");
                imprimir(i, j + 1);
            }
        } else {
            if (parqueadero[0].length - 1 == j) {
                System.out.println(parqueadero[i][j] + " ");
                imprimir(i + 1, 0);
            } else {
                System.out.print(parqueadero[i][j] + " ");
                imprimir(i, j + 1);
            }
        }

    }
}
```
