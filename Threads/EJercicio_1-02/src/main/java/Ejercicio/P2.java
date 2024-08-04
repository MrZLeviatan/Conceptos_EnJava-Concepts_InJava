package Ejercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P2 extends Thread{


    private ArrayList<Character> consonantes = new ArrayList<>();
    private Tuberia tuberia;


    public P2 ( ArrayList<Character> c, Tuberia t ){
        consonantes = sacarVocales(c);
        tuberia = t;
    }

    public P2 (){}

    public ArrayList<Character> sacarVocales (ArrayList<Character> c){

        return (ArrayList<Character>) c.stream().filter(character ->isConsonant(character)).collect(Collectors.toList());
    }

    public static boolean isConsonant(char caracter) {

       ArrayList<Character> consonantes = new ArrayList<>(Arrays.asList(
               'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'ñ', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'
       ));

        return consonantes.contains(caracter);
    }


    public void run(){
        char d;

        while (true){

            d = consonantes.get((int)(Math.random()*19));
            tuberia.lanzar(d);

            System.out.println("Lanza la consonante "+d+ " a la hp tuberia");

            try {

                sleep(150);

            }catch (InterruptedException e){

                System.out.println(e);

            }
        }

    }

}

