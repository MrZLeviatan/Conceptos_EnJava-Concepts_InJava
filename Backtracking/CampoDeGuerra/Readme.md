<h1 align="center"> Juego Campo De Guerra / Battlefield </h1>

Implementar un algoritmo usando backtracking que permita solucionar el siguiente problema: Un campo minado se puede representar en forma de matriz ( campoGuerra[i][j] ), 
el objetivo es que un soldado va a caminar por el campo de guerra en la oscuridad, pero el soldado tiene visión nocturna y debe identificar en donde hay enemigos, eliminarlo 
y contar cuantos enemigos elimina y de qué tipo, además debe contar cuantos aliados encontró también, pero no los va a eliminar. Se debe e ir trazando los caminos hasta un punto 
de control. Es decir el solado va caminando, a medida que avanza va identificando si encuentra algún enemigo o aliado, si dado el caso llega al punto de control debe imprimir por 
consola la matriz para evidenciar el camino trazado y luego debe regresar por donde venía para terminar de identificar si hay otros caminos y de igual forma identificar los enemigos 
y aliados. Se debe tener en cuenta:
>Implement an algorithm using backtracking that allows solving the following problem: A minefield can be represented in the form of a matrix ( campoGuerra[i][j] ),
The objective is that a soldier is going to walk through the war field in the dark, but the soldier has night vision and must identify where there are enemies, eliminate them
and count how many enemies he eliminates and what type, in addition he must count how many allies he also found, but he is not going to eliminate them. You must trace the paths to a point
of control. That is to say, the soldier is walking, as he advances he identifies if he finds any enemy or ally, if in that case he reaches the checkpoint he must print by
console the matrix to show the path drawn, and then he must return the way he came to finish identifying if there are other paths and in the same way identify the enemies
and allies. Should consider:
    
<H3> Reglas / Rules: </H3>

- E1 significa que hay un enemigo tipo 1.
- E2 significa que hay un enemigo tipo 2.
- A significa que hay un aliado.
- “CA”(vacío) significa que es un camino.
- Dejar una marca “??” en la posición[i][j] por donde va pasando el solado (solo por camino).
- El solado debe arrancar en la posición (0, 7) y terminar en un punto de control en la posición G (5, 8) definidas por parámetro.
- El patrón de movimiento a utilizar es:, izquierda, derecha, abajo, arriba. Debe tener en cuenta que no se puede salir de la matriz campoGuerra. Lo verde son los índices filas y columnas no son valores de la matriz.
> - E1 means there is a type 1 enemy.
> - E2 means there is a type 2 enemy.
> - A means there is an ally.
> - “CA” (empty) means it is a path.
> - Leave a mark “??” in the position[i][j] where the screed is passing (only on the road).
> - The screed must start in position (0, 7) and end at a control point in position G (5, 8) defined by parameter.
> - The movement pattern to use is: left, right, down, up. You should note that you cannot exit the WarField array. The green is the row and column indexes, they are not values of the matrix.


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


## _AppCDG_

- El programa registra la cantidad de enemigos tipo 1 y tipo 2 eliminados, así como la cantidad de aliados encontrados.
- Muestra en pantalla el campo de batalla actualizado cada vez que se realiza un movimiento.
- El juego termina cuando el jugador llega al objetivo final "G".
- Al finalizar, se muestra la cantidad de enemigos tipo 1 y tipo 2 eliminados, así como la cantidad de aliados encontrados

<br>

> [!IMPORTANT]
> Se denota el uso y conocimiento previo de [Java Orientado A Objetos](/Objects).
> > The use and prior knowledge of [Object-Oriented Java](/Objects) is denoted.

<br>

```java

public class AppCDG {

    public static String[][] campo = {

            {"CA", "E1","A","CA","A","CA","CA","CA","E1"},
            {"CA", "E1","E2","CA","A","E1","CA","E1","CA"},         
            {"CA", "CA","CA","CA","CA","CA","CA","CA","CA"},        
            {"E1", "CA","E1","A","CA","E1","A","CA","CA"},          
            {"A", "CA","A","CA","CA","E2","E1","CA","E2"},         
            {"CA","CA","CA","CA","CA","CA","CA","CA","CA"},        
            {"CA","A","E1","CA","E1","A","CA","A","CA"},
            {"CA","E2","CA","CA","CA","E1","CA","CA","CA"},
            {"CA","CA","CA","A","CA","CA","CA","E2","CA"}

    };

    public static int enemigosTipo1;
    public static int enemigosTipo2;
    public static int aliados;


    public static void main(String[] args) {

        System.out.println("""
       
                        -- CDG  --    
                """);
        AppCDG m = new AppCDG();
        enemigosTipo1 = 0;
        enemigosTipo2= 0;
        aliados = 0;
        m.campo[5][7]="G";
        m.resuelve(0,7);
        imprimir(0,0);
        System.out.println("La cantidad de enemigos eliminados tipo1 es de: "
                + enemigosTipo1 + " y de tipo2 es de: " + enemigosTipo2);

        System.out.println("La cantidad de aliados encontrados: " + aliados);
    }

    public void resuelve(int x, int y){
        movimiento(x, y);
        campo[x][y]="S";
    }

    private boolean esPasoValido(int x, int y) {
        if(x >= 0 && x <= campo.length-1 && y >= 0 && y<= campo[x].length-1){ 
            return true;
        }else{
            return false;
        }
    }

    public boolean movimiento(int x, int y){

        if (!esPasoValido(x,y)){
            return false;
        }

        if (campo[x][y].equals("G")){
            imprimir(0,0);
            return true;
        }

        if (campo[x][y].equals("A")){

            aliados++;
            campo[x][y]="V";
            return false;
        }
        if (campo[x][y].equals("E1")){

            enemigosTipo1++;
            campo[x][y]="X";
            return false;
        }
        if (campo[x][y].equals("E2")){

            enemigosTipo2++;
            campo[x][y]="XX";
            return false;
        }

        if (campo[x][y].equals("??") || campo[x][y].equals("+") || campo[x][y].equals("V")
                || campo[x][y].equals("X") || campo[x][y].equals("XX")){
            return false;
        }

        campo[x][y]="+";

        boolean result;

        result= movimiento(x, y+1); //MOVIMIENTO DERECHA
        result= movimiento(x+1, y); //MOVIMIENTO ARRIBA
        result= movimiento(x-1, y); //MOVIMIENTO ABAJO
        result= movimiento(x, y-1); //MOVIMIENTO IZQUIERDA

        campo[x][y]="??";
        return false;
    }

    public static void imprimir(int i, int j) {  

        if(campo.length-1==i){
            if(campo[0].length-1==j){
                System.out.println(campo[i][j] + "\n");
            }else {
                System.out.print(campo[i][j]+" ");
                imprimir(i,j+1);
            }
        }
        else {
            if(campo[0].length-1==j){
                System.out.println(campo[i][j]+" ");
                imprimir(i+1,0);
            }else {
                System.out.print(campo[i][j]+" ");
                imprimir(i,j+1);
            }
        }
    }
}
```
