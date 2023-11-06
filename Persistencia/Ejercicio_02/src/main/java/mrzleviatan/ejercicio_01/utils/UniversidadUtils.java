package mrzleviatan.ejercicio_01.utils;

import mrzleviatan.ejercicio_01.model.Estudiante;
import mrzleviatan.ejercicio_01.model.Universidad;

public class UniversidadUtils {

    public static Universidad inicializar(){

        Universidad universidad = new Universidad();


        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Nicolas");
        estudiante.setApellido("Cabrera");
        estudiante.setCodigo("1020");
        estudiante.setNota1(2);
        estudiante.setNota2(3);
        estudiante.setNota3(4);
        universidad.getEstudiantesList().add(estudiante);


        return universidad;
    }

}
