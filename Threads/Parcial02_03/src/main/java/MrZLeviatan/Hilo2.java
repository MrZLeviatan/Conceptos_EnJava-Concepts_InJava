package MrZLeviatan;

public class Hilo2 extends Thread {

    int[][] n;

    Hilo2(int[][] m, String nombre) {

        n = m;
    }

    public int recorrerMatriz(int[][] m) {

        int promedio=0;
        int totalElemento=0;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {

                promedio += m[i][j];
                totalElemento ++;
            }

        }

        return promedio/totalElemento;
}




    public void run(){

        System.out.println(" \n Hilo 2 Ah Iniciado // \n");

        try{

            System.out.println(" El promedio es " + recorrerMatriz(n));

        }catch (Exception e){

        }

        System.out.println(" \n El hilo 2 ah finalizado");
    }

    }


