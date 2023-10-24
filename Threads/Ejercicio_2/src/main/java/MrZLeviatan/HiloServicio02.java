package MrZLeviatan;

public class HiloServicio02 extends Thread {

    int numero = (int) (Math.random()*10+1);


    HiloServicio02(String nombre){

        super(nombre);
    }


    public void run(){

        System.out.println(" // "+getName() + " Ah iniciado // \n");

        try{

            for (int i = 1; i < 10; i++) {

                int contador = (int) Math.pow(numero,i);
                System.out.println("El numero es: "+ numero + " y la sumatoria va por: " + contador);
                Thread.sleep(1500);

            }

            System.out.println( "\n // "+getName() + " Ah Finalizado // ");

        }catch (Exception ex){}
    }

}