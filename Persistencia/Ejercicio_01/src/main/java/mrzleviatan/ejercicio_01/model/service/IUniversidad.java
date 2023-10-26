package mrzleviatan.ejercicio_01.model.service;


import mrzleviatan.ejercicio_01.exceptions.EstudianteException;
import mrzleviatan.ejercicio_01.model.Estudiante;

import java.util.ArrayList;

/**
 * SE CREA EL INTERFACE DE IUNIVERSIDAD
 */
public interface IUniversidad {


    /**
     * SE CREAN LOS METODOS NECESARIOS DEL CRUD DEL ESTUDIANTE.
     * @exception EstudianteException para verificar cualquier exception.
     */

    public Estudiante crearEstudiante (String nombre, String apellido, String codigo, Integer nota1, Integer nota2, Integer nota3) throws EstudianteException;

    public Boolean eliminarEstudiante (String codigo) throws EstudianteException;

    boolean actualizarEstudiante (String codigoActual, Estudiante estudiante) throws EstudianteException;

    public boolean VerificarEstudianteExistente(String codigo) throws EstudianteException;
    public Estudiante obtenerEstudiante (String codigo);
    public ArrayList<Estudiante> obtenerEstudiante();

}
