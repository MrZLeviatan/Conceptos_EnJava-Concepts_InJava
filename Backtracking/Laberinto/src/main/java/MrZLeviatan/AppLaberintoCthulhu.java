package MrZLeviatan;

import java.util.ArrayList;
import java.util.List;

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
        AppLaberintoCthulhu m = new AppLaberintoCthulhu(); //SE INICIALIZA ESTA VAINA LOCA
        m.laberinto[0][1] = 'X';                           //SE COLOCA LAS COORDENADAS DE LA SALIDA
        m.resuelve(4, 5);                           //SE COLOCA LAS COORDENADAS DONDE EMPEZAMOS
        m.imprimirSolutions();                             //SE IMPRIMEN LA/S SOLUCIONES DEL LABERINTO
    }

    public void resuelve(int x, int y) {
        movimientos(x, y);       //SE INTENTA RESOLVER EL LABERINTO EN ESTAS COORDENADAS
        laberinto[x][y]='S';

    }

    private boolean movimientos(int x, int y) {

        if (y > laberinto[0].length - 1 || y < 0 || x < 0 || x > laberinto.length - 1) { //verfica que no se vaya a desbordar
            return false;
        }

        if (laberinto[x][y] == 'X') {                                               //SE ENCUENTRA LA 'X' LO QUE DA INCAPIE AL GUARDADO DE LA POSIBLE SOLUCION
            char[][] copia = new char[laberinto.length][laberinto[0].length];
            char[][] solution = copiaLaberinto(0, copia);
            soluciones.add(solution);
            return true;
        }


        if (laberinto[x][y] == '#' || laberinto[x][y] == '^' || laberinto[x][y] == 'F') {  //SE ENCUENTRA UNA PARED OH UN CAMIDO YA RECORRIDO, LO CUAL HACE QUE EL PROGRAMA VUELVA A INICIAR
            return false;
        }

        int numRows = laberinto.length;
        int numCols = laberinto[0].length;

        laberinto[x][y] = '^'; //SE MARCA LA POSICION COMO VISITADA OH YA PISADO POR HAY

        // SE VERIFICAN LOS LIMITES ANTES DE MOVERSE

        if (x >= 0 && x < numRows && y + 1 >= 0 && y + 1 < numCols) { //VERIFICA SI SE PUEDE MOVERSE A LA DERECHA
            movimientos(x, y + 1);
        }

        if (x - 1 >= 0 && x - 1 < numRows && y >= 0 && y < numCols) { //VERIFICA SI SE PUEDE MOVERSE ARRIBA
            movimientos(x - 1, y);
        }


        if (x >= 0 && x < numRows && y - 1 >= 0 && y - 1 < numCols) { //VERIFICA SI SE PUEDE MOVERSE A LA IZQUIERDA
            movimientos(x, y - 1);
        }

        if (x + 1 >= 0 && x + 1 < numRows && y >= 0 && y < numCols) {  //VERIFICA SI SE PUEDE MOVERSE ABAJO
            movimientos(x + 1, y);
        }

        laberinto[x][y] = '0';      //PROXIMO USO PARA LA CARCEL UWU
        return false;
    }


    //METODO PARA GUARDAR LA SOLUCION Y PODER IMPRIMIRLA
    private char[][] copiaLaberinto ( int i, char[][] copia){

            if (i == laberinto.length) {
                return copia;

            } else {
                System.arraycopy(laberinto[i], 0, copia[i], 0, laberinto[i].length);
                return copiaLaberinto(i + 1, copia);
            }
    }

    // METODOS PARA IMPRIMIR TODAS LAS SOLUCIONES GUAPO
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
