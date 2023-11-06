package mrzleviatan.ejercicio_01.controller.service;


import mrzleviatan.ejercicio_01.mapping.dto.EstudianteDto;

import java.util.List;


/**
 * SE CREA LA INTERFACE DEL MODEL FACTORY BABY.
 */

public interface IEstudianteControllerService {

    /**
     * SE CREAN LOS METODOS AH IMPLEMENTAR.
     */
    List<EstudianteDto> obtenerEstudiante();
    boolean agregarEstudiante(EstudianteDto estudianteDto);
    boolean eliminarEstudiante (String codigo);
    boolean actualizarEstudiante (String codigoActual, EstudianteDto estudianteDto);

    void registrarAcciones (String mensaje, int nivel, String accion);
}
