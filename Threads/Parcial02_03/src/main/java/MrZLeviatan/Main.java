package MrZLeviatan;

import javax.swing.plaf.TableHeaderUI;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        int c;

        Thread hilo3;

        int[][] m = {

                {6,2,3},
                {5,4,4},
                {1,7,7},
        };


       Hilo01 hilo01 = new Hilo01( m,"Hilo 1");
       Hilo2 hilo2 = new Hilo2(m,"Hilo 2");



       hilo01.start();

       hilo01.join();

       hilo2.start();

       hilo2.join();



       if (hilo2.recorrerMatriz(m) != 0){

           c = hilo01.recorrerMatriz(m)/ hilo2.recorrerMatriz(m);
           System.out.println( "\n El numero de a/b es = "+c);

       }else{
           System.out.println("b es un 0");
       }

    }
}