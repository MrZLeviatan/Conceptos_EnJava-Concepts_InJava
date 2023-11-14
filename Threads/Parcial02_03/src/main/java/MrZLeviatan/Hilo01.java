package MrZLeviatan;

import java.util.ArrayList;

public class Hilo01 extends Thread {



    int [][]m;

    Hilo01(int [][]n ,String nombre) {

        m=n;

    }


    public int recorrerMatriz(int [][]m){

        int numeroMenor = m[0][0];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {

                if (numeroMenor > m[i][j]){
                    numeroMenor = m[i][j];

                }

            }

        }

        return numeroMenor;

    }


    public int recorrer(int [][]m, int i, int j){


        int numeroMenor= m[0][0];

        if (i!=m.length-1 || j!=m[i].length-1){


            if(j==m[i].length-1){

                i++;
                j=0;

            }else{
                j++;
            }

            if (numeroMenor > m[i][j]) {
                numeroMenor = m[i][j];

            }
            recorrer(m,i,j);
        }

        return numeroMenor;

    }




    public void run(){

        System.out.println(" Hilo 1 Ah Iniciado // \n");

        try{

            System.out.println(" El numero menor es " + recorrerMatriz(m));

            System.out.println(" EL numero es "+ recorrer(m,0,0));

        }catch (Exception e){

        }

        System.out.println(" Hilo 1 ah finalizado");


    }
}
