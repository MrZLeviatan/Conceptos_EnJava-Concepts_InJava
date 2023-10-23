package MrLeviatan;

public class HiloServicio01 extends Thread {


    String[] nombres = {"esto", "es", "un", "mensaje", "de", "un", "array"};

    public HiloServicio01() {

        this.nombres = nombres;
        start();

    }

    @Override
    public void run() {

        try {

            for (int i = 0; i < nombres.length; i++) {
                System.out.println(nombres[i]);
                Thread.sleep(1000);
            }

            System.out.println(" // HiloServicio 1 ah finalizado //");

        } catch (Exception e) { }

    }
}

