package MrZLeviatan;

public class AppParqueadero {

    public static String[][] parqueadero= {

            {"L"," ","L","C","R1","L"," "},
            {"L"," ","L","C"," ","L", " "},
            {" "," "," ","C"," "," ", " "},
            {"C"," "," ","C","I","I", " "},      // L ESPACIO LIBRE
            {"C"," "," "," "," ","L", " "},      // C CARRO EN ESE ESPACIO
            {"C"," ","C"," "," ","L", " "},      // R ESPACIO RESERVADO
            {"C"," ","C"," ","C","C", " "},      // I ESPACIO DE DISCAPACITADOS
            {" "," ","C"," "," "," ", " "},      // R1 Y R2 LUGAR PARA PARQUEAR
            {"C"," ","C"," ","C"," ", "C"},
            {"C"," ","R"," ","C"," ", "R"},
            {" "," ","R"," ","C","C", "R"},
            {" "," ","R"," "," "," ","R2"},


    };

    public static void main(String[] args) {
        System.out.println("""
       
                        -- PARQUEADERO LA CHINGADA  --    
                """);
        AppParqueadero m= new AppParqueadero();
        m.resuelve(11,0);
        imprimir(0,0);
        System.out.println("FIN DEL PROGRAMA");
    }

    public void resuelve(int x, int y){
        movimiento(x, y);
        parqueadero[x][y]="S";

    }

    private boolean esPasoValido(int x, int y) {

        if(x >= 0 && x <= parqueadero.length-1 && y >= 0 && y<= parqueadero[x].length-1){ //PARA QUE NO SE DESBORDE DE LA MATRIZ
            return true;
        }else{
            return false;
        }
    }

    public boolean movimiento (int x, int y){
        if(!esPasoValido(x, y)){    //PARA QUE NO SE DESBORDE DE LA MATRIZ
            return false;
        }

        if (parqueadero[x][y].equals("R1")){
            parqueadero[x][y] = "//";
            imprimir (0,0);
            System.out.println(" --- SE PARQUEO EL PRIMER CARRO ---");
            System.out.println("");
            return true;
        }

        if (parqueadero[x][y].equals("R2")){
            parqueadero[x][y] = "//";
            imprimir(0,0);
            System.out.println(" --- SE PARQUEO EL SEGUNDO CARRO ---");
            System.out.println("");
            return true;
        }

        if (parqueadero[x][y].equals("L") || parqueadero[x][y].equals("C") || parqueadero[x][y].equals("R")
                || parqueadero[x][y].equals("I")){
            return false;
        }
        if (parqueadero[x][y].equals("/") || parqueadero[x][y].equals("+")){
            return false;
        }

        parqueadero[x][y]="+";   //DONDE PISE, CAMBIA

        boolean result;

        result= movimiento(x, y+1); //MOVIMIENTO DERECHA
        result= movimiento(x+1, y); //MOVIMIENTO ARRIBA
        result= movimiento(x-1, y); //MOVIMIENTO ABAJO
        result= movimiento(x, y-1); //MOVIMIENTO IZQUIERDA

        parqueadero[x][y]=" ";  //SE BORRA EL CAMINO DONDE SE PASO
        return false;

    }

    public static void imprimir(int i, int j) {  //METODO IMPORTANTE PARA IMPRIMIR LAS SOLUCIONES

        if(parqueadero.length-1==i){
            if(parqueadero[0].length-1==j){
                System.out.println(parqueadero[i][j] + "\n");
            }else {
                System.out.print(parqueadero[i][j]+" ");
                imprimir(i,j+1);
            }
        }
        else {
            if(parqueadero[0].length-1==j){
                System.out.println(parqueadero[i][j]+" ");
                imprimir(i+1,0);
            }else {
                System.out.print(parqueadero[i][j]+" ");
                imprimir(i,j+1);
            }
        }

    }
}