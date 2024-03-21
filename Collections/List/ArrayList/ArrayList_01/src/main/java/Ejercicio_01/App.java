package Ejercicio_01;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<String> letras = new ArrayList<>();

        letras.addFirst("A");
        letras.add("C");
        letras.add("D");
        letras.add("E");
        letras.add(1,"B");

        /**
         * EnsureCapacity es un método que proporciona espacio para N elementos de manera previa.
         */
        letras.ensureCapacity(20);

        System.out.println(letras);

    }
}