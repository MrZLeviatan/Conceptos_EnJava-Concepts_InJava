package mrzleviatan.ejercicio_01.controller.service;

import mrzleviatan.ejercicio_01.exceptions.EstudianteException;
import mrzleviatan.ejercicio_01.mapping.dto.EstudianteDto;
import mrzleviatan.ejercicio_01.mapping.dto.NotasDto;

public interface IModelFactoryController {


    boolean addEstudiante (EstudianteDto estudianteDto);
    boolean deletEstudiante (EstudianteDto estudianteDto) throws EstudianteException;

    EstudianteDto obtenerEstudiante (String codgio);

}
