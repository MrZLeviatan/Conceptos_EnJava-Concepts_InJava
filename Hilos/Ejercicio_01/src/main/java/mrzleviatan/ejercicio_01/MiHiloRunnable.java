package mrzleviatan.ejercicio_01;

public class MiHiloRunnable implements Runnable{

    String nombreHilo;

    MiHiloRunnable(String nombre) {
        nombreHilo = nombre;


    }
    @Override
    public void run() {
        System.out.println("Comenzando "+nombreHilo);
        try {
            for (int contar=0; contar<=50; contar++){
                Thread.sleep(500);
                System.out.println("En "+nombreHilo+", el recuento "+contar);
            }
        }catch (InterruptedException exc){
            System.out.println(nombreHilo + "Interrumpido.");
        }
        System.out.println("Terminando "+nombreHilo);
    }
}

