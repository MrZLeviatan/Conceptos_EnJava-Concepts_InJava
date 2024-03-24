<h1 align="center">  Laberinto: Varias Solución / Labyrinth: Various Solution </h1>

Un código en Java que utiliza backtracking para resolver laberintos se centra en encontrar los varios caminos válidos de un punto de inicio a un punto de destino dentro de una matriz que representa el laberinto.
> Java code that uses backtracking to solve mazes focuses on finding the various valid paths from a start point to a destination point within an array that represents the maze.

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

## _Class AppCthulhu_
Este código en Java es un ejemplo de cómo resolver diversamente un laberinto usando el algoritmo de backtracking. A continuación, describo el propósito y funcionamiento de cada parte del código:
> This Java code is an example of how to variously solve a maze using the backtracking algorithm. Below I describe the purpose and operation of each part of the code:

- <H3>  Variables: </H3> 
    La clase contiene un arreglo bidimensional de caracteres "Laberinto", donde ' # ' indica las paredes del laberinto y los espacio ' ' el camino libre.

  >The class contains a two-dimensional array of "Laberinto" characters, where ' # ' indicates the walls of the maze and spaces ' ' the free path.

    -  <H3> Métodos / Methods: </H3>

        -  <H4> Main: </H4> 
            Crea una instancia de la clase, se marca la posición inicial del laberinto ' X ' y luego se llama el método
           ' resuelve ' con las coordenadas de inicio del recorrido. Finalmente, se imprime todas las soluciones encontradas.
    
            > Create an instance of the class, mark the starting position of the maze ' X ' and then call the method
            'resolves' with the start coordinates of the route. Finally, all the solutions found are printed.

        - <H4> Resuelve: </H4>
            Este método marca el punto inicial de la solución y llama al método paso para comenzar la exploración del laberinto.\
          
            > This method marks the starting point of the solution and calls the step method to begin exploring the maze.

       - <H4> Paso: </H4>

           - Base de la recursión: Si el método encuentra la posición marcada con ' X ', retorna true, indicando que ha encontrado la solución.

           - Caso de parada: Si se encuentra con una pared (' # '), un camino ya visitado (' ^ '), o un camino marcado como sin salida (' 0 '), retorna false.

           - Exploración: Marca la posición actual con '^' para indicar que está siendo explorada. Luego, intenta moverse en las cuatro direcciones posibles (arriba, abajo, izquierda, derecha) de manera recursiva. Si uno de estos movimientos lleva a la solución, retorna true.

           - Sin salida: Si ninguna dirección resulta en una solución, marca la posición actual con ' 0 ' para indicar que es un camino sin salida y retorna false.

         > - Basis of recursion: If the method finds the position marked with ' X ', it returns true, indicating that it has found the solution.
         > - Stop case: If it encounters a wall (' # '), a path already visited (' ^ '), or a path marked as dead end (' 0 '), returns false.
         > - Exploration: Marks the current position with ' ^ ' to indicate that it is being explored. Then, it tries to move in all four possible directions (up, down, left, right) recursively. If one of these moves leads to the solution, it returns true.
         > - Dead end: If no direction results in a solution, marks the current position with '0' to indicate that it is a dead end path and returns false.
        
       - <H4> CopiaLaberinto: </H4>
         Hace una copia profunda del laberinto actual para guardar el estado actual del camino explorado como una solución posible.
         
         >Makes a deep copy of the current maze to save the current state of the explored path as a possible solution.
       
       - <H4> ImprimirSolutions / Imprimir: </H4>
         Estos métodos se encargan de imprimir todas las soluciones encontradas, mostrando el laberinto con las rutas marcadas para cada solución almacenada.
         
         > These methods are responsible for printing all the solutions found, showing the maze with the marked routes for each stored solution.
       
       - <H4> MasImprimir: </H4>
         Se utiliza para imprimir cada solución de la matriz del laberinto, asegurando un formato legible al recorrer cada fila y columna.
        
         >It is used to print each solution of the maze matrix, ensuring a readable format when traversing each row and column.

<br>

> [!IMPORTANT]
> Se denota el uso y conocimiento previo de [Recursividad](/Recursividad).
> > The use and prior knowledge of [Recursion](/Recursion) is denoted.

<br>

```java

public class AppLaberintoCthulhu {

    private List<char[][]> soluciones = new ArrayList<>();

    public char[][] laberinto = {

            {'#', '#', ' ', '#', '#', ' ', '#', ' ', '#', '#'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {' ', ' ', '#', ' ', '#', '#', '#', '#', '#', '#'},
            {' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', ' ', ' ', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' '},
            {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', ' ', ' ', ' ', '#', '#', '#'},
    };

    public static void main(String[] args) {

        System.out.println("""
       
                        -- Laberinto De Cthulhu --    
                """);
        AppLaberintoCthulhu m = new AppLaberintoCthulhu();
        m.laberinto[1][1] = 'X';
        m.resuelve(5, 6);
        m.imprimirSolutions();
    }

    public void resuelve(int x, int y) {
        paso(x, y);
        laberinto[x][y] = 'S';
    }

    private void paso(int x, int y) {

        if (laberinto[x][y] == 'X') {
            char [][] copia = new char[laberinto.length][laberinto[0].length];
            char[][] solution = copiaLaberinto(0,copia);
            soluciones.add(solution);
            return;
        }


        if (laberinto[x][y] == '#' || laberinto[x][y] == '^' || laberinto[x][y] == '0') {
            return;
        }

        int numRows = laberinto.length;
        int numCols = laberinto[0].length;

        laberinto[x][y] = '^';


        if (x >= 0 && x < numRows && y + 1 >= 0 && y + 1 < numCols) {
            paso(x, y + 1);
        }

        if (x - 1 >= 0 && x - 1 < numRows && y >= 0 && y < numCols) {
            paso(x - 1, y);
        }


        if (x >= 0 && x < numRows && y - 1 >= 0 && y - 1 < numCols) {
            paso(x, y - 1);
        }

        if (x + 1 >= 0 && x + 1 < numRows && y >= 0 && y < numCols) {
            paso(x + 1, y);
        }

        laberinto[x][y] = ' ';

    }

    private char[][] copiaLaberinto(int i, char[][]copia) {


        if (i == laberinto.length) {
            return copia;

        } else {
            System.arraycopy(laberinto[i],0,copia[i],0,laberinto[i].length);
            return copiaLaberinto(i+1,copia);
        }

    }

    private void imprimirSolutions() {
        if (soluciones.isEmpty()) {
            System.out.println("No hay soluciones.");
            return;
        }
        System.out.println("Todas las soluciones posibles:");
        imprimir(0);

    }

    private void imprimir (int i){
        if ( i < soluciones.size()){
            char [][] so = soluciones.get(i);
            System.out.println("\n");
            System.out.println(" Solucion " + (i+1)+ ":");
            masImprimir(0,0,so);
            imprimir(i+1);
        }
    }

    private void masImprimir (int i, int j, char [][]solution){

            System.out.print(solution[i][j]);

            if (i!=solution.length-1 || j!=solution[i].length-1){

                if(j==solution[i].length-1){
                    i++;
                    j=0;
                    System.out.println(" ");
                }else{
                    j++;
                    System.out.print(" ");
                }
                masImprimir(i,j,solution);
            }
        }
    }
```