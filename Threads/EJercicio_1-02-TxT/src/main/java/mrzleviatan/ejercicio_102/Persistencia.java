package mrzleviatan.ejercicio_102;

import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {

    public static final  String RUTA_LETRAS= "EJercicio_1-02/src/main/resources/mrzleviatan.ejercicio_102/letras.txt";

    public static void guardarLetras(ArrayList<Character>letrasRechazadas) throws IOException {
        String contenido="";
        for (int i=0;i<letrasRechazadas.size();i++){
            contenido+=letrasRechazadas.get(i)+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_LETRAS,contenido,false);
    }
}
