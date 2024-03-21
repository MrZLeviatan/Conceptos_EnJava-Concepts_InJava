package MrZLeviatan;

import MrZLeviatan.Model.Diario;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {


    public static void main(String[] args) {


        ArrayList<Diario> diarios= new ArrayList<>();


        Diario usuario1 =new Diario("Maria");
        Diario usuario2 = new Diario("Juana");
        Diario usuario3 = new Diario("Carlos");

        diarios.add(usuario1);
        diarios.add(usuario2);
        diarios.add(usuario3);


        System.out.println(" ___ Recorrer Mediante Iterator ___ ");

        /***
         *  Iterator es un patron de diseño de comportamiento que permite
         *  el recorrido secuencial por una estructura de datos compleja sin
         *  exponer sus detalles internos.
         */


        Iterator iteratorDiario = diarios.iterator();

        while (iteratorDiario.hasNext()){

            Diario diarioActual =(Diario)iteratorDiario.next();
            System.out.println("El diario actual es de: " + diarioActual.getName());

        }
    }
}