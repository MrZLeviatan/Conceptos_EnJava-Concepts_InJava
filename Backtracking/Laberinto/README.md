# _Laberinto_
Queremos hallar la solucion oh posibles soluciones de un laberinto hecho por matrices.

## _Problematica Backtracking:_
Optener las mas optimas soluciones para resolver el laberinto compuestos por diferentes componentes
utilizando metodos recursivos y de Backtracking.

------

## _Tool_

- Java 17
- Maven
- IDE Intellij

# _Classes_

## _Class AppLeviatan_

En esta clase se muestra los pasos y metodos Backtracking para mostrar una unica solucion de un laverinto

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