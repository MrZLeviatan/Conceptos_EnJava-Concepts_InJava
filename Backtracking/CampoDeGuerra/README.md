# _Juego Campo De Guerra_

Implementar un algoritmo usando backtracking que permita solucionar el siguiente problema: Un campo minado se puede representar en forma de matriz (campoGuerra[i][j]), el objetivo es que un soldado va a caminar por el campo de guerra en la oscuridad, pero el soldado tiene visión nocturna y debe identificar en donde hay enemigos, eliminarlo y contar cuantos enemigos elimina y de qué tipo, además debe contar cuantos aliados encontro también, pero no los va a eliminar. Se debe e ir trazando los caminos hasta un punto de control. Es decir el solado va caminando, a medida que avanza va identificando si encuentra algún enemigo o aliado, si dado el caso llega al punto de control debe imprimir por consola la matriz para evidenciar el camino trazado y luego debe regresar por donde venía para terminar de identificar si hay otros caminos y de igual forma identificar los enemigos y aliados. Se debe tener en cuenta:
- campoGuerra[i][j]= E1 significa que hay un enemigo tipo 1
- campoGuerra[i][j]= E2 significa que hay un enemigo tipo 2
- campoGuerra[i][j]= A significa que hay un aliado
- campoGuerra[i][j]= “CA”(vacío) significa que es un camino
- Dejar una marca “??” en la posición[i][j] por donde va pasando el solado (solo por camino)
- El solado debe arrancar en la posición (0, 7) y terminar en un punto de control en la posición G (5, 8) definidas por parámetro.
- El patrón de movimiento a utilizar es:, izquierda, derecha, abajo, arriba. Debe tener en cuenta que no se puede salir de la matriz campoGuerra. Lo verde son los índices filas y columnas no son valores de la matriz

------
## _Tool_

- Java 17
- Maven
- IDE Intellij

# _Class:_

## _AppCDG_
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
