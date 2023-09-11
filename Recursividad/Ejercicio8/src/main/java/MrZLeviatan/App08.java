package MrZLeviatan;

public class App08 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println(" --EJERCICIO 8-- ");

        int [][] m = {


                //Columnas

                {1,2,3},
                {4,5,6},       //Filas
                {7,8,9}           // 1  4 2  7
        };

        System.out.println("");
        System.out.println("Recorrerla por Filas:  ");
        recorrerMatriz(m,0,0);

        System.out.println("");
        System.out.println("Recorrerla por Filas empezando al final: ");
        recorrerMatrizUltimo(m,0,m[0].length-1);


        System.out.println("");
        System.out.println("Recorrerla por Filas inversa: ");
        recorrerMatrizRetrocediendoFinal(m,m.length-1,m[0].length-1);

        System.out.println("");
        System.out.println("Recorrerla por Filas inversa empezando al inicio: ");
        recorrerMatrizRetrocediendoInicio(m,m.length-1,0);

        System.out.println("");
        System.out.println("Recorrerla por Columnas: ");
        recorrerMatrizAnormal(m,0,0);

        System.out.println("");
        System.out.println("Recorrerla por Columnas empezando al final: ");
        recorrerMatrizAnormalUltimo(m,m.length-1,0);

        System.out.println("");
        System.out.println("Recorrerla por Columnas inversa: ");
        recorrerMatrizAnormalRetrocediendoFinal(m,m.length-1,m[0].length-1);

        System.out.println("");
        System.out.println("Recorrerla por Columnas inversa empezando al inicio: ");
        recorrerMatrizAnormalRetrocediendoInicio(m,0,m[0].length-1);

        System.out.println("");
        System.out.println(" Diagonal: ");
        filas(m,0);

    }

    public static void recorrerMatriz(int [][]m, int i, int j){

        System.out.print(m[i][j]);

        if (i!=m.length-1 || j!=m[i].length-1){

            if(j==m[i].length-1){
                i++;
                j=0;
                System.out.println(" ");
            }else{
                j++;
                System.out.print(" ");
            }
            recorrerMatriz(m,i,j);
        }
    }

    public static void recorrerMatrizUltimo(int [][]m, int i, int j){

        System.out.print(m[i][j]);

        if (i != m.length-1 || j != 0){

            if (j==0){
                i++;
                j=m[0].length-1;
                System.out.println(" ");
            }else{
                j--;
                System.out.print(" ");
            }
            recorrerMatrizUltimo(m,i,j);
        }
    }

    public static void recorrerMatrizRetrocediendoFinal(int [][]m, int i, int j){

        System.out.print(m[i][j]);

        if (i != 0 || j != 0){

            if(j == 0){
                i--;
                j = m[0].length-1;
                System.out.println(" ");
                recorrerMatrizRetrocediendoFinal(m,i,j);
            }else{
                j--;
                System.out.print(" ");
                recorrerMatrizRetrocediendoFinal(m,i,j);
            }
        }
    }

    public static void recorrerMatrizRetrocediendoInicio ( int [][]m,int i, int j){
        System.out.print(m[i][j]);

        if (i!= 0 || j != m[0].length-1){

            if (j == m[0].length-1){
                i--;
                j = 0;
                System.out.println(" ");

            }else{
                j++;
                System.out.print(" ");

            }
            recorrerMatrizRetrocediendoInicio(m,i,j);
        }
    }


    public static void recorrerMatrizAnormal(int [][]m, int i, int j){

        System.out.print(m[i][j]);

        if (i!=m.length-1 || j!=m[i].length-1){

            if(i == m.length-1){
                i=0;
                System.out.println(" ");
                recorrerMatrizAnormal(m,i,j+1);
            }else{
                i++;
                System.out.print(" ");
                recorrerMatrizAnormal(m,i,j);
            }
        }
    }

    public static void recorrerMatrizAnormalUltimo (int [][]m,int i, int j){

        System.out.print(m[i][j]);

        if( i != 0 || j != m[0].length-1){

            if(i == 0){
                i= m.length-1;
                j++;
                System.out.println(" ");

            }else{
                i--;
                System.out.print(" ");

            }
            recorrerMatrizAnormalUltimo(m,i,j);
        }
    }

    public static void recorrerMatrizAnormalRetrocediendoFinal (int [][]m,int i, int j){
        System.out.print(m[i][j]);

        if ( i != 0 || j !=0){

            if (i==0) {
                i = m.length - 1;
                j--;
                System.out.println(" ");
            }else{
                i--;
                System.out.print(" ");
            }
            recorrerMatrizAnormalRetrocediendoFinal(m,i,j);
        }
    }

    public static void recorrerMatrizAnormalRetrocediendoInicio (int [][]m,int i, int j){
        System.out.print(m[i][j]);

        if (i != m.length-1 || j != 0){

            if(i==m.length-1){
                i=0;
                j--;
                System.out.println(" ");
                recorrerMatrizAnormalRetrocediendoInicio(m,i,j);
            }else {
                i++;
                System.out.print(" ");
                recorrerMatrizAnormalRetrocediendoInicio(m,i,j);
            }
        }
    }

    public static void filas(int [][] matriz,int i){
        if(i==matriz.length-1){
            diagonal(matriz,i,0);
        }else {
            diagonal(matriz,i,0);
            filas(matriz,i+1);

        }
    }

    public static void diagonal(int [][] matriz,int i, int j){
        if(i==0){
            System.out.println(matriz[i][j]);
        }else {
            System.out.println(matriz[i][j]);
            diagonal(matriz,i-1,j+1);
        }
    }

        }




