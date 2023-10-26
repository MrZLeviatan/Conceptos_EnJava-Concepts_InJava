package mrzleviatan.ejercicio_01.utils;



import mrzleviatan.ejercicio_01.model.Estudiante;
import mrzleviatan.ejercicio_01.model.Universidad;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * SE CREA LA CLASE UTIL PERSISTENCIA PARA PODER CARGAR Y GUARDAR LOS ARCHIVOS DESEADOS.
 */
public class Persistencia {



    /**
     * SE CREAN LAS VARIABLES QUE SERVIRÁN COMO RUTAS.
     */
    public static final String RUTA_ARCHIVO_ESTUDIANTE = "Persistencia/Ejercicio_01/src/main/resources/Persistencia/files/archivoEstudiante.txt";

    public static final String RUTA_ARCHIVO_LOG = "Persistencia/Ejercicio_01/src/main/resources/Persistencia/log/universidad_log.txt";

    public static final String RUTA_MODELO_UNIVERSIDAD_BINARIO = "Persistencia/Ejercicio_01/src/main/resources/Persistencia/model.dat";

    public static final String RUTA_MODELO_UNIVERSIDAD_XML = "Persistencia/Ejercicio_01/src/main/resources/Persistencia/model.xml";

    public static final String RUTA_ARCHIVO_RESPALDO_XML = "Persistencia/Ejercicio_01/src/main/resources/Persistencia/respaldo/respaldoUniversidadXML2023-10-26_01_48_12.xml";


    /**
     * SE CREA LA CLASE "formatRespaldo" PARA PODER FORMATEAR EL RESPALDO .xml
     */
    private static String formatRespaldo() throws IOException{

        String ruta = "src/main/resources/Persistencia/respaldo/respaldoUniversidadXML2023-10-26_01_48_12.xml";
        Path pathArchivoXML = Paths.get(ruta);
        String nombreArchivoOriginal = pathArchivoXML.getFileName().toString();
        String nombreArchivoFormateado = "respaldoUniversidadXL" + new SimpleDateFormat("YYYY-MM-DD-HH-mm-ss").format(new Date()) + ".xml";
        Files.move(pathArchivoXML,pathArchivoXML.resolveSibling(nombreArchivoFormateado));
        String mensaje = "src/main/resources/Persistencia/respaldo/"+nombreArchivoFormateado;
        ruta = mensaje;
        return mensaje;

    }


    /**
     * SE CREA LA CLASE PARA PODER CARGAR DESDE LOS ARCHIVOS .txt CON SU RESPECTIVO ORDEN.
     */
    public static ArrayList<Estudiante> cargarEstudiante() throws FileNotFoundException, IOException{

        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivos(RUTA_ARCHIVO_ESTUDIANTE);
        String linea ="";

        for (int i = 0; i < contenido.size(); i++) {

            linea = contenido.get(i);
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre(linea.split(" @@ ")[0]);
            estudiante.setApellido(linea.split(" @@ ")[1]);
            estudiante.setCodigo(linea.split(" @@ ")[2]);
            estudiante.setNota1(Integer.parseInt(linea.split(" @@ ")[3]));
            estudiante.setNota2(Integer.parseInt(linea.split(" @@ ")[4]));
            estudiante.setNota3(Integer.parseInt(linea.split(" @@ ")[5]));
            estudiantes.add(estudiante);

        }
            return estudiantes;
    }


    /**
     * SE CREA LA CLASE PARA PODER GUARDAR EN UN .txt LA LISTA DE ESTUDIANTES.
            SIRVE COMO LA BASE DE PERSISTENCIA DE DATOS .txt.
     */
    public static void guardarEstudiante (ArrayList<Estudiante> listaEstudiante) throws IOException {

        String contenido="";

        for (Estudiante estudiante:listaEstudiante){

            contenido +=      estudiante.getNombre()+
                              " @@ " + estudiante.getApellido()+
                              " @@ " + estudiante.getCodigo()+
                              " @@ " + estudiante.getNota1()+
                              " @@ " + estudiante.getNota2()+
                              " @@ " + estudiante.getNota3()+"\n";

        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ESTUDIANTE,contenido,false);

    }



    /**
     * SE CREA LA CLASE PARA CARGAR LOS ARCHIVOS Y AÑADIRLOS A LA LISTA DE LA UNIVERSIDAD.
     */
    public static void cargarDatosArchivos (Universidad universidad) throws FileNotFoundException, IOException{

        ArrayList<Estudiante> estudiantesCargado = cargarEstudiante();
        if (estudiantesCargado.size() > 0)
            universidad.getEstudiantesList().addAll(estudiantesCargado);

    }


    /**
     * SE CREA LA CLASE PARA GUARDAR EL REGISTRO EN EL ARCHIVO _log.txt.
     */
    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion){

        ArchivoUtil.guardarRegistroLog(mensajeLog,nivel,accion,RUTA_ARCHIVO_LOG);

    }


    /**
     * SE CREA LA CLASE PARA CARGAR LOS RECURSOS DEL ARCHIVOS SERIALIZADOS BINARIOS.
     */
    public static Universidad cargarRecursosUniversidadBinario(){

        Universidad universidad = null;

        try {
            universidad = (Universidad) ArchivoUtil.cargarRecursosSerializado(RUTA_MODELO_UNIVERSIDAD_BINARIO);

        } catch (Exception e){
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
        return universidad;
    }



    /**
     * SE CREA LA CLASE PARA GUARDAR LOS RECURSOS EN EL  ARCHIVOS SERIALIZADOS BINARIOS.
     */
    public static void guardarRecursosUniversidadBinario (Universidad universidad){

        try {
            ArchivoUtil.salvarRecursosSerializados(RUTA_MODELO_UNIVERSIDAD_BINARIO, universidad);

        }catch (Exception e){
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * SE CREA LA CLASE PARA CARGAR LOS RECURSOS DEL ARCHIVOS SERIALIZADOS XML.
     */
    public static Universidad cargarRecursosUniversidadXML(){

        Universidad universidad= null;

        try {
            universidad = (Universidad) ArchivoUtil.cargarRecursosSerializadoXML(RUTA_MODELO_UNIVERSIDAD_XML);

        } catch (Exception e){
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
        return universidad;
    }


    /**
     * SE CREA LA CLASE PARA GUARDAR LOS RECURSOS EN EL  ARCHIVOS SERIALIZADOS XML.
     */
    public static void guardarRecursosUniversidadXML(Universidad universidad){

        try {
            ArchivoUtil.salvarRecursosSerializadoXML(RUTA_MODELO_UNIVERSIDAD_XML,universidad);

        }catch (Exception e){
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * SE CREA LA CLASE PARA CARGAR LOS RECURSOS DEL ARCHIVOS SERIALIZADOS XML DEL RESPALDO.
     */
    public static Universidad cargarRespaldoXML(){

        Universidad universidad = null;

        try {
            universidad = (Universidad) ArchivoUtil.cargarRecursosSerializadoXML(RUTA_ARCHIVO_RESPALDO_XML);

        }catch (Exception e){
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
        return universidad;
    }


    /**
     * SE CREA LA CLASE PARA GUARDAR LOS RECURSOS EN EL  ARCHIVOS SERIALIZADOS XML DEL RESPALDO.
     */
    public static void copiaSeguridadXML (Universidad universidad){

        try {
            ArchivoUtil.salvarRecursosSerializadoXML(RUTA_ARCHIVO_RESPALDO_XML,universidad);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}

