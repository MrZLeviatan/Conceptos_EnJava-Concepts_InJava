package MrZLeviatan;

public class App02 {

    public static void main(String[] args) throws InterruptedException {

        HiloServicio01 hiloServicio01 = new HiloServicio01("Hilo 1");
        HiloServicio02 hiloServicio02 = new HiloServicio02("Hilo 2");
        HiloServicio03 hiloServicio03 = new HiloServicio03("Hilo 3");


        hiloServicio01.start();

        hiloServicio01.join();

        hiloServicio02.start();

        hiloServicio02.join();

        hiloServicio03.start();

        hiloServicio03.join();

    }
}
