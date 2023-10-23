package mrzleviatan.ejercicio_01.model;
import mrzleviatan.ejercicio_01.model.service.IColegio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Colegio implements Serializable, IColegio  {

    private static final long serialVersionUID = 1L;
    private List<Estudiante>estudianteList = new ArrayList<>();



    public void addEstudiante (Estudiante estudiante) {

        try{
            estudianteList.add(estudiante);
        }catch (NullPointerException e){
            throw new NullPointerException("El usuario es nulo");
        }
    }


    public void deletEstudiante (Estudiante estudiante) {

       if (estudianteExiste(estudiante.getCodigo()))
           estudianteList.remove(estudiante);

       }


   public Estudiante obtenerEstudiante (String codigo){

        return estudianteList.stream().filter(estudiante -> estudiante.getCodigo().equals(codigo)).findFirst().get();
   }


    public void addNotasEstudiante (Notas notas, String codigo){
        Estudiante estudiante = obtenerEstudiante(codigo);
        estudiante.addNotas(notas);
    }


    @Override
    public boolean estudianteExiste(String codigo) {
        boolean existe = false;

        for (Estudiante estudiante:estudianteList){
            if (estudiante.getCodigo().equals(codigo)){
                existe=true;
                break;
            }
        }
        return existe;
    }



}
