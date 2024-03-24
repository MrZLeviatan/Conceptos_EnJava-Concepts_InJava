package MrZLeviatan;


/**
 * SE CREA LA CLASE DE LA CÁRCEL.
 */
public class AppCDG {


    /**
     * SE CREA UNA MATRIZ DE STRING LA CUAL REFLEJA LA CÁRCEL.
     */
    public static String[][] campo = {

            {"CA", "E1","A","CA","A","CA","CA","CA","E1"},
            {"CA", "E1","E2","CA","A","E1","CA","E1","CA"},         // A ALIADOS
            {"CA", "CA","CA","CA","CA","CA","CA","CA","CA"},        // E1 ENEMIGOS TIPO 1
            {"E1", "CA","E1","A","CA","E1","A","CA","CA"},          // E2 ENEMIGOS TIPO 2
            {"A", "CA","A","CA","CA","E2","E1","CA","E2"},          // CA CAMINO LIBRE
            {"CA","CA","CA","CA","CA","CA","CA","CA","CA"},         // ?? CAMINO YA RECORRIDO
            {"CA","A","E1","CA","E1","A","CA","A","CA"},
            {"CA","E2","CA","CA","CA","E1","CA","CA","CA"},
            {"CA","CA","CA","A","CA","CA","CA","E2","CA"}

    };


    /**
     * SE CREAN LOS PARÁMETROS CONTADORES.
     */
    public static int enemigosTipo1;
    public static int enemigosTipo2;
    public static int aliados;



    /**
     * MÉTODO PARA VOLVER LA CLASE EJECUTABLE.
     */
    public static void main(String[] args) {

        System.out.println("""
       
                        -- CDG  --    
                """);
        AppCDG m = new AppCDG();                // Inicializa la cárcel.
        enemigosTipo1 = 0;                      // Inicializa los parámetros.
        enemigosTipo2= 0;
        aliados = 0;
        m.campo[5][7]="G";                      //  Se pone las coordenadas de salida.
        m.resuelve(0,7);                  //  Se pone las coordenadas de inicio.
        imprimir(0,0);                     //  Se llama el método de imprimir.
        System.out.println("La cantidad de enemigos eliminados tipo1 es de: "
                + enemigosTipo1 + " y de tipo2 es de: " + enemigosTipo2);

        System.out.println("La cantidad de aliados encontrados: " + aliados);
    }


    /**
     * MÉTODO SOLUCIONADOR DEL LABERINTO.
     */
    public void resuelve(int x, int y){
        movimiento(x, y);                       //  Intenta solucionar en las coordenadas antes puestas.
        campo[x][y]="S";                        //  Se introduce la entrada en el Laberinto.
    }


    /**
     * MÉTODO VERIFICADOR DEL PASO VALIDO.
     */
    private boolean esPasoValido(int x, int y) {

        if(x >= 0 && x <= campo.length-1 && y >= 0 && y<= campo[x].length-1){   //  Verificador del desborde.
            return true;
        }else{
            return false;
        }
    }


    /**
     * MÉTODO SIMULADOR DE MOVIMIENTOS EN EL LABERINTO.
     */
    public boolean movimiento(int x, int y){

        if (!esPasoValido(x,y)){                //  Llama al método de verificación.
            return false;
        }

        if (campo[x][y].equals("G")){           //  Pone la salida del campo.
            imprimir(0,0);
            return true;
        }

        if (campo[x][y].equals("A")){           // Verificador si encuentra un aliado realiza los métodos.

            aliados++;
            campo[x][y]="V";
            return false;
        }
        if (campo[x][y].equals("E1")){          // Verificador si encuentra un enemigo 1 realiza los métodos.

            enemigosTipo1++;
            campo[x][y]="X";
            return false;
        }
        if (campo[x][y].equals("E2")){          // Verificador si encuentra un enemigo 2 realiza los métodos.

            enemigosTipo2++;
            campo[x][y]="XX";
            return false;
        }

        if (campo[x][y].equals("??") || campo[x][y].equals("+") || campo[x][y].equals("V")  //  Verificador de bloqueos del campo.
                || campo[x][y].equals("X") || campo[x][y].equals("XX")){
            return false;
        }

        campo[x][y]="+";

        boolean result;

        result= movimiento(x, y+1);     //  Movimiento derecha.
        result= movimiento(x+1, y);     //  Movimiento abajo.
        result= movimiento(x-1, y);     //  Movimiento arriba.
        result= movimiento(x, y-1);     //  Movimiento izquierda.

        campo[x][y]="??";
        return false;
    }


    /**
     * MÉTODO RECURSIVO PARA IMPRIMIR LAS SOLUCIONES.
     */
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