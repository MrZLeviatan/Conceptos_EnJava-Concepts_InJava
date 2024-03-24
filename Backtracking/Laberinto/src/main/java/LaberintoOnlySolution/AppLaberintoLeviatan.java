package LaberintoOnlySolution;

import java.util.ArrayList;
import java.util.List;


/**
 * SE CREA LA CLASE DEL LABERINTO.
 */
public class AppLaberintoLeviatan {


    /**
     * SE CREA UNA MATRIZ DE CARACTERES LA CUAL REFLEJA EL LABERINTO.
     */
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


    /**
     * MÉTODO PARA VOLVER LA CLASE EJECUTABLE.
     */
    public static void main (String[] args){

        System.out.println("""
       
                        -- Laberinto De Leviatan --    
                """);
        AppLaberintoLeviatan m = new AppLaberintoLeviatan();  //  Se Inicializa el laberinto.
        m.laberinto[8][1]= 'X';                               //  Se pone las coordenadas de salida.
        m.resuelve(1,1);                                //  Se pone las coordenadas de inicio.
        System.out.println(m.imprimirLaberinto(0,0));   //  Se imprime la solución del laberinto.


    }

    /**
     * MÉTODO SOLUCIONADOR DEL LABERINTO.
     */
    public  void resuelve (int x, int y){
        if (movimientos(x,y)){                     //   Intenta solucionar en las coordenadas antes puestas.
            laberinto[x][y]='S';                   //   Se introduce la entrada en el Laberinto.
        }

    }


    /**
     * MÉTODO SIMULADOR DE MOVIMIENTOS EN EL LABERINTO.
     */
    private boolean movimientos(int x, int y){

        if (laberinto[x][y] == 'X'){                // Ya encontrado 'X' para dar fin a la solución.
            return true;
        }

        if (laberinto [x][y] == '#' || laberinto[x][y] == '^' || laberinto [x][y] == '0'){    // Los símbolos representan las paredes o caminos ya recorridos.
            return false;
        }

        laberinto[x][y] = '^';      //  Marca el paso.

        boolean result;

        result= movimientos(x-1,y); // Movimiento arriba.
        if (result) return true;

        result= movimientos(x, y-1);    // Movimiento izquierdo.
        if (result) return true;

        result= movimientos(x,y+1);     //  Movimiento derecha.
        if (result) return true;

        result= movimientos(x+1, y);    //  Movimiento abajo.
        if (result) return true;


        laberinto[x][y] = '0';  // Camino ya recorrido marcado con el 0.
        return false;
    }


    /**
     * MÉTODO RECURSIVO PARA IMPRIMIR LA SOLUCIÓN DEL LABERINTO.
     */
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
