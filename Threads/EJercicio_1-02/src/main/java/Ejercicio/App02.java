package Ejercicio;


import java.util.ArrayList;


public class App02 {


    public static void main(String[] args){


        String todo = "abcdefghijklmnopqrstuvwxyz0123456789@#/%+:;";
        ArrayList<Character> letras = new ArrayList<>();

        for (int i = 0; i < todo.length(); i++) {
            letras.add(todo.charAt(i));
        }

        Tuberia t = new Tuberia();
        P1 p1= new P1(letras,t);
        P2 p2 = new P2(letras,t);
        P3 p3 = new P3(letras,t);
        P4 p4 = new P4(letras,t);
        Consumer c = new Consumer(t);


        p1.start();
        p2.start();
        p3.start();
        p4.start();
        c.start();

    }
}

