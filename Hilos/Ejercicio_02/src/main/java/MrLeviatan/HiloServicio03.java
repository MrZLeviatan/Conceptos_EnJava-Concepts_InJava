package MrLeviatan;

public class HiloServicio03 extends Thread{


    public HiloServicio03(){
        start();

    }

    @Override
    public void run(){

        try {

            for (int i = 0; i < 15; i++) {

                System.out.println("HiloServicio 3 en ejecucion");
                Thread.sleep(500);
            }

            System.out.println(" // HiloServicio 3 ah finalizado // ");

        }catch (Exception e){}
    }
}
