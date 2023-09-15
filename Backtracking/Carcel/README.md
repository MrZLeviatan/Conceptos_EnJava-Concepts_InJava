# _Recorrer Carcel_
Recorrer una carcel hecha por matriz donde se encontraran presos; La idea es contar los presos y saber cuantos faltan dentro de la carcel.

## _Problematica Backtracking:_
Implementar un algoritmo usando backtracking que permita solucionar el siguiente problema:  Una cárcel de una ciudad se puede representar en forma de matriz carcel[i][j], tener en cuenta:
- Carcel[i][j]=P significa que hay un preso
- Carcel[i][j]= “X” significa que no hay preso
- Carcel[i][j]= “”(vacío) significa que es un pasillo
- Desarrolle una aplicación que permita obtener si faltan presos en una cárcel, para esto el guarda de seguridad debe recorrer toda la cárcel contando cuántos presos encontró.
- Dejar una marca en la posición[i][j] por donde va pasando el guarda.
- En total deben de haber 26 presos. Al final del recorrido por toda la cárcel. Debe indicar si se escaparon presos y cuántos. En caso contrario solo indicar que no se ha escapado ningún preso.
- El guarda debe arrancar en la posición S (0, 0) y terminar en un punto de control en la posición C (#, #) definidas por parámetro. El patrón de movimiento a utilizar es:, derecha, abajo, arriba, izquierda. Debe tener en cuenta que no se puede salir de la cárcel. Lo azul son los índices filas y columnas no son valores de la matriz

------
## _Tool_

- Java 17
- Maven
- IDE Intellij

# _Class:_

## _AppCarcel_
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