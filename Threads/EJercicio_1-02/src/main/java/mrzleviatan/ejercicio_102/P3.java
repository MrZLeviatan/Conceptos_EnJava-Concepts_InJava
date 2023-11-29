package mrzleviatan.ejercicio_102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P3 extends Thread{

    private ArrayList<Character> numero= new ArrayList<>();
    private Tuberia tuberia;


    public P3 ( ArrayList<Character> c, Tuberia t ){
        numero = sacarVocales(c);
        tuberia = t;
    }

    public P3 (){}

    public ArrayList<Character> sacarVocales (ArrayList<Character> c){

        return (ArrayList<Character>) c.stream().filter(character ->isNumero(character)).collect(Collectors.toList());
    }

    public static boolean isNumero(char caracter) {

        ArrayList<Character> numero = new ArrayList<>(Arrays.asList(
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

        return numero.contains(caracter);
    }


    public void run(){
        char d;

        while (true){

            d = numero.get((int)(Math.random()*10));
            tuberia.lanzar(d);

            System.out.println("Lanza el numero "+d+ " a la hp tuberia");

            try {

                sleep(250);

            }catch (InterruptedException e){

                System.out.println(e);

            }
        }
    }
}
