package LaberintoOnlySolution;

import java.util.ArrayList;
import java.util.List;

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

        System.out.println("""
       
                        -- Laberinto De Leviatan --    
                """);
        AppLaberintoLeviatan m = new AppLaberintoLeviatan();  //Se Inicializa
        m.laberinto[8][1]= 'X';                               //Se pone las coordenadas de salida
        m.resuelve(1,1);                               //Se pone las coordenadas de inicio
        System.out.println(m.imprimirLaberinto(0,0));  //Se imprime la solucion del laberinto


    }

    public  void resuelve (int x, int y){
        if (movimientos(x,y)){                                 //Intenta solucionar en las coordenadas antes puestas
            laberinto[x][y]='S';                        //Se introduce la entrada en el Laberinto
        }

    }

    private boolean movimientos(int x, int y){

        if (laberinto[x][y] == 'X'){                //Ya encontrado 'X' para dar fin a la solucion
            return true;
        }

        if (laberinto [x][y] == '#' || laberinto[x][y] == '^' || laberinto [x][y] == '0'){  //ENCONTRADO UNO ESTOS SIMBOLOS SIGNIFICA QUE ENCONTRO UNA PARED O CAMINO YA RECORRIDO
            return false;
        }

        laberinto[x][y] = '^';      //MARCA DONDE PASA

        boolean result;

        result= movimientos(x-1,y); //MOVIMIENTO ABAJO
        if (result) return true;

        result= movimientos(x, y-1);    //MOVIMIENTO IZQUIERDA
        if (result) return true;

        result= movimientos(x,y+1);     //MOVIMIENTO DERECHA
        if (result) return true;

        result= movimientos(x+1, y);    //MOVIMIENTO ARRIBA
        if (result) return true;


        laberinto[x][y] = '0';  //SI VUELVE A PASAR MARCA CON '0'
        return false;
    }

    //METODO PARA IMPRIMIR EL LABERINTO
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
