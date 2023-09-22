package MrZLeviatan;

public class AppCDG {

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

        if(x >= 0 && x <= campo.length-1 && y >= 0 && y<= campo[x].length-1){ //PARA QUE NO SE DESBORDE DE LA MATRIZ
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

    public static void imprimir(int i, int j) {  //METODO IMPORTANTE PARA IMPRIMIR LAS SOLUCIONES

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