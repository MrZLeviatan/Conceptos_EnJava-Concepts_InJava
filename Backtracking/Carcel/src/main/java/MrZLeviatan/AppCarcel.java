
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

    public static int presosEncontrados;    //CONTADOR PARA HALLAR CUALQUIER COSA

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

        if(!esPasoValido(x, y)){    //PARA QUE NO SE DESBORDE DE LA MATRIZ
            return false;
        }

        if (carcel[x][y]=='C') {    //SI SE ENCUENTRA LA C, SE VUELVE A EMPEZAR

            imprimir(0,0);
            return true;
        }

        if (carcel[x][y]=='P') {    //SI SE ENCUENTRA LA 'P', UN PRESO FUE ENCONTRADO Y SE SUMA EL CONTADOR, Y CAMBIA LA 'P' CON LA 'V'

            presosEncontrados++;
            carcel[x][y]='V';
            return false;
        }

        if (carcel[x][y]=='X') {    //SI SE ENCUENTRA LA 'X', SE HALLA UNA PARED Y DEVUELVE LOS MOVIMIENTOS
            return false;
        }

        if (carcel[x][y]=='^' || carcel[x][y]=='+' || carcel[x][y]=='V') {  //LITERALMENTE LO MAS IMPORTANTE, HACE QUE NO MANDE ERROR AL ENCONTRAR ALGO YA ANALIZADO
            return false;
        }

            carcel[x][y]='^';   //DONDE PISE, CAMBIA

            boolean result;

            result= movimiento(x, y+1); //MOVIMIENTO DERECHA
            result= movimiento(x+1, y); //MOVIMIENTO ARRIBA
            result= movimiento(x-1, y); //MOVIMIENTO ABAJO
            result= movimiento(x, y-1); //MOVIMIENTO IZQUIERDA

            carcel[x][y]='+';   //SI VUELVE A PASAR, MARCA CON '+'
            return false;
    }

    private boolean esPasoValido(int x, int y) {

        if(x >= 0 && x <= carcel.length-1 && y >= 0 && y<= carcel[x].length-1){ //PARA QUE NO SE DESBORDE DE LA MATRIZ
            return true;
        }else{
            return false;
        }
    }

    public static void imprimir(int i, int j) {  //METODO IMPORTANTE PARA IMPRIMIR LAS SOLUCIONES

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
