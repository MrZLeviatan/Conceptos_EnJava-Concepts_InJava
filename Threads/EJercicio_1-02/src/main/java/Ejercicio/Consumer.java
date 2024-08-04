package Ejercicio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Consumer extends Thread {

    private Tuberia tuberia;
    private BufferedWriter witter;

    ArrayList<Character> palabra = new ArrayList<>(Arrays.asList(' ',' ',
            ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '));
    ArrayList<Character> palabrasDeneganas = new ArrayList<>();
    String palabraABuscar = "progrOmacion_342023%";


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




    public Consumer(Tuberia t) {

            tuberia = t;
        try {
            witter =new BufferedWriter(new FileWriter("src/main/java/Ejercicio/letrasSobrantes.txt"));
        }catch (IOException e){
            e.printStackTrace();
        }
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
                    }else {
                        escribirEnArchivo(c);
                    }

                }

                if (asignarLetras(d,palabraABuscar,palabra)){

                    if (verificar(palabraABuscar,palabra)){

                        bandera = false;
                    }else{
                        escribirEnArchivo(d);
                    }

                }

                try {

                    sleep(500);

                } catch (InterruptedException e) {

                    System.out.println(e);

                }
            }

            System.out.println("\n \n");
            palabra.forEach(l->System.out.println(l));
            System.out.println("\n \n");
        }




    private void escribirEnArchivo(char c) {
        try {
            witter.write(c);
            witter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }




