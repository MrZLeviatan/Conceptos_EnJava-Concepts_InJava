package Ejercicio_02;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {


        ArrayList<Integer> números = new ArrayList<Integer>();

        números.addFirst(2);
        números.add(5);
        números.add(6);
        números.add(1,3);
        números.add(2,4);
        números.ensureCapacity(20);

        System.out.println(números);

    }
}