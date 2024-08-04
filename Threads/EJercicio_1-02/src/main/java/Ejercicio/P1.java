package Ejercicio;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class P1 extends Thread{

    private ArrayList<Character> vocales = new ArrayList<>();
    private Tuberia tuberia;


    public P1 ( ArrayList<Character> c, Tuberia t ){
        vocales = sacarVocales(c);
        tuberia = t;
    }

    public P1 (){ }

    public ArrayList<Character> sacarVocales (ArrayList<Character> c){

        return (ArrayList<Character>) c.stream().filter(character -> character.equals('a')||character.equals('e')||
                character.equals('i')||character.equals('o')||character.equals('u')).collect(Collectors.toList());
    }

    public void run(){
        char d;

        while (true){

            d = vocales.get((int)(Math.random()*5));
            tuberia.lanzar(d);

            System.out.println("Lanza la vocal "+d+ " a la hp tuberia");

            try {

                sleep(100);

            }catch (InterruptedException e){

                System.out.println(e);

            }
        }

    }

}
