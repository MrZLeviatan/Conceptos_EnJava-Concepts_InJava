package mrzleviatan.ejercicio_04.Utils;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ArchivoUtil {


    static String fechaSistema = "";


    // ----------------------- Log ----------------------------

    /**
     * Metodo para el Log.
     * @param mensajeLog
     * @param nivel
     * @param accion
     * @param rutaArchivo
     */
    public static void guardarRegistroLog(String mensajeLog, int nivel, String accion, String rutaArchivo){


        String log = "";
        Logger logger = Logger.getLogger(accion);
        FileHandler fileHandler = null;
        cargarFechaSistema();
        try {
            fileHandler =  new FileHandler(rutaArchivo,true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            switch (nivel){
                case 1:
                    logger.log(Level.INFO,accion+","+mensajeLog+","+fechaSistema);
                    break;

                case 2:
                    logger.log(Level.WARNING,accion+","+mensajeLog+","+fechaSistema);
                    break;

                case 3:
                    logger.log(Level.SEVERE, accion+","+mensajeLog+","+fechaSistema);
                    break;

                default:
                    break;
            }

        }catch (SecurityException e){

            logger.log(Level.SEVERE,e.getMessage());
            e.printStackTrace();


        } catch (IOException e) {

            logger.log(Level.SEVERE,e.getMessage());
            e.printStackTrace();

        }finally {

            fileHandler.close();
        }
    }

    /**
     * Metodo para cargar la fecha al sistema.
     */
    private static void cargarFechaSistema(){

        String diaN = "";
        String mesN = "";


        Calendar cale = Calendar.getInstance();

        int dia = cale.get(Calendar.DATE);
        int mes = cale.get(Calendar.MONTH)+1;
        int year = cale.get(Calendar.YEAR);
        int hora = cale.get(Calendar.HOUR);
        int minuto = cale.get(Calendar.MINUTE);


        if (dia < 10){
            diaN+="0"+dia;
        }else{
            diaN += ""+dia;
        }

        if (mes < 10){
            mesN+="0"+mes;
        }else{
            mesN += ""+mes;
        }

        // Diferente manera de usar el registro.
    //    fechaSistema = year +"-"+mesN+"-"+diaN+"-"+hora+"-"+minuto;
        fechaSistema = year +"-"+mesN+"-"+diaN;

    }



    // --------------------- Metodos Persistencia ------------------------------

    public static void guardarArchivo(String ruta,String contenido, Boolean flagAnexarContenido) throws IOException {

        FileWriter fw = new FileWriter(ruta,flagAnexarContenido);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(contenido);
        bfw.close();
        fw.close();
    }


public static ArrayList<String> leerArchivos(String ruta)throws IOException{

        ArrayList <String> contenido = new ArrayList<>();
        FileReader fr = new FileReader(ruta);
        BufferedReader bfr = new BufferedReader(fr);
        String lineas = "";

        while ((lineas = bfr.readLine())!= null){

            contenido.add(lineas);

        }

        bfr.close();
        fr.close();
        return contenido;
}

// --------------- Serializacion -------------------------


public static void salvarRecursosSerializado (String rutaArchivo, Object object) throws IOException {

    ObjectOutput oos = null;

    try {

        oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo));
        oos.writeObject(object);

        }catch (Exception e) {
        throw e;

    }finally {
        if (oos != null)
            oos.close();
    }
}


@SuppressWarnings("unchecked")
    public static Object cargarRecursoSerializado (String rutaArchivo) throws Exception{

        Object aux = null;
        ObjectInputStream ois = null;

        try {

            ois = new ObjectInputStream( new FileInputStream(rutaArchivo));
            aux = ois.readObject();

        }catch (Exception e){

            throw e;

        }finally {

            if (ois != null)
                ois.close();
        }
        return aux;

    }

 // -------------------- XML ---------------------------

public static void salvarRecursosXml(String rutaArchivo,Object object) throws  IOException {

    XMLEncoder codificadorXML;

    codificadorXML = new XMLEncoder(new FileOutputStream(rutaArchivo));
    codificadorXML.writeObject(object);
    codificadorXML.close();

    }


public static Object cargarRecursosXml (String rutaArchivo) throws IOException{

        XMLDecoder decodificadorXML;
        Object objectXML;

        decodificadorXML = new XMLDecoder(new FileInputStream(rutaArchivo));
        objectXML = decodificadorXML.readObject();
        decodificadorXML.close();
        return objectXML;
    }

}
