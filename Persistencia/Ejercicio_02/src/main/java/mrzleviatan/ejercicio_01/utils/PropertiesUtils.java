package mrzleviatan.ejercicio_01.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {



    private static Properties properties = null;


    static {


        FileInputStream fileInputStream = null;

        try {

            properties = new Properties();
            fileInputStream = new FileInputStream("Persistencia/Ejercicio_02/src/main/resources/Config/Modalidad.properties");
            properties.load(fileInputStream);


        } catch (Exception e) {

            e.getMessage();

        } finally {

            if (fileInputStream != null) {

                try {

                    fileInputStream.close();

                } catch (IOException e) {

                    e.getMessage();
                }
            }
        }
    }


  public static String gerProperty (String propertyName){

        return properties.getProperty(propertyName);

  }

}
