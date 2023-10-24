package MrZLeviatan;

public class HiloServicio03 extends Thread{


    HiloServicio03(String nombre){

        super(nombre);
    }

    public void run(){

        System.out.println(" // "+getName() + " Ah iniciado // \n");

        try {

            for (int i = 0; i < 15; i++) {
                System.out.println(getName() + " Contando ");
                Thread.sleep(500);
            }

            System.out.println(" // " + getName()+ " Ah Finalizado //");

        }catch (Exception e){}
    }
}
