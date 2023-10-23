package MrLeviatan;

public class HiloServicio02 extends Thread {

    int numero = (int) (Math.random()*10+1);

    public HiloServicio02(){

        this.numero = numero;
        start();

    }


    @Override
    public void run(){

        try{

            for (int i = 1; i < 10; i++) {
                int contador = (int) Math.pow(numero,i);
                System.out.println("El numero es: "+ numero + " y la sumatoria va por: " + contador);
                Thread.sleep(1500);

            }

            System.out.println(" // El Servicio del Hilo 2 ah finalizado //");


        }catch (Exception ex){}
    }

}
