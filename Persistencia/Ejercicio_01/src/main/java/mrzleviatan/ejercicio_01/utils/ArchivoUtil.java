package mrzleviatan.ejercicio_01.utils;


import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;


/**
 * SE CREA LA CLASE CON LA FUNCION DE UNA LIBRERIA PARA EL MANEJO DE ARCHIVOS.
 * @serial PARA IMPORTAR LOGGER SE IMPORTAN EN LA CLASE Y EN EL MODELO.
 * @serial PARA IMPORTAR XMLDecoder Y XMLEncoder SE IMPORTAN EN LA CLASE Y EN EL MODELO.
 */
public class ArchivoUtil {


    /**
     * SE CREA LA VARIABLE FECHA DE SISTEMA VACIO.
     */
    static String fechaSistema = "";


    /**
     * SE CREA EL METODO PARA PODER CARGAR LAS FECHAS DEL SISTEMA EN QUE SE ESTE GUARDANDO
            OH INTERACTUANDO CON EL SISTEMA.
     */
   private static void cargarFechaSistema(){

       String diaN= "";
       String mesN= "";
       String anoN= "";

       Calendar cal1= Calendar.getInstance();

       int dia = cal1.get(Calendar.DATE);
       int mes = cal1.get(Calendar.MONTH)+1;
       int ano = cal1.get(Calendar.YEAR);
       int hora = cal1.get(Calendar.HOUR);
       int minuto = cal1.get(Calendar.MINUTE);


       if (dia < 10){

           diaN+="0"+dia;

       }else {
           diaN+= ""+dia;
       }


       if (mes < 10){

           mesN += "0"+mes;
       }else {
           mesN += ""+mes;
       }


       fechaSistema = ano+" - "+mesN+" - "+diaN+" - "+hora+" - "+minuto;

   }


    /**
     * SE CREA EL METODO PARA PODER GUARDAR LOS ARCHIVOS CON LA RUTA DEL ARCHIVO.
     */

   public static void guardarArchivo(String ruta, String contenido, Boolean flagAnexarContenido) throws IOException{

       FileWriter fw = new FileWriter(ruta,flagAnexarContenido);
       BufferedWriter bfw = new BufferedWriter(fw);
       bfw.write(contenido);
       bfw.close();
       fw.close();
   }


    /**
     * SE CREA EL METODO PARA PODER LEER EL CONTENIDO DEL ARCHIVO UBICADO EN LA RUTA. CON LA
            LISTA DE CADENAS.
     */
   public static ArrayList<String> leerArchivos (String ruta) throws IOException{

       ArrayList<String> contenido = new ArrayList<String>();
       FileReader fr = new FileReader(ruta);
       BufferedReader bfr = new BufferedReader(fr);
       String linea ="";
       while ((linea = bfr.readLine())!=null){

           contenido.add(linea);
       }
       bfr.close();
       fr.close();
       return contenido;
   }



    /**
     * SE CREA EL METODO CON EL FIN DE GUARDAR EL REGISTRO LOG DE LAS ACCIONES.
     */
   public static void guardarRegistroLog (String mensajeLog, int nivel, String accion, String rutaArchivo){

       String log ="";
       Logger LOGGER = Logger.getLogger(accion);
       FileHandler fileHandler = null;
       cargarFechaSistema();
       try {

           fileHandler = new FileHandler(rutaArchivo,true);
           fileHandler.setFormatter(new SimpleFormatter());
           LOGGER.addHandler(fileHandler);

           switch (nivel){

               case 1:

                   LOGGER.log(Level.INFO, accion=","+mensajeLog+","+fechaSistema);
                   break;

               case 2:

                   LOGGER.log(Level.WARNING, accion=","+mensajeLog+","+fechaSistema);
                   break;

               case 3:

                   LOGGER.log(Level.SEVERE, accion=","+mensajeLog+","+fechaSistema);
                   break;

               default:
                   break;
           }


       }catch (SecurityException e) {

           LOGGER.log(Level.SEVERE, e.getMessage());
           e.printStackTrace();

       }catch (IOException e){
           //TODO Auto-generated catch block
           LOGGER.log(Level.SEVERE,e.getMessage());
           e.printStackTrace();

       }
       finally {
           fileHandler.close();
       }
   }


    /**
     * SE CREA EL METODO CON EL FIN DE CARGAR LA SERIALIZACION.
     */
   @SuppressWarnings("unchecked")
    public static Object cargarRecursosSerializado (String rutaArchivo) throws Exception{

       Object aux= null;
       ObjectInputStream ois = null;

       try {

           ois = new ObjectInputStream(new FileInputStream(rutaArchivo));
           aux = ois.readObject();

       }catch (Exception e2){

           throw e2;

       }finally {

           if (ois != null)
               ois.close();
       }
       return aux;
   }


    /**
     * SE CREA EL METODO CON EL FIN DE SALVAR LOS RECUSOS SERIALIZADOS.
     */
   public static void salvarRecursosSerializados(String rutaArchivo, Object object) throws Exception{

       ObjectOutputStream oos = null;

       try {

           oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo));
           oos.writeObject(object);
       }catch (Exception e){

           throw e;
       }finally {
           if (oos != null)
               oos.close();
       }

   }


    /**
     * SE CREA EL METODO CON EL FIN DE CARGAR LOS RECURSOS SERIALIZADOS EN XML.
     */
    public static Object cargarRecursosSerializadoXML (String rutaArvhico) throws IOException{

       XMLDecoder decodificadorXML;
       Object objetoXML;

       decodificadorXML = new XMLDecoder(new FileInputStream(rutaArvhico));
       objetoXML = decodificadorXML.readObject();
       decodificadorXML.close();
       return objetoXML;

    }


    /**
     * SE CREA EL METODO CON EL FIN DE SALVAR LOS RECURSOS SERIALIZADOS EN XML.
     */
    public static void salvarRecursosSerializadoXML (String rutaArchivo, Object objeto) throws IOException{

       XMLEncoder codificadorXML;

       codificadorXML = new XMLEncoder(new FileOutputStream(rutaArchivo));
       codificadorXML.writeObject(objeto);
       codificadorXML.close();

    }


}
