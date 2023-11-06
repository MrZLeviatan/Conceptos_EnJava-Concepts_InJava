package mrzleviatan.ejercicio_01.model;

import mrzleviatan.ejercicio_01.exceptions.EstudianteException;
import mrzleviatan.ejercicio_01.model.service.IUniversidad;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * SE CREA LA CLASE UNIVERSIDAD IMPLEMENTADA CON "SERIALIZABLE" Y LA INTERFACE "IUniversidad".
 */
public class Universidad implements Serializable, IUniversidad {


    /**
     * SE CREAN LAS VARIABLES DE LA UNIVERSIDAD.
     *
     * @param serialVersionUID se implementa para la Persistencia.
     */
    private static final long SerialVersionUID = 1L;

    private ArrayList<Estudiante> estudiantesList = new ArrayList<>();


    /**
     * SE CREA EL CONSTRUCTOR DE LA CLASE VACIO.
     */
    public Universidad() {
    }



    /**
     * SE CREAN LOS GET Y SER DE LAS VARIABLES.
     */

    public ArrayList<Estudiante> getEstudiantesList() { return estudiantesList; }

    public void setEstudiantesList(ArrayList<Estudiante> estudiantesList) { this.estudiantesList = estudiantesList; }



    /**
     * SE LLAMA EL METODO "crearEstudiante" Del Service PARA AGREGAR AL NUEVO ESTUDIANTE.
     *
     * @throws EstudianteException sirve para manejar la exception de Estudiante ya creado.
     */
    @Override
    public Estudiante crearEstudiante(String nombre, String apellido, String codigo, Integer nota1, Integer nota2, Integer nota3) throws EstudianteException {
        Estudiante nuevoEstudiante = null;
        boolean estudianteExiste = VerificarEstudianteExistente(codigo);

        if (estudianteExiste) {

            throw new EstudianteException("El Estudiante con el codigo: " + codigo + " Ya existe");

        } else {

            nuevoEstudiante = new Estudiante();
            nuevoEstudiante.setNombre(nombre);
            nuevoEstudiante.setApellido(apellido);
            nuevoEstudiante.setCodigo(codigo);
            nuevoEstudiante.setNota1(nota1);
            nuevoEstudiante.setNota2(nota2);
            nuevoEstudiante.setNota3(nota3);
            getEstudiantesList().add(nuevoEstudiante);
            System.out.println("nn");

        }

        return nuevoEstudiante;
    }


    /**
     * SE CREA LA CLASE AUXILIAR PARA AGREGAR ESTUDIANTES.
     *
     * @throws EstudianteException
     */
    public void agregarEstudiante(Estudiante nuevoEstudiante) throws EstudianteException {

        getEstudiantesList().add(nuevoEstudiante);

    }


    /**
     * SE LLAMA EL METODO "eliminarEstudiante" DEL Service PARA ELIMINAR ESTUDIANTES.
     *
     * @throws EstudianteException sirve para alertar de la existencia del estudiante.
     */
    @Override
    public Boolean eliminarEstudiante(String codigo) throws EstudianteException {

        Estudiante estudiante = null;
        boolean flagExiste = false;
        estudiante = obtenerEstudiante(codigo);

        if (estudiante == null)
            throw new EstudianteException("El estudiante a eliminar no existe");

        else {

            getEstudiantesList().remove(estudiante);
            flagExiste = true;

        }
        return flagExiste;
    }


    /**
     * SE LLAMA EL METODO "actualizarEstudiante" DEL Service PARA ACTUALIZAR OH
     * MODIFICAR ESTUDIANTES.
     *
     * @throws EstudianteException sirve para alertar de la existencia del estudiante.
     */
    @Override
    public boolean actualizarEstudiante(String codigoActual, Estudiante estudiante) throws EstudianteException {

        Estudiante estudianteActual = obtenerEstudiante(codigoActual);

        if (codigoActual == null)

            throw new EstudianteException("El estudiante a actualizar no existe");

        else {

            estudianteActual.setNombre(estudiante.getNombre());
            estudianteActual.setApellido(estudiante.getApellido());
            estudianteActual.setCodigo(estudiante.getCodigo());
            estudianteActual.setNota1(estudiante.getNota1());
            estudianteActual.setNota2(estudiante.getNota2());
            estudianteActual.setNota3(estudiante.getNota3());
            return true;
        }
    }


    /**
     * SE LLAMA EL METODO "VerificarEstudianteExistente" de Service PARA VERIFICAR LA
     * EXISTENCIA DEl ESTUDIANTE.
     *
     * @throws EstudianteException sirve para alertar de la existencia del estudiante.
     */
    @Override
    public boolean VerificarEstudianteExistente(String codigo) throws EstudianteException {

        if (estudianteExiste(codigo)) {

            throw new EstudianteException(" El estudiante con codgio: " + codigo + " ya existe");

        } else {

            return false;
        }
    }


    /**
     * SE LLAMA EL METODO "obtenrEstudiante" DEL Service PARA OBTENER EL ESTUDIANTE
     * QUE SE ESTA BUSANDO.
     */
    @Override
    public Estudiante obtenerEstudiante(String codigo) {
        Estudiante estudianteEncontrado = null;

        for (Estudiante estudiante : getEstudiantesList()) {
            if (estudiante.getCodigo().equalsIgnoreCase(codigo)) {
                estudianteEncontrado = estudiante;
                break;
            }
        }
        return estudianteEncontrado;
    }


    /**
     * SE LLAMA EL METODO "obtenerEstudiantes" DEL Service PARA OBTENER TODOS LOS
     * ESTUDIANTES REGISTRADOS.
     */
    @Override
    public ArrayList<Estudiante> obtenerEstudiante() {
        //TODO Auto-generated method stub
        return getEstudiantesList();
    }


    /**
     * SE CREA EL METODO PARA HALLAR ESTUDIANTES DE LA LISTA.
     */
    public boolean estudianteExiste(String codigo) {

        boolean estudianteEncontrado = false;

        for (Estudiante estudiante : getEstudiantesList()) {

            if (estudiante.getCodigo().equalsIgnoreCase(codigo)) {
                estudianteEncontrado = true;
                break;
            }
        }
        return estudianteEncontrado;
    }

}


