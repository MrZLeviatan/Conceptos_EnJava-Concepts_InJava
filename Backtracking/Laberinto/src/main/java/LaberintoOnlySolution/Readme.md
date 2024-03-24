<h1 align="center">  Laberinto: Única Solución / Labyrinth: Only Solution </h1>


Un código en Java que utiliza backtracking para resolver laberintos se centra en encontrar un único camino viable de un punto de inicio a un punto de destino dentro de una matriz que representa el laberinto.
>Java code that uses backtracking to solve mazes focuses on finding a single viable path from a start point to a destination point within an array that represents the maze.
> 
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

## _Class AppLeviatan:_

En esta clase, se detallan los pasos y métodos del algoritmo Backtracking, utilizados para encontrar una única solución a un laberinto.
>In this class, the steps and methods of the Backtracking algorithm, used to find a unique solution to a maze, are detailed.



- <H3>  Variables: </H3> 
    La clase contiene un arreglo bidimensional de caracteres "Laberinto", donde ' # ' indica las paredes del laberinto y los espacio ' ' el camino libre.

  >The class contains a two-dimensional array of "Laberinto" characters, where ' # ' indicates the walls of the maze and spaces ' ' the free path.

    -  <H3> Métodos / Methods: </H3>

        -  <H4> Main: </H4> 
           Crea una instancia de la clase, se marca la posición inicial del laberinto ' X ' y luego se llama el método
           ' resuelve ' con las coordenadas de inicio del recorrido. Finalmente, se imprime el laberinto resuelto con el método
           " imprimirLaberinto ".

           > Create an instance of the class, mark the starting position of the maze ' X ' and then call the method
           ' resuelve ' with the start coordinates of the route. Finally, the maze solved with the method is printed
           " imprimirLaberinto ".

        - <H4> Resuelve: </H4>
           Este método intenta resolver el laberinto marcando un camino desde el punto
           de inicio hasta el punto con ' X '. Utiliza el método " paso " para explorar
           las posibles direcciones y marca el camino con una ' S ' si encuentra una solución. 

          > This method attempts to solve the maze by marking a path from the point
          from start to the point with ' X '. Use the " paso " method to explore
          possible directions and mark the path with an ' S ' if you find a solution.

        - <H4> Paso: </H4>

            - Base de la recursión: Si el método encuentra la posición marcada con ' X ', retorna true, indicando que ha encontrado la solución.

            - Caso de parada: Si se encuentra con una pared (' # '), un camino ya visitado (' ^ '), o un camino marcado como sin salida (' 0 '), retorna false.

            - Exploración: Marca la posición actual con '^' para indicar que está siendo explorada. Luego, intenta moverse en las cuatro direcciones posibles (arriba, abajo, izquierda, derecha) de manera recursiva. Si uno de estos movimientos lleva a la solución, retorna true.

            - Sin salida: Si ninguna dirección resulta en una solución, marca la posición actual con ' 0 ' para indicar que es un camino sin salida y retorna false.

          > - Basis of recursion: If the method finds the position marked with ' X ', it returns true, indicating that it has found the solution.
          > - Stop case: If it encounters a wall (' # '), a path already visited (' ^ '), or a path marked as dead end (' 0 '), returns false.
          > - Exploration: Marks the current position with ' ^ ' to indicate that it is being explored. Then, it tries to move in all four possible directions (up, down, left, right) recursively. If one of these moves leads to the solution, it returns true.
          > - Dead end: If no direction results in a solution, marks the current position with '0' to indicate that it is a dead end path and returns false.

        - <H4> ImprimirLaberinto: </H4>

            - Recursividad: Utiliza un enfoque recursivo para imprimir el laberinto. Recorre el laberinto fila por fila y columna por columna, añadiendo el carácter correspondiente a la cadena de salida.
            - Cambio de línea: Al finalizar una fila, añade un salto de línea (' \n ') y llama a la función recursivamente para la siguiente fila.
          > - Recursion: Use a recursive approach to print the maze. Go through the maze row by row and column by column, adding the corresponding character to the output string.
          > - Line break: At the end of a row, adds a line break (' \n ') and calls the function recursively for the next row.

<br>

> [!IMPORTANT]
> Se denota el uso y conocimiento previo de [Recursividad](/Recursividad).
> > The use and prior knowledge of [Recursion](/Recursividad) is denoted.

<br>

```java

public class AppLaberintoLeviatan {

    private List<char [][]> soluciones = new ArrayList<>();

    public char[][] laberinto = {

            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', ' ', ' ', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
    };

    public static void main (String[] args){
        AppLaberintoLeviatan m = new AppLaberintoLeviatan();
        m.laberinto[8][1]= 'X';
        m.resuelve(1,1);
        System.out.println(m.imprimirLaberinto(0,0));
    }

    public  void resuelve (int x, int y){
        if (paso(x,y)){
            laberinto[x][y]='S';
        }

    }

    private boolean paso (int x, int y){

        if (laberinto[x][y] == 'X'){
            return true;
        }

        if (laberinto [x][y] == '#' || laberinto[x][y] == '^' || laberinto [x][y] == '0'){
            return false;
        }

        laberinto[x][y] = '^';

        boolean result;

        result=paso(x-1,y);
        if (result) return true;

        result=paso(x, y-1);
        if (result) return true;

        result= paso(x,y+1);
        if (result) return true;

        result=paso(x+1, y);
        if (result) return true;


        laberinto[x][y] = '0';
        return false;
    }

    private String imprimirLaberinto (int x, int y){

        String salida = "";

        if ( x < laberinto.length){
            if ( y < laberinto[x].length){

                salida += laberinto[x][y] + " ";
                return salida + imprimirLaberinto(x,y+1);
            }else{

                salida += "\n";
                y=0;
                return salida + imprimirLaberinto(x+1,y);
            }
        }else{
            return salida;
        }
    }

}
```