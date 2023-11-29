package mrzleviatan.ejercicio_102;

public class Tuberia {


    private char buffer[] = new char[12];
    private int siguiente = 0;

    private boolean estaLleno = false;
    private boolean estaVacio = true;


    public synchronized char recoger() {

        while (estaVacio) {

            try {

                wait();

            } catch (InterruptedException e) {
            }
        }
        siguiente--;

        if (siguiente == 0)

            estaVacio = true;
        estaLleno = false;
        notify();

        return (buffer[siguiente]);

    }

    public synchronized void lanzar(char c) {

        while (estaLleno == true) {


            try {
                wait();
            } catch (InterruptedException e) {

            }

        }

        buffer[siguiente] = c;
        siguiente ++;

        if (siguiente == 12)
            estaLleno = true;

        estaVacio = false;
        notify();
    }

}
