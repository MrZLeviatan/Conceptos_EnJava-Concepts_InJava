/**
 * SE CREA LA CLASE DE LA Cárcel.
 */
public class AppCarcel {


    /**
     * MATRIZ DE CARACTERES REFERENCIANDO A LA CÁRCEL.
     */
    public static char[][] cárcel ={

                {' ', 'P', 'X', ' ', 'P', 'P', ' ', 'P'},
                {' ', 'P', 'P', ' ', 'P', 'P', ' ', 'P'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'P', ' ', 'P', 'P', ' ', 'P', 'P', ' '},
                {'P', ' ', 'X', 'P', ' ', 'P', 'P', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'P', 'P', 'P', ' ', 'P', 'P', ' ', 'P'},

    };

    public static int presosEncontrados;    // Contador de los presos hallados.


    /**
     * MÉTODO PARA VOLVER EJECUTABLE LA CLASE.
     */
    public static void main(String[] args) {

        System.out.println("""
       
                        -- PRISIÓN BELL RAVE  --    
                """);

        AppCarcel m = new AppCarcel();   //  Se inicializa la cárcel.
        final int totalPresos = 26;
        presosEncontrados = 0;
        m.cárcel[5][7] = 'C';
        m.resuelve(0, 0);
        imprimir(0,0);
        System.out.println("La cantidad de presos encontrados en la cárcel es de: "+ presosEncontrados + " presos.");
        int presosFaltantes = totalPresos-presosEncontrados;
        System.out.println("Escaparon " + presosFaltantes + " presos de la cárcel");
    }


    /**
     * MÉTODO QUE INICIA LA EXPLORACIÓN DE LA CÁRCEL.
     */
    public void resuelve(int x, int y){
        movimiento(x, y);
        cárcel[x][y]='S';
    }


    /**
     * MÉTODO QUE INICIA LOS MOVIMIENTOS.
     */
    private boolean movimiento(int x, int y) {

        if(!esPasoValido(x, y)){    //PARA QUE NO SE DESBORDE DE LA MATRIZ
            return false;
        }

        if (cárcel[x][y]=='C') {    //SI SE ENCUENTRA LA C, SE VUELVE A EMPEZAR

            imprimir(0,0);
            return true;
        }

        if (cárcel[x][y]=='P') {    //SI SE ENCUENTRA LA 'P', UN PRESO FUE ENCONTRADO Y SE SUMA EL CONTADOR, Y CAMBIA LA 'P' CON LA 'V'

            presosEncontrados++;
            cárcel[x][y]='V';
            return false;
        }

        if (cárcel[x][y]=='X') {    //SI SE ENCUENTRA LA 'X', SE HALLA UNA PARED Y DEVUELVE LOS MOVIMIENTOS
            return false;
        }

        if (cárcel[x][y]=='^' || cárcel[x][y]=='+' || cárcel[x][y]=='V') {  //LITERALMENTE LO MAS IMPORTANTE, HACE QUE NO MANDE ERROR AL ENCONTRAR ALGO YA ANALIZADO
            return false;
        }

            cárcel[x][y]='^';   //DONDE PISE, CAMBIA

            boolean result;

            result= movimiento(x, y+1); //MOVIMIENTO DERECHA
            result= movimiento(x+1, y); //MOVIMIENTO ARRIBA
            result= movimiento(x-1, y); //MOVIMIENTO ABAJO
            result= movimiento(x, y-1); //MOVIMIENTO IZQUIERDA

            cárcel[x][y]='+';   //SI VUELVE A PASAR, MARCA CON '+'
            return false;
    }


    /**
     * VERIFICA LOS PASOS.
     */
    private boolean esPasoValido(int x, int y) {

        if(x >= 0 && x <= cárcel.length-1 && y >= 0 && y<= cárcel[x].length-1){ //PARA QUE NO SE DESBORDE DE LA MATRIZ
            return true;
        }else{
            return false;
        }
    }


    /**
     * MÉTODO PARA IMPRIMIR LAS SOLUCIONES.
     */
    public static void imprimir(int i, int j) {

        if(cárcel.length-1==i){
            if(cárcel[0].length-1==j){
                System.out.println(cárcel[i][j] + "\n");
            }else {
                System.out.print(cárcel[i][j]+" ");
                imprimir(i,j+1);
            }
        }
        else {
            if(cárcel[0].length-1==j){
                System.out.println(cárcel[i][j]+" ");
                imprimir(i+1,0);
            }else {
                System.out.print(cárcel[i][j]+" ");
                imprimir(i,j+1);
            }
        }

    }
}
