package mrzleviatan.ejercicio_102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P4 extends Thread{

    private ArrayList<Character> especiales = new ArrayList<>();
    private Tuberia tuberia;


    public P4 ( ArrayList<Character> c, Tuberia t ){
        especiales = sacarVocales(c);
        tuberia = t;
    }

    public P4 (){ }

    public ArrayList<Character> sacarVocales (ArrayList<Character> c){

        return (ArrayList<Character>) c.stream().filter(character ->isEspecial(character)).collect(Collectors.toList());
    }

    public static boolean isEspecial(char caracter) {

        ArrayList<Character> numero = new ArrayList<>(Arrays.asList(
                '@', '#', '/', '%', '+', ':', ';'));

        return numero.contains(caracter);
    }


    public void run(){
        char d;

        while (true){

            d = especiales.get((int)(Math.random()*7));
            tuberia.lanzar(d);

            System.out.println(" el hilo 4 Lanza el caracter especial "+d+ " a la  tuberia");

            try {

                sleep(350);

            }catch (InterruptedException e){

                System.out.println(e);

            }
        }
    }
}



