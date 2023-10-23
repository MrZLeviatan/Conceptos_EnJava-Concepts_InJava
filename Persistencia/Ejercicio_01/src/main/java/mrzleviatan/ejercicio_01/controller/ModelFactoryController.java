package mrzleviatan.ejercicio_01.controller;

import mrzleviatan.ejercicio_01.controller.service.IModelFactoryController;
import mrzleviatan.ejercicio_01.exceptions.EstudianteException;
import mrzleviatan.ejercicio_01.mapping.dto.EstudianteDto;
import mrzleviatan.ejercicio_01.mapping.mappers.ColegioMapper;
import mrzleviatan.ejercicio_01.model.Colegio;
import mrzleviatan.ejercicio_01.model.Estudiante;

public class ModelFactoryController implements IModelFactoryController {

    private EstudianteDto estudianteDtoLogeado;
    Colegio colegio;
    ColegioMapper mapper = ColegioMapper.INSTANCE;


    @Override
    public boolean addEstudiante(EstudianteDto estudianteDto) {

        try{
            if (!colegio.estudianteExiste(estudianteDto.codigo())){
                Estudiante estudiante= mapper
            }else{
                return false;
            }
        }catch (Exception e){
            e.getMessage();
            return false;
        }

    }

    @Override
    public boolean deletEstudiante(EstudianteDto estudianteDto) throws EstudianteException {
        return false;
    }

    @Override
    public EstudianteDto obtenerEstudiante(String codgio) {
        return null;
    }
}
