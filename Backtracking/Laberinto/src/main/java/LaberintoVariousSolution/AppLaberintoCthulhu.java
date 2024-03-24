package LaberintoVariousSolution;

import java.util.ArrayList;
import java.util.List;


/**
 * SE CREA LA CLASE DEL LABERINTO.
 */
public class AppLaberintoCthulhu {


    /**
     * SE CREA UNA MATRIZ DE CARACTERES LA CUAL REFLEJA EL LABERINTO.
     */
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


    /**
     * MÉTODO PARA VOLVER LA CLASE EJECUTABLE.
     */
    public static void main(String[] args) {

        System.out.println("""
       
                        -- Laberinto De Cthulhu --    
                """);
        AppLaberintoCthulhu m = new AppLaberintoCthulhu();  // Se inicializa el laberinto.
        m.laberinto[0][1] = 'X';                            //  Se pone las coordenadas de salida.
        m.resuelve(4, 5);                             //  Se pone las coordenadas de inicio.
        m.imprimirSolutions();                              //  Se imprime la solución del laberinto.
    }


    /**
     * MÉTODO SOLUCIONADOR DEL LABERINTO.
     */
    public void resuelve(int x, int y) {
        movimientos(x, y);                  //   Intenta solucionar en las coordenadas antes puestas.
        laberinto[x][y]='S';                //   Se introduce la entrada en el Laberinto.

    }


    /**
     * MÉTODO SIMULADOR DE MOVIMIENTOS EN EL LABERINTO.
     */
    private boolean movimientos(int x, int y) {

        if (y > laberinto[0].length - 1 || y < 0 || x < 0 || x > laberinto.length - 1) {    // Verificar y evita el desborde.
            return false;
        }

        if (laberinto[x][y] == 'X') {                                               // Ya encontrado 'X' para dar fin a la solución y guardarla en una copia.
            char[][] copia = new char[laberinto.length][laberinto[0].length];
            char[][] solution = copiaLaberinto(0, copia);
            soluciones.add(solution);
            return true;
        }


        if (laberinto[x][y] == '#' || laberinto[x][y] == '^' || laberinto[x][y] == 'F') {  // Los símbolos representan las paredes o caminos ya recorridos.
            return false;
        }

        int numRows = laberinto.length;
        int numCols = laberinto[0].length;

        laberinto[x][y] = '^'; // Se marca la posición como recorrida.

        // Se verifican los límites antes del movimiento.

        if (x >= 0 && x < numRows && y + 1 >= 0 && y + 1 < numCols) {   // Verificar si se puede mover a la derecha.
            movimientos(x, y + 1);
        }

        if (x - 1 >= 0 && x - 1 < numRows && y >= 0 && y < numCols) {   // Verificar si se puede mover arriba.
            movimientos(x - 1, y);
        }


        if (x >= 0 && x < numRows && y - 1 >= 0 && y - 1 < numCols) {   // Verificar si se puede mover a la izquierda.
            movimientos(x, y - 1);
        }

        if (x + 1 >= 0 && x + 1 < numRows && y >= 0 && y < numCols) {   // Verificar si se puede mover abajo.
            movimientos(x + 1, y);
        }

        laberinto[x][y] = '0';      //  Marca el camino ya recorrido.
        return false;
    }



    /**
     * MÉTODO PARA GUARDAR LA SOLUCIÓN Y PODER IMPRIMIRLA.
     */
    private char[][] copiaLaberinto ( int i, char[][] copia){

            if (i == laberinto.length) {
                return copia;

            } else {
                System.arraycopy(laberinto[i], 0, copia[i], 0, laberinto[i].length);
                return copiaLaberinto(i + 1, copia);
            }
    }


    /**
     * MÉTODOS QUE IMPRIMEN LAS SOLUCIONES GUARDADAS.
     */
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
