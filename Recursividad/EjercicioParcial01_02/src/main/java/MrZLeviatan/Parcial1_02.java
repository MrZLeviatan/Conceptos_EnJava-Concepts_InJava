package MrZLeviatan;

import java.util.ArrayList;

public class Parcial1_02 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println(" --EJERCICIO PARCIAL 01.02-- ");

        ArrayList listaNumero = new ArrayList();

        int[][] m = {

                {454,1010,4141,4444,234},
                {100,2163,5456,222,444},
                {1001,0,99,111,5654},
                {13,89,6,112,555}
        };

        System.out.println("");
        recorrerMatrizRetrocediendoInicio(m,m.length-1,0,listaNumero);
        System.out.println("\n \nARRAYLIST NUMERO CON SUMATORIA MAYORES A 10 : " + listaNumero);
    }

    public static void recorrerMatrizRetrocediendoInicio ( int [][]m,int i, int j, ArrayList listaNumero){
        System.out.print(m[i][j]);
        int edad = m[i][j];
        if (i!= 0 || j != m[i].length-1){
            if (j == m[i].length-1){
                if (sumaCifras(edad) > 10)
                    listaNumero.add(edad);
                i--;
                j = 0;
                System.out.println(" ");
            }else{
                if (sumaCifras(edad) >10)
                    listaNumero.add(edad);
                j++;
                System.out.print(" ");
            }
            recorrerMatrizRetrocediendoInicio(m,i,j,listaNumero);
        }
    }

    public static int sumaCifras (int n){
        if(n<10){
            return n;
        }else {
            return (n % 10) + sumaCifras(n /10);
        }
    }
}
