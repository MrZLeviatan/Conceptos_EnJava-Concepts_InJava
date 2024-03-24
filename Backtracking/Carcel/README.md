<h1 align="center"> Recorrer Cárcel / Tour Jail </h1>

Implementar un algoritmo usando backtracking que permita solucionar el siguiente problema: 
Una cárcel de una ciudad se puede representar en forma de matriz cárcel[i][j].
>Implement an algorithm using backtracking that allows solving the following problem:
A city jail can be represented in the form of a jail[i][j] matrix.


<H3> Reglas / Rules: </H3>

- Cárcel[i][j]= P significa que hay un preso.
- Cárcel[i][j]= 'X' significa que no hay preso.
- Cárcel[i][j]= ' '(vacío) significa que es un pasillo.
- Desarrolle una aplicación que permita obtener si faltan presos en una cárcel, para esto el guarda de 
seguridad debe recorrer toda la cárcel contando cuántos presos encontró.
- Dejar una marca en la posición[i][j] por donde va pasando el guarda.
- En total debe de haber 26 presos. Al final del recorrido por toda la cárcel. Debe indicar si se escaparon presos y cuántos. 
- En caso contrario solo indicar que no se ha escapado ningún preso.
- El guarda debe arrancar en la posición S (0, 0) y terminar en un punto de control en la posición C (#, #)
definidas por parámetro. El patrón de movimiento a utilizar es:, derecha, abajo, arriba, izquierda. 
Debe tener en cuenta que no se puede salir de la cárcel. Lo azul son los índices filas y columnas no son 
valores de la matriz.

> - Cárcel[i][j]= P means there is a prisoner.
> - Cárcel[i][j]= 'X' means there is no prisoner.
> - Cárcel[i][j]= ' '(empty) means it is a hallway.
> - Develop an application that allows you to find out if there are missing prisoners in a prison, for this the prison guard
  Security must go through the entire prison counting how many prisoners he found.
> - Leave a mark in the position[i][j] where the guard passes.
> - In total there must be 26 prisoners. At the end of the tour of the entire prison. You must indicate if prisoners escaped and how many.
> - Otherwise, just indicate that no prisoner has escaped.
> - The guard must start at position S (0, 0) and end at a checkpoint at position C (#, #)
  defined by parameter. The movement pattern to use is: right, down, up, left.
  You must keep in mind that you cannot get out of jail. The blue are the row and column indexes, they are not
  matrix values. 

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

## _AppCárcel_


El programa busca todos los 'P' (presos) en la cárcel desde un punto de inicio 'C', contabilizando el número de presos encontrados. Finalmente, calcula e informa el número de presos que no fueron encontrados, basándose en un total de presos supuestamente presentes en la cárcel.
   > The program searches for all 'P' (prisoners) in the jail from a starting point 'C', counting the number of prisoners found. Finally, it calculates and reports the number of prisoners who were not found, based on a total of prisoners supposedly present in the jail.

   - <H3>  Variables: </H3> 
     La cárcel está representada por una matriz de caracteres char[][] cárcel, donde cada celda puede contener:
       
        - Un espacio ' ' que indica un camino libre.
        - 'P' que representa un preso.
        - 'X' que representa una barrera que no se puede cruzar.
        - 'C' que indica el punto de inicio de la búsqueda.
     
        > The jail is represented by a character array char[][] cárcel, where each cell can contain:
        >   - A space ' ' indicating a free path.
        >   - 'P' representing a prisoner.
        >   - 'X' which represents a barrier that cannot be crossed.
        >   - 'C' indicating the starting point of the search.

       -  <H3> Métodos / Methods: </H3>

           -  <H4> Main: </H4> 
                Se crea una instancia de la cárcel, se inicializa los valores necesarios y se llaman a los otros métodos.
              
                > The jail is instantiated, the necessary values are initialized, and the other methods are called.

          - <H4> Resuelve: </H4>
                 Método que inicia la exploración desde una posición específica. Marca el camino recorrido para evitar repeticiones.
                
                > Method that starts scanning from a specific position. Mark the path taken to avoid repetitions.

          - <H4> Movimiento: </H4>
                  Intenta moverse en todas las direcciones desde la posición actual. Si encuentra un preso ('P'), incrementa el contador ' presosEncontrados ' y marca la posición como visitada ('V'). No puede atravesar muros ('X') ni volver sobre caminos ya marcados.
                
                > Try to move in all directions from the current position. If it finds a prisoner ('P'), it increments 
                    the ' presosEncontrados ' counter and marks the position as visited ('V'). It cannot go through walls ('X') or retrace already marked paths.

          - <H4> EsPasoValido: </H4>
                Verifica si la posición actual está dentro de los límites de la matriz y no ha sido visitada previamente o bloqueada.
    
                > Checks if the current position is within the boundaries of the array and has not been previously visited or locked.

          - <H4> Imprimir: </H4> 
                 Imprime la matriz actual, mostrando el estado actual de la cárcel con los caminos explorados y los presos encontrados.
    
                > Prints the current matrix, showing the current state of the jail with paths explored and prisoners found.


<br>

> [!IMPORTANT]
> Se denota el uso y conocimiento previo de [Recursividad](/Recursividad).
> > The use and prior knowledge of [Recursion](/Recursividad) is denoted.

<br>

```java

public class AppCarcel {

    public static char[][] carcel={

                {' ', 'P', 'X', ' ', 'P', 'P', ' ', 'P'},
                {' ', 'P', 'P', ' ', 'P', 'P', ' ', 'P'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'P', ' ', 'P', 'P', ' ', 'P', 'P', ' '},
                {'P', ' ', 'X', 'P', ' ', 'P', 'P', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'P', 'P', 'P', ' ', 'P', 'P', ' ', 'P'},

    };

    public static int presosEncontrados;

    public static void main(String[] args) {

        System.out.println("""
       
                        -- PRISION BELL RAVE  --    
                """);

        AppCarcel m = new AppCarcel();
        final int totalPresos = 26;
        presosEncontrados = 0;
        m.carcel[5][7] = 'C';
        m.resuelve(0, 0);
        imprimir(0,0);
        System.out.println("La cantidad de presos encontrados en la cárcel es de: "+ presosEncontrados + " presos.");
        int presosFaltantes = totalPresos-presosEncontrados;
        System.out.println("Escaparon " + presosFaltantes + " presos de la carcel");
    }

    public void resuelve(int x, int y){
        movimiento(x, y);
        carcel[x][y]='S';
    }

    private boolean movimiento(int x, int y) {

        if(!esPasoValido(x, y)){
            return false;
        }

        if (carcel[x][y]=='C') {

            imprimir(0,0);
            return true;
        }

        if (carcel[x][y]=='P') {

            presosEncontrados++;
            carcel[x][y]='V';
            return false;
        }

        if (carcel[x][y]=='X') {
            return false;
        }

        if (carcel[x][y]=='^' || carcel[x][y]=='+' || carcel[x][y]=='V') {
            return false;
        }

            carcel[x][y]='^';

            boolean result;

            result= movimiento(x, y+1);
            result= movimiento(x+1, y);
            result= movimiento(x-1, y);
            result= movimiento(x, y-1);

            carcel[x][y]='+';
            return false;
    }

    private boolean esPasoValido(int x, int y) {

        if(x >= 0 && x <= carcel.length-1 && y >= 0 && y<= carcel[x].length-1){
            return true;
        }else{
            return false;
        }
    }

    public static void imprimir(int i, int j) {

        if(carcel.length-1==i){
            if(carcel[0].length-1==j){
                System.out.println(carcel[i][j] + "\n");
            }else {
                System.out.print(carcel[i][j]+" ");
                imprimir(i,j+1);
            }
        }
        else {
            if(carcel[0].length-1==j){
                System.out.println(carcel[i][j]+" ");
                imprimir(i+1,0);
            }else {
                System.out.print(carcel[i][j]+" ");
                imprimir(i,j+1);
            }
        }
    }
}

```