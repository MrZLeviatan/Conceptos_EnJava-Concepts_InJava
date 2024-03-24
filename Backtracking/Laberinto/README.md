<h1 align="center">  Laberintos </h1>
Uno de los problemas más comunes en los que se aplica el algoritmo de 
Backtracking es en la resolución de laberintos, donde se busca encontrar 
un camino desde un punto inicial hasta uno final, considerando las restricciones 
del laberinto y evitando los caminos que conduzcan a soluciones inválidas o 
cíclicas.

>One of the most common problems in which the algorithm is applied
Backtracking is in the resolution of mazes, where one seeks to find
a path from a starting point to an ending point, considering the constraints
of the maze and avoiding paths that lead to invalid or invalid solutions.
cyclical.


---

## _Tools:_

- <H3> Backend:</H3>

    - [![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ](https://www.oracle.com/co/java/technologies/downloads/#java21)


- <H3>  IDEs/ Editors: </H3>

    - [![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/es-es/idea/) [![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org/)



___

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
        
        

> [!IMPORTANT]
> Se denota el uso y conocimiento previo de [Recursividad](/Recursividad). 
> > The use and prior knowledge of [Recursion](/Recursion) is denoted.

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

## _Class AppCthulhu_

En este main se muestran las diferentes soluciones para un unico laberinto.

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