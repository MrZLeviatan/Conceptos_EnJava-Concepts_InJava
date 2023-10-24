package MrZLeviatan;


public class HiloServicio01 extends Thread {



    String[] nombres = {"esto", "es", "un", "mensaje", "de", "un", "array"};



    HiloServicio01(String nombre) {

        super(nombre);
    }


    public void run() {

        System.out.println(" // "+getName() + " Ah Iniciado // \n");

        try {

            for (int i = 0; i < nombres.length; i++) {
                System.out.print(nombres[i] + " ");
                Thread.sleep(1000);
            }

            System.out.println("\n //"+ getName() + " Ah Finalizado //");

        } catch (Exception e) { }

    }
}

