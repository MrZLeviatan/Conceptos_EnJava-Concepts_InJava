package mrzleviatan.ejercicio_01.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class VisualizacionPropiedades {


    static String Distancia;
    static String Presencial;


    public static void main(String[] args) {

        Properties prodiedades = new Properties();
        InputStream entrada = null;

        try {

            entrada = new FileInputStream("Persistencia/Ejercicio_02/src/main/java/mrzleviatan/ejercicio_01/controller/Modalidad.properties");
            prodiedades.load(entrada);


            Presencial = prodiedades.getProperty("Presencial");
            System.out.println(Presencial);


        }catch (FileNotFoundException e){

            e.printStackTrace();

        }catch (IOException ex){

            ex.printStackTrace();
        }


    }
}

