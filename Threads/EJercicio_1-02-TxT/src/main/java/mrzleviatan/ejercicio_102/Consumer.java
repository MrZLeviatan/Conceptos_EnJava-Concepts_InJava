package mrzleviatan.ejercicio_102;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Consumer extends Thread {

    private Tuberia tuberia;


    ArrayList<Character> palabra = new ArrayList<>(Arrays.asList(' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '));
    ArrayList<Character> palabrasDeneganas = new ArrayList<>();
    String palabraABuscar = "universid@d#2023%";


    public ArrayList<Character> getPalabrasDeneganas() {return palabrasDeneganas; }


    public boolean verificarPosiciones (int posicion, char c, ArrayList<Character> palabra){

        if (palabra.get(posicion)==c){
            return false;
        }else {
            palabra.remove(posicion);
            palabra.add(posicion,c);
            return true;
        }
    }




  public boolean asignarLetras (char c, String palabraABuscar, ArrayList<Character> palabra){

        boolean asignado = false;

      for (int i = 0; i < palabraABuscar.length(); i++) {
          if (palabraABuscar.charAt(i) == c) {

              if (verificarPosiciones(i, c, palabra)) {
                  asignado = true;
                  System.out.println("\n se asigno " + c + "\n");
                  break;
              }
          }
      }
      if (asignado == false){
            getPalabrasDeneganas().add(c);
      }
      return asignado;
  }


  public boolean verificar (String palabraABuscar, ArrayList<Character> palabra) {

      boolean bandera = true;

      for (int i = 0; i < palabraABuscar.length(); i++) {

          if (palabraABuscar.charAt(i) != palabra.get(i)) {
              bandera = false;
              break;
          }
      }
      return bandera;
  }


    public ArrayList<Character> especifica() {

        ArrayList<Character> palabraEspecial = new ArrayList<>();

        for (int i = 0; i < palabraABuscar.length(); i++) {
            palabraEspecial.add(palabraABuscar.charAt(i));
        }

        return palabraEspecial;
    }


    public Consumer(Tuberia t) {

            tuberia = t;

    }


    public void run () {

            char c;
            char d;
            boolean bandera = true;

            while (bandera){

                c = tuberia.recoger();
                d = tuberia.recoger();


                System.out.println("Caracter 1 Recogido " + c);
                System.out.println("Caracter 2 Recogido " + d);


                if (asignarLetras(c,palabraABuscar,palabra)){

                    if (verificar(palabraABuscar,palabra)){

                        bandera = false;
                    }
                }

                if (asignarLetras(d,palabraABuscar,palabra)){

                    if (verificar(palabraABuscar,palabra)){
                        bandera = false;
                    }
                }

                try {

                    sleep(500);

                } catch (InterruptedException e) {

                    System.out.println(e);

                }
            }
        try {
            Persistencia.guardarLetras(palabrasDeneganas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n");
        palabra.forEach(l->System.out.print(l));
        System.out.println("\n");


        System.out.println("aca las letras que no fueran utilizadas o descartadas");
        System.out.println("");
        System.out.println("");
        palabrasDeneganas.forEach(w->System.out.print(w));
        System.out.println("");
        System.out.println("");
        }
    }


